DML Commands - Insert \ Update \ Delete
DDL Commands -Create\Alter \ Truncate


Create Table Table_Truncate_Example
(
	ID Int,
	NAme varchar(100)
)


Insert Into Table_Truncate_Example
Select 1,'Yogesh' Union All
Select 2,'Amol' 

Select * from Table_Truncate_Example

Begin Transaction
Truncate table Table_Truncate_Example
Select * from Table_Truncate_Example


Rollback transaction

Create table Table_Delete_Example
(
	Id Int Identity(1,1),
	NAme varchar(100)
)

Insert Into Table_Delete_Example(name)
Select 'Yogesh' Union All
Select 'Amol' Union All
Select 'Hemant' 

Select * from Table_Delete_Example
delete Table_Delete_Example Where name ='Hemant'
Truncate table Table_Delete_Example

Begin Transaction
delete Table_Delete_Example Where name ='Hemant'
Select * from Table_Delete_Example


Rollback transaction

--Delete
--Select * 
from Table_Delete_Example Where name ='Hemant'

