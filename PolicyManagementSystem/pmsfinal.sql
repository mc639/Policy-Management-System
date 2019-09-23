/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.13-log : Database - pms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pms`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) NOT NULL,
  `state_id` tinyint(3) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`city_id`,`city_name`,`state_id`) values (1,'Ahmedabad',1),(2,'Surat ',1),(3,'Vadodara ',1),(4,'Rajkot ',1),(5,'Bhavnagar ',1),(7,'Mumbai',2),(8,'Pune',2),(9,'Nagpur',2),(10,'Nashik',2),(11,'Solapur',2),(12,'Akola',2),(13,'Bengaluru',3),(14,'Mysore',3),(15,'Mangalore',3),(16,'Belgaum',3),(17,'Gulbarga	',3),(18,'Hyderabad',4),(19,'Visakhapatnam',4),(20,'Vijayawada',4),(21,'Warangal',4),(22,'Guntur',4),(23,'Kanpur',5),(24,'Lucknow',5),(25,'Ghaziabad',5),(26,'agra ',5),(27,'Varanasi ',5);

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `countryid` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `countryname` varchar(50) NOT NULL,
  PRIMARY KEY (`countryid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`countryid`,`countryname`) values (1,'India'),(2,'Pakistan'),(3,'China'),(4,'USA'),(5,'UK'),(6,'Russia'),(7,'Australia'),(8,'Canada'),(9,'UAE'),(10,'Singapore'),(11,'Iran'),(12,'Iraq'),(13,'Japan'),(14,'South Africa'),(15,'Georgia');

/*Table structure for table `policy` */

DROP TABLE IF EXISTS `policy`;

CREATE TABLE `policy` (
  `policy_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `policy_name` varchar(50) NOT NULL,
  `policy_no` varchar(10) NOT NULL,
  `sum_insurance` int(8) NOT NULL,
  `surrenderpolicy_amnt_percentage` tinyint(3) NOT NULL,
  `min_age` tinyint(2) NOT NULL,
  `max_age` tinyint(2) NOT NULL,
  PRIMARY KEY (`policy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `policy` */

/*Table structure for table `policy_plan` */

DROP TABLE IF EXISTS `policy_plan`;

CREATE TABLE `policy_plan` (
  `plan_id` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `policy_id` int(5) NOT NULL,
  `tabular_rate` tinyint(3) NOT NULL,
  `rebet_2_to_5_lac` tinyint(2) NOT NULL,
  `rebet_above_5_lac` tinyint(2) NOT NULL,
  `premium_mode_six_month` tinyint(2) NOT NULL,
  `premium_mode_one_year` tinyint(2) NOT NULL,
  `no_of_years` tinyint(2) NOT NULL,
  `plan_name` varchar(100) NOT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `policy_plan` */

/*Table structure for table `premium` */

DROP TABLE IF EXISTS `premium`;

CREATE TABLE `premium` (
  `premium_id` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `user_policy_id` tinyint(2) NOT NULL,
  `payment_date` date NOT NULL,
  `amount` int(8) NOT NULL,
  `cheque_number` varchar(14) DEFAULT NULL,
  `payment_mode` tinyint(1) NOT NULL,
  PRIMARY KEY (`premium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `premium` */

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `state_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `statename` varchar(50) NOT NULL,
  `countryid` tinyint(3) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `state` */

insert  into `state`(`state_id`,`statename`,`countryid`) values (1,'Gujarat',1),(2,'Maharashtra',1),(3,'Karnataka',1),(4,'Andhra Pradesh.',1),(5,'Uttar Pradesh ',1),(6,'Balochistan',2),(7,'Punjab',2),(8,'Sindh',2),(9,'Islamabad ',2),(10,'Lahore',2);

/*Table structure for table `tax` */

DROP TABLE IF EXISTS `tax`;

CREATE TABLE `tax` (
  `tax_id` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `tax_name` varchar(50) NOT NULL,
  `tax_percentage` tinyint(2) NOT NULL,
  PRIMARY KEY (`tax_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tax` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city_id` tinyint(3) NOT NULL,
  `phone_no` varchar(12) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `marital_status` tinyint(1) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `login_id` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `anivarsary_date` date NOT NULL,
  `id_proof` varchar(100) DEFAULT NULL,
  `address_proof` varchar(100) DEFAULT NULL,
  `office_address` varchar(255) DEFAULT NULL,
  `user_type` tinyint(1) NOT NULL,
  `premium_pay_mode` tinyint(1) NOT NULL,
  `reg_date` date NOT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `account_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`first_name`,`middle_name`,`last_name`,`address`,`city_id`,`phone_no`,`email_id`,`dob`,`photo`,`marital_status`,`sex`,`login_id`,`password`,`anivarsary_date`,`id_proof`,`address_proof`,`office_address`,`user_type`,`premium_pay_mode`,`reg_date`,`bank_name`,`account_number`) values (1,'Mohammed','H','Contractor','Khanpur',1,'99999','mohammedcontractor786@gmail.com','1997-04-17','',1,1,'mammu','mammu','2015-12-03',NULL,NULL,NULL,1,1,'2017-03-01',NULL,NULL);

/*Table structure for table `user_policy` */

DROP TABLE IF EXISTS `user_policy`;

CREATE TABLE `user_policy` (
  `user_policy_id` tinyint(2) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `plan_id` tinyint(2) NOT NULL,
  `policy_purchase_date` date NOT NULL,
  `policy_amnt` int(10) NOT NULL,
  `nominee_name` varchar(100) NOT NULL,
  `nominee_relation_type` varchar(30) NOT NULL,
  `premium_type` tinyint(1) NOT NULL,
  `policy_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_policy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_policy` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
