Drop database if exists ims;
Create database if not exists ims;
CREATE TABLE if not exists ims.items (item_id int NOT NULL UNIQUE AUTO_INCREMENT, name varchar(45) NOT NULL UNIQUE, price decimal(7,2) NOT NULL, PRIMARY KEY (item_id));
CREATE TABLE if not exists ims.customers (customer_id int NOT NULL UNIQUE AUTO_INCREMENT, name varchar(45) NOT NULL, address varchar(200) NOT NULL, PRIMARY KEY (customer_id));
CREATE TABLE if not exists ims.orders (order_id int NOT NULL UNIQUE AUTO_INCREMENT, customer_id int NOT NULL, total_price decimal(7,2) NOT NULL, PRIMARY KEY (order_id), FOREIGN KEY (customer_id) REFERENCES ims.customers (customer_id));
CREATE TABLE if not exists ims.orderline (item_id int NOT NULL, order_id int NOT NULL, FOREIGN KEY (item_id) REFERENCES ims.items (item_id), FOREIGN KEY (order_id) REFERENCES ims.orders (order_id));
