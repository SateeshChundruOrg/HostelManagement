/*
SQLyog Trial v11.51 (32 bit)
MySQL - 5.5.35-0ubuntu0.12.04.2 : Database - HostelManagement
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`HostelManagement` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `HostelManagement`;

/*Table structure for table `Payments` */

DROP TABLE IF EXISTS `Payments`;

CREATE TABLE `Payments` (
  `paymentId` bigint(10) NOT NULL AUTO_INCREMENT,
  `actualAmount` decimal(10,0) DEFAULT NULL,
  `paidAmount` decimal(20,0) DEFAULT NULL,
  `actualDate` date DEFAULT NULL,
  `paidDate` date DEFAULT NULL,
  `hostlerId` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `Payments` */

/*Table structure for table `RoomHostlerMapping` */

DROP TABLE IF EXISTS `RoomHostlerMapping`;

CREATE TABLE `RoomHostlerMapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roomId` bigint(20) DEFAULT NULL,
  `hostlerId` bigint(20) DEFAULT NULL,
  `dateOfJoining` date DEFAULT NULL,
  `deleted` bigint(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `RoomHostlerMapping` */


/*Table structure for table `expense` */

DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
  `expenseId` bigint(10) NOT NULL AUTO_INCREMENT,
  `expense` varchar(20) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`expenseId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `expense` */


/*Table structure for table `hostel` */

DROP TABLE IF EXISTS `hostel`;

CREATE TABLE `hostel` (
  `hostelName` varchar(20) DEFAULT NULL,
  `hostelAddress` varchar(20) DEFAULT NULL,
  `hostelId` bigint(20) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(10) DEFAULT '0',
  PRIMARY KEY (`hostelId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `hostel` */


/*Table structure for table `hostler` */

DROP TABLE IF EXISTS `hostler`;

CREATE TABLE `hostler` (
  `name` varchar(20) DEFAULT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `dateOfJoining` date DEFAULT NULL,
  `mobileNumber` varchar(20) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `hostlerId` tinyint(2) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`hostlerId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `hostler` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `roomId` bigint(20) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(20) DEFAULT NULL,
  `noOfBeds` int(20) DEFAULT NULL,
  `deleted` tinyint(10) DEFAULT '0',
  `hostelId` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `room` */


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;




CREATE TABLE `OppUsers` (
  `oppId` bigint(20) NOT NULL AUTO_INCREMENT,
  `oppUserName` varchar(100) DEFAULT NULL,
  `oppPassword` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`oppId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1

