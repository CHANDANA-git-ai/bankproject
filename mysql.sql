CREATE DATABASE bank_db;
USE bank_db;
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    mobile VARCHAR(15),
    city VARCHAR(50),
    balance DOUBLE,
    status VARCHAR(20)
);
DESC customers;
select * from customers;
