Create database if not exists ims;
DROP table if exists item;
CREATE TABLE if not exists items (
item_id int NOT NULL UNIQUE AUTO_INCREMENT,
name varchar(45) NOT NULL UNIQUE,
price decimal(7,2) NOT NULL,
PRIMARY KEY (item_id)
);
DROP table if exists customers;
CREATE TABLE if not exists customers (
customer_id int NOT NULL UNIQUE AUTO_INCREMENT,
name varchar(45) NOT NULL,
address varchar(200) NOT NULL,
PRIMARY KEY (customer_id)
);
DROP table if exists orders;
CREATE TABLE if not exists orders (
order_id int NOT NULL UNIQUE AUTO_INCREMENT,
customer_id int NOT NULL,
date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
total_price decimal(7,2) NOT NULL,
PRIMARY KEY (order_id),
FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);
DROP table if exists orderline;
CREATE TABLE if not exists orderline (
product_id int NOT NULL,
order_id int NOT NULL,
FOREIGN KEY (item_id) REFERENCES products (item_id),
FOREIGN KEY (order_id) REFERENCES orders (order_id));
