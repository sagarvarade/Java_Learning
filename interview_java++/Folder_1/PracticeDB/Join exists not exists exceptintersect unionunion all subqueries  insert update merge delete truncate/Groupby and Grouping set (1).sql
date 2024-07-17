Select * from [dbo].[Employee_Table]
Order by Date_Of_Birth

Select b.Department_Name,Count(a.EmpID) CountOfEmployee 
from [Employee_Table] A
Inner join Department_Table B On A.Department_ID=b.Department_ID
Group by B.Department_Name

Select OrderDate,Count(Distinct SalesOrderNumber) CountOrder,
Sum(SalesAmount) SalesAmount
From AdventureWorksDW2019.dbo.FactInternetSales
Group by OrderDate
Order by SalesAmount Desc



Select Month(OrderDate) OrderMonth,YEar(Orderdate) OrderYear,Count(Distinct SalesOrderNumber) CountOrder,
Sum(SalesAmount) SalesAmount
From AdventureWorksDW2019.dbo.FactInternetSales
Group by Month(OrderDate),YEar(Orderdate)
Order by SalesAmount Desc

Select IsNull(Cast(YEar(Orderdate) As Varchar(5)),'Total') OrderYear,Count(Distinct SalesOrderNumber) CountOrder,
Sum(SalesAmount) SalesAmount
From AdventureWorksDW2019.dbo.FactInternetSales
Group by
Grouping Sets (YEar(Orderdate),())


Select IsNull(Cast(YEar(Orderdate) As Varchar(5)),'Total') OrderYear,Count(Distinct SalesOrderNumber) CountOrder,
Sum(SalesAmount) SalesAmount
From AdventureWorksDW2019.dbo.FactInternetSales
Group by YEar(Orderdate)
with Rollup

Select IsNull(Cast(YEar(Orderdate) As Varchar(5)),'Total') OrderYear,Count(Distinct SalesOrderNumber) CountOrder,
Sum(SalesAmount) SalesAmount
From AdventureWorksDW2019.dbo.FactInternetSales
Group by YEar(Orderdate)
with cube


