---While loop

Declare @From Int=1,@To Int =100
While @From<@to+1
BEgin
	Select @From
	If @From=50
	Break;
	Set @From=@From+1
End


Declare @FromDate Date='2021-01-01',@ToDate Date ='2021-01-15'
While @FromDate<Dateadd(day,1,@Todate)
BEgin
	Select @FromDate
	Set @FromDate=Dateadd(day,1,@FromDate)
End

