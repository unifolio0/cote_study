SELECT
    MCDP_CD AS '진료과코드',
    COUNT(APNT_NO) AS '5월예약건수'
FROM
    APPOINTMENT
WHERE
    APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY
    MCDP_CD
ORDER BY
    COUNT(APNT_NO) ASC,
    MCDP_CD ASC
;