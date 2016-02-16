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

CREATE TABLE buyer
(
    user_id INT(11) PRIMARY KEY NOT NULL,
    receive_news_letter TINYINT(1) NOT NULL,
    contact_id INT(11),
    CONSTRAINT fk_buyer_user FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT fk_contact_id FOREIGN KEY (contact_id) REFERENCES contact_info (id)
);
CREATE INDEX fk_contact_id_idx ON buyer (contact_id);
CREATE TABLE corporate_buyer
(
    buyer_id INT(11) PRIMARY KEY NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    company_type VARCHAR(45),
    CONSTRAINT fk_buyer FOREIGN KEY (buyer_id) REFERENCES buyer (user_id)
);
CREATE TABLE country
(
    id INT(11) PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    abbreviation VARCHAR(45) NOT NULL
);
CREATE TABLE individual_buyer
(
    buyer_id INT(11) PRIMARY KEY NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    CONSTRAINT fk_buyer_individual_buyer FOREIGN KEY (buyer_id) REFERENCES buyer (user_id)
);
CREATE TABLE contact_info
(
    id INT(11) PRIMARY KEY NOT NULL,
    address1 VARCHAR(100),
    address2 VARCHAR(100),
    city VARCHAR(100),
    postal_code VARCHAR(10),
    state_province VARCHAR(45),
    country_id INT(11),
    mobile VARCHAR(45),
    phone VARCHAR(45),
    fax VARCHAR(45),
    hotline VARCHAR(45),
    email VARCHAR(45),
    website_url VARCHAR(45),
    CONSTRAINT fk_contactInfo_country FOREIGN KEY (country_id) REFERENCES country (id)
);
CREATE INDEX fk_contactInfo_country_idx ON contact_info (country_id);
#Seller table
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
#Vehicle and related tables
CREATE TABLE eagle.VehicleMake
(
  id INT PRIMARY KEY,
  name VARCHAR(100),
  country_id INT,
  is_machinery TINYINT(1),
  CONSTRAINT VehicleMake___country_fk FOREIGN KEY (country_id) REFERENCES country (id)
);
CREATE TABLE eagle.vehicle_model
(
  id INT PRIMARY KEY,
  name VARCHAR(100),
  vehicle_make_id INT,
  CONSTRAINT vehicle_model___vehicle_make_id_fk FOREIGN KEY (vehicle_make_id) REFERENCES vehiclemake (id)
);
CREATE TABLE eagle.vehicle
(
  id INT PRIMARY KEY,
  seller_id INT,
  model_id INT,
  body_type VARCHAR(100),
  grade VARCHAR(100),
  transmission VARCHAR(100),
  drive_type VARCHAR(100),
  steering VARCHAR(100),
  fuel VARCHAR(100),
  manuf_year INT,
  manuf_month INT,
  registration_date DATE,
  mileage INT,
  displacement VARCHAR(100),
  price FLOAT,
  stock_no INT,
  stock_location VARCHAR(100),
  vin_chassis_no VARCHAR(100),
  is_left_drive TINYINT(1),
  doors VARCHAR(100),
  interior_color VARCHAR(50),
  exterior_color VARCHAR(50),
  `keys` VARCHAR(50),
  comments VARCHAR(2000),
  location_id INT,
  fob_price FLOAT,
  in_stock TINYINT(1),
  CONSTRAINT vehicle___seller_id_fk FOREIGN KEY (seller_id) REFERENCES seller (id),
  CONSTRAINT vehicle___model_id_fk FOREIGN KEY (model_id) REFERENCES vehicle_model (id)
);