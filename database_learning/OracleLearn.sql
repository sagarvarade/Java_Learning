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


-- Select statement

SELECT * FROM contacts;

select first_name from contacts;


SELECT customer_id,name,address,website,credit_limit FROM customers;

-- Dual table , to call a function

select upper('sagar') from dual;

-- Order by clause

select customer_id,name,address,website,credit_limit FROM customers order by credit_limit asc;

select customer_id,name,address,website,credit_limit FROM customers order by credit_limit desc;

select * from CUSTOMERS;

select Name,upper(website) from CUSTOMERS order by name,WEBSITE asc;

SELECT first_name,	last_name FROM 	contacts ORDER BY 	first_name, last_name DESC;


SELECT name, credit_limit FROM  customers ORDER BY 2 DESC, 1;

SELECT country_id,city,state FROM locations ORDER BY state NULLS first ;

SELECT country_id,upper(city),state FROM locations ORDER BY state NULLS last , upper(city) ;

select * from orders order by ORDER_DATE;

-- Distinct clause
select first_name from CONTACTS group by FIRST_NAME having count(FIRST_NAME)>1;

select  distinct  first_name from CONTACTS group by FIRST_NAME having count(FIRST_NAME)>1;

select distinct PRODUCT_NAME from PRODUCTS;


select distinct state from LOCATIONS order by STATE nulls first;

-- Where condition

select * from LOCATIONS where STATE='BE' and (LOCATION_ID<30 or LOCATION_ID >20) ;

select * from LOCATIONS where STATE='BE' and LOCATION_ID between 22 and 30;


SELECT owner, table_name FROM dba_tables;

select * from EMPLOYEES where HIRE_DATE between '01-Jan-2010' and '31-12-2016'
and FIRST_NAME like '%as%' order by HIRE_DATE ;


select * from PRODUCTS where lower(PRODUCT_NAME) like '%king%';

-- Table aliases

select FIRST_NAME as "fName", last_name as "lName" from EMPLOYEES;

select FIRST_NAME || ' '  || last_name as "FullName" from EMPLOYEES;

-- Fetch clause
SELECT product_name,list_price - standard_cost AS gross_profit FROM products
order by gross_profit DESC FETCH NEXT 5 ROWS ONLY;

SELECT product_name,quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC LIMIT 5;


SELECT product_name, quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC FETCH NEXT 5 ROWS ONLY;

SELECT product_name, quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC FETCH NEXT 10 ROWS ONLY;


SELECT product_name, quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC FETCH NEXT 10 ROWS WITH TIES;



SELECT product_name, quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC FETCH FIRST 1 PERCENT ROWS ONLY;

SELECT product_name, quantity FROM inventories INNER JOIN products USING(product_id) ORDER BY quantity DESC OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;

-- Boolean functions and operator


SELECT
	order_id,
	customer_id,
	status,
	order_date
FROM
	orders
WHERE
	status = 'Pending'
	AND customer_id = 2
ORDER BY
	order_date;

SELECT
    order_id,
    customer_id,
    status,
    order_date
FROM
    orders
WHERE
    status = 'Shipped'
    AND salesman_id = 60
    AND EXTRACT(YEAR FROM order_date) = 2017
ORDER BY
    order_date;

SELECT
    order_id,
    customer_id,
    status,
    salesman_id,
    order_date
FROM
    orders
WHERE
    (
        status = 'Canceled'
        OR status = 'Pending'
    )
    AND customer_id = 44
ORDER BY
    order_date;

SELECT
    order_id,
    customer_id,
    status,
    order_date
FROM
    orders
WHERE
    status = 'Pending'
    OR status = 'Canceled'
ORDER BY
    order_date DESC;



SELECT order_id, customer_id, status, salesman_id, order_date FROM orders WHERE salesman_id = 60 OR salesman_id = 61 OR salesman_id = 62 ORDER BY order_date DESC;


SELECT
    order_id,
    customer_id,
    status,
    salesman_id,
    order_date
FROM
    orders
WHERE
    salesman_id IN(
        60,
        61,
        62
    )
ORDER BY
    order_date DESC;


SELECT
    order_id,
    customer_id,
    status,
    salesman_id,
    order_date
FROM
    orders
WHERE
    (
        status = 'Canceled'
        OR status = 'Pending'
    )
    AND customer_id = 44
ORDER BY
    order_date;


-- expression IN and NOT IN
-- expression [NOT] IN (v1,v2,...)
--  expression [NOT] IN (subquery)

SELECT order_id, customer_id, status, salesman_id FROM orders WHERE salesman_id IN ( 54, 55, 56 ) ORDER BY order_id;

SELECT order_id, customer_id, status, salesman_id FROM orders WHERE status IN( 'Pending', 'Canceled' ) ORDER BY order_id;


SELECT employee_id, first_name, last_name FROM employees WHERE employee_id IN( SELECT DISTINCT salesman_id FROM orders WHERE status = 'Canceled' );

SELECT DISTINCT salesman_id FROM orders WHERE status = 'Canceled';


SELECT customer_id, name FROM customers WHERE customer_id NOT IN( SELECT customer_id FROM orders );

SELECT customer_id, status, salesman_id FROM orders WHERE salesman_id IN( 60, 61, 62 ) ORDER BY customer_id;


-- Oracle between
SELECT product_name, standard_cost FROM products WHERE standard_cost not BETWEEN 500 AND 600 ORDER BY standard_cost;


SELECT order_id, customer_id, status, order_date FROM orders WHERE order_date BETWEEN DATE '2016-12-01' AND DATE '2016-12-31' ORDER BY order_date;

-- Oracle LIKE operator

SELECT first_name, last_name, phone FROM contacts WHERE last_name LIKE 'St%' ORDER BY last_name;


SELECT first_name, last_name, email FROM contacts WHERE UPPER( first_name ) LIKE '%CHR%'; ORDER BY first_name;


SELECT first_name, last_name, phone FROM contacts WHERE phone NOT LIKE '+1%' ORDER BY first_name;



SELECT first_name, last_name, email, phone FROM contacts WHERE first_name LIKE 'Je_i' ORDER BY first_name;


SELECT
  first_name, last_name, phone
FROM
  contacts
WHERE
  phone NOT LIKE '+1%'
ORDER BY
  first_name;


SELECT
    first_name,
    last_name,
    email,
    phone
FROM
    contacts
WHERE
    first_name LIKE 'Je_%';



CREATE TABLE discounts (product_id NUMBER,discount_message VARCHAR2( 255 ) NOT NULL,PRIMARY KEY( product_id ));


INSERT INTO discounts(product_id, discount_message) VALUES(1, 'Buy 1 and Get 25% OFF on 2nd ');

INSERT INTO discounts(product_id, discount_message) VALUES(2, 'Buy 2 and Get 50% OFF on 3rd ');


INSERT INTO discounts(product_id, discount_message) VALUES(3, 'Buy 3 Get 1 free');


SELECT product_id, discount_message FROM discounts WHERE discount_message LIKE '%25!%%' ESCAPE '!';


SELECT * FROM orders
WHERE salesman_id = NULL
ORDER BY order_date DESC;


SELECT order_id,SALESMAN_ID FROM orders
WHERE salesman_id IS NULL
ORDER BY order_date DESC;


SELECT * FROM orders
WHERE salesman_id IS NOT NULL
ORDER BY order_date DESC;

-- Joins

CREATE TABLE palette_a ( id INT PRIMARY KEY, color VARCHAR2 (100) NOT NULL );



CREATE TABLE palette_b ( id INT PRIMARY KEY, color VARCHAR2 (100) NOT NULL );



INSERT INTO palette_a (id, color) VALUES (1, 'Red');
INSERT INTO palette_a (id, color) VALUES (2, 'Green');
INSERT INTO palette_a (id, color) VALUES (3, 'Blue');
INSERT INTO palette_a (id, color) VALUES (4, 'Purple'); -- insert data for the palette_b



INSERT INTO palette_b (id, color) VALUES (1, 'Green');
INSERT INTO palette_b (id, color) VALUES (2, 'Red');
INSERT INTO palette_b (id, color) VALUES (3, 'Cyan');
INSERT INTO palette_b (id, color) VALUES (4, 'Brown');

select * from palette_a;
select * from palette_b;

-- Inner Join
select a.*,b.* from palette_a a
inner join palette_b b on a.color=b.color;

select a.*,b.* from palette_a a
left join palette_b b on a.color=b.color;

select a.*,b.* from palette_a a
left join palette_b b on a.color=b.color where b.id is null;

select a.*,b.* from palette_a a
right join palette_b b on a.color=b.color;

select a.*,b.* from palette_a a
right join palette_b b on a.color=b.color where a.id is null;



SELECT a.id id_a, a.color color_a, b.id id_b, b.color color_b FROM palette_a a RIGHT JOIN palette_b b ON a.color = b.color WHERE a.id IS NULL;

SELECT a.id id_a, a.color color_a, b.id id_b, b.color color_b FROM palette_a a FULL OUTER JOIN palette_b b ON a.color = b.color;


SELECT a.id id_a, a.color color_a, b.id id_b, b.color color_b FROM palette_a a FULL outer JOIN palette_b b ON a.color = b.color WHERE a.id IS NULL OR b.id IS NULL;

-- Innner Join Table

SELECT
  *
FROM
  T1
INNER JOIN T2 ON join_predicate;


SELECT
    *
FROM
    orders
INNER JOIN order_items ON
    order_items.order_id = orders.order_id
ORDER BY
    order_date DESC;



-- Using can be used , but same column need to be in both tables
SELECT
  *
FROM
  orders
INNER JOIN order_items USING( order_id )
ORDER BY
  order_date DESC;


SELECT
  name AS customer_name,
  order_id,
  order_date,
  item_id,
  quantity,
  unit_price
FROM
  orders
INNER JOIN order_items USING(order_id)
INNER JOIN customers USING(customer_id)
ORDER BY
  order_date DESC,
  order_id DESC,
  item_id ASC;


select * from orders;

SELECT
	name AS customer_name,
	order_id,
	order_date,
	item_id,
	product_name,
	quantity,
	unit_price
FROM
	orders
INNER JOIN order_items
		USING(order_id)
INNER JOIN customers
		USING(customer_id)
INNER JOIN products
		USING(product_id)
ORDER BY
	order_date DESC,
	order_id DESC,
	item_id ASC;

-- Left Join
SELECT
    order_id,
    name AS customer_name,
    status,
    first_name,
    last_name
FROM
    orders
LEFT JOIN employees ON
    employee_id = salesman_id
LEFT JOIN customers ON
    customers.customer_id = orders.customer_id
ORDER BY
    order_date DESC;


SELECT
    name,
    order_id,
    status,
    order_date
FROM
    customers
LEFT JOIN orders
        USING(customer_id)
ORDER BY
    name;



SELECT
    order_id,
    status,
    employee_id,
    last_name
FROM
    orders
LEFT JOIN employees ON
    employee_id = salesman_id
WHERE
    order_id = 58;

SELECT
    order_id,
    status,
    employee_id,
    last_name
FROM
    orders
LEFT JOIN employees ON
    employee_id = salesman_id
    AND order_id = 58;


--- Right Join

RIGHT OUTER JOIN == RIGHT JOIN

SELECT FIRST_NAME,LAST_NAME,ORDER_ID,STATUS,JOB_TITLE
FROM ORDERS RIGHT JOIN EMPLOYEES ON EMPLOYEE_ID=SALESMAN_ID
WHERE JOB_TITLE='Sales Representative' and order_id is not null
order by first_name,last_name;

SELECT
    name,
    order_id,
    status
FROM
    orders
RIGHT JOIN customers
        USING(customer_id)
ORDER BY
    name;


SELECT
    employee_id,
    last_name,
    first_name,
    order_id,
    status
FROM
    orders
RIGHT JOIN employees ON
    employee_id = salesman_id
WHERE
    employee_id = 57;


SELECT
    employee_id,
    last_name,
    first_name,
    order_id,
    status
FROM
    orders
RIGHT JOIN employees ON
    employee_id = salesman_id
and
    employee_id = 57;

-- FULL OUTER JOIN == FULL  JOIN

SELECT
    member_name,
    project_name
FROM
    members m
FULL OUTER JOIN projects p ON p.project_id = m.project_id
ORDER BY
    member_name;

SELECT
    member_name,
    project_name
FROM
    members m
    FULL OUTER JOIN projects p
        ON p.project_id = m.project_id
WHERE
    project_name IS NULL
ORDER BY
    member_name;


-- Cross join

select * from products;

select * from warehouses;

-- This can be used to push data to inventories table
SELECT
    product_id,
    warehouse_id,
    ROUND( dbms_random.value( 10, 100 )) quantity
FROM
    products
CROSS JOIN warehouses;

-- Self Join

SELECT
    (e.first_name || '  ' || e.last_name) employee,
    (m.first_name || '  ' || m.last_name) manager,
    e.job_title
FROM
    employees e
LEFT JOIN employees m ON
    m.employee_id = e.manager_id
ORDER BY
    manager;


SELECT
   e1.hire_date,
  (e1.first_name || ' ' || e1.last_name) employee1,
  (e2.first_name || ' ' || e2.last_name) employee2
FROM
    employees e1
INNER JOIN employees e2 ON
    e1.employee_id > e2.employee_id
    AND e1.hire_date = e2.hire_date
ORDER BY
   e1.hire_date DESC,
   employee1,
   employee2;

-- Group By

SELECT status FROM orders GROUP BY status
==
SELECT DISTINCT status FROM orders;

SELECT
    name,
    COUNT( order_id )
FROM
    orders
INNER JOIN customers
        USING(customer_id)
GROUP BY
    name
ORDER BY
    name;


SELECT
    EXTRACT(YEAR FROM order_date) YEAR,
    COUNT( order_id )
FROM
    orders
GROUP BY
    EXTRACT(YEAR FROM order_date)
ORDER BY
    YEAR;

SELECT name, COUNT( order_id ) FROM orders INNER JOIN customers USING(customer_id) WHERE status = 'Shipped' GROUP BY name ORDER BY name;


SELECT customer_id, status, SUM( quantity * unit_price ) sales FROM orders INNER JOIN order_items USING(order_id) GROUP BY ROLLUP( customer_id, status );

--- Roll up and using are new func to me

-- Having clause

SELECT
    order_id,
    SUM( unit_price * quantity ) order_value
FROM
    order_items
GROUP BY
    order_id
HAVING
    SUM( unit_price * quantity ) > 1000000
ORDER BY
    order_value DESC;


SELECT
    order_id,
    COUNT( item_id ) item_count,
    SUM( unit_price * quantity ) total
FROM
    order_items
GROUP BY
    order_id
HAVING
    SUM( unit_price * quantity ) > 500000 AND
    COUNT( item_id ) BETWEEN 10 AND 12
ORDER BY
    total DESC,
    item_count DESC;

----

--  Union operttator

select upper('abc') from dual
union
select upper('abc') from dual;


select upper('abc') from dual
union all
select upper('abc') from dual;

select upper('abc') from dual
union
select upper('xyz') from dual;


select upper('abc') from dual
minus
select upper('abc') from dual;



SELECT
    first_name,
    last_name,
    email,
    'contact'
FROM
    contacts
UNION SELECT
    first_name,
    last_name,
    email,
    'employee'
FROM
    employees;


SELECT first_name || ' ' || last_name name, email, 'contact' FROM contacts
UNION
SELECT first_name || ' ' || last_name name, email, 'employee' FROM employees
ORDER By name DESC;


SELECT last_name FROM employees
UNION
SELECT last_name FROM contacts ORDER BY last_name;

-- Intersect tables , will return match rows between them

SELECT last_name FROM contacts
INTERSECT
SELECT last_name FROM employees
ORDER BY last_name;


-- Oracle minus

SELECT last_name FROM contacts
minus
SELECT last_name FROM employees
ORDER BY last_name;

SELECT product_id FROM products
MINUS
SELECT product_id FROM inventories;


SELECT
    product_id,
    product_name,
    list_price
FROM
    products
WHERE
    list_price = (
        SELECT
            MAX( list_price )
        FROM
            products
    );

SELECT
    product_name,
    list_price,
    ROUND(
        (
            SELECT
                AVG( list_price )
            FROM
                products p1
            WHERE
                p1. category_id = p2.category_id
        ),
        2
    ) avg_list_price
FROM
    products p2
ORDER BY
    product_name;



SELECT
    employee_id,
    first_name,
    last_name
FROM
    employees
WHERE
    employee_id IN(
        SELECT
            salesman_id
        FROM
            orders
        INNER JOIN order_items
                USING(order_id)
        WHERE
            status = 'Shipped'
        GROUP BY
            salesman_id,
            EXTRACT(
                YEAR
            FROM
                order_date
            )
        HAVING
            SUM( quantity * unit_price )  >= 1000000
            AND EXTRACT(
                YEAR
            FROM
                order_date) = 2017
            AND salesman_id IS NOT NULL
    )
ORDER BY
    first_name,
    last_name;


-- Corelated sub-queries

SELECT
    product_id,
    product_name,
    list_price
FROM
    products p
WHERE
    list_price > (
        SELECT
            AVG( list_price )
        FROM
            products
        WHERE
            category_id = p.category_id
    );

SELECT
    product_id,
    product_name,
    standard_cost,
    ROUND(
        (
            SELECT
                AVG( standard_cost )
            FROM
                products
            WHERE
                category_id = p.category_id
        ),
        2
    ) avg_standard_cost
FROM
    products p
ORDER BY
    product_name;


SELECT
    customer_id,
    name
FROM
    customers
WHERE
    NOT EXISTS (
        SELECT
            *
        FROM
            orders
        WHERE
            orders.customer_id = customers.customer_id
    )
ORDER BY
    name;


SELECT
    name
FROM
    customers c
WHERE
    EXISTS (
        SELECT
            1
        FROM
            orders
        WHERE
            customer_id = c.customer_id
    )
ORDER BY
    name;

UPDATE
    warehouses w
SET
    warehouse_name = warehouse_name || ', USA'
WHERE
    EXISTS (
        SELECT
            1
        FROM
            locations
        WHERE
            country_id = 'US'
            AND location_id = w.location_id
    );

select * from warehouses;


SELECT
	warehouse_name
FROM
	warehouses
INNER JOIN locations
		USING(location_id)
WHERE
	country_id = 'US';



SELECT * FROM customers WHERE customer_id IN(NULL);


SELECT * FROM customers WHERE not EXISTS ( SELECT NULL FROM dual );

SELECT * FROM customers WHERE EXISTS ( SELECT NULL FROM dual );


-- Not exists

SELECT
    name
FROM
    customers
WHERE
    NOT EXISTS (
        SELECT
            NULL
        FROM
            orders
        WHERE
            orders.customer_id = customers.customer_id
    )
ORDER BY
    name;


create table test(id int);

DELETE
FROM
    customers
WHERE
    NOT EXISTS(
        SELECT
            NULL
        FROM
            orders
        WHERE
            orders.customer_id = customers.customer_id
            AND EXTRACT(
                YEAR FROMorder_date
            ) IN(
                2016,
                2017
            )
    );

-- Any

SELECT product_name, list_price FROM products WHERE list_price > ANY( SELECT list_price FROM products WHERE category_id = 1 ) ORDER BY product_name;



SELECT product_name, list_price FROM products p1 WHERE EXISTS( SELECT list_price FROM products p2 WHERE category_id = 1 AND p1.list_price > p2.list_price ) ORDER BY product_name;

SELECT
  sysdate
FROM
  dual;


SELECT
  TO_CHAR( SYSDATE, 'FMMonth DD, YYYY' ) FM
FROM
  dual;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

-- Oracle data types are

1. Number
2. FLOAT
3. BINARY_FLOAT
4. BINARY_DOUBLE
5. IDENTITY = SAME AS AUTO INCREMENT IN MYSQL
6. CHAR
7. NCHAR
8. VARCHAR2
9. NVARCHAR2
10. DATE
11. TIMESTAMP
12. INTERVAL


Constraints in SQL
1. Primary Key : A primary key is a column of a combination of columns in a table that uniquely identifies a row in the table.
CREATE TABLE purchase_orders (
    po_nr NUMBER PRIMARY KEY

    CONSTRAINT pk_purchase_orders PRIMARY KEY(po_nr)
);

2. Foreign Key
3. Oracle check constraints
4. Oracle unique constraints
5. Not null  constraints



Views in Oracle :

1. Select query :

CREATE VIEW employee_yos AS
SELECT
    employee_id,
    first_name || ' ' || last_name full_name,
    FLOOR( months_between( CURRENT_DATE, hire_date )/ 12 ) yos
FROM
    employees;


Columns names defined by user
CREATE VIEW employee_yos (employee_id, full_name, yos) AS
SELECT
    employee_id,
    first_name || ' ' || last_name,
    FLOOR( months_between( CURRENT_DATE, hire_date )/ 12 )
FROM
    employees;


Read only view :
CREATE OR REPLACE VIEW customer_credits(
        customer_id,
        name,
        credit
    ) AS
SELECT
        customer_id,
        name,
        credit_limit
    FROM
        customers WITH READ ONLY;



Creating view by Joins tables :
CREATE OR REPLACE VIEW backlogs AS
SELECT
    product_name,
    EXTRACT(
        YEAR
    FROM
        order_date
    ) YEAR,
    SUM( quantity * unit_price ) amount
FROM
    orders
INNER JOIN order_items
        USING(order_id)
INNER JOIN products
        USING(product_id)
WHERE
    status = 'Pending'
GROUP BY
    EXTRACT(
        YEAR
    FROM
        order_date
    ),
    product_name;



Drop view to drop a views;

DROP VIEW salesman_contacts;



Oracle Updatable View

