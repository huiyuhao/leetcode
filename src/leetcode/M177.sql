CREATE FUNCTION getNthHighestSalary ( N INT ) RETURNS INT BEGIN
	DECLARE
		p INT DEFAULT n - 1;
	IF
		( p < 0 ) THEN
			RETURN NULL;
		ELSE RETURN ( SELECT ifnull( ( SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT p, 1 ), NULL ) AS SecondHighSalary );
	END IF;
END