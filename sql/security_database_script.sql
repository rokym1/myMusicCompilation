DROP DATABASE  IF EXISTS `security_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `security_bcrypt`;
USE `security_bcrypt`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.bcryptcalculator.com/encode
--
-- Password for admin: admin, rokym: rokym
--

INSERT INTO `users` 
VALUES 
('admin','{bcrypt}$2a$10$25D.HAlOw7PN1F/AYCGGd.va3Y73tCEWKjX0e4zX9i8X1/wWEnCg6',1),
('rokym','{bcrypt}$2a$10$Fpzo3Vvjcsyu7jAZw71QLeDNglGxce6v1UfqpcGwTSrWF89vpLk7C',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` 
VALUES 
('admin','ROLE_ADMIN'),
('rokym','ROLE_USER');


