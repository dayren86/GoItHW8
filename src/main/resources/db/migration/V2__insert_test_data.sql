INSERT INTO manufacturer (manufacturer_name) VALUES
('Audi'),
('Mercedes'),
('Kia'),
('Ford')
;

INSERT INTO products (products_name, price, manufacturer_id) VALUES
('TT', 20000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Audi')),
('Q7', 30000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Audi')),
('RS', 35000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Audi')),
('RIO', 10000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Kia')),
('CLC', 40000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Mercedes')),
('E-Class', 35000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Mercedes')),
('Fusion', 20000, (SELECT id FROM manufacturer WHERE manufacturer_name = 'Ford'))
;

INSERT INTO roles (roles_name) VALUES
('admin'),
('user')
;

INSERT INTO users (email, passwords, first_name, last_name, roles_id) VALUES
('admin@goit.com', 'admin', 'admin name', 'admin last name', (SELECT id FROM roles WHERE roles_name = 'admin')),
('user@goit.com', 'user', 'user name', 'user last name', (SELECT id FROM roles WHERE roles_name = 'user'))
;