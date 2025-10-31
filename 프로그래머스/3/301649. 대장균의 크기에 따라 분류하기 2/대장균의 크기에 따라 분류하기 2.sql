-- 크기를 내름차순으로 정렬했을 때 상위 0% ~ 25% 를 'CRITICAL', 26% ~ 50% 를 'HIGH', 51% ~ 75% 를 'MEDIUM', 76% ~ 100% 를 'LOW' 
--  ID(ID) 와 분류된 이름(COLONY_NAME)을 출력
-- ID 오름
WITH E AS (
    SELECT ID, NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS G
    FROM ECOLI_DATA 
)

SELECT ID, (CASE WHEN G=1 THEN 'CRITICAL'
                 WHEN G=2 THEN 'HIGH'
                 WHEN G=3 THEN 'MEDIUM'
                 WHEN G=4 THEN 'LOW'
                 END
    ) AS COLONY_NAME
FROM E
ORDER BY ID
