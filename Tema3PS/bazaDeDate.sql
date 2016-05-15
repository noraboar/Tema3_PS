-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Schema teatru
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema teatru
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teatru` DEFAULT CHARACTER SET utf8 ;

USE `teatru` ;
-- -----------------------------------------------------
-- Table `teatru`.`spectacol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teatru`.`spectacol` (
  `regia` VARCHAR(45) NOT NULL,
  `datapremierei` INT(11) NOT NULL,
  `numarBilete` INT(11) NOT NULL,
  `titlul` VARCHAR(45) NOT NULL,
  `distributia` VARCHAR(45) NOT NULL, 
  PRIMARY KEY (`titlul`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teatru`.`bilet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teatru`.`bilet` (
  `id` INT(11) NOT NULL,
  `titlul` VARCHAR(45) NOT NULL,
  `rand` INT(11) NOT NULL,
  `numar` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `titlu`
    FOREIGN KEY (`titlul`)
    REFERENCES `teatru`.`spectacol` (`titlul`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teatru`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teatru`.`user` (
  `Name` VARCHAR(50) NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
