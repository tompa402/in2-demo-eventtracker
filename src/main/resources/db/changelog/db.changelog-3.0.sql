--liquibase formatted sql

--changeset novak:3
INSERT INTO event (name, start, end, free_entry, city_id, created, created_by)
VALUES
  ('Prvi event', NOW()+1, NOW()+2, 'DA', 1, NOW(), 'admin'),
  ('Drugi event', NOW()+2, NOW()+2, 'DA', 2, NOW(), 'admin'),
  ('Treći event', NOW()+5, NOW()+5, 'NE', 3, NOW(), 'admin'),
  ('Četvrti event', NOW()+1, NOW()+2, 'DA', 4, NOW(), 'admin'),
  ('Peti event', NOW()+1, NOW()+1, 'NE', 5, NOW(), 'admin'),
  ('Šesti event', NOW()+5, NOW()+5, 'NE', 6, NOW(), 'admin'),
  ('Sedmi event', NOW()+2, NOW()+2, 'DA', 7, NOW(), 'admin'),
  ('Osmi event', NOW()+3, NOW()+4, 'DA', 8, NOW(), 'admin'),
  ('Deveti event', NOW()+1, NOW()+1, 'NE', 9, NOW(), 'admin'),
  ('Deseti event', NOW()+4, NOW()+4, 'NE', 10, NOW(), 'admin'),
  ('Prvi event opet', NOW()+1, NOW()+2, 'DA', 1, NOW(), 'admin'),
  ('Drugi event opet', NOW()+2, NOW()+2, 'DA', 2, NOW(), 'admin'),
  ('Treći event opet', NOW()+5, NOW()+5, 'NE', 3, NOW(), 'admin'),
  ('Četvrti event opet', NOW()+1, NOW()+2, 'DA', 4, NOW(), 'admin'),
  ('Peti event opetv', NOW()+1, NOW()+1, 'NE', 5, NOW(), 'admin'),
  ('Šesti event opet', NOW()+5, NOW()+5, 'NE', 6, NOW(), 'admin'),
  ('Sedmi event opet', NOW()+2, NOW()+2, 'DA', 7, NOW(), 'admin'),
  ('Osmi event opet', NOW()+3, NOW()+4, 'DA', 8, NOW(), 'admin'),
  ('Deveti event opet', NOW()+1, NOW()+1, 'NE', 9, NOW(), 'admin'),
  ('Deseti event opet', NOW()+4, NOW()+4, 'NE', 10, NOW(), 'admin');