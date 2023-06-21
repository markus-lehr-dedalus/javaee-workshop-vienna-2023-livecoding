insert into fruitBowl (id, availableFruits)
values (1, 5);

insert into room (id, roomType, numberOfSeats, name, fruit_bowl)
values (nextval('hibernate_sequence'), 0, 6, 'Tick', 1);

insert into room (id, roomType, numberOfSeats, name)
values (nextval('hibernate_sequence'), 0, 8, 'Trick');

insert into room (id, roomType, numberOfSeats, name)
values (nextval('hibernate_sequence'), 1, 8, 'Track');

insert into room (id, roomType, numberOfSeats, name)
values (nextval('hibernate_sequence'), 1, 12, 'Donald');