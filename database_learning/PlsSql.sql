


-- 1. Anonymous Block
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello, World!');
END;
/

-- 2. Procedure
CREATE OR REPLACE PROCEDURE say_hello(name IN VARCHAR2) AS
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello, ' || name || '!');
END;
/

BEGIN
  say_hello('John');
END;
/

-- 3. Function
CREATE OR REPLACE FUNCTION add_numbers(a IN NUMBER, b IN NUMBER) RETURN NUMBER AS
BEGIN
  RETURN a + b;
END;
/

DECLARE
  result NUMBER;
BEGIN
  result := add_numbers(5, 3);
  DBMS_OUTPUT.PUT_LINE('Result: ' || result);
END;
/

-- 4. Cursor
DECLARE
  CURSOR employee_cursor IS
    SELECT first_name, last_name FROM employees;
  first_name employees.first_name%TYPE;
  last_name employees.last_name%TYPE;
BEGIN
  OPEN employee_cursor;
  LOOP
    FETCH employee_cursor INTO first_name, last_name;
    EXIT WHEN employee_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Employee: ' || first_name || ' ' || last_name);
  END LOOP;
  CLOSE employee_cursor;
END;
/

-- 5. Trigger
CREATE OR REPLACE TRIGGER before_insert_employee
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
  :NEW.hire_date := SYSDATE;
END;
/

-- 6. Exception Handling
DECLARE
  v_num NUMBER;
BEGIN
  v_num := 10 / 0;
EXCEPTION
  WHEN ZERO_DIVIDE THEN
    DBMS_OUTPUT.PUT_LINE('Division by zero is not allowed.');
END;
/

-- 7. Package
CREATE OR REPLACE PACKAGE math_pkg AS
  FUNCTION multiply(a NUMBER, b NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY math_pkg AS
  FUNCTION multiply(a NUMBER, b NUMBER) RETURN NUMBER AS
  BEGIN
    RETURN a * b;
  END;
END;
/

DECLARE
  result NUMBER;
BEGIN
  result := math_pkg.multiply(6, 7);
  DBMS_OUTPUT.PUT_LINE('Result: ' || result);
END;
/

-- 8. Variables and Constants
DECLARE
  v_name VARCHAR2(50) := 'Alice';
  v_age NUMBER := 30;
  c_max_age CONSTANT NUMBER := 100;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Name: ' || v_name);
  DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);
  DBMS_OUTPUT.PUT_LINE('Max Age: ' || c_max_age);
END;
/

-- 9. Conditional Statements
DECLARE
  v_score NUMBER := 85;
BEGIN
  IF v_score >= 90 THEN
    DBMS_OUTPUT.PUT_LINE('Grade: A');
  ELSIF v_score >= 80 THEN
    DBMS_OUTPUT.PUT_LINE('Grade: B');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Grade: C');
  END IF;
END;
/

-- 10. Loops
DECLARE
  v_counter NUMBER := 1;
BEGIN
  WHILE v_counter <= 5 LOOP
    DBMS_OUTPUT.PUT_LINE('Counter: ' || v_counter);
    v_counter := v_counter + 1;
  END LOOP;
END;
/

Pl sql has 3 sections

1. Declaration
2. Execution
3. Exception-handling



1.  PLS SQL 

BEGIN
   DBMS_OUTPUT.put_line ('Hello World!');
END;

2. Using variable

DECLARE
  l_message VARCHAR2( 255 ) := 'Hello Sagar !';
BEGIN
  DBMS_OUTPUT.PUT_LINE( l_message );
END;

3.  Handling exception :

DECLARE
      v_result NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hii ');
   v_result := 1 / 0;
   EXCEPTION
      WHEN ZERO_DIVIDE THEN
         DBMS_OUTPUT.PUT_LINE( SQLERRM );
END;


PLSQL data types are boolean , character , datetime,  numbers


PL/SQL divides the scalar data types into four families:

Number
Boolean
Character
Datetime

The data types NUMBER, BINARY_FLOAT, and BINARY_DOUBLE are SQL data types.


Boolean  : True, false , null

Character data types
The character data types represent alphanumeric text. PL/SQL uses the SQL character data types such as CHAR, VARCHAR2, LONG, RAW, LONG RAW, ROWID, and UROWID.

 CHAR(n) is a fixed-length character type whose length is from 1 to 32,767 bytes.
 VARCHAR2(n) is varying length character data from 1 to 32,767 bytes.
 
 
 
 Datetime data types
The datetime data types represent dates, timestamps with or without time zones, and intervals. PL/SQL datetime data types are DATE, TIMESTAMP, TIMESTAMP WITH TIME ZONE, TIMESTAMP WITH LOCAL TIME ZONE, INTERVAL YEAR TO MONTH, and INTERVAL DAY TO SECOND.

PL/SQL Variables


DECLARE
    l_total_sales NUMBER(15,2);
    l_credit_limit NUMBER (10,0);    
    l_contact_name VARCHAR2(255);
    l_product_name VARCHAR2( 100 ) := 'Laptop';
    l_shipping_status VARCHAR2( 25 ) NOT NULL := 'Shipped';
BEGIN
    l_shipping_status := 'Shipped chan';
    DBMS_OUTPUT.PUT_LINE(l_shipping_status);
    NULL;
END;




DECLARE
    l_customer_group VARCHAR2(100) := 'Silver';
BEGIN
    l_customer_group := 'Gold';
    DBMS_OUTPUT.PUT_LINE(l_customer_group);
END;



DECLARE
    l_business_parter VARCHAR2(100) := 'Distributor';
    l_lead_for VARCHAR2(100);
BEGIN
    l_lead_for := l_business_parter; 
    DBMS_OUTPUT.PUT_LINE(l_lead_for);
END;


anchoring table colums to variables

DECLARE
  l_customer_name customers.name%TYPE;
  l_credit_limit customers.credit_limit%TYPE;
BEGIN
  SELECT
    name, credit_limit
  INTO
    l_customer_name, l_credit_limit
  FROM
    customers
  WHERE
    customer_id = 38;

  DBMS_OUTPUT.PUT_LINE(l_customer_name || ':' || l_credit_limit );
END;
/



-- Anchroing variables form table cokumns

DECLARE
    l_credit_limit   customers.credit_limit%TYPE;
    l_average_credit l_credit_limit%TYPE;
    l_max_credit     l_credit_limit%TYPE;
    l_min_credit     l_credit_limit%TYPE;
BEGIN
    -- get credit limits
    SELECT 
        MIN(credit_limit), 
        MAX(credit_limit), 
        AVG(credit_limit)
    INTO 
        l_min_credit,
        l_max_credit, 
        l_average_credit
    FROM customers;
    
    
    SELECT 
        credit_limit
    INTO 
        l_credit_limit
    FROM 
        customers
    WHERE 
        customer_id = 100;

    -- show the credits     
    dbms_output.put_line('Min Credit: ' || l_min_credit);
    dbms_output.put_line('Max Credit: ' || l_max_credit);
    dbms_output.put_line('Avg Credit: ' || l_average_credit);

    -- show customer credit    
    dbms_output.put_line('Customer Credit: ' || l_credit_limit);
END;


-- Using constant in pl/sql
DECLARE
    co_payment_term   CONSTANT NUMBER   := 45; -- days 
    co_payment_status CONSTANT BOOLEAN  := FALSE; 
BEGIN
    NULL;
END;


DECLARE 
    co_pi     CONSTANT REAL := 3.14159;
    co_radius CONSTANT REAL := 10;
    co_area   CONSTANT REAL := (co_pi * co_radius**2);
BEGIN
    DBMS_OUTPUT.PUT_LINE(co_area);
END;

If else 

DECLARE n_sales NUMBER := 2000000; 
BEGIN 
   IF n_sales > 100000 THEN 
      DBMS_OUTPUT.PUT_LINE( 'Sales revenue is greater than 100K ' ); 
   END IF; 
END;


DECLARE
  b_profitable BOOLEAN;
  n_sales      NUMBER:=1000;
  n_costs      NUMBER:=1000;
BEGIN
  b_profitable := n_sales > n_costs;
  IF b_profitable = TRUE THEN
     DBMS_OUTPUT.PUT_LINE( 'This sales deal is profitable' );
  else
    DBMS_OUTPUT.PUT_LINE( 'This sales deal is not profitable' );
  END IF;
END;



DECLARE
  n_sales NUMBER := 300000;
  n_commission NUMBER( 10, 2 ) := 0;
BEGIN
  IF n_sales > 200000 THEN
    n_commission := n_sales * 0.1;
  ELSIF n_sales <= 200000 AND n_sales > 100000 THEN 
    n_commission := n_sales * 0.05;
  ELSIF n_sales <= 100000 AND n_sales > 50000 THEN 
    n_commission := n_sales * 0.03;
  ELSE
    n_commission := n_sales * 0.02;
  END IF;
  DBMS_OUTPUT.PUT_LINE(n_commission);
END;


CASE STATMENT , FIXED VALUE CASE : 

DECLARE
  c_grade CHAR( 1 );
  c_rank  VARCHAR2( 20 );
BEGIN
  c_grade := 'B';
  CASE c_grade
  WHEN 'A' THEN
    c_rank := 'Excellent' ;
  WHEN 'B' THEN
    c_rank := 'Very Good' ;
  WHEN 'C' THEN
    c_rank := 'Good' ;
  WHEN 'D' THEN
    c_rank := 'Fair' ;
  WHEN 'F' THEN
    c_rank := 'Poor' ;
  ELSE
    c_rank := 'No such grade' ;
  END CASE;
  DBMS_OUTPUT.PUT_LINE( c_rank );
END;


CASE WITH RANDOM VALUE , THIS IS SEARCH CASE, VALUE CALCULATED AT EACH TIME.

DECLARE
  n_sales      NUMBER;
  n_commission NUMBER;
BEGIN
  n_sales := 150000;
  CASE
  WHEN n_sales    > 200000 THEN
    n_commission := 0.2;
  WHEN n_sales   >= 100000 AND n_sales < 200000 THEN
    n_commission := 0.15;
  WHEN n_sales   >= 50000 AND n_sales < 100000 THEN
    n_commission := 0.1;
  WHEN n_sales    > 30000 THEN
    n_commission := 0.05;
  ELSE
    n_commission := 0;
  END CASE;

  DBMS_OUTPUT.PUT_LINE( 'Commission is ' || n_commission * 100 || '%'
  );
END;



GO-TO DEMO

BEGIN
  GOTO second_message;

  <<first_message>>
  DBMS_OUTPUT.PUT_LINE( 'Hello' );
  GOTO the_end;

  <<second_message>>
  DBMS_OUTPUT.PUT_LINE( 'PL/SQL GOTO Demo' );
  GOTO first_message;

  <<the_end>>
  DBMS_OUTPUT.PUT_LINE( 'and good bye...' );

END;



NULL STATMENT , USE WHEN YOU EXPLICITLY DONT WANT TO DO ANYTHING


DECLARE
  n_credit_status VARCHAR2( 50 );
BEGIN
  n_credit_status := 'GOOD';

  CASE n_credit_status
  WHEN 'BLOCK' THEN
    DBMS_OUTPUT.PUT_LINE( 'rEQUEST FOR APPROVVAL' );
  WHEN 'WARNING' THEN
    DBMS_OUTPUT.PUT_LINE( 'send_email_to_accountant' );
  ELSE
    DBMS_OUTPUT.PUT_LINE( 'NULLLL' );
    NULL;
  END CASE;
END;



LOOPS IN PLSQL


DECLARE
  l_counter NUMBER := 0;
BEGIN
  LOOP
    l_counter := l_counter + 1;
    IF l_counter > 3 THEN
      EXIT;
    END IF;
    dbms_output.put_line( 'Inside loop: ' || l_counter )  ;
  END LOOP;
  -- control resumes here after EXIT
  dbms_output.put_line( 'After loop: ' || l_counter );
END;





DECLARE
  l_counter NUMBER := 0;
BEGIN
  LOOP
    l_counter := l_counter + 1;
    EXIT WHEN l_counter > 3;
    dbms_output.put_line( 'Inside loop: ' || l_counter ) ;
  END LOOP;

  -- control resumes here after EXIT
  dbms_output.put_line( 'After loop: ' || l_counter );
END;




DECLARE
  l_i NUMBER := 0;
  l_j NUMBER := 0;
BEGIN
  <<outer_loop>>
  LOOP
    l_i := l_i + 1;
    EXIT outer_loop WHEN l_i > 2;    
    dbms_output.put_line('Outer counter ' || l_i);
    -- reset inner counter
    l_j := 0;
      <<inner_loop>> LOOP
      l_j := l_j + 1;
      EXIT inner_loop WHEN l_j > 3;
      dbms_output.put_line(' Inner counter ' || l_j);
    END LOOP inner_loop;
  END LOOP outer_loop;
END;



FOR LOOP IN PLSQL


BEGIN
  FOR l_counter IN 1..5
  LOOP
    DBMS_OUTPUT.PUT_LINE( l_counter );
  END LOOP;
END;

DECLARE
  l_step  PLS_INTEGER := 2;
BEGIN
  FOR l_counter IN 1..5 LOOP
    dbms_output.put_line (l_counter*l_step);
  END LOOP;
END;




DECLARE
  l_counter PLS_INTEGER := 10;
BEGIN
  FOR l_counter IN 1.. 5 loop
    DBMS_OUTPUT.PUT_LINE (l_counter);
  end loop;
  -- after the loop
  DBMS_OUTPUT.PUT_LINE (l_counter);
END; 




<<outer>>
DECLARE
  l_counter PLS_INTEGER := 10;
BEGIN
  FOR l_counter IN 1.. 5 loop
    DBMS_OUTPUT.PUT_LINE ('Local counter:' ||  l_counter);
    outer.l_counter := l_counter;
  end loop;
  -- after the loop
  DBMS_OUTPUT.PUT_LINE ('Global counter' || l_counter);
END outer;

REVERSE THE LOOP

BEGIN
  FOR l_counter IN REVERSE 1..3
  LOOP
    DBMS_OUTPUT.PUT_LINE( l_counter );
  END LOOP;
END;




WHILE LOOPS

DECLARE
  n_counter NUMBER := 1;
BEGIN
  WHILE n_counter <= 5
  LOOP
    DBMS_OUTPUT.PUT_LINE( 'Counter : ' || n_counter );
    n_counter := n_counter + 1;
  END LOOP;
END;




DECLARE
   n_counter NUMBER := 1;
BEGIN
   WHILE n_counter <= 5
      LOOP
        DBMS_OUTPUT.PUT_LINE( 'Counter : ' || n_counter );
        n_counter := n_counter + 1;
        EXIT WHEN n_counter = 3;
      END LOOP;
END;




BEGIN
  FOR n_index IN 1 .. 10
  LOOP
    -- skip odd numbers
    IF MOD( n_index, 2 ) = 1 THEN
      CONTINUE;
    END IF;
    DBMS_OUTPUT.PUT_LINE( n_index );
  END LOOP;
END;


BEGIN
  FOR n_index IN 1 .. 10
  LOOP
    -- skip even numbers
    CONTINUE
  WHEN MOD( n_index, 2 ) = 0;
    DBMS_OUTPUT.PUT_LINE( n_index );
  END LOOP;
END;


DECLARE
  l_customer_name customers.name%TYPE;
BEGIN
  -- get name of the customer 100 and assign it to l_customer_name
  SELECT name INTO l_customer_name
  FROM customers
  WHERE customer_id = 100;

  -- show the customer name
  dbms_output.put_line( l_customer_name );
END;




DECLARE
  r_customer customers%ROWTYPE;
BEGIN
  -- get the information of the customer 100
  SELECT * INTO r_customer
  FROM customers
  WHERE customer_id = 100;
  -- show the customer info
  dbms_output.put_line( r_customer.name || ', website: ' || r_customer.website );
END;


DECLARE
  l_customer_name customers.name%TYPE;
  l_contact_first_name contacts.first_name%TYPE;
  l_contact_last_name contacts.last_name%TYPE;
BEGIN
  -- get customer and contact names
  SELECT
    name, 
    first_name, 
    last_name
  INTO
    l_customer_name, 
    l_contact_first_name, 
    l_contact_last_name
  FROM
    customers
  INNER JOIN contacts USING( customer_id )
  WHERE
    customer_id = 100;
  -- show the information  
  dbms_output.put_line( 
    l_customer_name || ', Contact Person: ' ||
    l_contact_first_name || ' ' || l_contact_last_name );
END;


TABLE BASE RECORD 

DECLARE
   record_name table_name%ROWTYPE;


DECLARE
   r_contact contacts%ROWTYPE;
   
   
DECLARE
    CURSOR c_contacts IS
        SELECT first_name, last_name, phone
        FROM contacts;
    r_contact c_contacts%ROWTYPE;


DECLARE
  -- define a record type
TYPE r_customer_contact_t
IS
  RECORD
  (
    customer_name customers.name%TYPE,
    first_name    contacts.first_name%TYPE,
    last_name     contacts.last_name%TYPE );
  -- declare a record
  r_customer_contacts r_customer_contact_t;
BEGIN
  NULL;
END;



CREATE TABLE persons  (
    person_id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR2( 50 ) NOT NULL, 
    last_name VARCHAR2( 50 ) NOT NULL,
    primary key (person_id)
);






DECLARE
  r_person persons%ROWTYPE;

BEGIN
  -- assign values to person record
  r_person.person_id  := 1;
  r_person.first_name := 'John';
  r_person.last_name  := 'Doe';

  -- insert a new person
  INSERT INTO persons VALUES r_person;
END;

SELECT * FROM PERSONS;


DECLARE
  r_person persons%ROWTYPE;

BEGIN
  -- get person data of person id 1
  SELECT * INTO r_person 
  FROM persons 
  WHERE person_id = 1;

  -- change the person's last name
  r_person.last_name  := 'Smith';

  -- update the person
  UPDATE persons
  SET ROW = r_person
  WHERE person_id = r_person.person_id;
END;




DECLARE
  TYPE address IS RECORD (
    street_name VARCHAR2(255),
    city VARCHAR2(100),
    state VARCHAR2(100),
    postal_code VARCHAR(10),
    country VARCHAR2(100)
  );
  TYPE customer IS RECORD(
      customer_name VARCHAR2(100),
      ship_to address,
      bill_to address
  );
  r_one_time_customer customer;
BEGIN

  r_one_time_customer.customer_name := 'John Doe';
  -- assign address
  r_one_time_customer.ship_to.street_name := '4000 North 1st street';
  r_one_time_customer.ship_to.city := 'San Jose';
  r_one_time_customer.ship_to.state := 'CA';
  r_one_time_customer.ship_to.postal_code := '95134';
  r_one_time_customer.ship_to.country := 'USA';
  -- bill-to address is same as ship-to address
  r_one_time_customer.bill_to := one_time_customer.ship_to;
END;





DECLARE
    l_name customers.NAME%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the customer name by id
    SELECT name INTO l_name
    FROM customers
    WHERE customer_id = l_customer_id;

    -- show the customer name   
    dbms_output.put_line('Customer name is ' || l_name);
    
END;
/


DECLARE
    l_name customers.NAME%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the customer
    SELECT NAME INTO l_name
    FROM customers
    WHERE customer_id = l_customer_id;
    
    -- show the customer name   
    dbms_output.put_line('customer name is ' || l_name);

    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_customer_id ||  ' does not exist');
END;
/





DECLARE
    l_name customers.NAME%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the customer
    SELECT NAME INTO l_name
    FROM customers
    WHERE customer_id > l_customer_id;
    
    -- show the customer name   
    dbms_output.put_line('Customer name is ' || l_name);
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_customer_id ||  ' does not exist');
        WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('The database returns more than one customer');    
END;
/


USER DEFINED EXCEPTIONS 



DECLARE
    e_credit_too_high EXCEPTION;
    PRAGMA exception_init( e_credit_too_high, -20001 );
    l_max_credit customers.credit_limit%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
    l_credit customers.credit_limit%TYPE := &credit_limit;
BEGIN
    -- get the meax credit limit
    SELECT MAX(credit_limit) 
    INTO l_max_credit
    FROM customers;
    
    -- check if input credit is greater than the max credit
    IF l_credit > l_max_credit THEN 
        RAISE e_credit_too_high;
    END IF;
    
    -- if not, update credit limit
    UPDATE customers 
    SET credit_limit = l_credit
    WHERE customer_id = l_customer_id;
    
    COMMIT;
END;
/




DECLARE
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the meax credit limit
    IF l_customer_id < 0 THEN
        RAISE invalid_number;
    END IF;
END;
/


RE-RAISE THE EXCEPTION

DECLARE
    e_credit_too_high EXCEPTION;
    PRAGMA exception_init( e_credit_too_high, -20001 );
    l_max_credit customers.credit_limit%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
    l_credit customers.credit_limit%TYPE     := &credit_limit;
BEGIN
    BEGIN
        -- get the max credit limit
        SELECT MAX(credit_limit) 
        INTO l_max_credit
        FROM customers;
        
        -- check if input credit is greater than the max credit
        IF l_credit > l_max_credit THEN 
            RAISE e_credit_too_high;
        END IF;
        EXCEPTION
            WHEN e_credit_too_high THEN
                dbms_output.put_line('The credit is too high' || l_credit);
                RAISE; -- reraise the exception
    END;
EXCEPTION
    WHEN e_credit_too_high THEN
        -- get average credit limit
        SELECT avg(credit_limit) 
        into l_credit
        from customers;
        
        -- adjust the credit limit to the average
        dbms_output.put_line('Adjusted credit to ' || l_credit);
    
        --  update credit limit
        UPDATE customers 
        SET credit_limit = l_credit
        WHERE customer_id = l_customer_id;
   
        COMMIT;
END;
/





DECLARE
    credit_limit_exceed EXCEPTION;
    PRAGMA exception_init(credit_limit_exceed, -20111);

    l_customer_id     customers.customer_id%TYPE := &customer_id;
    l_credit_limit    customers.credit_limit%TYPE := &credit_limit;

    l_customer_credit customers.credit_limit%TYPE;
    
BEGIN
    -- get customer credit limit
    SELECT credit_limit INTO l_customer_credit
    FROM customers
    WHERE customer_id = l_customer_id;
    
    -- raise an exception if the credit limit is exceeded
    IF l_customer_credit > l_credit_limit THEN
        raise_application_error(-20111,'Credit Limit Exceeded');
    END IF;
    
    dbms_output.put_line('Credit Limit is checked and passed');
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer with id ' || l_customer_id || ' does not exist.');
END;
/







--------------------------------------

Cursor , implicit cursor, explicit cursor

CURSOR cursor_name IS query;


DECLARE
  l_budget NUMBER := 1000000;
   -- cursor
  CURSOR c_sales IS
  SELECT  *  FROM sales  
  ORDER BY total DESC;
   -- record    
   r_sales c_sales%ROWTYPE;
BEGIN

  -- reset credit limit of all customers
  UPDATE customers SET credit_limit = 0;

  OPEN c_sales;

  LOOP
    FETCH  c_sales  INTO r_sales;
    EXIT WHEN c_sales%NOTFOUND;

    -- update credit for the current customer
    UPDATE 
        customers
    SET  
        credit_limit = 
            CASE WHEN l_budget > r_sales.credit 
                        THEN r_sales.credit 
                            ELSE l_budget
            END
    WHERE 
        customer_id = r_sales.customer_id;

    --  reduce the budget for credit limit
    l_budget := l_budget - r_sales.credit;

    DBMS_OUTPUT.PUT_LINE( 'Customer id: ' ||r_sales.customer_id || 
' Credit: ' || r_sales.credit || ' Remaining Budget: ' || l_budget );

    -- check the budget
    EXIT WHEN l_budget <= 0;
  END LOOP;

  CLOSE c_sales;
END;



DECLARE
  CURSOR c_product
  IS
    SELECT 
        product_name, list_price
    FROM 
        products 
    ORDER BY 
        list_price DESC;
BEGIN
  FOR r_product IN c_product
  LOOP
    dbms_output.put_line( r_product.product_name || ': $' ||  r_product.list_price );
  END LOOP;
END;



set serveroutput on;

BEGIN
  FOR r_product IN (
        SELECT 
            product_name, list_price 
        FROM 
            products
        ORDER BY list_price DESC
    )
  LOOP
     dbms_output.put_line( r_product.product_name ||
        ': $' || 
        r_product.list_price );
  END LOOP;
END;



BEGIN
  FOR r_product IN (
        SELECT 
            product_name, list_price 
        FROM 
            products
        ORDER BY list_price DESC
    )
  LOOP
     dbms_output.put_line( r_product.product_name ||
        ': $' || 
        r_product.list_price );
  END LOOP;
END;

-- Cursors  

DECLARE
    r_product products%rowtype;
    CURSOR c_product (low_price NUMBER, high_price NUMBER)
    IS
        SELECT *
        FROM products
        WHERE list_price BETWEEN low_price AND high_price;
BEGIN
    -- show mass products
    dbms_output.put_line('Mass products: ');
    OPEN c_product(50,100);
    LOOP
        FETCH c_product INTO r_product;
        EXIT WHEN c_product%notfound;
        dbms_output.put_line(r_product.product_name || ': ' ||r_product.list_price);
    END LOOP;
    CLOSE c_product;

    -- show luxury products
    dbms_output.put_line('Luxury products: ');
    OPEN c_product(800,1000);
    LOOP
        FETCH c_product INTO r_product;
        EXIT WHEN c_product%notfound;
        dbms_output.put_line(r_product.product_name || ': ' ||r_product.list_price);
    END LOOP;
    CLOSE c_product;

END;
/










DECLARE
    CURSOR c_revenue (in_year NUMBER :=2017 , in_customer_id NUMBER := 1)
    IS
        SELECT SUM(quantity * unit_price) revenue
        FROM order_items
        INNER JOIN orders USING (order_id)
        WHERE status = 'Shipped' AND EXTRACT( YEAR FROM order_date) = in_year
        GROUP BY customer_id
        HAVING customer_id = in_customer_id;
        
    r_revenue c_revenue%rowtype;
BEGIN
    OPEN c_revenue;
    LOOP
        FETCH c_revenue INTO r_revenue;
        EXIT    WHEN c_revenue%notfound;
        -- show the revenue
        dbms_output.put_line(r_revenue.revenue);
    END LOOP;
    CLOSE c_revenue;
END;





CREATE OR REPLACE FUNCTION get_direct_reports(
      in_manager_id IN employees.manager_id%TYPE)
   RETURN SYS_REFCURSOR
AS
   c_direct_reports SYS_REFCURSOR;
BEGIN

   OPEN c_direct_reports FOR 
   SELECT 
      employee_id, 
      first_name, 
      last_name, 
      email
   FROM 
      employees 
   WHERE 
      manager_id = in_manager_id 
   ORDER BY 
         first_name,   
         last_name;

   RETURN c_direct_reports;
END;



DECLARE
   c_direct_reports SYS_REFCURSOR;
   l_employee_id employees.employee_id%TYPE;
   l_first_name  employees.first_name%TYPE;
   l_last_name   employees.last_name%TYPE;
   l_email       employees.email%TYPE;
BEGIN
   -- get the ref cursor from function
   c_direct_reports := get_direct_reports(42); 
   
   -- process each employee
   LOOP
      FETCH
         c_direct_reports
      INTO
         l_employee_id,
         l_first_name,
         l_last_name,
         l_email;
      EXIT
   WHEN c_direct_reports%notfound;
      dbms_output.put_line(l_first_name || ' ' || l_last_name || ' - ' ||    l_email );
   END LOOP;
   -- close the cursor
   CLOSE c_direct_reports;
END;
/



DECLARE
    -- customer cursor
    CURSOR c_customers IS 
        SELECT 
            customer_id, 
            name, 
            credit_limit
        FROM 
            customers
        WHERE 
            credit_limit > 0 
        FOR UPDATE OF credit_limit;
    -- local variables
    l_order_count PLS_INTEGER := 0;
    l_increment   PLS_INTEGER := 0;
    
BEGIN
    FOR r_customer IN c_customers
    LOOP
        -- get the number of orders of the customer
        SELECT COUNT(*)
        INTO l_order_count
        FROM orders
        WHERE customer_id = r_customer.customer_id;
        -- 
        IF l_order_count >= 5 THEN
            l_increment := 5;
        ELSIF l_order_count < 5 AND l_order_count >=2 THEN
            l_increment := 2;
        ELSIF l_increment = 1 THEN
            l_increment := 1;
        ELSE 
            l_increment := 0;
        END IF;
        
        IF l_increment > 0 THEN
            -- update the credit limit
            UPDATE 
                customers
            SET 
                credit_limit = credit_limit * ( 1 +  l_increment/ 100)
            WHERE 
                customer_id = r_customer.customer_id;
            
            -- show the customers whose credits are increased
            dbms_output.put_line('Increase credit for customer ' 
                || r_customer.NAME || ' by ' 
                || l_increment || '%' );
        END IF;
    END LOOP;
    
    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line('Error code:' || SQLCODE);
            dbms_output.put_line('Error message:' || sqlerrm);
            RAISE;
            
END;
/



PL/SQL procedures


1) Declarative part

In this part, you can declare variables, constants, cursors, etc. Unlike an anonymous block, a declaration part of a procedure does not start with the DECLARE keyword.

2) Executable part

This part contains one or more statements that implement specific business logic. It might contain only a NULL statement.

3) Exception-handling part

This part contains the code that handles exceptions.



CREATE OR REPLACE PROCEDURE print_contact(
    in_customer_id NUMBER 
)
IS
  r_contact contacts%ROWTYPE;
BEGIN
  -- get contact based on customer id
  SELECT *
  INTO r_contact
  FROM contacts
  WHERE customer_id = p_customer_id;

  -- print out contact's information
  dbms_output.put_line( r_contact.first_name || ' ' ||
  r_contact.last_name || '<' || r_contact.email ||'>' );

EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line( SQLERRM );
END;



CREATE OR REPLACE PROCEDURE get_customer_by_credit(
    min_credit NUMBER
)
AS 
    c_customers SYS_REFCURSOR;
BEGIN
    -- open the cursor
    OPEN c_customers FOR
        SELECT customer_id, credit_limit, name
        FROM customers
        WHERE credit_limit > min_credit
        ORDER BY credit_limit;
    -- return the result set
    dbms_sql.return_result(c_customers);
END;


exec get_customer_by_credit(100);



CREATE OR REPLACE PROCEDURE get_customers(
    page_no NUMBER, 
    page_size NUMBER
)
AS
    c_customers SYS_REFCURSOR;
    c_total_row SYS_REFCURSOR;
BEGIN
    -- return the total of customers
    OPEN c_total_row FOR
        SELECT COUNT(*)
        FROM customers;
    
    dbms_sql.return_result(c_total_row);
    
    -- return the customers 
    OPEN c_customers FOR
        SELECT customer_id, name
        FROM customers
        ORDER BY name
        OFFSET page_size * (page_no - 1) ROWS
        FETCH NEXT page_size ROWS ONLY;
        
    dbms_sql.return_result(c_customers);    
END;



EXEC get_customers(1,10);








CREATE OR REPLACE FUNCTION get_total_sales(
    in_year PLS_INTEGER
) 
RETURN NUMBER
IS
    l_total_sales NUMBER := 0;
BEGIN
    -- get total sales
    SELECT SUM(unit_price * quantity)
    INTO l_total_sales
    FROM order_items
    INNER JOIN orders USING (order_id)
    WHERE status = 'Shipped'
    GROUP BY EXTRACT(YEAR FROM order_date)
    HAVING EXTRACT(YEAR FROM order_date) = in_year;
    
    -- return the total sales
    RETURN l_total_sales;
END;


select get_total_sales(2016) from dual;


DECLARE
    l_sales_2017 NUMBER := 0;
BEGIN
    l_sales_2017 := get_total_sales (2017);
    DBMS_OUTPUT.PUT_LINE('Sales 2017: ' || l_sales_2017);
END;

BEGIN
    IF get_total_sales (2017) > 10000000 THEN
        DBMS_OUTPUT.PUT_LINE('Sales 2017 is above target');
    END IF;
END;



Package : 



CREATE OR REPLACE PACKAGE order_mgmt
AS
  gc_shipped_status  CONSTANT VARCHAR(10) := 'Shipped';
  gc_pending_status CONSTANT VARCHAR(10) := 'Pending';
  gc_canceled_status CONSTANT VARCHAR(10) := 'Canceled';

  -- cursor that returns the order detail
  CURSOR g_cur_order(p_order_id NUMBER)
  IS
    SELECT
      customer_id,
      status,
      salesman_id,
      order_date,
      item_id,
      product_name,
      quantity,
      unit_price
    FROM
      order_items
    INNER JOIN orders USING (order_id)
    INNER JOIN products USING (product_id)
    WHERE
      order_id = p_order_id;

  -- get net value of a order
  FUNCTION get_net_value(
      p_order_id NUMBER)
    RETURN NUMBER;

  -- Get net value by customer
  FUNCTION get_net_value_by_customer(
      p_customer_id NUMBER,
      p_year        NUMBER)
    RETURN NUMBER;

END order_mgmt;





CREATE TABLE audits (
      audit_id         NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);




CREATE OR REPLACE TRIGGER customers_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON customers
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;

   -- insert a row into the audit table   
   INSERT INTO audits (table_name, transaction_name, by_user, transaction_date)
   VALUES('CUSTOMERS', l_transaction, USER, SYSDATE);
END;
/










CREATE OR REPLACE TRIGGER customers_credit_trg
    BEFORE UPDATE OF credit_limit  
    ON customers
DECLARE
    l_day_of_month NUMBER;
BEGIN
    -- determine the transaction type 
    l_day_of_month := EXTRACT(DAY FROM sysdate);

    IF l_day_of_month BETWEEN 28 AND 31 THEN
        raise_application_error(-20100,'Cannot update customer credit from 28th to 31st');
    END IF;
END;

