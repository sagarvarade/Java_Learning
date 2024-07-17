---Cursors

DECLARE @EmpID int
DECLARE @Fullname varchar(50)
DECLARE @DateofBirth Date

DECLARE Cursor1 CURSOR
STATIC FOR 
SELECT EmpID,Emp_First_Name + ' ' + Emp_Last_Name FullName,Date_Of_Birth from Employee_Table
Where 1!=1

OPEN Cursor1

IF @@CURSOR_ROWS > 0
BEGIN 

	FETCH NEXT FROM Cursor1 INTO @EmpId,@FullName,@DateofBirth
	WHILE @@Fetch_status = 0
	BEGIN

		Select 'Employee Id : '+ convert(varchar(20),@EmpId)+', Name : '+@Fullname+ ', Salary : '
		+convert(varchar,@DateofBirth,106)
		FETCH NEXT FROM Cursor1 INTO @EmpId,@FullName,@DateofBirth
	END
END

CLOSE Cursor1
DEALLOCATE Cursor1
