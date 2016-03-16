CREATE DATABASE IF NOT EXISTS hotelDB 
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE hotelDB;

CREATE TABLE Location (
	id int NOT NULL,
	name varchar(40) NOT NULL,
	airport varchar(40) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Hotel (
	id int NOT NULL auto_increment,
	name varchar(40) NOT NULL,
	type varchar(30) NOT NULL,
	description varchar(200),
	city varchar(40),
	address varchar(50),
	location_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (location_id) REFERENCES Location(id)
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
	number_of_rooms int NOT NULL,
	room_type_id int NOT NULL,
	reservation_id int NOT NULL,
	status varchar(20) NOT NULL,
	PRIMARY KEY (reservation_id),
	FOREIGN KEY (reservation_id) REFERENCES Reservation(id),
	FOREIGN KEY (room_type_id) REFERENCES Room_Type(id)
);

CREATE TABLE Occupied_Room (
	id int NOT NULL auto_increment,
	check_in date NOT NULL,
	check_out date NOT NULL,
	room_id int NOT NULL,
	reservation_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (reservation_id) REFERENCES Reservation(id),
	FOREIGN KEY (room_id) REFERENCES Room(id)

);

CREATE TABLE Hosted_In (
	guest_id int NOT NULL,
	occupied_room_id int NOT NULL,
	PRIMARY KEY (guest_id, occupied_room_id),
	FOREIGN KEY (guest_id) REFERENCES Guest(id),
	FOREIGN KEY (occupied_room_id) REFERENCES Occupied_Room(id)

);