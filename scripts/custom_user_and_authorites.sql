USE `student_tracker`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
                           `user_id` varchar(50) NOT NULL,
                           `pw` char(68) NOT NULL,
                           `active` tinyint NOT NULL,
                           PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `members`
VALUES
    ('john','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1),
    ('mary','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1),
    ('joe','{bcrypt}$2a$12$GbfFqMb0/l49HsYMD8ejJOplhoLCTdJuZtFuwRRl3Ya7c0JC53.CK',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
                         `user_id` varchar(50) NOT NULL,
                         `role` varchar(50) NOT NULL,
                         UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
                         CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
    ('john','ROLE_STUDENT'),
    ('mary','ROLE_STUDENT'),
    ('mary','ROLE_TEACHER'),
    ('joe','ROLE_STUDENT'),
    ('joe','ROLE_TEACHER'),
    ('joe','ROLE_PRINCIPAL');
