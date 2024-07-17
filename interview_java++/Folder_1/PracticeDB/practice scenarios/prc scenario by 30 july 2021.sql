--a.	Create scalar user function to evaluate EndofDayRate against the parameter CurrencyKey and Date
--Hint – FactCurrencyRate table need to be use to create the function


select top(5)* from FactCurrencyRate 

sp_help FactCurrencyRate 

create function FunctionExchangeRate(@CurrencyKey int, @Date int)
returns float as
begin
Declare @EndOftheDayRate float
select @EndOftheDayRate=EndOfDayRate from FactCurrencyRate 
where CurrencyKey=@CurrencyKey and DateKey=@Date;
return @EndOftheDayRate 
End
