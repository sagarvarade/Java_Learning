
----Cte Insert example
;With Cte_Employeewithmanager As
(
	Select a.EmpID,a.Department_ID,A.Emp_First_Name + ' ' + A.Emp_Last_Name  EmpFullName,A.Reporting_EmpID
	from Employee_Table a	
)
Select a.* ,
(Select b.Emp_First_Name + ' ' + b.Emp_Last_Name From Employee_Table B Where a.Reporting_EmpID=b.EmpID) Managername
Into #Table1
from Cte_Employeewithmanager A

Select * from #Table1


------Cte with update
Alter table #Table1 
Add DepartmentNAme varchar(100)

;with Cte1
as
(Select * 
from #Table1)
Update A
Set DepartmentNAme=c.Department_Name
From Cte1 a
Inner Join Department_Table c On a.Department_ID=c.Department_ID

----Cte with Delete
;With Cte as( Select * from #Table1)
Delete Cte where EmpID=1

