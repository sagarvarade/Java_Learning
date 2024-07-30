


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





