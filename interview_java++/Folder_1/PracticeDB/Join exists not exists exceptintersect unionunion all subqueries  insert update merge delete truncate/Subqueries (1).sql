--4 subqueries 

Select A.EnglishProductName ,
(
	Select Count(1)
	From FactInternetSales B Where A.ProductKey=b.ProductKey
) NoOrders
from 
[dbo].[DimProduct] a 
Order by 2 desc

Select A.ProductKey,A.EnglishProductName ,
Count(b.ProductKey) NoOrders
from 
[dbo].[DimProduct] a 
Left Join  FactInternetSales B On A.ProductKey=b.ProductKey
Group by A.EnglishProductName,A.ProductKey
Order by 2 desc




Select A.EnglishProductSubcategoryName,
(Select B.EnglishProductName +','
from DimProduct B Where A.ProductSubcategoryKey=b.ProductSubcategoryKey
Order By b.EnglishProductName
For XMl Path('')
) Products
from [dbo].[DimProductSubcategory] A
Order by a.EnglishProductSubcategoryName

