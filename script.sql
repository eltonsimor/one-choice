CREATE SCHEMA `vianuvem` ;

CREATE TABLE IF NOT EXISTS `vianuvem`.`lists` (
  `pk` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`pk`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `vianuvem`.`orders` (
  `pk` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  `price` DOUBLE NOT NULL DEFAULT 0.0,
  `name_image` VARCHAR(200) NOT NULL DEFAULT 'foto.jpg',
  `marked` CHAR(1) NOT NULL DEFAULT 'N',
  `lists_pk` INT NOT NULL,
  PRIMARY KEY (`pk`),
  INDEX `fk_orders_Lists_idx` (`lists_pk` ASC),
  CONSTRAINT `fk_orders_Lists`
    FOREIGN KEY (`lists_pk`)
    REFERENCES `vianuvem`.`lists` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

use vianuvem;

INSERT INTO lists (name) values("Lista Para Churrasco");

insert into orders (name, quantity, price, name_image, marked, lists_pk) values("Picanha", 30, 39.80, "picanha.jpg", 'N', 1);
