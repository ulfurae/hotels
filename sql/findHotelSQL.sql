Select Hotel.name, Hotel.type, Hotel.city, Location.airport
From Hotel, Location
Where Hotel.location_id = Location.id
and Hotel.type = 'Hotel'