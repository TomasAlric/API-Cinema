INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Tomas', 'Alric', '1999-08-21', '91933210826', 'tomas@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Felipe', 'Appio', '1984-03-15', '32879273960', 'felipe@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Vitória', 'Gonçalves', '1984-12-28', '27724790809', 'vitoria@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');

INSERT INTO role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO role (authority) VALUES ('ROLE_STANDARD');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
INSERT INTO user_role (user_id, role_id) VALUES (3,1);
INSERT INTO user_role (user_id, role_id) VALUES (3,2);

INSERT INTO room (room_name, seats) VALUES ('AB08', 60);
INSERT INTO room (room_name, seats) VALUES ('AB09', 60);
INSERT INTO room (room_name, seats) VALUES ('AB10', 60);

INSERT INTO sessions (movie,synopsis, date_session, room_id) VALUES ('Avengers', 'Loki, the brother of Thor, gains access to the cosmic cube''s unlimited power by stealing it from within S.H.I.E.L.D. Nick Fury, the director of this international peacekeeping agency, soon gathers the only superheroes who will be able to defend Earth from unprecedented threats. Iron Man, Captain America, Hulk, Thor, Black Widow and Hawkeye form Fury''s dream team, but they must learn to put their egos aside and act as a group for the benefit of humanity.', TIMESTAMP WITHOUT TIME ZONE '2022-07-13T20:50:07', 1);
INSERT INTO sessions (movie,synopsis,  date_session, room_id) VALUES ('Avatar', 'On the lush alien world of Pandora live the Na''vi, beings that appear to be primitive but are highly evolved. As the planet''s environment is toxic, avatars were created, biological bodies controlled by the human mind that move freely on Pandora. Jake Sully, a paralyzed ex-Marine, walks back through an avatar and falls in love with a Na''vi. This passion drives Jake to fight for Pandora''s survival.', TIMESTAMP WITHOUT TIME ZONE '2022-07-13T22:50:07', 2);
INSERT INTO sessions (movie,synopsis,  date_session, room_id) VALUES ('Spider-man: No way home', 'For the first time in the cinematic history of Spider-Man, our friendly neighborhood hero''s identity is revealed, bringing his Super Hero responsibilities into conflict with his normal life and putting those he cares about most at risk. When he enlists Doctor Strange’s help to restore his secret, the spell tears a hole in their world, releasing the most powerful villains who’ve ever fought a Spider-Man in any universe. Now, Peter will have to overcome his greatest challenge yet, which will not only forever alter his own future but the future of the Multiverse.', TIMESTAMP WITHOUT TIME ZONE '2022-07-13T22:50:07', 3);


INSERT INTO tickets (value_of_ticket, seat, discount, user_id, session_id) VALUES (100.0, 1, 20.0, 1, 1);
INSERT INTO tickets (value_of_ticket, seat, discount, user_id, session_id) VALUES (100.0, 2, 0.0, 2, 2);

