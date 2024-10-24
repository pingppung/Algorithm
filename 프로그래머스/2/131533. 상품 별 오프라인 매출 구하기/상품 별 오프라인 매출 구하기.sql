SELECT P.PRODUCT_CODE, SUM(OS.SALES_AMOUNT) * P.PRICE AS SALES
FROM PRODUCT P
JOIN OFFLINE_SALE OS ON OS.PRODUCT_ID = P.PRODUCT_ID
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE ASC;