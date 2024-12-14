-- SELECT * FROM student_tracker.student;
-- Truncate student_tracker.student;


-- CREATE DATABASE productdb;
-- USE productdb;
-- CREATE TABLE products (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     price DOUBLE NOT NULL
-- );


USE `student_tracker`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
                         `username` varchar(50) NOT NULL,
                         `password` char(68) NOT NULL,
                         `enabled` tinyint NOT NULL,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users`
VALUES
    ('john','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1),
    ('mary','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1),
    ('joe','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
                               `username` varchar(50) NOT NULL,
                               `authority` varchar(50) NOT NULL,
                               UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
    ('john','ROLE_STUDENT'),
    ('mary','ROLE_STUDENT'),
    ('mary','ROLE_TEACHER'),
    ('joe','ROLE_STUDENT'),
    ('joe','ROLE_TEACHER'),
    ('joe','ROLE_PRINCIPAL');