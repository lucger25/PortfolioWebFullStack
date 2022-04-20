SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfoliodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfoliodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfoliodb` DEFAULT CHARACTER SET utf8 ;
USE `portfoliodb` ;

-- -----------------------------------------------------
-- Table `portfoliodb`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`persona` (
  `persona_id` MEDIUMTEXT NOT NULL,
  `persona_user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `persona_photo` VARCHAR(150) NULL,
  `banner_photo` VARCHAR(150) NULL,
  `birthdate` DATE NULL,
  `phonenumber` VARCHAR(12) NULL,
  `mail` VARCHAR(45) NULL,
  `about_me` VARCHAR(200) NULL,
  PRIMARY KEY (`persona_id`, `persona_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`job_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`job_type` (
  `id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`job_experience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`job_experience` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `company_name` VARCHAR(45) NULL,
  `job_title` VARCHAR(45) NULL,
  `job_start_date` DATE NULL,
  `job_end_date` DATE NULL,
  `job_description` VARCHAR(150) NULL,
  `job_photo` VARCHAR(200) NULL,
  `is_current_job` TINYINT NULL,
  `persona_id` INT NOT NULL,
  `persona_user` VARCHAR(45) NOT NULL,
  `job_type_id` INT NOT NULL,
  PRIMARY KEY (`id`, `persona_id`, `persona_user`, `job_type_id`),
  CONSTRAINT `fk_job_experience_persona`
    FOREIGN KEY (`persona_id` , `persona_user`)
    REFERENCES `portfoliodb`.`persona` (`persona_id` , `persona_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_job_experience_job_type1`
    FOREIGN KEY (`job_type_id`)
    REFERENCES `portfoliodb`.`job_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`education` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `education_title` VARCHAR(100) NULL,
  `school_name` VARCHAR(100) NULL,
  `education_start_date` DATE NULL,
  `education_end_date` DATE NULL,
  `school_photo` VARCHAR(200) NULL,
  `persona_id` INT NOT NULL,
  `persona_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `persona_id`, `persona_user`),
  CONSTRAINT `fk_education_persona1`
    FOREIGN KEY (`persona_id` , `persona_user`)
    REFERENCES `portfoliodb`.`persona` (`persona_id` , `persona_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`skill` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `skill_title` VARCHAR(45) NULL,
  `skill_tipe` VARCHAR(45) NULL,
  `skill_level` VARCHAR(45) NULL,
  `skill_description` VARCHAR(150) NULL,
  `persona_id` INT NOT NULL,
  `persona_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `persona_id`, `persona_user`),
  CONSTRAINT `fk_skill_persona1`
    FOREIGN KEY (`persona_id` , `persona_user`)
    REFERENCES `portfoliodb`.`persona` (`persona_id` , `persona_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`proyect`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`proyect` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `proyect_title` VARCHAR(45) NULL,
  `proyect_description` VARCHAR(200) NULL,
  `proyect_start_date` DATE NULL,
  `proyect_end_date` DATE NULL,
  `proyect_photo` VARCHAR(200) NULL,
  `persona_id` INT NOT NULL,
  `persona_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `persona_id`, `persona_user`),
  CONSTRAINT `fk_proyect_persona1`
    FOREIGN KEY (`persona_id` , `persona_user`)
    REFERENCES `portfoliodb`.`persona` (`persona_id` , `persona_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfoliodb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfoliodb`.`users` (
  `user_id` MEDIUMTEXT NOT NULL,
  `user` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `persona_persona_id` MEDIUMTEXT NOT NULL,
  `persona_persona_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`, `persona_persona_id`, `persona_persona_user`),
  CONSTRAINT `fk_users_persona1`
    FOREIGN KEY (`persona_persona_id` , `persona_persona_user`)
    REFERENCES `portfoliodb`.`persona` (`persona_id` , `persona_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
