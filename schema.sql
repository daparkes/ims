CREATE DATABASE IF NOT EXISTS ims;
USE ims;

CREATE TABLE customers (
	id INT AUTO_INCREMENT,
    first_name varchar(50),
    surname varchar(50),
    PRIMARY KEY (id)
    );
    
CREATE TABLE items (
	id INT AUTO_INCREMENT,
    item_name varchar(50),
    price decimal(7,2),
    PRIMARY KEY (id)
    );
    
CREATE TABLE users (
	id int AUTO_INCREMENT,
    username varchar(50),
    PRIMARY KEY (id)
    );
    
CREATE TABLE orders (
	id int AUTO_INCREMENT,
    customer_id INT,
    total_price decimal(7,2),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) 
		REFERENCES customers(id)
    );
    
CREATE TABLE order_items (
    id INT AUTO_INCREMENT,
    item_id INT,
    order_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id)
        REFERENCES orders(id),
    FOREIGN KEY (item_id)
        REFERENCES items(id)
);