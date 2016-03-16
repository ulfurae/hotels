USE hotelDB;

# INSERT Locations

INSERT INTO Location (id, name, airport)
VALUES (1, 'Capital Area','Reykjavíkurflugvöllur');

INSERT INTO Location (id, name, airport)
VALUES (2, 'Reykjanes Int. Airport', 'Keflavíkurflugvöllur');

INSERT INTO Location (id, name, airport)
VALUES (3, 'North Iceland', 'Akureyrarflugvöllur');

INSERT INTO Location (id, name, airport)
VALUES (4, 'Eastern Iceland', 'Egilsstaðaflugvöllur');


# INSERT Hotels etc.

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Hotel Óðinsvé','Hotel', 'Reykjavík', 1);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Kex Hostel','Hostel', 'Reykjavík', 1);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Hotel Berg','Hotel', 'Keflavík', 2);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Start Hostel','Hostel', 'Keflavík', 2);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Apotek Guesthouse', 'Guesthouse', 'Akureyri', 3);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Fosshótel Húsavík', 'Hotel', 'Húsavík', 3);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Hotel Eskifjörður', 'Hotel', 'Eskifjörður', 4);

INSERT INTO Hotel (name, type, city, location_id)
VALUES ('Birta Guesthouse', 'Guesthouse', 'Egilsstaðir', 4);

