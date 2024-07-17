1 union/union all

Create Table Table_ForEx_Union
(ID Int,
NAme varchar(100))

Create Table Table_ForEx_Unionall
(ID Int,
NAme varchar(100))

Insert into Table_ForEx_Union
Select 1,'Yogesh' Union all
Select 2,'Amol'


Insert into Table_ForEx_UnionAll
Select 1,'Yogesh' Union all
Select 2,'Hemant'

Select * from Table_ForEx_Union
Union
Select * from Table_ForEx_Unionall


Select * from Table_ForEx_Union
Union all
Select * from Table_ForEx_Unionall

Alter Table Table_ForEx_Union
Add  ContactNo Int


Alter Table Table_ForEx_UnionAll
Add  ContactNo varchar(100)

Update Table_ForEx_Union Set ContactNo ='1234567890'
Update Table_ForEx_UnionAll Set ContactNo ='Ind1234567890'



Select * from Table_ForEx_Unionall
Union all
Select * from Table_ForEx_Union

Select ID,Name,Cast(ContactNo as varchar(100)) As ContactNo from Table_ForEx_Union
Union all
Select * from Table_ForEx_Unionall

