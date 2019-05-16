--liquibase formatted sql

--changeset novak:2
INSERT INTO org_unit_type(name)
VALUES
  ('REGIJA'),
  ('ŽUPANIJA');

INSERT INTO city_type(name)
VALUES
  ('MALI'),
  ('SREDNJI'),
  ('VELIK');

INSERT INTO organisation_unit(code, name, description, active, org_unit_type_id, parent_id)
VALUES
  ('HR01', 'Sjeverozapadna',null, 1, 1, null),
  ('HR02', 'Središnja i Panonska', null, 1, 1, null),
  ('HR03', 'Jadranska', null, 1, 1, null),
  ('HR011', 'Grad Zagreb', null, 1, 2, 1),
  ('HR012', 'Zagrebačka', null, 1, 2, 1),
  ('HR013', 'Krapinsko-zagorska', null, 1, 2, 1),
  ('HR014', 'Varaždinska', null, true, 2, 1),
  ('HR015', 'Koprivničko-križevačka', null, 1, 2, 1),
  ('HR016', 'Međimurska', null, 1, 2, 1),
  ('HR021', 'Bjelovarsko-bilogorska', null, 1, 2, 2),
  ('HR022', 'Virovitičko-podravska', null, 1, 2, 2),
  ('HR023', 'Požeško-slavonska', null, 1, 2, 2),
  ('HR024', 'Osječko-baranjska', null, 1, 2, 2),
  ('HR025', 'Brodsko-posavska', null, 1, 2, 2),
  ('HR026', 'Vukovarsko-srijemska', null, 1, 2, 2),
  ('HR027', 'Karlovačka', null, 1, 2, 2),
  ('HR028', 'Sisačko-moslavačka', null, 1, 2, 2),
  ('HR031', 'Primorsko-goranska', null, 1, 2, 3),
  ('HR032', 'Ličko-senjska', null, 1, 2, 3),
  ('HR033', 'Zadarska', null, 1, 2, 3),
  ('HR034', 'Šibensko-kninska', null, 1, 2, 3),
  ('HR035', 'Splitsko-dalmatinska', null, 1, 2, 3),
  ('HR036', 'Istarska', null, 1, 2, 3),
  ('HR037', 'Dubrovačko-neretvanska', null, 1, 2, 3);

INSERT INTO city (code, name, active, city_type_id, org_unit_id)
VALUES
  ('49231', 'Hum', 1, 1, 6),
  ('48260', 'Križevci', 1, 2, 8),
  ('21000', 'Split', 1, 3, 22),
  ('10000', 'Zagreb', 1, 3, 4),
  ('42000', 'Varaždin', 1, 3, 7),
  ('20000', 'Dubrovnik', 1, 3, 24),
  ('52100', 'Pula', 1, 3, 23),
  ('47000', 'Karlovac', 1, 3, 16),
  ('40000', 'Čakovec', 1, 3, 9),
  ('10431', 'Sveta Nedjelja', 1, 2, 5),
  ('52210', 'Rovinj', 1, 2, 23),
  ('52440', 'Poreč', 1, 2, 23),
  ('51215', 'Kastav', 1, 2, 18),
  ('52470', 'Umag', 1, 2, 23),
  ('10370', 'Dugo Selo', 1, 2, 5),
  ('51500', 'Krk', 1, 1, 18),
  ('49243', 'Oroslavlje', 1, 1, 6),
  ('51222', 'Bakar', 1, 1, 18),
  ('49210', 'Zabok', 1, 1, 6),
  ('51280', 'Rab', 1, 1, 18),
  ('42223', 'Varaždniske Toplice', 1, 1, 7);

INSERT INTO user (username, password, enabled, created)
VALUES
  ('admin', '$2a$10$eG28hqAjihXGfSyrNUji9OZEGnMNh66uQUjjIBU0OaaE4Os4u1tom', 1, NOW()),
  ('student', '$2a$10$XUil1gwD8eWVxsCl4T0WmuvWr/u/eOR/colwWalMWa.4rw.BK7Unm', 1, NOW());

INSERT INTO role (name, created)
VALUES
  ('ROLE_ADMIN', NOW()),
  ('ROLE_USER', NOW());

INSERT INTO user_role (user_id, role_id)
VALUES
  (1,1),
  (1,2),
  (2,2);