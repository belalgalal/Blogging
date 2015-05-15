SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bidirectional_schema` ;
CREATE SCHEMA IF NOT EXISTS `bidirectional_schema` DEFAULT CHARACTER SET utf8 ;
USE `bidirectional_schema` ;

-- -----------------------------------------------------
-- Table `bidirectional_schema`.`PARENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bidirectional_schema`.`PARENT` ;

CREATE  TABLE IF NOT EXISTS `bidirectional_schema`.`PARENT` (
  `PARENT_ID` INT NOT NULL ,
  `PARENT_CONTENT` VARCHAR(45) NULL ,
  PRIMARY KEY (`PARENT_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bidirectional_schema`.`CHILD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bidirectional_schema`.`CHILD` ;

CREATE  TABLE IF NOT EXISTS `bidirectional_schema`.`CHILD` (
  `CHILD_ID` INT NOT NULL ,
  `CHILD_CONTENT` VARCHAR(45) NULL ,
  `PARENT_PARENT_ID` INT NOT NULL ,
  PRIMARY KEY (`CHILD_ID`) ,
  INDEX `fk_CHILD_PARENT_idx` (`PARENT_PARENT_ID` ASC) ,
  CONSTRAINT `fk_CHILD_PARENT`
    FOREIGN KEY (`PARENT_PARENT_ID` )
    REFERENCES `bidirectional_schema`.`PARENT` (`PARENT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
