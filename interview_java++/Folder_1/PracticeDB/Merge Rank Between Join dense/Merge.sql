Drop table #EmployeeSource
Create Table #EmployeeSource
(
	EmpName varchar(100),
	DOB Date,
	DOJ Date,
	Designation varchar(100),
	ContactNo varchar(100)
)

Drop table #EmployeeDestination
Create Table #EmployeeDestination
(
	EmpName varchar(100),
	DOB Date,
	DOJ Date,
	Designation varchar(100),
	ContactNo varchar(100)
)

Insert into #EmployeeSource
Values
('Employee 1','1990-01-01','2021-01-01','Trainee','1234567890'),
('Employee 2','1990-01-03','2021-03-01','Developer','1234567891'),
('Employee 3','1990-01-04','2021-03-01','Sr Developer','1234567892')

Insert into #EmployeeDestination
Values
('Employee 1','1990-01-01','2021-01-01','Trainee','1234567890'),
('Employee 2','1990-01-03','2021-03-01','JR Developer','1234567891'),
('Employee 4','1990-01-03','2021-03-01','JR Developer','1234567893')

Update #EmployeeSource
Set Designation='Manager'
Where EmpName='Employee 1'


MERGE #EmployeeDestination AS TR
USING #EmployeeSource as SR
ON TR.EmpName=SR.EmpName
WHEN MATCHED And Isnull(TR.Designation,'')<>Isnull(SR.Designation,'')
THEN Update Set Designation=SR.Designation
When not Matched by Target
THEN Insert (Empname,DOB,DOJ,Designation,ContactNo) Values(SR.EmpName,SR.DOB,SR.DOJ,SR.Designation,SR.ContactNo)
WHEN NOT MATCHED BY SOURCE
THEN DELEte;

Select * From #EmployeeSource
Select * from #EmployeeDestination


Delete from #EmployeeSource Where EmpName='Employee 1'

Insert into #EmployeeSource
Values
('Employee 5','1990-01-01','2021-01-01','SR Dev','1234567899')