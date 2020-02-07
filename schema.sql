CREATE DATABASE IF NOT EXISTS ims;
USE ims;

CREATE TABLE customers (
	id int AUTO_INCREMENT,
    first_name varchar(50),
    surname varchar(50),
    PRIMARY KEY (id)
    );