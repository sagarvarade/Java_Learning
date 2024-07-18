Show connection name :

> show con_name;


To switch to the PDBORCL pluggable database, you use the following statement:
> ALTER SESSION SET CONTAINER=pdborcl;
> show con_name;

> ALTER DATABASE OPEN;

CREATE USER 

> CREATE USER OT IDENTIFIED BY abcd_123
= User created

> GRANT CONNECT, RESOURCE, DBA TO OT
= grant succeed


After this to connec to db by sql :

>CONNECT ot@pdborcl
=Enter pass 
=Connected


Show all tables from schema 
> SELECT table_name FROM user_tables ORDER BY table_name;


Count of rows :
> select count(*) from tables;


****** ORACLE BASIC **********
1. SELECT COMMAND

>SELECT NAME FROM STUDENT;

SELECT * FROM table_name WHERE 1=2 GROUP BY NAME HAVING NAME='ABC' ORDER BY ID;

AND ALSO CONTAINS JOIN AND 

2. DUAL table , use to query function , or use as dummy table 

> SELECT UPPER('abc') from dual;

> SELECT (10 + 5)/2 FROM dual;

3. Order by clause 






