# 🧩 Coding Test

백준 · 프로그래머스 · LeetCode 알고리즘 문제 풀이 저장소입니다. (Java / SQL)

## 📊 현황

| 플랫폼 | 풀이 수 | 구성 |
| --- | ---: | --- |
| 백준 | 119 | 브론즈 15 · 실버 83 · 골드 21 |
| 프로그래머스 | 91 | Level 1 51 · Level 2 27 · Level 3 4 · Level 4 1 · PCCP 모의고사 1회 7 · 기타 1 |
| LeetCode | 70 | 문제별 폴더 37 · 단일 파일 33 |
| **합계** | **280** | |

## 📁 구조

```
src/main/java/com/codingTest/
├── baekzoon/      # 백준 — bronze / silver / gold
├── programers/    # 프로그래머스 — level1 ~ level4 / pccp / test
└── leetcode/      # LeetCode — LeetHub 자동 업로드 폴더 + 직접 작성한 파일
```

- **빌드:** Gradle (Java), 테스트는 JUnit 5
- **커밋 규칙:** `feat: 백준 골드5 Z 문제해결`, `feat: 프로그래머스 레벨2 ... 문제 해결`

## ⚙️ LeetCode 자동화

1. [LeetHub v2](https://github.com/arunbhardwaj/LeetHub-2.0)가 LeetCode 제출 시 저장소 루트에 `0058-length-of-last-word/` 형태로 커밋합니다.
2. GitHub Actions(`.github/workflows/move-leetcode.yml`)가 해당 폴더를 `src/main/java/com/codingTest/leetcode/`로 옮깁니다.

## 📝 문제 목록

### 백준

<details>
<summary>브론즈 (15)</summary>

- [1919](https://www.acmicpc.net/problem/1919) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem1919.java)
- [1934](https://www.acmicpc.net/problem/1934) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem1934.java)
- [2748](https://www.acmicpc.net/problem/2748) 피보나치 수 2 · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem2748.java)
- [5073](https://www.acmicpc.net/problem/5073) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem5073.java)
- [8958](https://www.acmicpc.net/problem/8958) OX퀴즈 · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem8958.java)
- [9933](https://www.acmicpc.net/problem/9933) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem9933.java)
- [11328](https://www.acmicpc.net/problem/11328) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem11328.java)
- [13300](https://www.acmicpc.net/problem/13300) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem13300.java)
- [23881](https://www.acmicpc.net/problem/23881) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem23881.java)
- [23968](https://www.acmicpc.net/problem/23968) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem23968.java)
- [23969](https://www.acmicpc.net/problem/23969) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem23969.java)
- [27160](https://www.acmicpc.net/problem/27160) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem27160.java)
- [29701](https://www.acmicpc.net/problem/29701) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem29701.java)
- [30010](https://www.acmicpc.net/problem/30010) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem30010.java)
- [31562](https://www.acmicpc.net/problem/31562) · [풀이](src/main/java/com/codingTest/baekzoon/bronze/Problem31562.java)

</details>

<details>
<summary>실버 (83)</summary>

- [1002](https://www.acmicpc.net/problem/1002) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1002.java)
- [1010](https://www.acmicpc.net/problem/1010) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1010.java)
- [1018](https://www.acmicpc.net/problem/1018) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1018.java)
- [1021](https://www.acmicpc.net/problem/1021) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1021.java)
- [1024](https://www.acmicpc.net/problem/1024) 수열의 합 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1024.java)
- [1049](https://www.acmicpc.net/problem/1049) 기타줄 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1049.java)
- [1051](https://www.acmicpc.net/problem/1051) 숫자 정사각형 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1051.java)
- [1057](https://www.acmicpc.net/problem/1057) 토너먼트 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1057.java)
- [1059](https://www.acmicpc.net/problem/1059) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1059.java)
- [1063](https://www.acmicpc.net/problem/1063) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1063.java)
- [1064](https://www.acmicpc.net/problem/1064) 평행사변형 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1064.java)
- [1149](https://www.acmicpc.net/problem/1149) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1149.java)
- [1260](https://www.acmicpc.net/problem/1260) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1260.java)
- [1309](https://www.acmicpc.net/problem/1309) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1309.java)
- [1463](https://www.acmicpc.net/problem/1463) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1463.java)
- [1475](https://www.acmicpc.net/problem/1475) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1475.java)
- [1654](https://www.acmicpc.net/problem/1654) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1654.java)
- [1699](https://www.acmicpc.net/problem/1699) 제곱수의 합 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1699.java)
- [1735](https://www.acmicpc.net/problem/1735) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1735.java)
- [1822](https://www.acmicpc.net/problem/1822) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1822.java)
- [1904](https://www.acmicpc.net/problem/1904) 01타일 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1904.java)
- [1912](https://www.acmicpc.net/problem/1912) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1912.java)
- [1920](https://www.acmicpc.net/problem/1920) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1920.java)
- [1932](https://www.acmicpc.net/problem/1932) 정수 삼각형 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1932.java)
- [1935](https://www.acmicpc.net/problem/1935) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1935.java)
- [1991](https://www.acmicpc.net/problem/1991) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem1991.java)
- [2002](https://www.acmicpc.net/problem/2002) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2002.java)
- [2003](https://www.acmicpc.net/problem/2003) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2003.java)
- [2156](https://www.acmicpc.net/problem/2156) 포도주 시식 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2156.java)
- [2161](https://www.acmicpc.net/problem/2161) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2161.java)
- [2193](https://www.acmicpc.net/problem/2193) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2193.java)
- [2358](https://www.acmicpc.net/problem/2358) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2358.java)
- [2579](https://www.acmicpc.net/problem/2579) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2579.java)
- [2805](https://www.acmicpc.net/problem/2805) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem2805.java)
- [3273](https://www.acmicpc.net/problem/3273) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem3273.java)
- [3986](https://www.acmicpc.net/problem/3986) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem3986.java)
- [4358](https://www.acmicpc.net/problem/4358) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem4358.java)
- [5568](https://www.acmicpc.net/problem/5568) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem5568.java)
- [9095](https://www.acmicpc.net/problem/9095) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9095.java)
- [9184](https://www.acmicpc.net/problem/9184) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9184.java)
- [9322](https://www.acmicpc.net/problem/9322) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9322.java)
- [9372](https://www.acmicpc.net/problem/9372) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9372.java)
- [9461](https://www.acmicpc.net/problem/9461) 파도반 수열 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9461.java)
- [9465](https://www.acmicpc.net/problem/9465) 스티커 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9465.java)
- [9536](https://www.acmicpc.net/problem/9536) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9536.java)
- [9655](https://www.acmicpc.net/problem/9655) 돌 게임 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9655.java)
- [9934](https://www.acmicpc.net/problem/9934) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem9934.java)
- [10546](https://www.acmicpc.net/problem/10546) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem10546.java)
- [10844](https://www.acmicpc.net/problem/10844) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem10844.java)
- [10845](https://www.acmicpc.net/problem/10845) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem10845.java)
- [11048](https://www.acmicpc.net/problem/11048) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11048.java)
- [11051](https://www.acmicpc.net/problem/11051) 이항 계수 2 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11051.java)
- [11052](https://www.acmicpc.net/problem/11052) 카드 구매하기 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11052.java)
- [11053](https://www.acmicpc.net/problem/11053) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11053.java)
- [11055](https://www.acmicpc.net/problem/11055) 가장 큰 증가하는 부분 수열 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11055.java)
- [11057](https://www.acmicpc.net/problem/11057) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11057.java)
- [11660](https://www.acmicpc.net/problem/11660) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11660.java)
- [11722](https://www.acmicpc.net/problem/11722) 가장 긴 감소하는 부분 수열 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11722.java)
- [11725](https://www.acmicpc.net/problem/11725) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11725.java)
- [11726](https://www.acmicpc.net/problem/11726) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11726.java)
- [11727](https://www.acmicpc.net/problem/11727) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11727.java)
- [11899](https://www.acmicpc.net/problem/11899) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem11899.java)
- [12789](https://www.acmicpc.net/problem/12789) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem12789.java)
- [13335](https://www.acmicpc.net/problem/13335) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem13335.java)
- [13414](https://www.acmicpc.net/problem/13414) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem13414.java)
- [14244](https://www.acmicpc.net/problem/14244) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem14244.java)
- [14501](https://www.acmicpc.net/problem/14501) 퇴사 · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem14501.java)
- [14713](https://www.acmicpc.net/problem/14713) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem14713.java)
- [15815](https://www.acmicpc.net/problem/15815) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem15815.java)
- [16165](https://www.acmicpc.net/problem/16165) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem16165.java)
- [17219](https://www.acmicpc.net/problem/17219) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem17219.java)
- [17413](https://www.acmicpc.net/problem/17413) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem17413.java)
- [19583](https://www.acmicpc.net/problem/19583) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem19583.java)
- [20291](https://www.acmicpc.net/problem/20291) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem20291.java)
- [20920](https://www.acmicpc.net/problem/20920) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem20920.java)
- [22233](https://www.acmicpc.net/problem/22233) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem22233.java)
- [24060](https://www.acmicpc.net/problem/24060) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem24060.java)
- [25192](https://www.acmicpc.net/problem/25192) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem25192.java)
- [25325](https://www.acmicpc.net/problem/25325) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem25325.java)
- [25757](https://www.acmicpc.net/problem/25757) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem25757.java)
- [26069](https://www.acmicpc.net/problem/26069) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem26069.java)
- [28278](https://www.acmicpc.net/problem/28278) · [풀이](src/main/java/com/codingTest/baekzoon/silver/Problem28278.java)
- 섬의 개수 · [풀이](src/main/java/com/codingTest/baekzoon/silver/섬의_개수.java)

</details>

<details>
<summary>골드 (21)</summary>

- [1005](https://www.acmicpc.net/problem/1005) ACM Craft · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1005.java)
- [1013](https://www.acmicpc.net/problem/1013) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1013.java)
- [1016](https://www.acmicpc.net/problem/1016) 제곱 ㄴㄴ 수 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1016.java)
- [1027](https://www.acmicpc.net/problem/1027) 고층 건물 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1027.java)
- [1068](https://www.acmicpc.net/problem/1068) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1068.java)
- [1074](https://www.acmicpc.net/problem/1074) Z · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1074.java)
- [1520](https://www.acmicpc.net/problem/1520) 내리막 길 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1520.java)
- [1717](https://www.acmicpc.net/problem/1717) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem1717.java)
- [2110](https://www.acmicpc.net/problem/2110) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem2110.java)
- [2293](https://www.acmicpc.net/problem/2293) 동전 1 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem2293.java)
- [2294](https://www.acmicpc.net/problem/2294) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem2294.java)
- [2493](https://www.acmicpc.net/problem/2493) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem2493.java)
- [2565](https://www.acmicpc.net/problem/2565) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem2565.java)
- [3584](https://www.acmicpc.net/problem/3584) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem3584.java)
- [5639](https://www.acmicpc.net/problem/5639) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem5639.java)
- [9251](https://www.acmicpc.net/problem/9251) LCS · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem9251.java)
- [9663](https://www.acmicpc.net/problem/9663) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem9663.java)
- [9935](https://www.acmicpc.net/problem/9935) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem9935.java)
- [11054](https://www.acmicpc.net/problem/11054) 가장 긴 바이토닉 부분 수열 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem11054.java)
- [12865](https://www.acmicpc.net/problem/12865) 평범한 배낭 · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem12865.java)
- [14503](https://www.acmicpc.net/problem/14503) · [풀이](src/main/java/com/codingTest/baekzoon/gold/Problem14503.java)

</details>

### 프로그래머스

<details>
<summary>Level 1 (51)</summary>

- [x만큼 간격이 있는 n개의 숫자](src/main/java/com/codingTest/programers/level1/x만큼_간격이_있는_n개의_숫자.java)
- [가운데 글자 가져오기](src/main/java/com/codingTest/programers/level1/가운데_글자_가져오기.java)
- [가장 많이 받은 선물](src/main/java/com/codingTest/programers/level1/가장_많이_받은_선물.java)
- [개인정보 수집 유효기간](src/main/java/com/codingTest/programers/level1/개인정보_수집_유효기간.java)
- [과일 장수](src/main/java/com/codingTest/programers/level1/과일_장수.java)
- [기사단원의 무기](src/main/java/com/codingTest/programers/level1/기사단원의_무기.java)
- [나누어 떨어지는 숫자 배열](src/main/java/com/codingTest/programers/level1/나누어_떨어지는_숫자_배열.java)
- [노란불 신호등](src/main/java/com/codingTest/programers/level1/노란불_신호등.java)
- [다트 게임](src/main/java/com/codingTest/programers/level1/다트_게임.java)
- [동영상 재생기](src/main/java/com/codingTest/programers/level1/동영상_재생기.java)
- [명예의 전당](src/main/java/com/codingTest/programers/level1/명예의_전당.java)
- [몸풀기 1부터 N까지의 숫자 더하기](src/main/java/com/codingTest/programers/level1/몸풀기_1부터_N까지의_숫자_더하기.java)
- [문자열 나누기](src/main/java/com/codingTest/programers/level1/문자열_나누기.java)
- [문자열 내 p와 y의 개수](src/main/java/com/codingTest/programers/level1/문자열_내_p와_y의_개수.java)
- [문자열 내 마음대로 정렬하기](src/main/java/com/codingTest/programers/level1/문자열_내_마음대로_정렬하기.java)
- [문자열 내림차순으로 배치하기](src/main/java/com/codingTest/programers/level1/문자열_내림차순으로_배치하기.java)
- [문자열 다루기 기본](src/main/java/com/codingTest/programers/level1/문자열_다루기_기본.java)
- [문제 2016년](src/main/java/com/codingTest/programers/level1/문제_2016년.java)
- [문제 3진법 뒤집기](src/main/java/com/codingTest/programers/level1/문제_3진법_뒤집기.java)
- [부족한 금액 계산하기](src/main/java/com/codingTest/programers/level1/부족한_금액_계산하기.java)
- [붕대감기](src/main/java/com/codingTest/programers/level1/붕대감기.java)
- [삼총사](src/main/java/com/codingTest/programers/level1/삼총사.java)
- [서울에서 김서방 찾기](src/main/java/com/codingTest/programers/level1/서울에서_김서방_찾기.java)
- [성격 유형 검사하기](src/main/java/com/codingTest/programers/level1/성격_유형_검사하기.java)
- [소수 찾기](src/main/java/com/codingTest/programers/level1/소수_찾기.java)
- [숫자 짝꿍](src/main/java/com/codingTest/programers/level1/숫자_짝꿍.java)
- [시저 암호](src/main/java/com/codingTest/programers/level1/시저_암호.java)
- [신고 결과 받기](src/main/java/com/codingTest/programers/level1/신고_결과_받기.java)
- [실패율](src/main/java/com/codingTest/programers/level1/실패율.java)
- [약수의 개수와 덧셈](src/main/java/com/codingTest/programers/level1/약수의_개수와_덧셈.java)
- [약수의 합](src/main/java/com/codingTest/programers/level1/약수의_합.java)
- [예산](src/main/java/com/codingTest/programers/level1/예산.java)
- [옹알이 2](src/main/java/com/codingTest/programers/level1/옹알이_2.java)
- [완주하지 못한 선수](src/main/java/com/codingTest/programers/level1/완주하지_못한_선수.java)
- [이상한 문자 만들기](src/main/java/com/codingTest/programers/level1/이상한_문자_만들기.java)
- [정수 내림차순으로 배치하기](src/main/java/com/codingTest/programers/level1/정수_내림차순으로_배치하기.java)
- [정수 제곱근 판별](src/main/java/com/codingTest/programers/level1/정수_제곱근_판별.java)
- [제일 작은 수 제거하기](src/main/java/com/codingTest/programers/level1/제일_작은_수_제거하기.java)
- [주식 가격](src/main/java/com/codingTest/programers/level1/주식_가격.java)
- [체육복](src/main/java/com/codingTest/programers/level1/체육복.java)
- [최대공약수와 최소공배수](src/main/java/com/codingTest/programers/level1/최대공약수와_최소공배수.java)
- [코카 문제](src/main/java/com/codingTest/programers/level1/코카_문제.java)
- [콜라츠 추측](src/main/java/com/codingTest/programers/level1/콜라츠_추측.java)
- [크기가 작은 부분 문자열](src/main/java/com/codingTest/programers/level1/크기가_작은_부분_문자열.java)
- [크레인 인형뽑기 게임](src/main/java/com/codingTest/programers/level1/크레인_인형뽑기_게임.java)
- [키패드 누르기](src/main/java/com/codingTest/programers/level1/키패드_누르기.java)
- [폰켓몬](src/main/java/com/codingTest/programers/level1/폰켓몬.java)
- [푸드 파이트 대회](src/main/java/com/codingTest/programers/level1/푸드_파이트_대회.java)
- [하샤드 수](src/main/java/com/codingTest/programers/level1/하샤드_수.java)
- [햄버거 만들기](src/main/java/com/codingTest/programers/level1/햄버거_만들기.java)
- [행렬의 덧셈](src/main/java/com/codingTest/programers/level1/행렬의_덧셈.java)

</details>

<details>
<summary>Level 2 (27)</summary>

- [NQueen](src/main/java/com/codingTest/programers/level2/NQueen.java)
- [거리두기 확인하기](src/main/java/com/codingTest/programers/level2/거리두기_확인하기.java)
- [게임 맵 최단거리](src/main/java/com/codingTest/programers/level2/게임_맵_최단거리.java)
- [과제 진행하기](src/main/java/com/codingTest/programers/level2/과제_진행하기.java)
- [괄호 회전하기](src/main/java/com/codingTest/programers/level2/괄호_회전하기.java)
- [광물 캐기](src/main/java/com/codingTest/programers/level2/광물_캐기.java)
- [기능개발](src/main/java/com/codingTest/programers/level2/기능개발.java)
- [뒤에 있는 큰 수 찾기](src/main/java/com/codingTest/programers/level2/뒤에_있는_큰_수_찾기.java)
- [미로 탈출](src/main/java/com/codingTest/programers/level2/미로_탈출.java)
- [방문 길이](src/main/java/com/codingTest/programers/level2/방문_길이.java)
- [비밀 코드 해독](src/main/java/com/codingTest/programers/level2/비밀_코드_해독.java)
- [서버 증설 횟수](src/main/java/com/codingTest/programers/level2/서버_증설_횟수.java)
- [석유 시추](src/main/java/com/codingTest/programers/level2/석유_시추.java)
- [수식 최대화](src/main/java/com/codingTest/programers/level2/수식_최대화.java)
- [연속된 부분 수열의 합](src/main/java/com/codingTest/programers/level2/연속된_부분_수열의_합.java)
- [영어 끝말잇기](src/main/java/com/codingTest/programers/level2/영어_끝말잇기.java)
- [예상 대진표](src/main/java/com/codingTest/programers/level2/예상_대진표.java)
- [오픈채팅방](src/main/java/com/codingTest/programers/level2/오픈채팅방.java)
- [올바른 괄호](src/main/java/com/codingTest/programers/level2/올바른_괄호.java)
- [완전범죄](src/main/java/com/codingTest/programers/level2/완전범죄.java)
- [조이스틱](src/main/java/com/codingTest/programers/level2/조이스틱.java)
- [주식가격](src/main/java/com/codingTest/programers/level2/주식가격.java)
- [짝지어 제거하기](src/main/java/com/codingTest/programers/level2/짝지어_제거하기.java)
- [충돌위험 찾기](src/main/java/com/codingTest/programers/level2/충돌위험_찾기.java)
- [퍼즐 게임 챌린지](src/main/java/com/codingTest/programers/level2/퍼즐_게임_챌린지.java)
- [피로도](src/main/java/com/codingTest/programers/level2/피로도.java)
- [할인 행사](src/main/java/com/codingTest/programers/level2/할인_행사.java)

</details>

<details>
<summary>Level 3 (4)</summary>

- [길 찾기 게임](src/main/java/com/codingTest/programers/level3/길_찾기_게임.java)
- [네트워크](src/main/java/com/codingTest/programers/level3/네트워크.java)
- [베스트앨범](src/main/java/com/codingTest/programers/level3/베스트앨범.java)
- [표 편집](src/main/java/com/codingTest/programers/level3/표_편집.java)

</details>

<details>
<summary>Level 4 (1)</summary>

- [도둑질](src/main/java/com/codingTest/programers/level4/도둑질.java)

</details>

<details>
<summary>PCCP 모의고사 1회 (7)</summary>

- [대충 만든 자판](src/main/java/com/codingTest/programers/pccp/guest1/대충_만든_자판.java)
- [데이터 분석](src/main/java/com/codingTest/programers/pccp/guest1/데이터_분석.java)
- [둘만의 암호](src/main/java/com/codingTest/programers/pccp/guest1/둘만의_암호.java)
- [외톨이 알파벳](src/main/java/com/codingTest/programers/pccp/guest1/외톨이_알파벳.java)
- [이웃한 칸](src/main/java/com/codingTest/programers/pccp/guest1/이웃한_칸.java)
- [체육대회](src/main/java/com/codingTest/programers/pccp/guest1/체육대회.java)
- [카드 뭉치](src/main/java/com/codingTest/programers/pccp/guest1/카드_뭉치.java)

</details>

<details>
<summary>기타 (1)</summary>

- [행렬의 곱셈](src/main/java/com/codingTest/programers/test/행렬의_곱셈.java)

</details>

### LeetCode

<details>
<summary>문제별 폴더 (37)</summary>

- [0058. length of last word](src/main/java/com/codingTest/leetcode/0058-length-of-last-word) · [문제](https://leetcode.com/problems/length-of-last-word/)
- [0066. plus one](src/main/java/com/codingTest/leetcode/0066-plus-one) · [문제](https://leetcode.com/problems/plus-one/)
- [0067. add binary](src/main/java/com/codingTest/leetcode/0067-add-binary) · [문제](https://leetcode.com/problems/add-binary/)
- [0069. sqrtx](src/main/java/com/codingTest/leetcode/0069-sqrtx) · [문제](https://leetcode.com/problems/sqrtx/)
- [0070. climbing stairs](src/main/java/com/codingTest/leetcode/0070-climbing-stairs) · [문제](https://leetcode.com/problems/climbing-stairs/)
- [0080. remove duplicates from sorted array ii](src/main/java/com/codingTest/leetcode/0080-remove-duplicates-from-sorted-array-ii) · [문제](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
- [0088. merge sorted array](src/main/java/com/codingTest/leetcode/0088-merge-sorted-array) · [문제](https://leetcode.com/problems/merge-sorted-array/) _(문제 설명만 있음)_
- [0094. binary tree inorder traversal](src/main/java/com/codingTest/leetcode/0094-binary-tree-inorder-traversal) · [문제](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [0100. same tree](src/main/java/com/codingTest/leetcode/0100-same-tree) · [문제](https://leetcode.com/problems/same-tree/) _(문제 설명만 있음)_
- [0101. symmetric tree](src/main/java/com/codingTest/leetcode/0101-symmetric-tree) · [문제](https://leetcode.com/problems/symmetric-tree/)
- [0104. maximum depth of binary tree](src/main/java/com/codingTest/leetcode/0104-maximum-depth-of-binary-tree) · [문제](https://leetcode.com/problems/maximum-depth-of-binary-tree/) _(문제 설명만 있음)_
- [0108. convert sorted array to binary search tree](src/main/java/com/codingTest/leetcode/0108-convert-sorted-array-to-binary-search-tree) · [문제](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
- [0110. balanced binary tree](src/main/java/com/codingTest/leetcode/0110-balanced-binary-tree) · [문제](https://leetcode.com/problems/balanced-binary-tree/)
- [0112. path sum](src/main/java/com/codingTest/leetcode/0112-path-sum) · [문제](https://leetcode.com/problems/path-sum/)
- [0118. pascals triangle](src/main/java/com/codingTest/leetcode/0118-pascals-triangle) · [문제](https://leetcode.com/problems/pascals-triangle/)
- [0169. majority element](src/main/java/com/codingTest/leetcode/0169-majority-element) · [문제](https://leetcode.com/problems/majority-element/)
- [0175. combine two tables](src/main/java/com/codingTest/leetcode/0175-combine-two-tables) · [문제](https://leetcode.com/problems/combine-two-tables/)
- [0181. employees earning more than their managers](src/main/java/com/codingTest/leetcode/0181-employees-earning-more-than-their-managers) · [문제](https://leetcode.com/problems/employees-earning-more-than-their-managers/)
- [0460. lfu cache](src/main/java/com/codingTest/leetcode/0460-lfu-cache) · [문제](https://leetcode.com/problems/lfu-cache/) _(문제 설명만 있음)_
- [0584. find customer referee](src/main/java/com/codingTest/leetcode/0584-find-customer-referee) · [문제](https://leetcode.com/problems/find-customer-referee/)
- [0620. not boring movies](src/main/java/com/codingTest/leetcode/0620-not-boring-movies) · [문제](https://leetcode.com/problems/not-boring-movies/) _(문제 설명만 있음)_
- [0840. magic squares in grid](src/main/java/com/codingTest/leetcode/0840-magic-squares-in-grid) · [문제](https://leetcode.com/problems/magic-squares-in-grid/) _(문제 설명만 있음)_
- [0944. delete columns to make sorted](src/main/java/com/codingTest/leetcode/0944-delete-columns-to-make-sorted) · [문제](https://leetcode.com/problems/delete-columns-to-make-sorted/) _(문제 설명만 있음)_
- [0955. delete columns to make sorted ii](src/main/java/com/codingTest/leetcode/0955-delete-columns-to-make-sorted-ii) · [문제](https://leetcode.com/problems/delete-columns-to-make-sorted-ii/) _(문제 설명만 있음)_
- [1970. last day where you can still cross](src/main/java/com/codingTest/leetcode/1970-last-day-where-you-can-still-cross) · [문제](https://leetcode.com/problems/last-day-where-you-can-still-cross/)
- [2017. grid game](src/main/java/com/codingTest/leetcode/2017-grid-game) · [문제](https://leetcode.com/problems/grid-game/)
- [2054. two best non overlapping events](src/main/java/com/codingTest/leetcode/2054-two-best-non-overlapping-events) · [문제](https://leetcode.com/problems/two-best-non-overlapping-events/)
- [2110. number of smooth descent periods of a stock](src/main/java/com/codingTest/leetcode/2110-number-of-smooth-descent-periods-of-a-stock) · [문제](https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/)
- [2147. number of ways to divide a long corridor](src/main/java/com/codingTest/leetcode/2147-number-of-ways-to-divide-a-long-corridor) · [문제](https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/)
- [2483. minimum penalty for a shop](src/main/java/com/codingTest/leetcode/2483-minimum-penalty-for-a-shop) · [문제](https://leetcode.com/problems/minimum-penalty-for-a-shop/) _(문제 설명만 있음)_
- [3074. apple redistribution into boxes](src/main/java/com/codingTest/leetcode/3074-apple-redistribution-into-boxes) · [문제](https://leetcode.com/problems/apple-redistribution-into-boxes/) _(문제 설명만 있음)_
- [3432. count partitions with even sum difference](src/main/java/com/codingTest/leetcode/3432-count-partitions-with-even-sum-difference) · [문제](https://leetcode.com/problems/count-partitions-with-even-sum-difference/) _(문제 설명만 있음)_
- [3433. count mentions per user](src/main/java/com/codingTest/leetcode/3433-count-mentions-per-user) · [문제](https://leetcode.com/problems/count-mentions-per-user/)
- [3531. count covered buildings](src/main/java/com/codingTest/leetcode/3531-count-covered-buildings) · [문제](https://leetcode.com/problems/count-covered-buildings/)
- [3577. count the number of computer unlocking permutations](src/main/java/com/codingTest/leetcode/3577-count-the-number-of-computer-unlocking-permutations) · [문제](https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/)
- [3583. count special triplets](src/main/java/com/codingTest/leetcode/3583-count-special-triplets) · [문제](https://leetcode.com/problems/count-special-triplets/)
- [3606. coupon code validator](src/main/java/com/codingTest/leetcode/3606-coupon-code-validator) · [문제](https://leetcode.com/problems/coupon-code-validator/)

</details>

<details>
<summary>단일 파일 (33)</summary>

- [Button with Longest Push Time](src/main/java/com/codingTest/leetcode/Button_with_Longest_Push_Time.java)
- [Combination Sum](src/main/java/com/codingTest/leetcode/Combination_Sum.java)
- [Combination Sum 2](src/main/java/com/codingTest/leetcode/Combination_Sum_2.java)
- [Combine Two Tables](src/main/java/com/codingTest/leetcode/Combine_Two_Tables.sql)
- [Container With Most Water](src/main/java/com/codingTest/leetcode/Container_With_Most_Water.java)
- [Count Square Sum Triples](src/main/java/com/codingTest/leetcode/Count_Square_Sum_Triples.java)
- [Count and Say](src/main/java/com/codingTest/leetcode/Count_and_Say.java)
- [Count odd Numbers in a Interval Range](src/main/java/com/codingTest/leetcode/Count_odd_Numbers_in_a_Interval_Range.java)
- [DesignBrowserHistory](src/main/java/com/codingTest/leetcode/DesignBrowserHistory.java)
- [Find First and Last Position of Element in Sorted Array](src/main/java/com/codingTest/leetcode/Find_First_and_Last_Position_of_Element_in_Sorted_Array.java)
- [Find the Index of the First Occurrence in a String](src/main/java/com/codingTest/leetcode/Find_the_Index_of_the_First_Occurrence_in_a_String.java)
- [Generate Parentheses](src/main/java/com/codingTest/leetcode/Generate_Parentheses.java)
- [LRUCache](src/main/java/com/codingTest/leetcode/LRUCache.java)
- [Letter Combinations of a Phone Number](src/main/java/com/codingTest/leetcode/Letter_Combinations_of_a_Phone_Number.java)
- [Longest Valid Parentheses](src/main/java/com/codingTest/leetcode/Longest_Valid_Parentheses.java)
- [Merge Two Sorted Lists](src/main/java/com/codingTest/leetcode/Merge_Two_Sorted_Lists.java)
- [Merge k Sorted Lists](src/main/java/com/codingTest/leetcode/Merge_k_Sorted_Lists.java)
- [Next Permutation](src/main/java/com/codingTest/leetcode/Next_Permutation.java)
- [Remove Duplicates from sorted Array](src/main/java/com/codingTest/leetcode/Remove_Duplicates_from_sorted_Array.java)
- [Remove Element](src/main/java/com/codingTest/leetcode/Remove_Element.java)
- [Remove Nth Node From End of List](src/main/java/com/codingTest/leetcode/Remove_Nth_Node_From_End_of_List.java)
- [ReverseInteger](src/main/java/com/codingTest/leetcode/ReverseInteger.java)
- [Search Insert Position](src/main/java/com/codingTest/leetcode/Search_Insert_Position.java)
- [Search in Rotated Sorted Array](src/main/java/com/codingTest/leetcode/Search_in_Rotated_Sorted_Array.java)
- [StringToInteger](src/main/java/com/codingTest/leetcode/StringToInteger.java)
- [Sudoku Solver](src/main/java/com/codingTest/leetcode/Sudoku_Solver.java)
- [Swap Nodes in Pairs](src/main/java/com/codingTest/leetcode/Swap_Nodes_in_Pairs.java)
- [TwoSum](src/main/java/com/codingTest/leetcode/TwoSum.java)
- [Valid Parentheses](src/main/java/com/codingTest/leetcode/Valid_Parentheses.java)
- [Valid Sudoku](src/main/java/com/codingTest/leetcode/Valid_Sudoku.java)
- [3Sum](src/main/java/com/codingTest/leetcode/_3Sum.java)
- [3SumClosest](src/main/java/com/codingTest/leetcode/_3SumClosest.java)
- [4Sum](src/main/java/com/codingTest/leetcode/_4Sum.java)

</details>

---

<!-- 아래 영역은 LeetHub가 자동으로 갱신합니다 -->
<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0080-remove-duplicates-from-sorted-array-ii](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0080-remove-duplicates-from-sorted-array-ii) |
| [2110-number-of-smooth-descent-periods-of-a-stock](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/2110-number-of-smooth-descent-periods-of-a-stock) |
## Two Pointers
|  |
| ------- |
| [0080-remove-duplicates-from-sorted-array-ii](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0080-remove-duplicates-from-sorted-array-ii) |
## Database
|  |
| ------- |
| [0584-find-customer-referee](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0584-find-customer-referee) |
## Math
|  |
| ------- |
| [2110-number-of-smooth-descent-periods-of-a-stock](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/2110-number-of-smooth-descent-periods-of-a-stock) |
## Dynamic Programming
|  |
| ------- |
| [2110-number-of-smooth-descent-periods-of-a-stock](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/2110-number-of-smooth-descent-periods-of-a-stock) |
## Stack
|  |
| ------- |
| [0094-binary-tree-inorder-traversal](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0094-binary-tree-inorder-traversal) |
## Tree
|  |
| ------- |
| [0094-binary-tree-inorder-traversal](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0094-binary-tree-inorder-traversal) |
## Depth-First Search
|  |
| ------- |
| [0094-binary-tree-inorder-traversal](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0094-binary-tree-inorder-traversal) |
## Binary Tree
|  |
| ------- |
| [0094-binary-tree-inorder-traversal](https://github.com/KrongDev/coding-test/tree/master/src/main/java/com/codingTest/leetcode/0094-binary-tree-inorder-traversal) |
<!---LeetCode Topics End-->
