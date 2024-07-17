USE master; 
GO

-- To allow advanced options to be changed.
EXECUTE sp_configure 'show advanced options', 1; 
GO 
-- To update the currently configured value for advanced options. 
RECONFIGURE; 
GO

-- To enable the feature. 
EXEC sp_configure 'xp_cmdshell', 1; 
GO 
-- To update the currently configured value for this feature. 
RECONFIGURE;


Use AdventureWorksDW2019

If Object_id('tempdb..##Out') Is not Null
	Drop table ##Out
Select *,Ntile(10) Over(Order by SalesOrderNumber) FileNo Into ##Out from FactInternetSales

Declare @Command varchar(4000)
Declare @From Int=1,@To Int
Set @To =(Select Max(Fileno) from ##Out)
While @From <=@To
BEgin

	Set @Command='bcp "Select * from tempdb.dbo.##Out Where Fileno=' +
	Cast(@From as varchar(10)) + '" queryout '
	+ '"C:\YogeshWork\Input\OutputFile_' + Cast(@From as varchar(10))  + '.csv" '
	+'-T -c -t, -S N64V0Y93\SQLEXPRESS'
	--Print @Command 
	Exec xp_cmdshell @Command	
	Set @From=@From+1
End
Drop table ##Out

