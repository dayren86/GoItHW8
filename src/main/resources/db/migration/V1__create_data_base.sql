CREATE TABLE manufacturer (
	id UUID DEFAULT gen_random_uuid (),
	manufacturer_name VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE products (
	id UUID DEFAULT gen_random_uuid (),
	products_name VARCHAR(100) NOT NULL UNIQUE,
	price DECIMAL,
	manufacturer_id UUID,
	PRIMARY KEY (id),
	CONSTRAINT fk_manufacturer FOREIGN KEY(manufacturer_id) REFERENCES manufacturer(id)
);

CREATE TABLE roles (
	id UUID DEFAULT gen_random_uuid (),
	roles_name VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE users (
	id UUID DEFAULT gen_random_uuid (),
	email VARCHAR(100) NOT NULL UNIQUE,
	passwords VARCHAR(100),
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	roles_id UUID,
	PRIMARY KEY (id),
	CONSTRAINT fk_users FOREIGN KEY(roles_id) REFERENCES roles(id)
);

