select top(5)* from DimCustomer 
select top(5)* from FactInternetSales 
select top(5)* from DimDate

--Customer Full Name	Order Year	Total Sum of Sales Amount
--b.	Create stored procedure for above query with parameter Order Year. 
--E.g. If Order year passed as 2010 then above output should be generated for order placed in year 2010

create procedure SalesAmountSUMUsingYR(@CustomerID int)
as
select d.FirstName+' '+ISNULL(d.MiddleName,'')+' '+d.LastName as FullName,dt.CalendarYear as [Year] , 
SUM(f.SalesAmount) as [sales Amount] 
from DimCustomer d 
inner join FactInternetSales f on d.CustomerKey=f.CustomerKey
inner join DimDate dt on dt.DateKey=f.OrderDateKey
where f.CurrencyKey=@CustomerID
group by d.FirstName+' '+ISNULL(d.MiddleName,'')+' '+d.LastName ,dt.CalendarYear;














select 
FirstName+' '+ISNULL(MiddleName,'')+' '+LastName as FullName masked with (FUNCTION=''),
CAST(SUM(SalesAmount*b.AverageRate)as decimal(20,2)) as SalesAmountInUSD
 from FactInternetSales a inner join FactCurrencyRate b on 
a.OrderDateKey = b.DateKey and a.CurrencyKey = b.CurrencyKey inner join DimCustomer c on
c.CustomerKey=a.CustomerKey
Group by 
FirstName+' '+ISNULL(MiddleName,'')+' '+LastName

having SUM(SalesAmount*b.AverageRate)>=500

Order by SalesAmountInUSD 


