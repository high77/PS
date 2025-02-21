# -- 코드를 입력하세요

SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE,"%Y-%m-%d")
FROM REST_REVIEW R
JOIN MEMBER_PROFILE M
ON R.MEMBER_ID = M.MEMBER_ID
WHERE R.MEMBER_ID 
IN (SELECT MEMBER_ID 
    FROM REST_REVIEW  
    GROUP BY MEMBER_ID 
    HAVING COUNT(*) = (SELECT COUNT(*)
                      FROM REST_REVIEW  
                      GROUP BY MEMBER_ID 
                      ORDER BY COUNT(*) DESC
                      LIMIT 1))
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT
