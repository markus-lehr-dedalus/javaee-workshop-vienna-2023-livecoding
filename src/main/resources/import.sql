insert into fruitBowl (id, availableFruits)
values (1, 5);

insert into room (id, roomType, numberOfSeats, name, city, fruit_bowl)
values (nextval('hibernate_sequence'), 0, 6, 'Tick', 'Vienna', 1);

insert into room (id, roomType, numberOfSeats, city, name)
values (nextval('hibernate_sequence'), 0, 8, 'Vienna', 'Trick');

insert into room (id, roomType, numberOfSeats, city, name)
values (nextval('hibernate_sequence'), 1, 8, 'London', 'Track');

insert into room (id, roomType, numberOfSeats, city, name)
values (nextval('hibernate_sequence'), 1, 12, 'Kirchberg am Wagram', 'Donald');