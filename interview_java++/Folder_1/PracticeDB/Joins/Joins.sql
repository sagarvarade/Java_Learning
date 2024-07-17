--Join combine rows from 2 or more tables on the basis of related column

--Joins in SQL (dbms)
--natural
--Inner
--Left
--Right
--Full
--Cross
--Self

--Natrual Join
Select 
Employee_Table.Emp_First_Name,Employee_Table.Emp_Last_Name,
Designation_Table.Designation
from [Employee_Table],[Designation_Table]
Where Employee_Table.Designation_ID=Designation_Table.Designation_ID


Select a.Empname,b.Designation from Table_LJ_Employee A
,Table_Lj_DEsignation b 



Select a.Empname,b.Designation from Table_LJ_Employee A
Cross Join Table_Lj_DEsignation b 
Order by a.empName

Select * from Table_LJ_Employee
Select * from Table_Lj_DEsignation


--Inner Join
Select 
Employee_Table.Emp_First_Name,Employee_Table.Emp_Last_Name,
Designation_Table.Designation
from [Employee_Table] 
Inner Join [Designation_Table]
On Employee_Table.Designation_ID=Designation_Table.Designation_ID

Select a.Empname,b.Designation from Table_LJ_Employee A
Inner Join Table_Lj_DEsignation b On a.DesignationID=b.DesignationID

--Left Join 
Select 
Employee_Table.Emp_First_Name,Employee_Table.Emp_Last_Name,
Designation_Table.Designation
from [Employee_Table] 
Left Join [Designation_Table]
On Employee_Table.Designation_ID=Designation_Table.Designation_ID

Create Table Table_LJ_Employee
(
	EmpID int,
	EmpName varchar(100),
	DesignationID Int
)

Create Table Table_LJ_Designation
(
	DesignationID int,
	Designation varchar(100)
)
Insert into Table_LJ_Employee 
Select 1,'Employee 1',1 Union all
Select 2,'Employee 2',2 Union all
Select 3,'Employee 3',3 Union all
Select 4,'Employee 4',Null

Insert into Table_LJ_Designation
Select 1,'Admin' Union All
Select 2,'IT' Union All
Select 3,'HR' 




Select a.Empname,b.Designation from Table_LJ_Employee A
Left Join Table_Lj_DEsignation b On a.DesignationID=b.DesignationID

--Right Join

Select a.Empname,b.Designation from Table_LJ_Employee A
Right Join Table_Lj_DEsignation b On a.DesignationID=b.DesignationID

Select a.Empname,b.Designation from Table_Lj_DEsignation b  
Right Join Table_LJ_Employee A On a.DesignationID=b.DesignationID

--Full Join 
Insert into Table_LJ_Designation
Select 4, 'Service Delivery'

Select a.Empname,b.Designation from Table_Lj_DEsignation b  
Full Join Table_LJ_Employee A On a.DesignationID=b.DesignationID

