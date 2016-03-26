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
	areaid int NOT NULL,
	description varchar(900),
	city varchar(40),
	address varchar(50),
	picture varchar(50),
    wifi boolean,
    smoking boolean,
    breakfast boolean,
	PRIMARY KEY (id),
	FOREIGN KEY (areaid) REFERENCES Area(id)
);

CREATE TABLE Guest (
	id int NOT NULL auto_increment,
	first_name varchar(64) NOT NULL,
	last_name varchar(64) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Reservation (
	id int NOT NULL auto_increment,
	hotel_id int NOT NULL,
	date_in date NOT NULL,
	date_out date NOT NULL,
	guest_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (hotel_id) REFERENCES Hotel(id),
	FOREIGN KEY (guest_id) REFERENCES Guest(id)
);

CREATE TABLE Room_Type (
	id int NOT NULL auto_increment,
	name varchar(30) NOT NULL,
	description varchar(80),
	max_capacaty int NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Room (
	id int NOT NULL auto_increment,
	number int NOT NULL,
	room_type_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (room_type_id) REFERENCES Room_Type(id)
);

CREATE TABLE Reserved_Room (
	room_id int NOT NULL,
	reservation_id int NOT NULL,
	status varchar(20) NOT NULL,
	PRIMARY KEY (reservation_id),
	FOREIGN KEY (reservation_id) REFERENCES Reservation(id),
	FOREIGN KEY (room_id) REFERENCES Room(id)
);

CREATE TABLE Reviews (
	id int NOT NULL,
	hotel_id int NOT NULL,
	review varchar(200) NOT NULL,
	rating double(2,1) NOT NULL,
	FOREIGN KEY (hotel_id) REFERENCES Hotel(id)
);
