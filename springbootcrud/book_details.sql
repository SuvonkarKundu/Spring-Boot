/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 10.1.21-MariaDB : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `book`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(100) DEFAULT NULL,
  `author_email` varchar(100) DEFAULT NULL,
  `author_address` varchar(100) DEFAULT NULL,
  `author_phone` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`id`,`author_name`,`author_email`,`author_address`,`author_phone`) values 
(1,'tytyttuutu','yyyy@gmail.com','ttytttiooiioioiyiy','01809123123');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `pub_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book` (`author_id`),
  CONSTRAINT `book` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`language`,`publisher`,`pub_date`,`author_id`) values 
(2,'Love','English','Dream Publisher','2019-02-23 21:52:49',1),
(3,'Dream','English','Dream Publisher','2019-02-23 21:57:26',1),
(4,'Fighter','English','Dream Publisher','2019-02-23 21:57:58',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
