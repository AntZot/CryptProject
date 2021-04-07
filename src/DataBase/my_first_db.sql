-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `project` ;

-- -----------------------------------------------------
-- Schema project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project` DEFAULT CHARACTER SET utf8 ;
USE `project` ;

-- -----------------------------------------------------
-- Table `project`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`users` (
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`mail`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`bags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`bags` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `profit` VARCHAR(45) NOT NULL,
  `users_mail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bags_users1_idx` (`users_mail` ASC) VISIBLE,
  CONSTRAINT `fk_bags_users1`
    FOREIGN KEY (`users_mail`)
    REFERENCES `project`.`users` (`mail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`bags_content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`bags_content` (
  `ticket` VARCHAR(10) NOT NULL,
  `date_start` DATETIME NOT NULL,
  `date_finish` DATETIME NOT NULL,
  `count` INT NOT NULL,
  `bags_id` INT NOT NULL,
  `price_start` FLOAT NOT NULL,
  `price_finish` FLOAT NOT NULL,
  `ticket_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ticket`, `ticket_name`),
  INDEX `fk_bags_content_bags1_idx` (`bags_id` ASC) VISIBLE,
  CONSTRAINT `fk_bags_content_bags1`
    FOREIGN KEY (`bags_id`)
    REFERENCES `project`.`bags` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`.`candles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project`.`candles` (
  `ticket` VARCHAR(10) NOT NULL,
  `price_start` FLOAT NOT NULL,
  `price_finish` FLOAT NOT NULL,
  `price_max` FLOAT NOT NULL,
  `price_min` FLOAT NOT NULL,
  `gap` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`ticket`),
  CONSTRAINT `fk_candles_bags_content1`
    FOREIGN KEY (`ticket`)
    REFERENCES `project`.`bags_content` (`ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
