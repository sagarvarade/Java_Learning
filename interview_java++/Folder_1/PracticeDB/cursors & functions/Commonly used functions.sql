--Frequently used function like substring, left, right, len, 
--convert,cast, datediff, dateadd, charindex, char, stuff, replace etc


sELECT SUBSTRING(CustomerAlternateKey,6,5) SUBSTRING_FUN, 
lEFT(CustomerAlternateKey,2) LEFT_FUN,
RIGHT(CustomerAlternateKey,5) RIGHT_FUN,
LEN(CustomerAlternateKey) LEN_FUN,
CONVERT(VARCHAR,CustomerKey) CONVERT_FROM_INT_TO_VARCHAR,
CONVERT(VARCHAR,DateFirstPurchase,101) CONVERT_DATE_TO_VARCHAR,
CAST(DateFirstPurchase AS VARCHAR(100)) CAST_DATE_TO_VARCHAR,
DATEDIFF(YEAR,BirthDate,DateFirstPurchase) DATEDIFF_FUN,
DATEADD(YEAR,1,DateFirstPurchase) DATEADD_FUN,
SUBSTRING(EmailAddress,CHARINDEX('@',EmailAddress,1)+1,25) CHARINDEX_FUN,
CHAR(65) CHAR_FUN,
REPLACE(EmailAddress,'adventure-works.com','GMAIL.COM') REPLACE_FUN,
STUFF(FIRSTNAME,2,2,'YOGESH') STUFF_FUN,*
FROM DimCustomer


