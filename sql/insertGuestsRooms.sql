USE hotelDB;

# INSERT Guests

INSERT INTO Guest (name, ssn)
VALUES ('Gunnar Friðbertsson', 0101971119);

INSERT INTO Guest (name, ssn)
VALUES ('Stefán Björn Sæmundsson', 0311831219);

INSERT INTO Guest (name, ssn)
VALUES ('Anna Heiðarsdóttir', 2102772139);

INSERT INTO Guest (name, ssn)
VALUES ('Lovísa Huld Björnsdóttir', 2103902209);

# Insert Room types

INSERT INTO Room_Type (id, name, description, max_capacaty)
VALUES (1, 'Single room', 'Room for one person. 1 single bed.', 1);

INSERT INTO Room_Type (id, name, description, max_capacaty)
VALUES (2, 'Double room', 'Room for two persons. 1 double bed.', 2);

INSERT INTO Room_Type (id, name, description, max_capacaty)
VALUES (3, 'Dorm - small', 'Dorm with 6 bunk beds', 6);

INSERT INTO Room_Type (id, name, description, max_capacaty)
VALUES (4, 'Dorm - large', 'Dorm with 12 bunk beds', 12);

# Insert rooms into hotels

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 1, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 1, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 1, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 1, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 2, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 2, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 2, 3);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 2, 4);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 3, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 3, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 3, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 3, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 4, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 4, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 4, 3);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 4, 4);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 5, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 5, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 5, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 5, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 6, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 6, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 6, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 6, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 7, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 7, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 7, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 7, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 8, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 8, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 8, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 8, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 9, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 9, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 9, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 9, 2);

INSERT INTO Room (number, hotel_id, room_type_id) VALUES (1, 10, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (2, 10, 1);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (3, 10, 2);
INSERT INTO Room (number, hotel_id, room_type_id) VALUES (4, 10, 2);
