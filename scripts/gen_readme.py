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
