# SQL Slim Study Guide

### Database Theory
A **Database** is simply an organized collection of data stored and accessed electronically. **Relational Databases** can create connections between the data stored in the **database** and use those connections to facilitate actions that can be taken with the data. What makes **Relational Databases** unique is their ability to facilitate **relationships** between tables: they can be related to each other through **keys**.

### SQL
**Structured Query Language** is tool for interacting with relational databases. It allows you to create tables, manipulate them, create user rolls, and create some functionality in the database. The different kinds of relational databases will have their own flavor of SQL, but the core syntax of the language is shared across most relational databases, so as long as you are comfortable with **SQL** you can pick up the specific syntax used by individual systems without needing to relearn everything

### Relational DataBase Management System
 In order to provide a way for external entities to manipulate the database a special kind of software called a **relational database management system** is used. There are many different vendors of RDBMS systems, including:
- Oracle
- PostgreSQL (or just "Postgres")
- MySQL
- SQLite
- Microsoft SQLServer
- Microsoft Access

**RDBMS** systems are one of the key components of any enterprise application or system: data by itself doesn’t mean a lot or even have intrinsic value. A lot of data thrown in a bucket would be meaningless unless some kind of processing and analysis was done on it. Related data is what provides meaning and organizes the structure of data. **RDBMS** provide the tools to create meaningful connections between data and access the data

## Structure

### Schema
In SQL, a **schema** is a collection of database objects such as tables, stored procedures, indexes, views, and other entities that define the structure and organization of a database. It’s a container for organizing and managing data within a database. Each **schema** has an owner, typically a database user, and it helps enhance security by allowing fine-grained control over access privileges to database objects

### Table Structure
Relational Databases data is organized into **tables**, which consist of **rows** and **columns**. Each **table** represents a specific entity, such as customers, orders, or products, all ordered in **rows** and **columns**. **Rows** (also called records) represent individual entries, while **columns** (also called fields) represent the attributes of the entity. A **primary key** uniquely identifies each row in a table, while a **foreign key** is a field in one table that links to the **primary key** of another table

### SQL Data Types
Most SQL databases share several common data types, which can be broadly categorized into three main groups: **numeric**, **character**, and **date/time**
- **Numeric Data Types**
    - INTEGER: Stores whole numbers
    - FLOAT/REAL: Stores floating-point numbers
    - DECIMAL/NUMERIC: Stores fixed-point numbers with exact precision
- **Character Data Types**
    - CHAR: Fixed-length character strings
    - VARCHAR: Variable-length character strings
    - TEXT: Large variable-length character strings
- **Date/Time Data Types**
    - DATE: Stores date values (year, month, day)
    - TIME: Stores time values (hour, minute, second)
    - TIMESTAMP: Stores both date and time values

### Normalization
**Normalization** is simply a standardized way of organizing data in tables. Higher and/or lower levels of **normalization** are not inherently better or worse than each other: they are simply different
- **1st Normal Form (1NF)**
  - Primary key is present (composite key allowed)
  - Each column contains only one value (atomic value)
    - Valid: "first_name"
    - Invalid: "first_and_last_name"
- **2nd Normal Form (2NF)**
  - Non-key columns depend on the entire primary key
    - If composite key, non-key columns must depend on all parts of the key
- **3rd Normal Form (3NF)**
  - No transitive dependencies (non-key columns must not depend on other non-key columns)
    - Valid: "product_cost" and "product_purchased"
    - Invalid: "product_cost," "product_purchased," and "total_cost" (if "total_cost" can be derived from the other two)

### Multiplicity
**Multiplicity** is a way of describing relationships between tables: tables can have a **one-to-one**, **one-to-many**, and **many-to-many** relationship. In a **one-to-one** relationship one table will have a reference to one record in another table, with no duplicate relationships. In **one-to-many** more than one record can point to the same record in another table. **Many-to-many** relationships are a bit different in that many records in one table can be related to many records in another table. This relationship is usually facilitated by a **junction table**

### Entity Relationship Diagram
An **Entity-Relationship Diagram** (ERD) is used to **design the database structure**, ensuring that all entities and their relationships are accurately represented. It also helps to **document the database**, providing a visual representation that can be easily referenced. Additionally, **ERDs** are helpful when **communicating the design to stakeholders**, making it easier for non-technical stakeholders to understand the database layout. **ERDs** also help to **identify potential design issues** early in the development process, allowing for adjustments before implementation

### Referential Integrity
**Referential Integrity** is the idea that there should be **no orphaned records** in a database. If an entry has a foreign key, it needs to reference an existing record. If the primary record is deleted then the foreign record needs to have a response to maintain **referential integrity**. This response could be to self delete, or even to stop the parent record from being deleted:
- **on delete cascade**: deletes the data that has a foreign relationship to the primary data
- **on delete restrict**: prevents the primary data from being deleted
- **on delete update**: allow the foreign key to update, but if it breaks referential integrity the whole transaction will fail

## Sublanguages

### Data Definition Language
```sql
--these are the commands that let us set up and alter tables within our database

--create allows us to make new tables. We define the columns and their types inside parenthesis
create table simple_table(
	first_name varchar(50),
	last_name varchar(50)
);

--alter lets us make changes to tables and their columns
alter table simple_table add column person_id serial;

--rename allows us to change the name of a table
alter table simple_table rename to renamed_table;

--add a new column to an existing table
alter table renamed_table add column email varchar(100);

--modify an existing column's data type
alter table renamed_table alter column email type text;

--drop a column from a table
alter table renamed_table drop column email;

--add a primary key constraint to a column
alter table renamed_table add primary key (person_id);

--add a foreign key constraint to a column
alter table renamed_table add constraint fk_example foreign key (last_name) references another_table(last_name);

--create an index to improve query performance
create index idx_last_name on renamed_table(last_name);

--delete an index
drop index idx_last_name;

--truncate will remove all the data within a table without deleting the table itself, as long as there are no constraint issues
truncate table renamed_table;

--drop will delete a table and its data, as long as there are no constraint issues
drop table renamed_table;

--these commands are not reversible: there is no option to do a rollback
```

#### Constraints
**Constraints** are used to limit or identify data within your tables:
- **PRIMARY KEY**: makes the column an identifier. Combination of unique and not null
    - multiple primary keys are called composite keys
    - columns that could work as primary keys are called candidate keys
- **FOREIGN KEY**: makes the column reference a primary key on another table
- **NOT NULL**: column must have a value
- **UNIQUE**: column value must be different from all others in table
- **CHECK**: use when you need to ensure a condition is met (number > 0, for instance)
- **DEFAULT**: lets you create a default value. Also used with serial data type
```sql
-- PRIMARY KEY
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);

-- Composite Key
CREATE TABLE enrollments (
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    PRIMARY KEY (student_id, course_id)
);

-- FOREIGN KEY
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- NOT NULL
CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- UNIQUE
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);

-- CHECK
CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    balance DECIMAL(10, 2),
    CHECK (balance >= 0)
);

-- DEFAULT
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    order_date DATE DEFAULT CURRENT_DATE,
    status VARCHAR(20) DEFAULT 'Pending'
);
```

### Data Manipulation Language
**Data Manipulation Language** (DML) consists of your **CRUD operations**: creating, reading, updating, and deleting data
```sql
-- INSERT is used to add data into a table
-- Example: Adding a new person to the 'names' table
INSERT INTO names (person_id, first_name, last_name) VALUES (DEFAULT, 'Billy', 'Bob');

-- UPDATE is used to change data in a table
-- Example: Changing the first name of the person with person_id = 1
UPDATE names SET first_name = 'Sally' WHERE person_id = 1;

-- SELECT is used to retrieve data from a table
-- This is sometimes categorized under DQL (Data Query Language) separately from DML
-- Example: Retrieving all columns for the person with person_id = 1
SELECT * FROM names WHERE person_id = 1;

-- DELETE is used to remove data from a table
-- Example: Removing the person with person_id = 1 from the 'names' table
DELETE FROM names WHERE person_id = 1;
```

### Data Query Language
```sql
-- SELECT is used to retrieve data from a table. This is sometimes categorized under DQL separately from DML.
SELECT * FROM names;

-- JOIN operations are used to combine rows from two or more tables based on a related column between them.
-- INNER JOIN: Returns records that have matching values in both tables.
SELECT players.name, teams.team_name
FROM players
INNER JOIN teams ON players.team_id = teams.team_id;

-- LEFT JOIN: Returns all records from the left table, and the matched records from the right table. The result is NULL from the right side, if there is no match.
SELECT players.name, teams.team_name
FROM players
LEFT JOIN teams ON players.team_id = teams.team_id;

-- RIGHT JOIN: Returns all records from the right table, and the matched records from the left table. The result is NULL from the left side, when there is no match.
SELECT players.name, teams.team_name
FROM players
RIGHT JOIN teams ON players.team_id = teams.team_id;

-- FULL OUTER JOIN: Returns all records when there is a match in either left or right table.
SELECT players.name, teams.team_name
FROM players
FULL OUTER JOIN teams ON players.team_id = teams.team_id;

-- SET operations are used to combine the results of two or more SELECT statements.
-- UNION: Combines the result set of two or more SELECT statements (removes duplicates).
SELECT team_id FROM teams
UNION
SELECT team_id FROM players;

-- UNION ALL: Combines the result set of two or more SELECT statements (includes duplicates).
SELECT team_id FROM teams
UNION ALL
SELECT team_id FROM players;

-- INTERSECT: Returns the common records from two SELECT statements.
SELECT team_id FROM teams
INTERSECT
SELECT team_id FROM players;

-- EXCEPT: Returns the records from the first SELECT statement that are not in the second SELECT statement.
SELECT team_id FROM teams
EXCEPT
SELECT team_id FROM players;

-- Functions are used to perform operations on data.
-- Aggregate Functions: Perform a calculation on a set of values and return a single value.
SELECT COUNT(*) FROM players; -- Returns the number of rows in the players table.
SELECT AVG(age) FROM players; -- Returns the average age of players.
SELECT SUM(salary) FROM players; -- Returns the total salary of players.

-- Scalar Functions: Return a single value based on the input value.
SELECT UPPER(name) FROM players; -- Converts the name to uppercase.
SELECT LOWER(name) FROM players; -- Converts the name to lowercase.
SELECT LENGTH(name) FROM players; -- Returns the length of the name.

-- WHERE clause: Used to filter records.
SELECT * FROM players WHERE age > 25;

-- ORDER BY clause: Used to sort the result set.
SELECT * FROM players ORDER BY age DESC;

-- GROUP BY clause: Used to group rows that have the same values in specified columns.
SELECT team_id, COUNT(*) AS player_count
FROM players
GROUP BY team_id;

-- HAVING clause: Used to filter groups based on a condition.
SELECT team_id, COUNT(*) AS player_count
FROM players
GROUP BY team_id
HAVING COUNT(*) > 5;

-- LIMIT clause: Used to specify the number of records to return.
SELECT * FROM players LIMIT 10;

-- OFFSET clause: Used to specify the starting point to return records.
SELECT * FROM players LIMIT 10 OFFSET 5;

-- DISTINCT clause: Used to return only distinct (different) values.
SELECT DISTINCT team_id FROM players;

-- IN clause: Used to filter records based on a list of values.
SELECT * FROM players WHERE team_id IN (1, 2, 3);

-- BETWEEN clause: Used to filter records within a range.
SELECT * FROM players WHERE age BETWEEN 20 AND 30;

-- LIKE clause: Used to search for a specified pattern in a column.
SELECT * FROM players WHERE name LIKE 'J%'; -- Names starting with 'J'
SELECT * FROM players WHERE name LIKE '%son'; -- Names ending with 'son'
SELECT * FROM players WHERE name LIKE '%a%'; -- Names containing 'a'

```

### Data Control Language
**Data Control Language (DCL)** commands are essential for managing users and their privileges within a database. The `CREATE ROLE` command is used to create a new user or role, such as `test`, with specific restrictions like `NOSUPERUSER`, `NOCREATEDB`, `NOCREATEROLE`, and `NOINHERIT`, ensuring the user has limited capabilities 
```sql
CREATE ROLE test NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN PASSWORD 'test';
```
To manage what actions a user can perform, the `GRANT` and `REVOKE` commands are used. `GRANT ALL PRIVILEGES ON TABLE practice.names TO test;` gives the user full access to the specified table, enabling actions like `SELECT`, `INSERT`, `UPDATE`, and `DELETE`. Conversely, `REVOKE ALL PRIVILEGES ON TABLE practice.names FROM test;` removes all these privileges

### Transaction Control Language
**Tansaction Control Language** (TCL) commands are used to manage **transactions** in a database. They allow you to control the changes made by DML statements. These commands can **start**, **end**, and **rollback** **transactions**, giving you fine control over your queries. `BEGIN ` starts a new **transaction**: it ensures all subsequent operations are part of a single **transaction** until a `COMMIT` or `ROLLBACK` command is issued.
```sql
BEGIN;
```
`SAVEPOINT` creates a **savepoint** within a **transaction**. A **savepoint** is a point in the **transaction** you can return to if needed, which is useful for partially undoing a **transaction**
```sql
SAVEPOINT my_savepoint;
```
`ROLLBACK TO SAVEPOINT` will roll back the **transaction** to the specified **savepoint**. Any operations performed after the **savepoint** are undone, but operations before the **savepoint** remain intact
```sql
SAVEPOINT my_savepoint;
INSERT INTO names VALUES (DEFAULT, 'Billy', 'Bob');
ROLLBACK TO SAVEPOINT my_savepoint;
```
`RELEASE SAVEPOINT` removes a **savepoint**. It is good practice to release **savepoints** that are no longer needed to free up system resources
```sql
RELEASE SAVEPOINT my_savepoint;
```

`COMMIT` **commits** the current **transaction**, making all changes permanent. You can also use the `END` command as an alternative to `COMMIT`
```sql
COMMIT; -- or END;
```
A full example of TCL in action
```sql
BEGIN;
    INSERT INTO names VALUES (DEFAULT, 'Billy', 'Bob');
    SAVEPOINT my_savepoint;
    INSERT INTO names VALUES (DEFAULT, 'Sally', 'Sherbert');
    ROLLBACK TO SAVEPOINT my_savepoint;
    RELEASE SAVEPOINT my_savepoint;
COMMIT; -- or END;
```
#### ACID
Any DML actions before a commit are called **transactions**: Every **transaction** should have the **ACID** properties (this is managed by the database, and different types of databases will handle implementing ACID in their own way):
- **Atomicity**: all transactions must succeed for a commit to happen: If any fail, there is no commit
- **Consistency**: all transactions must enforce existing constraints
- **Isolation**: multiple concurrent transactions should not interfere with one another
- **Durability**: committed transactions should be persisted, even if there is some catastrophic failure (power outage, system, crash, etc)