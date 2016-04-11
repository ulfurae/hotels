USE hotelDB;

# INSERT Locations

INSERT INTO Area (id, name, airport)
VALUES (1, 'Capital Area','Reykjavíkurflugvöllur');

INSERT INTO Area (id, name, airport)
VALUES (2, 'Reykjanes Int. Airport', 'Keflavíkurflugvöllur');

INSERT INTO Area (id, name, airport)
VALUES (3, 'North Iceland', 'Akureyrarflugvöllur');

INSERT INTO Area (id, name, airport)
VALUES (4, 'Eastern Iceland', 'Egilsstaðaflugvöllur');

INSERT INTO Area (id, name, airport)
VALUES (5, 'Westfjords', 'Ísafjarðarflugvöllur');

INSERT INTO Area (id, name, airport)
VALUES (6, 'Vestmannaeyjar', 'Vestmannaeyjarflugvöllur');


# INSERT Hotels etc.

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Hotel Óðinsvé','Hotel', 'Reykjavík', 1, true, false, true, 'odinsve', "Hotel Odinsve is 400 m from Laekjartorg Square in central Reykjavik. It offers free Wi-Fi internet. All rooms have satellite TV, hardwood floors and a tea/coffee maker.\n\nHotel Odinsve’s rooms also have luxury duvets and pillows by Kronborg. Some rooms offer city views.\n\nOdinsve’s facilities include a terrace, a café bar and a 2nd floor balcony offering city views. Snaps Restaurant is an on-site bistro serving Danish food for lunch and dinner.\n\nReykjavik’s main shopping street, Laugavegur, is just 200 m from Odinsve Hotel.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nThis is our guests' favourite part of Reykjavík, according to independent reviews. \n\nHotel Rooms: 50");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Kex Hostel','Hostel', 'Reykjavík', 1, false, false, false, 'kex', "Set just 250 m from Laugarvegur shopping street, this central Reykjavik hostel offers guest rooms and dormitory rooms with free Wi-Fi access. Harpa Concert Hall is 1 km away.\n\nA seating area and a wardrobe feature in all rooms at Kex Hostel. Some rooms have a private bathroom with shower.\n\nGuests have access to a communal kitchen on site. A buffet breakfast is available each morning, while other meals are served at the in-house Sæmundur í Sparifötunum Restaurant. Drinks can be enjoyed at the on-site Drinx Bar.\n\nLeisure options include a communal lounge and a heated outdoor terrace. Hostel Kex offers free luggage storage. Bicycles can be rented on site.\n\nWhale watching trips depart from Reykjavik Harbour, a 20-minute walk from the hostel.\n\nThis is our guests' favourite part of Reykjavík, according to independent reviews. \n\nHostel: 42 rooms");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Hotel Berg','Hotel', 'Keflavík', 2, true, true, false, 'berg', "This family-run hotel is next to central Keflavik’s picturesque marina, 3.5 km from Keflavik Airport. It offers free Wi-Fi, free airport transfer and breakfast from 04:00. On-site car rental is available and there is free on-site parking.\n\nAll rooms at Hotel Berg have a flat-screen TV and private bathroom with shower. The individually designed rooms offer views of the marina or the surrounding hills.\n\nFree 24-hour tea/coffee are offered on site. Staff can recommend restaurants, cafés and bars in Keflavik’s centre, just steps away.\n\nThe Blue Lagoon is 20 minutes' drive from the hotel as well as the Bridge Between Two Continents where the ends of 2 tectonic plates are bridged. Holmsvollur Golf Course is 3 km away.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nHotel Rooms: 17");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Start Hostel','Hostel', 'Keflavík', 2, true, true, true, 'start', "This hostel is a 10-minute drive from Keflavík International Airport. It offers breakfast from 04:30 and free Wi-Fi. Facilities include a shared kitchen, TV lounge and terrace.\n\nStart Hostel’s rooms offer simple, modern décor and blackout blinds. Guests can choose between rooms with a private bathroom or dormitory facilities. A communal laundry room is also available.\n\nRestaurants and a gym are within 5 minutes’ walk, while a children’s playground is found on site.\n\nThe Blue Lagoon geothermal spa is 20 km from Start Hostel Keflavík Airport. The Viking World museum is a 10-minute drive away.\n\nHostel: 21 rooms");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Apotek Guesthouse', 'Guesthouse', 'Akureyri', 3, false, false, true, 'apotekakureyri', "Renovated in 2015, this guest house is located in central Akureyri, a 2-minute walk from Hof - Cultural Center and Conference Hall. All rooms and apartments have free WiFi access.\n\nAccommodation options at Apotek Guesthouse Akureyri have either shared or private bathrooms. Apartments include a flat-screen TV, seating area and a well-equipped kitchen.\n\nThe on-site kitchen is located on the 4th floor of the property and all guests rooms have access. Amenities include a microwave, a toaster, a dishwasher, a fridge and a seating area. Guests can also relax on the sun terrace.\n\nAkureyri Airport is a 5-minute drive from Apotek Guesthouse.\n\nThis is our guests' favourite part of Akureyri, according to independent reviews.  \n\nHotel Rooms: 19");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Fosshótel Húsavík', 'Hotel', 'Húsavík', 3, true, true, false, 'fosshotelhusavik', "Situated in the heart of Husavik town centre, the whale-themed Fosshotel Husavik offers free parking and guest rooms with satellite TV. The whale watching boats depart from Husavik Harbour, 1 km away.\n\nAll guest rooms at Fosshotel Husavik feature a seating area and a private bathroom with shower. Some rooms include marine and whaled-themed décor.\n\nDrinks can be enjoyed at Moby Dick Pub, which features sculptured whale stools, rocking chair and tables. The hotel also has an in-house restaurant.\n\nThe hotel has a 24-hour reception for guests’ convenience. Wi-Fi access is also available. The tour desk can help with different excursions.\n\nLake Myvatn is a 45-minute drive away. The Dettifoss Water Fall is a 1-hour drive from the hotel.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nHotel Rooms: 70, Hotel Chain: Fosshotel");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Hotel Eskifjörður', 'Hotel', 'Eskifjörður', 4, false, true, true, 'eskifjordur', "Hotel Eskifjörður is located in Eskifjörður. Free WiFi access is available. Featuring a shower, private bathroom also comes with a hairdryer. You can enjoy mountain view from the room. Extras include bed linen.\n\nAt Eskifjörður Hotel you will find a 24-hour front desk and a garden. Other facilities offered at the property include a shared lounge, a tour desk and luggage storage. An array of activities can be enjoyed on site or in the surroundings, including skiing, cycling and fishing. The property offers free parking.\n\nEgilsstaðir Airport is 50 km away.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nHotel Rooms: 16");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Birta Guesthouse', 'Guesthouse', 'Egilsstaðir', 4, true, true, true, 'birta', "Birta Guesthouse features a garden and basis style rooms with shared bathrooms. Free Wi-Fi access is available. Egilsstadir Public Pool is 450 m away.\n\nAll guest rooms have wooden floors, a flat-screen TV, a fridge and coffee/tea facilities. Some rooms offer garden views. Bathroom facilities are shared.\n\nAt Guesthouse Birta you will also find a furnished terrace and a shared kitchen. Other facilities offered include a children's playground. The property offers free parking.\n\nEgilsstaðir Airport is 2 km away.\n\nWe speak your language!\n\nHotel Rooms: 6");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Fosshotel Westfjords', 'Hotel', 'Patreksfjörður', 5, false, true, false, 'fosshotelwest', "This hotel, opened in June 2013, is situated along the coast in Patreksfjordur, a fishing village in Iceland’s Westfjords. It offers an à la carte restaurant with a bar and daily breakfast buffet.\n\nMinimalist design with modern furnishings decorates each Fosshotel Westfjords room. All have a flat-screen TV, blackout curtains and bathroom with a shower. Guests can enjoy views of either the surrounding mountains or fjord.\n\nWi-Fi access is available at Westfjords Fosshotel. Staff arranges guided hiking, horseback riding and sailing tours.\n\nThe huge Latrabjarg Cliff, well-known for bird watching, is 60 km away. Raudasandur Beach is 32 km from the hotel, while Dynjandi Waterfall is 97 km away. Restaurants and shops can be found within a 10-minute walk.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nWe speak your language!\n\nHotel Rooms: 40");

INSERT INTO Hotel (name, type, city, area_id, wifi, smoking, breakfast, picture, description)
VALUES ('Guesthouse Hamrar', 'Guesthouse', 'Vestmannaeyjabær', 6, false, false, true, 'hamrar', "This family-run guest house is set on the island of Heimaey in the Westman Islands archipelago. It offers free Wi-Fi. Herjolfur Ferry Terminal is 250 m away.\n\nTea/coffee facilities and a TV are featured in each classically decorated room at Guesthouse Hamar. All have a private bathroom with a shower and hairdryer.\n\nFacilities at Hamar Guesthouse include a terrace and vending machine with soft drinks. A daily breakfast buffet is also available.\n\nVestmannaeyja Golf Club is 5 minutes’ walk away. Heimaey-bound ferries depart from Thorlakshofn, which is 53 km from Reykjavik, or from Landeyjahofn, which is 30 km from Hvolfsvollur. Several hiking paths are found on the 13 km² island.\n\nCheck-out is a leisurely 12:00, so you can relax with another cup of coffee.\n\nHotel Rooms: 14");
