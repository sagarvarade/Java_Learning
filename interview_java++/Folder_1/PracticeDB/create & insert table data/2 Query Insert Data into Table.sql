
Set Identity_Insert Department_Table On
Go
Insert Into Department_Table (Department_ID,Department_Name,Department_Description) 
Select 1,'HR','HR' Union All 
Select 2,'IT','Information Technology' Union All 
Select 3,'Ops','Operations' Union All 
Select 4,'ADMIN','Administration' 
Go
Set Identity_Insert Department_Table Off
Go

Set Identity_Insert Designation_Table On
Go
Insert Into Designation_Table (Designation_ID,Designation)
Select 1,'Manager' Union All 
Select 2,'Associate Manager' Union All 
Select 3,'Specialist' 
Go
Set Identity_Insert Designation_Table Off
Go

Set Identity_Insert Month_Table On
Go
Insert Into Month_Table (MonthID,[MonthName],TotalDay,MonthFirstDate,MonthLastDate)
Select 1,'Jan-2021','31','01-Jan-2021','31-Jan-2021' Union All 
Select 2,'Feb-2021','28','01-Feb-2021','28-Feb-2021' Union All 
Select 3,'Mar-2021','31','01-Mar-2021','31-Mar-2021' Union All 
Select 4,'Apr-2021','30','01-Apr-2021','30-Apr-2021' Union All 
Select 5,'May-2021','31','01-May-2021','31-May-2021' 
Go
Set Identity_Insert Month_Table Off
Go

Set Identity_Insert Project_Table On
Go
Insert into Project_Table(ProjectID,ProjectName,StartDate,EndDate)
Select 1,'XYZ','01-Jan-2021','15-Feb-2021' Union All 
Select 2,'ZYX','01-Feb-2021','28-Mar-2021' Union All 
Select 3,'WXY','01-Mar-2021','30-Apr-2021' Union All 
Select 4,'YXW','01-Apr-2021','30-May-2021'  
Go
Set Identity_Insert Project_Table Off
Go

Set Identity_Insert Employee_Table On
Go
Insert Into Employee_Table(EmpID,Emp_First_Name,Emp_Last_Name,Date_of_Join,Date_of_Birth,
Department_ID,Designation_ID,[Address],Contact_No,Email,Salary_PM,Reporting_EMPID)
Select '1','ABC','CBA','04-Jan-2021','01-Jan-1987','1','1','FR','1234567890','ABC.CBA@COMPANY.COM','3000',Null Union All 
Select '2','BCD','DCB','01-May-2020','01-Jun-1991','1','2','SA','1234567800','BCD.DCB@COMPANY.COM','2000','1' Union All 
Select '3','CDE','EDC','01-Jan-2021','01-Jan-1992','1','3','US','1234567801','CDE.EDC@COMPANY.COM','1000','2' Union All 
Select '4','DEF','FED','01-Dec-2020','01-Dec-1984','2','1','IN','1234567802','DEF.FED@COMPANY.COM','4000',Null Union All 
Select '5','EFG','GFE','01-Jan-2021','01-Jan-1985','2','2','US','1234567803','EFG.GFE@COMPANY.COM','3000','4' Union All 
Select '6','FGH','HGF','01-Jan-2021','01-Feb-1986','2','3','DE','1234567804','FGH.HGF@COMPANY.COM','2000','5' Union All 
Select '7','GHI','IHG','03-Nov-2020','01-Jan-1990','3','1','FR','1234567805','GHI.IHG@COMPANY.COM','5000',Null Union All 
Select '8','HIJ','JIH','01-Jan-2021','01-Jan-1991','3','2','SA','1234567806','HIJ.JIH@COMPANY.COM','4000','7' Union All 
Select '9','IJK','KJI','01-Mar-2021','01-Jan-1992','3','3','US','1234567807','IJK.KJI@COMPANY.COM','3000','8' Union All 
Select '10','JKL','LKJ','01-Jan-2021','01-Jan-1985','1','3','DE','1234567808','JKL.LKJ@COMPANY.COM','2000','2' Union All 
Select '11','KLM','MLK','01-Jan-2021','01-Jan-1987','2','3','IN','1234567809','KLM.MLK@COMPANY.COM','1500','5' Union All 
Select '12','LMN','NML','01-Jan-2021','19-Jun-1983','3','3','DE','1234567811','LMN.NML@COMPANY.COM','800','8' Union All 
Select '13','MNO','ONM','01-Jan-2021','20-Feb-1988','2','3','DE','1234567812','MNO.ONM@COMPANY.COM','900','5'  
Go
Set Identity_Insert Employee_Table Off
Go



Insert into Attendance_Table(EmpId,MonthID,Days_Present)
Select 1,1,27 Union All 
Select 1,2,28 Union All 
Select 1,3,31 Union All 
Select 1,4,22 Union All 
Select 1,5,27 Union All 
Select 2,1,30 Union All 
Select 2,2,23 Union All 
Select 2,3,30 Union All 
Select 2,4,28 Union All 
Select 2,5,29 Union All 
Select 3,1,29 Union All 
Select 3,2,28 Union All 
Select 3,3,20 Union All 
Select 3,4,30 Union All 
Select 3,5,31 Union All 
Select 4,1,31 Union All 
Select 4,2,27 Union All 
Select 4,3,31 Union All 
Select 4,4,30 Union All 
Select 4,5,31 Union All 
Select 5,1,31 Union All 
Select 5,2,28 Union All 
Select 5,3,31 Union All 
Select 5,4,30 Union All 
Select 5,5,31 Union All 
Select 6,1,31 Union All 
Select 6,2,28 Union All 
Select 6,3,31 Union All 
Select 6,4,30 Union All 
Select 6,5,31 Union All 
Select 7,1,31 Union All 
Select 7,2,28 Union All 
Select 7,3,31 Union All 
Select 7,4,30 Union All 
Select 7,5,31 Union All 
Select 8,1,25 Union All 
Select 8,2,28 Union All 
Select 8,3,30 Union All 
Select 8,4,30 Union All 
Select 8,5,31 Union All 
Select 9,3,31 Union All 
Select 9,4,30 Union All 
Select 9,5,21 Union All 
Select 10,1,31 Union All 
Select 10,2,24 Union All 
Select 10,3,23 Union All 
Select 10,4,22 Union All 
Select 10,5,28 Union All 
Select 11,1,10 Union All 
Select 11,2,10 Union All 
Select 11,3,16 Union All 
Select 11,4,20 Union All 
Select 11,5,22 Union All 
Select 12,1,31 Union All 
Select 12,2,28 Union All 
Select 12,3,31 Union All 
Select 12,4,30 Union All 
Select 12,5,31 Union All 
Select 13,1,31 Union All 
Select 13,2,28 Union All 
Select 13,3,31 Union All 
Select 13,4,30 Union All 
Select 13,5,31 
Go

Insert into Employee_Project_Table(EmpID,ProjectID)
Select 5,1 Union All 
Select 5,2 Union All 
Select 5,3 Union All 
Select 6,1 Union All 
Select 6,2 Union All 
Select 8,1 Union All 
Select 8,2 Union All 
Select 9,1 Union All 
Select 9,3 
Go