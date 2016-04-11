set @dateIn = '2016-04-21';
set @dateOut = '2016-04-26';

DROP TABLE IF EXISTS tempBooked;
CREATE TEMPORARY TABLE tempBooked (
	hotel_id int,
	room_number int );

INSERT INTO tempBooked
Select h.id, r.number
From Hotel h, Room r, Room_Type rt, Booking book
Where book.hotel_id = h.id
and book.room_number = r.number
and h.id = r.hotel_id
and rt.id = r.room_type_id
and book.date_in < @dateOut
and book.date_out > @dateIn;


Select h.*
From Hotel h, Area a, Room r, Room_Type rt
Where h.area_id = a.id
and rt.id = r.room_type_id
and h.id = r.hotel_id
#and rt.id = 1
and concat(h.id) NOT IN
	(Select concat(hotel_id) from tempBooked)

group by h.id;

