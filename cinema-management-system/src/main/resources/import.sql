INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Tomas', 'Alric', TIMESTAMP WITHOUT TIME ZONE '1999-08-21', '91933210826', 'tomas@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Felipe', 'Appio', TIMESTAMP WITHOUT TIME ZONE '1984-03-15', '32879273960', 'felipe@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, birth_date, cpf, email, password) VALUES ('Vitória', 'Gonçalves', TIMESTAMP WITHOUT TIME ZONE '1984-12-28', '27724790809', 'vitoria@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');

INSERT INTO role (authority) VALUES ('ROLE_STANDARD');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
INSERT INTO user_role (user_id, role_id) VALUES (3,1);
INSERT INTO user_role (user_id, role_id) VALUES (3,2);

