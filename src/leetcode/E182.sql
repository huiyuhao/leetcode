SELECT DISTINCT
	a.Email 
FROM
	Person a,
	Person b 
WHERE
	a.Id != b.Id 
	AND a.Email = b.Email;
	

SELECT
	Email 
FROM
	( SELECT Email, count( Email ) AS num from Person GROUP BY Email ) as s
WHERE
	num > 1;
	
	
SELECT
	Email 
FROM
	Person 
GROUP BY
	Email 
HAVING
	count( Email ) > 1;