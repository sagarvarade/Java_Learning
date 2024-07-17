---Row Numer
Select Row_number() Over(Order by CustomerKey) as ID,* From [DimCustomer]

Create table #Employee 
(EmployeeName varchar(100))

Insert Into #Employee values
('Employee 1'),
('Employee 2'),
('Employee 3'),
('Employee 1'),
('Employee 2'),
('Employee 3'),
('Employee 4')


;with Cte1
As
(
	Select ROW_NUMBER() Over(Partition by Employeename Order by Employeename) id,EmployeeName 
	from #Employee
)
Select * from cte1 where ID>1
-----------------------------------------------------
--Rank and Dense Rank
Select Rank() Over(Order by Employeename),* from #Employee
Select Dense_Rank() Over(Order by Employeename),* from #Employee

------------------------------------------------------------
--Ntile

Select Ntile(4) Over (Order by EmployeeNAme) ID ,* from #Employee

