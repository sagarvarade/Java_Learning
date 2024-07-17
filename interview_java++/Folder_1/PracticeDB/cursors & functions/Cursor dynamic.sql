--SELECT EmpID,Emp_First_Name ,Date_Of_Birth into testemp from Employee_Table
---Cursors

DECLARE @EmpID int
DECLARE @Fullname varchar(50)
DECLARE @DateofBirth Date

DECLARE Cursor1 CURSOR
Dynamic FOR 
SELECT EmpID,Emp_First_Name ,Date_Of_Birth from Employee_Table

OPEN Cursor1

FETCH First FROM Cursor1 INTO @EmpId,@FullName,@DateofBirth

WHILE @@Fetch_status = 0
BEGIN

	Select 'Employee Id : '+ convert(varchar(20),@EmpId)+', Name : '+@Fullname+ ', Salary : '
	+convert(varchar,@DateofBirth,106)
	FETCH NEXT FROM Cursor1 INTO @EmpId,@FullName,@DateofBirth
	Waitfor delay '00:00:02';

END

CLOSE Cursor1
DEALLOCATE Cursor1
