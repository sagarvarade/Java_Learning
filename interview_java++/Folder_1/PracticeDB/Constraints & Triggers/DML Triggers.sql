Create Table TableTrig1
(
	Id Int Primary key,
	Name varchar(100)
)


Insert into TableTrig1
Select 1,'abc' Union all
Select 2,'bcd'

Alter trigger tr_TableTrig1
On TableTrig1
--FOR/After/
Instead of Delete
as
Begin
	
	Raiserror ('You are not authorised to delete data',1,10);
End


--disable trigger dbo.tr_TableTrig1 on  dbo.TableTrig1

Create Table TableTrig2
(
	Id Int ,
	Name varchar(100)
)


Create trigger tr_TableTrig2
On TableTrig1
--FOR/After/
after Delete
as
Begin
	
	Insert into TableTrig2
	Select ID,Name from deleted
End


Delete from TableTrig1 Where Id =2
Select * from TableTrig1
Select * from TableTrig2
