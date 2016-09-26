INSERT INTO user (email, password_hash, role, username)
VALUES ('admin@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN', 'admin');

INSERT INTO user (email, password_hash, role, username)
VALUES ('nhanvo@localhost', '$2a$10$pgzKwJaj8bG.hyOqv4jmK.2dpBPZLDVLrCkSsveCd214sps0sMFO2', 'ADMIN', 'nhanvo');


INSERT INTO product (name, image, description, createdat, updateat)
VALUES ('flower1', 'flower1.png', 'This is a flower for love.', '2005-05-10', '2005-06-12');

INSERT INTO product (name, image, description, createdat, updateat)
VALUES ('flower2', 'flower2.png', 'This is flower for parent.', '2006-04-10', '2008-07-8');

INSERT INTO product (name, image, description, createdat, updateat)
VALUES ('flower3', 'flower3.png', 'This is flower for kid.', '2011-08-14', '2014-05-17');

