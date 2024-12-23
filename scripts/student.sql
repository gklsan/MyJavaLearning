CREATE DATABASE  IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `first_name`varchar(45) DEFAULT NULL,
                           `last_name` varchar(45) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `student_tracker`.`departments` (
  `id` INT,
  `name` VARCHAR(45) NOT NULL,
  `staff_count` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

insert into departments values (1,"CIVIL", 6), (2,"MECH", 2),(3,"IT", 8),(4,"ME", 2),(5,"ECE", 5),(6,"EEE", 3)


ALTER TABLE `student_tracker`.`student`
    ADD INDEX `department_id_idx` (`department_id` ASC) VISIBLE;

ALTER TABLE `student_tracker`.`student`
    ADD CONSTRAINT `department_id`
        FOREIGN KEY (`department_id`)
            REFERENCES `student_tracker`.`departments` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
