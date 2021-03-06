DROP DATABASE IF EXISTS hotelDB;
CREATE DATABASE hotelDB 
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE hotelDB;

CREATE TABLE Area (
	id int NOT NULL,
	name varchar(40) NOT NULL,
	airport varchar(40) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Hotel (
	id int NOT NULL auto_increment,
	name varchar(40) NOT NULL,
	type varchar(30) NOT NULL,
	area_id int NOT NULL,
	city varchar(40),
	description varchar(900),
	picture varchar(50),
    wifi boolean,
    smoking boolean,
    breakfast boolean,
	PRIMARY KEY (id),
	FOREIGN KEY (area_id) REFERENCES Area(id)
);

CREATE TABLE Guest (
	id int NOT NULL auto_increment,
	name varchar(64) NOT NULL,
	ssn int NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Room_Type (
	id int NOT NULL auto_increment,
	name varchar(30) NOT NULL,
	description varchar(80),
	max_capacaty int NOT NULL,
	price int NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Room (
	number int NOT NULL,
	hotel_id int NOT NULL,
	room_type_id int NOT NULL,
	PRIMARY KEY (number, hotel_id),
	FOREIGN KEY (hotel_id) REFERENCES Hotel(id),
	FOREIGN KEY (room_type_id) REFERENCES Room_Type(id)
);

CREATE TABLE Booking (
	id int NOT NULL auto_increment,
	hotel_id int NOT NULL,
	date_in date NOT NULL,
	date_out date NOT NULL,
	room_number int NOT NULL,
	guest_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (hotel_id) REFERENCES Hotel(id),
	FOREIGN KEY (room_number) REFERENCES Room(number),
	FOREIGN KEY (guest_id) REFERENCES Guest(id)
);


CREATE TABLE Reviews (
	id int NOT NULL,
	hotel_id int NOT NULL,
	customer_name varchar(45),
	review varchar(200) NOT NULL,
	rating double(2,1) NOT NULL,
	FOREIGN KEY (hotel_id) REFERENCES Hotel(id)
);
