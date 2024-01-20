DROP TABLE IF EXISTS bug_scripts CASCADE;
DROP TABLE IF EXISTS users CASCADE;


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(15) NOT NULL UNIQUE,
    firstname VARCHAR(15) NOT NULL,
    lastname VARCHAR(15) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    counter INT,
    activated BOOLEAN
);

CREATE TABLE bug (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
	bug_name VARCHAR(255) NOT NULL,
    script TEXT,
    sprite_image_path VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
    ON DELETE CASCADE
);

INSERT INTO users (username, firstname, lastname, password_hash, email, counter, activated)
VALUES
('TestLaura', 'Laura', 'Stevenson', '12345', 'laura@mail.com', 0, false),
('TestAshley', 'Ashley', 'Mical', '45678', 'ashley@mail.com', 0, false);
