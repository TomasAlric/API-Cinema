INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Tomas', 'Alric', TIMESTAMP WITHOUT TIME ZONE '1999-08-21', '91933210826', 'tomas@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Felipe', 'Appio', TIMESTAMP WITHOUT TIME ZONE '1984-03-15', '32879273960', 'felipe@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Vitória', 'Gonçalves', TIMESTAMP WITHOUT TIME ZONE '1984-12-28', '27724790809', 'vitoria@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');

INSERT INTO role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO role (authority) VALUES ('ROLE_STANDARD');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
INSERT INTO user_role (user_id, role_id) VALUES (3,1);
INSERT INTO user_role (user_id, role_id) VALUES (3,2);

-- INSERT INTO tickets (room_id, user_id, value_of_ticket, seat, discount) VALUES (1, 1, 100.0, 1, 20.0);

INSERT INTO room (room_name, seats) VALUES ('AB08', 60);
INSERT INTO room (room_name, seats) VALUES ('AB09', 60);

INSERT INTO sessions (movie,synopsis, date_session, room_id) VALUES ('Avengers', 'Loki, synopsis.', TIMESTAMP WITHOUT TIME ZONE '2022-07-13T20:50:07', 1);
INSERT INTO sessions (movie,synopsis,  date_session, room_id) VALUES ('Avatar', 'synopsis', TIMESTAMP WITHOUT TIME ZONE '2022-07-13T22:50:07', 2);


INSERT INTO tickets (value_of_ticket, seat, discount, user_id, session_id) VALUES (100.0, 1, 20.0, 1, 1);
INSERT INTO tickets (value_of_ticket, seat, discount, user_id, session_id) VALUES (100.0, 2, 0.0, 2, 2);

