CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_id PRIMARY KEY(id)
);

INSERT INTO category(name, description, image_url, is_active) VALUES('Laptop', 'This is laptop', 'cat1.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES('TV', 'This is TV', 'cat2.png', true);
INSERT INTO category(name, description, image_url, is_active) VALUES('Mobile', 'This is mobile', 'cat3.png', true);

CREATE TABLE user_detail(
	id IDENTITY,
	fname VARCHAR(50),
	lname VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_no VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


INSERT INTO user_detail(fname,lname,role, enabled, password, email, contact_no) VALUES('Karan', 'Dadwal', 'ADMIN', true,'admin','kd@gmail.com','9999999999');

INSERT INTO user_detail(fname,lname,role, enabled, password, email, contact_no) VALUES('John', 'Menon', 'SUPPLIER', true,'supplier','jm@gmail.com','8888888888');

CREATE TABLE product(
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	view INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)	
);

INSERT INTO product(code,name,brand, description, unit_price, quantity, is_active, category_id,supplier_id) 
VALUES('PBXD01', 'IPAD', 'apple', 'best product', 12000, 2, true, 3, 1);

INSERT INTO product(code,name,brand, description, unit_price, quantity, is_active, category_id,supplier_id) 
VALUES('PBXD02', 'APPLE TV', 'apple', 'best TV', 20000, 3, true, 2, 1);

INSERT INTO product(code,name,brand, description, unit_price, quantity, is_active, category_id,supplier_id) 
VALUES('PBXD03', 'S6', 'samsung', 'S series', 40000, 1, true, 1, 1);


