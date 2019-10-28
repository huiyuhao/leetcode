SELECT
	ifnull( ( SELECT num FROM my_numbers GROUP BY num HAVING count( num ) = 1 ORDER BY num DESC LIMIT 1 ), NULL ) AS num;
