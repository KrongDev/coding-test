-- 프로그래머스 - 흉부외과 또는 일반외과 의사 목록 출력하기 (SELECT)
-- IN으로 진료과 필터, 고용일 내림차순 → 이름 오름차순 정렬
-- HIRE_YMD는 DATE 타입이라 기본 출력이 YYYY-MM-DD
SELECT DR_NAME, DR_ID, MCDP_CD, HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME;
