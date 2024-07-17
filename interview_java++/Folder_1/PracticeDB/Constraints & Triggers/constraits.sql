Constraints
1) Not Null
2) Check
3) Default
4) Unique
5) Primary
6) Foreign

Constrainst - We use these as rule and regulation to avoid any wrong or improrer data insert \updation in tables

-----Not Null constaint----------------

Create table Table_Cons1
(
	Id Int,
	Name varchar(100)
)


Insert into Table_Cons1
values(1,'Abc'),
(Null,'bcd'),
(2,Null)


Truncate table Table_Cons1
Alter Table Table_Cons1
Alter column Id int not Null 

Alter Table Table_Cons1
Alter column Name varchar(100) not Null 


Insert into Table_Cons1
values(1,'Abc'),
(3,'bcd'),
(2,'cde')

-----Not Null constaint----------------

-----Check constaint----------------

Create table Table_Cons2
(
	Id Int,
	Name varchar(100),
	Age Int
)


Alter table Table_Cons2
Add Constraint ConsAge Check(Age between 10 and 20)

Insert Into Table_Cons2
Values(1,'ABC',11),
(2,'BCD',20)

-----Check constaint----------------
-----Default constaint----------------
Create table Table_Cons3
(
	Id Int,
	Name varchar(100) 
)


Alter table Table_Cons3
Add Constraint ConsName1 Default('HFG') for Name

Truncate table Table_Cons3

Insert into Table_Cons3(Id)
Values(1)

Insert into Table_Cons3(Id,NAme)
Values(2,'ABC')

Insert into Table_Cons3(Id,NAme)
Values(3,Null)

Select * from Table_Cons3
-----Default constaint----------------

-----Unique key constaint----------------
Create table Table_Cons4
(
	Id Int,
	Name varchar(100) 
)

Insert into Table_Cons4
values(1,'abc'),(1,'bcd')

Truncate table Table_Cons4
Alter table Table_Cons4
Add Constraint ConsIdUnique1 Unique(ID)

Insert into Table_Cons4
values(1,'abc'),(2,'bcd')

-----Unique key constaint----------------
-----Primary key and Foreign key constaint----------------

Create table Table_Cons5
(
	Id Int,
	Name varchar(100) 
)

Alter table Table_Cons5
Alter Column Id Int Not Null

Alter Table Table_Cons5
Add Constraint PrimaryKey_TableCons5 Primary key(ID)

Create Table Table_cons6
(
	ID Int Not Null,
	SalesAmount Money
)

Alter Table Table_Cons6
Add Constraint ForeignKey_TableCons6 Foreign key(ID) references Table_Cons5(Id)

Insert into Table_cons5
VAlues(1,'ABC'),
(2,'BCD'),
(3,'CDE')

Insert into Table_cons6
Values(1,1000),(1,2000),(2,3000),(2,3000)


Insert into Table_cons6
Values(5,1000),(6,2000),(7,3000),(8,3000)

Delete from Table_Cons5 Where id =2

-----Primary key and Foreign key constaint----------------
