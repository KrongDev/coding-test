-- 프로그래머스 - 인기있는 아이스크림 (SELECT)
-- 출력하지 않는 컬럼으로도 정렬 가능: 총주문량 내림차순 → 출하 번호 오름차순
SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;
