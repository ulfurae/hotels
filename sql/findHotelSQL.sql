Select h.id, h.name, h.city, l.name area, l.airport, h.description
From Hotel h, Location l
Where h.location_id = l.id
and l.id = 3
