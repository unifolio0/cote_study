SELECT
    ANIMAL_TYPE,
    COUNT(ANIMAL_ID) AS 'count'
FROM
    ANIMAL_INS
WHERE
    ANIMAL_TYPE = 'Dog'
    OR ANIMAL_TYPE = 'Cat'
GROUP BY
    ANIMAL_TYPE
ORDER BY
    ANIMAL_TYPE ASC
;