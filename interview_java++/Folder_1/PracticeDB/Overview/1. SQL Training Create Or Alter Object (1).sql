SP_WHO active;

Create Table Testing_1
(
	ID Int Identity(1,1) Primary key,
	Name Varchar(100)
)

Alter Table Testing_1
Add Contact_No varchar(100)

Alter Table Testing_1
Alter Column Contact_no Bigint


Create\Alter View View_Empoyee_Table
As
Select 
a.EmpID
,a.Emp_First_Name
,a.Emp_Last_Name
,a.Date_Of_Join
,a.Date_Of_Birth
,a.Department_ID
,a.Designation_ID
,b.Department_Name
from Employee_Table a
Inner Join Department_Table B On a.Department_ID=b.Department_ID


Alter function UFn_Emplyee_Name(@EmpID As int)
Returns Varchar(100)
As
Begin
	Declare @Emp_Name varchar(100)
	Select @Emp_Name=Emp_First_Name + ' ' + Emp_Last_Name
	From Employee_Table 
	Where EmpID=EmpID
	Return @Emp_Name
End

Select dbo.UFn_Emplyee_Name(1)


Create Function UFN_Employee_Info(@EmpID Int)
Returns Table
As
Return
Select EmpID,Emp_First_Name,Emp_Last_Name,Contact_No from Employee_Table Where EmpID=@empID

Drop function UFN_Employee_Info

Alter Function UFN_Employee_Info(@EmpID Int)
Returns 
@Output Table 
(EmpID Int,Emp_First_Name varchar(100),Emp_Last_Name varchar(100),Contact_no varchar(100))
As
Begin

Insert into @Output
Select EmpID,Emp_First_Name,Emp_Last_Name,Contact_No from Employee_Table Where EmpID=@empID
Return

End


Select * from dbo.UFN_Employee_Info(1)


Create\Alter Procedure USP_Employee_Report (@FromJoinDt Date, @ToJoinDate Date)
As
Select a.*,b.Designation from Employee_Table A
Inner Join Designation_Table b On a.Designation_ID=b.Designation_ID
Where Date_Of_Join Between @FromJoinDt and @ToJoinDate


USP_Employee_Report '2021-01-01','2021-01-31'


Create trigger Trg_Employee 
On Employee_Table
Instead of Delete
As
Raiserror ('You are not allowed to delete',1,10);

Delete from Employee_Table

Select * from Employee_Table

Create trigger Trg_Testing1 
On Testing_1
After Insert
As
Update A
Set NAme='MR'+a.Name
From Testing_1 A
Inner Join inserted B On A.ID=b.ID

Insert Into Testing_1(Name,Contact_No)
Select 'Yogesh','111111111'

Select * from Testing_1






