--1)	
--Write query using Employee_Table and Department_table to print Department_Name, 
--Minimum salary and Maximum salary.

select top(5) * from Employee_Table;
select top(5) * from Department_table;

select d.Department_Name, min(e.Salary_PM) as [Minnimum Salary],max(e.Salary_PM )  as [Maximum salary] from Employee_Table e
inner join Department_table d on e.Department_Id=d.Department_Id
group by d.Department_Name

----------------------------------------------------
-- 2)	Write query using Employee_table , Designation_table, Department_Table and Attendance_Table to print
--EmployeeFullName,Designation,Department_Name, AgverageAttendance


select top(5) * from Employee_Table;
select top(5) * from Designation_Table;
select top(5) * from Department_Table;

select e.Emp_First_Name+' '+Emp_Last_Name as FullName,d.Designation, dp.Department_Name, AVG(a.Days_Present) as [Average attendence]
from 
Employee_table e inner join  Designation_Table d on e.Designation_ID=d.Designation_ID 
inner join Department_Table dp on e.Department_ID = dp.Department_ID
inner join Attendance_Table a on e.EmpId=a.EmpID
group by e.Emp_First_Name+' '+Emp_Last_Name,d.Designation, dp.Department_Name;


select top(5) * from Attendance_Table;=dp.Designation_ID 

--3)Write query using Employee_Table, Employee_Project_table to find out the EmployeefullName to whom no project assigned

select top(10) * from Employee_Table;
select top(10) * from Employee_Project_Table;

Select e.Emp_First_Name+' '+Emp_Last_Name as FullName
from Employee_Table e left join Employee_Project_Table p on
e.EmpID=p.EmpId where p.ProjectId IS NULL

-------------------


Create Table Table_SSISSource
(
 Id Int,
 Name Varchar(100),
 Address Varchar(100)
)

Insert into Table_SSISSource
Values(1,'Name1','Address1')
,(2,'Name2','Address2')
,(3,'Name3','Address3')
,(4,'Name4','Address4')
,(5,'Name5','Address5')

Select * from Table_SSISSource

Create Table Table_SSISDestination
(
 Id Int,
 Name Varchar(100),
 Address Varchar(100)
)

Select * from Table_SSISDestination