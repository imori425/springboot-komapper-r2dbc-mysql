CREATE TABLE IF NOT EXISTS message (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255)
);


INSERT INTO message (text) VALUES ('Hello');
INSERT INTO message (text) VALUES ('World');
