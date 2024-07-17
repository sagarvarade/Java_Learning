
Create Table #Product
(
	ProductId Int Identity,
	ProductName varchar(100),
	Price Money
)


Create Table #Offer
(
	OfferId Int Identity,
	OfferName varchar(100),
	MinOrderValue Money,
	FromDt Date,
	ToDt Date,
	DiscountInPercent Decimal(5,2),
	MaxDiscount Money
)

Create Table #Sales
(
	SalesID Int Identity,
	SalesDate Date,
	ProductId Int,
	OfferID Int,
	Units Int,
	SalesAmount Money,
	NetSalesAmount Money
)

Insert Into #Product (ProductNAme,Price) Values
('Product 1',1000),
('Product 2',2000),
('Product 3',999),
('Product 4',1499)

Insert Into #Offer(OfferName,MinOrderValue,FromDt,ToDt,DiscountInPercent,MaxDiscount) Values
('New Year Offer',1001,'2021-01-01','2021-01-31',0.10,300)

Insert into #Sales(SalesDate,ProductId,Units) Values
('2021-01-01',1,2),
('2021-02-01',1,2),
('2021-01-01',1,1),
('2021-01-01',2,1),
('2021-02-01',2,2),
('2021-01-01',3,1),
('2021-01-01',3,2),
('2021-02-01',2,2)

Insert into #Sales(SalesDate,ProductId,Units) Values
('2021-01-01',3,7)


Select * from #Sales
Update A
Set SalesAmount=B.Price*a.Units
--Select B.Price*a.Units as SalesAmountNew,b.Price,a.* 
from #Sales A
Inner Join #Product b On A.ProductId=b.ProductId

Update A
Set OfferID=b.OfferId,
NetSalesAmount=a.SalesAmount-
Isnull(Case When B.MaxDiscount<a.SalesAmount*b.DiscountInPercent Then B.MaxDiscount 
Else a.SalesAmount*b.DiscountInPercent End,0)
--Select b.OfferId OfferIdnew,
--Case When B.MaxDiscount<a.SalesAmount*b.DiscountInPercent Then B.MaxDiscount Else a.SalesAmount*b.DiscountInPercent End DiscountAmount
--,a.* 
from #Sales a
Left Join #Offer B On a.SalesDate between b.FromDt and b.ToDt
And a.SalesAmount>=b.MinOrderValue

Select * from #Sales






