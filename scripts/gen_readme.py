# README.md 생성기: python3 scripts/gen_readme.py . > README.md
import os, re, sys

root = sys.argv[1] if len(sys.argv) > 1 else '.'
base = 'src/main/java/com/codingTest'
B = os.path.join(root, base)

def files(d, exts=('.java', '.sql')):
    p = os.path.join(B, d)
    return sorted(f for f in os.listdir(p) if os.path.isfile(os.path.join(p, f)) and f.endswith(exts))

def title_of(path):
    with open(path, encoding='utf-8') as fh:
        for line in fh.read(3000).splitlines():
            m = re.search(r'문제:\s*(?:백준:\s*)?\d+\s*-\s*(.+)', line)
            if m:
                return m.group(1).strip()
    return ''

out = []
w = out.append

# ---- counts ----
tiers = [('bronze', '브론즈'), ('silver', '실버'), ('gold', '골드')]
boj = {t: sorted(files(f'baekzoon/{t}'), key=lambda f: (0, int(re.sub(r'\D', '', f))) if f.startswith('Problem') else (1, 0)) for t, _ in tiers}
levels = [('level1', 'Level 1'), ('level2', 'Level 2'), ('level3', 'Level 3'), ('level4', 'Level 4'),
          ('pccp/guest1', 'PCCP 모의고사 1회'), ('test', '기타')]
prg = {l: files(f'programers/{l}') for l, _ in levels}
lc_dirs = sorted(d for d in os.listdir(os.path.join(B, 'leetcode'))
                 if os.path.isdir(os.path.join(B, 'leetcode', d)))
lc_files = files('leetcode')

boj_n = sum(len(v) for v in boj.values())
prg_n = sum(len(v) for v in prg.values())
lc_n = len(lc_dirs) + len(lc_files)

w('# 🧩 Coding Test')
w('')
w('백준 · 프로그래머스 · LeetCode 알고리즘 문제 풀이 저장소입니다. (Java / SQL)')
w('')
w('## 📊 현황')
w('')
w('| 플랫폼 | 풀이 수 | 구성 |')
w('| --- | ---: | --- |')
w(f'| 백준 | {boj_n} | ' + ' · '.join(f'{k} {len(boj[t])}' for t, k in tiers) + ' |')
w(f'| 프로그래머스 | {prg_n} | ' + ' · '.join(f'{k} {len(prg[l])}' for l, k in levels) + ' |')
w(f'| LeetCode | {lc_n} | 문제별 폴더 {len(lc_dirs)} · 단일 파일 {len(lc_files)} |')
w(f'| **합계** | **{boj_n + prg_n + lc_n}** | |')
w('')

# ---- 풀이 기록 (잔디) ----
import subprocess, datetime as dt
from collections import Counter

LC_DIR = re.compile(r'(?:^|/)(\d{4}-[a-z0-9-]+)/')

def key_of(path):
    m = LC_DIR.search(path)
    if m:
        return 'lc:' + m.group(1)
    name = os.path.basename(path)
    if not name.endswith(('.java', '.sql')):
        return None
    return os.path.splitext(name)[0]

current = set()
for t, _ in tiers:
    current |= {os.path.splitext(f)[0] for f in boj[t]}
for l, _ in levels:
    current |= {os.path.splitext(f)[0] for f in prg[l]}
current |= {'lc:' + d for d in lc_dirs} | {os.path.splitext(f)[0] for f in lc_files}

first = {}
log = subprocess.run(['git', '-C', root, '-c', 'core.quotepath=false', 'log', '-M', '--diff-filter=A', '--name-only',
                      '--format=@%ad', '--date=short'], capture_output=True, text=True).stdout
day = None
for line in log.splitlines():
    if line.startswith('@'):
        day = dt.date.fromisoformat(line[1:])
    elif line.strip():
        k = key_of(line.strip().strip('"'))
        if k in current and (k not in first or day < first[k]):
            first[k] = day
today = dt.date.today()
for k in current - first.keys():  # 아직 커밋되지 않은 새 풀이
    first[k] = today
per_day = Counter(first.values())

def streaks(days):
    ds = sorted(days)
    best = cur = 0
    prev = None
    for d in ds:
        cur = cur + 1 if prev and (d - prev).days == 1 else 1
        best = max(best, cur)
        prev = d
    now = 0
    d = today if today in days else today - dt.timedelta(days=1)
    while d in days:
        now += 1
        d -= dt.timedelta(days=1)
    return now, best

def heatmap_svg(path):
    cell, gap, left, top = 11, 3, 28, 20
    end = today + dt.timedelta(days=(5 - today.weekday()) % 7)  # 이번 주 토요일
    start = end - dt.timedelta(days=53 * 7 - 1)                   # 53주 전 일요일
    weeks = 53
    width = left + weeks * (cell + gap) + 8
    height = top + 7 * (cell + gap) + 26
    lv = lambda n: 0 if n == 0 else 1 if n == 1 else 2 if n <= 3 else 3 if n <= 6 else 4
    s = [f'<svg xmlns="http://www.w3.org/2000/svg" width="{width}" height="{height}" viewBox="0 0 {width} {height}" font-family="-apple-system,Segoe UI,Helvetica,Arial,sans-serif" font-size="9">',
         '<style>text{fill:#59636e}.l0{fill:#eff2f5}.l1{fill:#aceebb}.l2{fill:#4ac26b}.l3{fill:#2da44e}.l4{fill:#116329}'
         '@media (prefers-color-scheme:dark){text{fill:#9198a1}.l0{fill:#151b23}.l1{fill:#033a16}.l2{fill:#196c2e}.l3{fill:#2ea043}.l4{fill:#56d364}}</style>']
    for i, name in ((1, '월'), (3, '수'), (5, '금')):
        s.append(f'<text x="0" y="{top + i * (cell + gap) + 9}">{name}</text>')
    last_month = None
    for wk in range(weeks):
        x = left + wk * (cell + gap)
        wstart = start + dt.timedelta(days=wk * 7)
        if wstart.month != last_month and wk < weeks - 2:
            s.append(f'<text x="{x}" y="{top - 7}">{wstart.month}월</text>')
            last_month = wstart.month
        for d in range(7):
            day_ = wstart + dt.timedelta(days=d)
            if day_ > today:
                continue
            n = per_day.get(day_, 0)
            y = top + d * (cell + gap)
            s.append(f'<rect class="l{lv(n)}" x="{x}" y="{y}" width="{cell}" height="{cell}" rx="2">'
                     f'<title>{day_.isoformat()}: {n}문제</title></rect>')
    ly = top + 7 * (cell + gap) + 10
    lx = width - 8 - 5 * (cell + gap) - 30
    s.append(f'<text x="{lx - 28}" y="{ly + 9}">적음</text>')
    for i in range(5):
        s.append(f'<rect class="l{i}" x="{lx + i * (cell + gap)}" y="{ly}" width="{cell}" height="{cell}" rx="2"/>')
    s.append(f'<text x="{lx + 5 * (cell + gap) + 2}" y="{ly + 9}">많음</text>')
    s.append('</svg>')
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, 'w', encoding='utf-8') as fh:
        fh.write('\n'.join(s) + '\n')
    return start

svg_rel = 'assets/solved-heatmap.svg'
since = heatmap_svg(os.path.join(root, svg_rel))
year_n = sum(n for d, n in per_day.items() if d >= since)
active = {d for d, n in per_day.items() if n}
cur_streak, best_streak = streaks(active)
month_n = sum(n for d, n in per_day.items() if (d.year, d.month) == (today.year, today.month))

w('## 🌱 풀이 기록')
w('')
w(f'![풀이 잔디]({svg_rel})')
w('')
w(f'최근 1년 **{year_n}문제** · 이번 달 **{month_n}문제** · 현재 연속 **{cur_streak}일** · 최장 연속 **{best_streak}일**')
w('')
years = sorted({d.year for d in per_day})
w('| ' + ' | '.join(f'{y}년' for y in years) + ' |')
w('|' + ' ---: |' * len(years))
w('| ' + ' | '.join(str(sum(n for d, n in per_day.items() if d.year == y)) for y in years) + ' |')
w('')
w(f'<sub>풀이 파일이 저장소에 처음 추가된 날짜 기준 · {today.isoformat()} 갱신</sub>')
w('')
w('## 📁 구조')
w('')
w('```')
w(f'{base}/')
w('├── baekzoon/      # 백준 — bronze / silver / gold')
w('├── programers/    # 프로그래머스 — level1 ~ level4 / pccp / test')
w('└── leetcode/      # LeetCode — LeetHub 자동 업로드 폴더 + 직접 작성한 파일')
w('```')
w('')
w('- **빌드:** Gradle (Java), 테스트는 JUnit 5')
w('- **커밋 규칙:** `feat: 백준 골드5 Z 문제해결`, `feat: 프로그래머스 레벨2 ... 문제 해결`')
w('')
w('## ⚙️ LeetCode 자동화')
w('')
w('1. [LeetHub v2](https://github.com/arunbhardwaj/LeetHub-2.0)가 LeetCode 제출 시 저장소 루트에 `0058-length-of-last-word/` 형태로 커밋합니다.')
w('2. GitHub Actions(`.github/workflows/move-leetcode.yml`)가 해당 폴더를 `src/main/java/com/codingTest/leetcode/`로 옮깁니다.')
w('')
w('## 📝 문제 목록')
w('')

w('### 백준')
w('')
for t, k in tiers:
    w(f'<details>\n<summary>{k} ({len(boj[t])})</summary>\n')
    for f in boj[t]:
        path = f'{base}/baekzoon/{t}/{f}'
        m = re.match(r'Problem(\d+)\.java', f)
        if m:
            num = m.group(1)
            ttl = title_of(os.path.join(root, path))
            w(f'- [{num}](https://www.acmicpc.net/problem/{num})' + (f' {ttl}' if ttl else '') + f' · [풀이]({path})')
        else:
            w(f'- {f[:-5].replace("_", " ")} · [풀이]({path})')
    w('\n</details>\n')

w('### 프로그래머스')
w('')
for l, k in levels:
    if not prg[l]:
        continue
    w(f'<details>\n<summary>{k} ({len(prg[l])})</summary>\n')
    for f in prg[l]:
        name = os.path.splitext(f)[0].replace('_', ' ')
        w(f'- [{name}]({base}/programers/{l}/{f})')
    w('\n</details>\n')

w('### LeetCode')
w('')
w(f'<details>\n<summary>문제별 폴더 ({len(lc_dirs)})</summary>\n')
for d in lc_dirs:
    num, slug = d.split('-', 1)
    has_sol = any(x != 'README.md' for x in os.listdir(os.path.join(B, 'leetcode', d)))
    note = '' if has_sol else ' _(문제 설명만 있음)_'
    w(f'- [{num}. {slug.replace("-", " ")}]({base}/leetcode/{d}) · [문제](https://leetcode.com/problems/{slug}/){note}')
w('\n</details>\n')
w(f'<details>\n<summary>단일 파일 ({len(lc_files)})</summary>\n')
for f in lc_files:
    name = os.path.splitext(f)[0].strip('_').replace('_', ' ')
    w(f'- [{name}]({base}/leetcode/{f})')
w('\n</details>\n')

sys.stdout.write('\n'.join(out).rstrip() + '\n')
