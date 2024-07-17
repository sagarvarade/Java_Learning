Use Dev_Yogesh
Go

Create Table Department_Table
(
	Department_ID Int identity(1,1) Primary key,
	Department_Name Varchar(100),
	Department_Description varchar(255)
)
Go
Create Table Designation_Table
(
	Designation_ID Int identity(1,1) Primary key,
	Designation Varchar(100),
)
Go
Create Table Month_Table
(
	MonthID Int identity(1,1) Primary key,
	[MonthName] Varchar(100),
	TotalDay Int,
	MonthFirstDate Date,
	MonthLastDate Date
)
Go
Create Table Project_Table
(
	ProjectID Int identity(1,1) Primary key,
	ProjectName Varchar(100),
	StartDate Date,
	EndDate Date
)
Go
Create Table Employee_Table
(
	EmpID Int Identity(1,1) Primary Key,
	Emp_First_Name Varchar(100),
	Emp_Last_Name varchar(100),
	Date_Of_Join Date,
	Date_Of_Birth Date,
	Department_ID Int,
	Designation_ID Int,
	[Address] Varchar(500),
	Contact_No Int,
	Email varchar(100),
	Salary_PM Numeric(25,2),
	Reporting_EmpID Int,
	Foreign Key (Department_ID) References Department_Table(Department_ID),
	Foreign Key (Designation_ID) References Designation_Table(Designation_ID)
)
Go


Create Table Attendance_Table
(
	EmpID Int,
	MonthID Int,
	Days_Present Int,
	Primary key (EmpID,MonthID),
	Foreign Key (Empid) References Employee_Table(EmpID)
)
Go
Create Table Employee_Project_Table
(
	EmpID Int,
	ProjectID Int,
	Primary key (EmpID,ProjectID),
	Foreign Key (EmpID) References Employee_Table(EmpID),
	Foreign Key (ProjectID) References Project_Table(ProjectID)
)
Go

