CTE/CTE recursive

---CTE stand for Common table expression
--1) CTE can be use as temporary table
--2) Using to simplify the complex queries

Select * from Employee_Table
Select * from Designation_Table
Select * from Department_Table
Select * from Employee_Project_Table
Select * from Project_Table

Select A.EmpID,A.Emp_First_Name + ' ' + A.Emp_Last_Name EmployeeFullName,
a.Email EmployeeEmail,
B.Designation EmployeeDesignation,
C.Department_Name EmployeeDepartmentname,
E.ProjectName
from Employee_Table A
Inner Join Designation_Table B On A.Department_ID=b.Designation_ID
Inner Join Department_Table C On A.Department_ID=c.Department_ID
inner join Employee_Project_Table d On d.EmpID=a.EmpID
inner join Project_Table E on d.ProjectID=e.ProjectID

;With Cte_empdetails_1 (EmpID,Department_ID,EmpFullName,EmployeeEmail,Designation)as
(
	Select a.EmpID,a.Department_ID,A.Emp_First_Name + ' ' + A.Emp_Last_Name , 
	a.email EmployeeEmail,
	b.Designation
	from Employee_Table a
	Inner Join Designation_Table B On A.Designation_ID=B.Designation_ID
),
Cte_empdetails_2 as
(
	Select a.*,B.Department_Name from Cte_empdetails_1 A
	Inner join Department_Table B On A.Department_ID=B.Department_ID
),
Cte_empdetails_3 as
(
	Select a.*,b.ProjectID from Cte_empdetails_2 a
	Inner Join Employee_Project_Table b On A.EmpID=b.ProjectID
),
Cte_empdetails_4 As
(
	Select a.*,b.ProjectName from Cte_empdetails_3 a
	inner join Project_Table B On A.ProjectID=b.ProjectID
)
Select * from Cte_empdetails_4

;With Cte_Employeewithmanager As
(
	Select a.EmpID,a.Department_ID,A.Emp_First_Name + ' ' + A.Emp_Last_Name  EmpFullName,A.Reporting_EmpID
	from Employee_Table a	
)
Select a.* ,
(Select b.Emp_First_Name + ' ' + b.Emp_Last_Name From Employee_Table B Where a.Reporting_EmpID=b.EmpID) Managername
from Cte_Employeewithmanager A





