-- DROP DATABASE IF EXISTS `usuarios`;
-- CREATE DATABASE `usuarios` IF NOT EXISTS;
USE `usuarios`;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (`username` varchar(50) NOT NULL, `authority` varchar(50) NOT NULL, UNIQUE KEY `ix_auth_username` (`username`,`authority`), CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users`
CREATE TABLE `users` (`username` varchar(50) NOT NULL, `password` varchar(50) NOT NULL, `enabled` tinyint(1) NOT NULL, PRIMARY KEY (`username`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO users (username, password, enabled) VALUES ('ana','{noop}1234',1),('eva','{noop}1234',1),('miguel','{noop}1234',1);
INSERT INTO authorities (username, authority) VALUES ('ana','ROLE_COLABORADOR'),('eva','ROLE_EDITOR'),('miguel','ROLE_ADMIN');