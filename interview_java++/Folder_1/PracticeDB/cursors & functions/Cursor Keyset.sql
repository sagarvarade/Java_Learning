--SELECT EmpID,Emp_First_Name ,Date_Of_Birth into testemp from Employee_Table
---Cursors

--Create table TableKeysetCursorExample
--(
--	Id Int,
--	Employeename varchar(100)
--)

--Alter table TableKeysetCursorExample
--Add constraint ConsID Unique(ID)

--Insert into TableKeysetCursorExample
--Select 1,'Employee 1' Union All
--Select 2,'Employee 2' Union All
--Select 3,'Employee 3' Union All
--Select 4,'Employee 4' 



DECLARE @EmpID int
DECLARE @Fullname varchar(50)


DECLARE Cursor1 CURSOR
Keyset FOR 
SELECT ID,Employeename from TableKeysetCursorExample

OPEN Cursor1

FETCH First FROM Cursor1 INTO @EmpId,@FullName

WHILE @@Fetch_status = 0
BEGIN

	Select 'Employee Id : '+ convert(varchar(20),@EmpId)+', Name : '+@Fullname
	FETCH NEXT FROM Cursor1 INTO @EmpId,@FullName
	Waitfor delay '00:00:03';

END

CLOSE Cursor1
DEALLOCATE Cursor1
