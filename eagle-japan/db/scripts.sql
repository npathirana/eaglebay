CREATE DATABASE IF NOT EXISTS eagle;

USE eagle;

DROP TABLE IF EXISTS role;
CREATE TABLE `role` (
  `id`     INT(11)     NOT NULL,
  `code`   VARCHAR(45) NOT NULL,
  `status` SMALLINT    NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS permission;
CREATE TABLE permission (
  `id`     INT(11)     NOT NULL,
  `code`   VARCHAR(45) NOT NULL,
  `status` SMALLINT    NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS role_permission;
CREATE TABLE role_permission (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `role_id`       INT     NOT NULL,
  `permission_id` INT     NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
);

DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  `id`             INT(11)      NOT NULL AUTO_INCREMENT,
  `email`          VARCHAR(100) NOT NULL,
  `password`       VARCHAR(100) NOT NULL,
  `last_logged_on` TIMESTAMP    NULL,
  `registered_on`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `attempts`       SMALLINT     NOT NULL DEFAULT 0,
  `user_type`      SMALLINT     NOT NULL DEFAULT 0,
  `status`         SMALLINT     NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT     NOT NULL,
  `role_id` INT     NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);

DROP TABLE IF EXISTS user_permission;
CREATE TABLE user_permission (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `user_id`       INT     NOT NULL,
  `permission_id` INT     NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
);

DROP TABLE IF EXISTS verification_medium;
CREATE TABLE `verification_medium` (
  `id`   INT(11)     NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS user_verification;
CREATE TABLE user_verification (
  `id`                     INT(11)     NOT NULL AUTO_INCREMENT,
  `user_id`                INT         NOT NULL,
  `verification_medium_id` INT         NOT NULL,
  `initiated_on`           TIMESTAMP   NULL,
  `verification_code`      VARCHAR(45) NOT NULL,
  `status`                 SMALLINT    NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  FOREIGN KEY (`verification_medium_id`) REFERENCES `verification_medium` (`id`)
);

CREATE TABLE `contact_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `state_province` varchar(45) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `hotline` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `website_url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `abbreviation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `seller` (
  `id` int(11) NOT NULL,
  `is_exporter` bit(1) DEFAULT NULL,
  `is_auction_agent` bit(1) DEFAULT NULL,
  `biz_type` varchar(100) DEFAULT NULL,
  `is_supplier` bit(1) DEFAULT NULL,
  `is_distributor` bit(1) DEFAULT NULL,
  `is_deals_car` bit(1) DEFAULT NULL,
  `is_deals_machinery` bit(1) DEFAULT NULL,
  `is_deals_spare_parts` bit(1) DEFAULT NULL,
  `biz_name` varchar(100) DEFAULT NULL,
  `biz_established_on` varchar(100) DEFAULT NULL,
  `operational_country` varchar(100) DEFAULT NULL,
  `currency_id` varchar(100) DEFAULT NULL,
  `biz_reg_certificate_path` varchar(100) DEFAULT NULL,
  `biz_police_certificate_path` varchar(100) DEFAULT NULL,
  `biz_reg_card_path` varchar(100) DEFAULT NULL,
  `letter_of_card_accepted` varchar(100) DEFAULT NULL,
  `bank_transfer_accepted` varchar(100) DEFAULT NULL,
  `about_company` varchar(100) DEFAULT NULL,
  `notify_logins` varchar(100) DEFAULT NULL,
  `biz_ContactInfo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `vehiclemake` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `is_machinery` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `VehicleMake___country_fk` (`country_id`),
  CONSTRAINT `VehicleMake___country_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
);

CREATE TABLE `vehicle_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `vehicle_make_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_model___vehicle_make_id_fk` (`vehicle_make_id`),
  CONSTRAINT `vehicle_model___vehicle_make_id_fk` FOREIGN KEY (`vehicle_make_id`) REFERENCES `vehiclemake` (`id`)
);

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  `body_type` varchar(100) DEFAULT NULL,
  `grade` varchar(100) DEFAULT NULL,
  `transmission` varchar(100) DEFAULT NULL,
  `drive_type` varchar(100) DEFAULT NULL,
  `steering` varchar(100) DEFAULT NULL,
  `fuel` varchar(100) DEFAULT NULL,
  `manuf_year` int(11) DEFAULT NULL,
  `manuf_month` int(11) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `mileage` int(11) DEFAULT NULL,
  `displacement` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `stock_no` int(11) DEFAULT NULL,
  `stock_location` varchar(100) DEFAULT NULL,
  `vin_chassis_no` varchar(100) DEFAULT NULL,
  `is_left_drive` tinyint(1) DEFAULT NULL,
  `doors` varchar(100) DEFAULT NULL,
  `interior_color` varchar(50) DEFAULT NULL,
  `exterior_color` varchar(50) DEFAULT NULL,
  `keys` varchar(50) DEFAULT NULL,
  `comments` varchar(2000) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `fob_price` float DEFAULT NULL,
  `in_stock` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle___seller_id_fk` (`seller_id`),
  KEY `vehicle___model_id_fk` (`model_id`),
  CONSTRAINT `vehicle___model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `vehicle_model` (`id`),
  CONSTRAINT `vehicle___seller_id_fk` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`)
);




INSERT INTO `role` (`id`, `code`, `status`) VALUES (1, 'role.root', 1);
INSERT INTO `role` (`id`, `code`, `status`) VALUES (2, 'role.seller', 1);
INSERT INTO `role` (`id`, `code`, `status`) VALUES (3, 'role.buyer', 1);
INSERT INTO `role` (`id`, `code`, `status`) VALUES (4, 'role.seller.employee', 1);

INSERT INTO `permission` (`id`, `code`, `status`) VALUES (1, 'USER', 1);
INSERT INTO `permission` (`id`, `code`, `status`) VALUES (2, 'USERS_ADD', 1);
INSERT INTO `permission` (`id`, `code`, `status`) VALUES (3, 'USERS_EDIT', 1);
INSERT INTO `permission` (`id`, `code`, `status`) VALUES (4, 'USERS_DELETE', 1);
INSERT INTO `permission` (`id`, `code`, `status`) VALUES (5, 'USERS_LIST', 1);
INSERT INTO `permission` (`id`, `code`, `status`) VALUES (6, 'USERS_VIEW', 1);

-- root permissions
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             1,
                                                             id
                                                           FROM `eagle`.`permission`;

INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             2,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_ADD';
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             2,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_EDIT';
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             2,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_DELETE';
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             2,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_LIST';
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             2,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_VIEW';
INSERT INTO `role_permission` (`role_id`, `permission_id`) SELECT
                                                             3,
                                                             id
                                                           FROM `eagle`.`permission`
                                                           WHERE code = 'USERS_VIEW';

INSERT INTO `eagle`.`user` (`email`, `password`, `last_logged_on`, `registered_on`, `attempts`, `user_type`, `status`)
VALUES
  ('root@eaglejapan.com', '$2a$10$gyqpsTQ7YePWhjw/WGxlHOtlF9N8lX3bypgMEnjXJwI2X8Q.C/ZP.', NULL, CURRENT_TIMESTAMP, 0, 0,
   1);

INSERT INTO `eagle`.`user_role` (`user_id`, `role_id`)
VALUES ((SELECT id
         FROM user
         WHERE email = 'root@eaglejapan.com'), 1);

INSERT INTO `user_permission` (`user_id`, `permission_id`)
  SELECT DISTINCT
    ur.user_id,
    rp.permission_id
  FROM user_role ur, role_permission rp
  WHERE ur.role_id = rp.role_id;

