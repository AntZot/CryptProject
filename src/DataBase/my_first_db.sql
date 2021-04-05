CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8;
USE `mydb`;

CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusers`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`bags` (
  `idbags` INT NOT NULL AUTO_INCREMENT,
  `users_idusers` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `profit` INT NOT NULL,
  PRIMARY KEY (`idbags`),
  INDEX `fk_bags_users_idx` (`users_idusers` ASC),
  CONSTRAINT `fk_bags_users`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `mydb`.`users` (`idusers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`assets` (
  `idassets` INT NOT NULL,
  `ticket` VARCHAR(45) NULL,
  PRIMARY KEY (`idassets`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`bagcontent` (
  `idbagcontent` INT NOT NULL,
  `bags_idbags` INT NOT NULL,
  `ticket` VARCHAR(45) NULL,
  `firstData` DATE NULL,
  `lastData` DATE NULL,
  `assets_idassets` INT NOT NULL,
  PRIMARY KEY (`idbagcontent`),
  INDEX `fk_bagcontent_bags1_idx` (`bags_idbags` ASC) ,
  INDEX `fk_bagcontent_assets1_idx` (`assets_idassets` ASC) ,
  CONSTRAINT `fk_bagcontent_bags1`
    FOREIGN KEY (`bags_idbags`)
    REFERENCES `mydb`.`bags` (`idbags`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bagcontent_assets1`
    FOREIGN KEY (`assets_idassets`)
    REFERENCES `mydb`.`assets` (`idassets`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `mydb`.`candles` (
  `idcandles` INT NOT NULL AUTO_INCREMENT,
  `assets_idassets` INT NOT NULL,
  `firstTime` DATETIME NOT NULL,
  `lastTime` DATETIME NOT NULL,
  `max` VARCHAR(45) NULL,
  `min` VARCHAR(45) NULL,
  `start` VARCHAR(45) NULL,
  `finish` VARCHAR(45) NULL,
  PRIMARY KEY (`idcandles`),
  INDEX `fk_candles_assets1_idx` (`assets_idassets` ASC) ,
  CONSTRAINT `fk_candles_assets1`
    FOREIGN KEY (`assets_idassets`)
    REFERENCES `mydb`.`assets` (`idassets`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
