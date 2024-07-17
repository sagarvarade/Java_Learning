--Customer Full Name	Order Year	Total Sum of Sales Amount
--b.	Create stored procedure for above query with parameter Order Year. 
--E.g. If Order year passed as 2010 then above output should be generated for order placed in year 2010

select top(5)* from DimCustomer 
select top(5)* from FactInternetSales 
select top(5)* from DimDate

create procedure CustomerWiseSalesAgainOrderYear(@OrderYear int)
as
select d.FirstName+' '+ISNULL(d.MiddleName,'')+' '+d.LastName as FullName,dt.CalendarYear as [Year] , 
SUM(f.SalesAmount) as [sales Amount] 
from DimCustomer d 
inner join FactInternetSales f on d.CustomerKey=f.CustomerKey
inner join DimDate dt on dt.DateKey=f.OrderDateKey
where dt.CalendarYear=@OrderYear
group by d.FirstName+' '+ISNULL(d.MiddleName,'')+' '+d.LastName ,dt.CalendarYear;


select distinct a.CalendarYear from DimDate a where exists(select 1 from FactInternetSales b where a.DateKey=b.OrderDateKey)