SELECT
	a.NAME AS Customers 
FROM
	Customers a
	LEFT JOIN orders b ON a.Id = b.customerId 
WHERE
	b.CustomerId IS NULL;
	

	
SELECT
	Customers.NAME AS Customers 
FROM
	Customers 
WHERE
	Customers.id NOT IN ( SELECT CustomerId FROM Orders );