SELECT
	a.score AS Score,
	( SELECT count( DISTINCT b.score ) FROM scores b WHERE b.score >= a.score ) AS Rank 
FROM
	scores a 
ORDER BY
	score DESC;
	
	
