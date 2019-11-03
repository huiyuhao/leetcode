SELECT
	Department.NAME AS Department,
	Employee.NAME AS Employee,
	Employee.salary AS Salary 
FROM
	Employee
	JOIN Department ON Employee.DepartmentId = Department.Id 
WHERE
	( Employee.DepartmentId, Salary ) IN ( SELECT DepartmentId, max( Salary ) FROM Employee GROUP BY DepartmentId )