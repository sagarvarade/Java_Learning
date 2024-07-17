2 exists/not exists  

Select a.* from [dbo].[DimProduct] A Where Not Exists (
Select 1 from 
[dbo].[FactInternetSales] b Where A.ProductKey=b.ProductKey)


Select a.* from [dbo].[DimProduct] A Where  Exists (
Select 1 from 
[dbo].[FactInternetSales] b Where A.ProductKey=b.ProductKey)
