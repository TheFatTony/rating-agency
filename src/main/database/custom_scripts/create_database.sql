CREATE USER 'agnc'@'localhost' IDENTIFIED BY 'g4sGfdTbT23';
CREATE USER 'agnc'@'%' IDENTIFIED BY 'g4sGfdTbT23';

CREATE DATABASE agnc CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON agnc.* TO 'agnc'@'localhost';
GRANT ALL PRIVILEGES ON agnc.* TO 'agnc'@'%';

CREATE USER 'agnc_user'@'localhost' IDENTIFIED BY 'tmuL4svR76d';
CREATE USER 'agnc_user'@'%' IDENTIFIED BY 'tmuL4svR76d';

GRANT DELETE ON agnc.* TO 'agnc_user'@'localhost';
GRANT DELETE ON agnc.* TO 'agnc_user'@'%';
GRANT INSERT ON agnc.* TO 'agnc_user'@'localhost';
GRANT INSERT ON agnc.* TO 'agnc_user'@'%';
GRANT SELECT ON agnc.* TO 'agnc_user'@'localhost';
GRANT SELECT ON agnc.* TO 'agnc_user'@'%';
GRANT UPDATE ON agnc.* TO 'agnc_user'@'localhost';
GRANT UPDATE ON agnc.* TO 'agnc_user'@'%';