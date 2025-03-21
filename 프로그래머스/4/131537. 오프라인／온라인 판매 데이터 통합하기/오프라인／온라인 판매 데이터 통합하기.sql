-- 코드를 입력하세요

# SELECT DATE_FORMAT(SALES_DATE,"%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
# FROM (SELECT * 
#       FROM ONLINE_SALE 
#       UNION ALL
#       SELECT *, NULL AS USER_ID 
#       FROM OFFLINE_SALE) SALES
# WHERE SALES_DATE LIKE '2022-03%'
# ORDER BY SALES_DATE,PRODUCT_ID, USER_ID

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
UNION ALL
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;