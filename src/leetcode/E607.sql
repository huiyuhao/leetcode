select salesperson.name from salesperson 
where salesperson.name not in
(select distinct a.name from salesperson as a, company as b,orders as c
where b.name = 'RED' and c.com_id = b.com_id and a.sales_id = c.sales_id)