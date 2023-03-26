/*Hotels*/
INSERT INTO hotels (name, category) VALUES ('hotel2',1);
INSERT INTO hotels (name, category) VALUES ('hotel1',9);
INSERT INTO hotels (name, category) VALUES ('hotel3',2);
/*Availabilities*/
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-10', 2, 0);
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-11', 2, 0);
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-12', 1, 4);
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-13', 1, 5);
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-14', 1, 0);
INSERT INTO availabilities(date, id_hotel, rooms) VALUES ('2000-10-15', 2, 10);
/*>Bookings*/
INSERT INTO Bookings(id_hotel, date_from, date_to, email) VALUES ('1','2000-10-10', '2000-10-15', 'carlosveralopez@gmail.com');
INSERT INTO Bookings(id_hotel, date_from, date_to, email) VALUES ('2','2000-10-14', '2000-10-15', 'johntitor@gmail.com');
INSERT INTO Bookings(id_hotel, date_from, date_to, email) VALUES ('3','2000-10-10', '2000-10-12', 'tylerdurden@gmail.com');
INSERT INTO Bookings(id_hotel, date_from, date_to, email) VALUES ('1','2000-10-13', '2000-10-14', 'michaelcorleone@gmail.com');


/*Query para abrir disponibilidad, aumentando el numero de habitaciones en caso de que
ya exista el registro */

INSERT INTO availabilities as a(date, id_hotel, rooms)
VALUES ('2000-10-29', 2, 0)
ON CONFLICT (date, id_hotel)
DO UPDATE SET rooms = a.rooms + 5;

