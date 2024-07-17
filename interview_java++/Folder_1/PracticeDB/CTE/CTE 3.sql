---Cte with Recursion
Create Table #exampleCteRecursive
(
	ID Int
)
Insert into #exampleCteRecursive Values(1)

Select * from #exampleCteRecursive

;with fortest as
(
	Select ID from #exampleCteRecursive
	Union All
	Select ID+1 from Fortest
	--Where Id<500
	
)
Select * from fortest
Option (Maxrecursion 100000)

----Cte recursion with example of hirachy
Create table #employee
(
	EmpName varchar(10),
	MgrName varchar(10)
)

Insert into #employee
Select 'A','Boss' Union All
Select 'B','A' Union All
Select 'C','A' Union All
Select 'D','B' Union All
Select 'E','B' Union All
Select 'F','C' Union All
Select 'G','C' 

Declare @Empname varchar(10)='E'
;With Cte1 As 
(
	Select A.EmpName,A.MgrName from #employee A
	Where A.EmpName=@Empname
	Union All
	Select A.EmpName,a.MgrName From #employee A 
	inner Join cte1 B On B.EmpName=a.MgrName
)

Select * from Cte1

