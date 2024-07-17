Disable trigger [Trg_Employee] On Employee_Table
Insert into Employee_Table
(
Emp_First_Name
,Emp_Last_Name
,Date_Of_Join
,Date_Of_Birth
,Department_ID
,Designation_ID
,Address
,Contact_No
,Email
,Salary_PM
,Reporting_EmpID)
Select 'Hemant','Patil','2021-01-01','1990-01-01',1,1,'Pune','22222222','hemant@Company.com',1000,1
Enable trigger [Trg_Employee] On Employee_Table