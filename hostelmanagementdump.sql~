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

insert  into `Payments`(`paymentId`,`actualAmount`,`paidAmount`,`actualDate`,`paidDate`,`hostlerId`,`deleted`) values (8,'3002','1456','2014-07-01','2014-07-01',1,0);

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

insert  into `RoomHostlerMapping`(`id`,`roomId`,`hostlerId`,`dateOfJoining`,`deleted`) values (14,19,1,'2013-04-01',0),(15,5,6,'2013-05-06',0),(16,17,11,'0001-02-13',0);

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

insert  into `expense`(`expenseId`,`expense`,`amount`,`date`,`deleted`) values (15,'vegtab',1000,'2014-10-12',0),(16,'veg',1000,'2014-10-12',1),(17,'yflju',222,'2014-12-04',0),(18,'veg',1000,'2014-10-12',0),(19,'nvng',87658,'2014-10-12',1);

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

insert  into `hostel`(`hostelName`,`hostelAddress`,`hostelId`,`deleted`) values ('kkk','hhh',1,0),('11','11',2,1),('aaa','aaaaa',3,0),('aaa','aaa',4,0),('sss','sss12',5,0),('www','www',6,0),('qqq','qqq',7,0);

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

insert  into `hostler`(`name`,`firstName`,`lastName`,`age`,`sex`,`qualification`,`dateOfJoining`,`mobileNumber`,`address`,`hostlerId`,`deleted`) values ('sar','aa','d',33,'ma','hh','0001-02-13','98456317','po',1,0),('satish','qq','ww',33,'male','btech','0001-02-13','1234567890','i',6,0),('ffff','f','f',22,'male','bba','0001-04-06','98765432','frrf',7,0),('karuturi','s','s',45,'male','btech','0008-09-10','474676475','gh',8,0),('raju','k','m',24,'male','bba','0001-05-06','65655654','fff',9,0),('k','g','h',12,'fem','fff','0002-04-12','12365478','hghghgh',10,0),('hh','l','L',9,'male','NN','0001-02-13','465646747','JG',11,0),('w','w','w',22,'s','s','0001-01-01','11111','111',12,0),('t','t','tt',5,'t','t','0001-01-01','61561461','t',13,0),('raju','s','a',12,'male','btech','2013-05-06','984802233','ddd',14,0),('aaa','aaaa','aaaa',22,'qqq','sss','2014-05-05','1561456','cdwc',15,0),('babu','b','b',23,'male','be','0001-02-13','363465','fn',16,0),('ffff','f','f',55,'ff','fff','0001-02-13','325','gre',17,0),('ffff','f','f',55,'ff','fff','0001-02-13','325','gre',18,0),('karuturi','f','ww',33,'male','btech','0001-02-13','123456','klj',19,0),('karuturi','f','ww',33,'male','btech','0001-02-13','123456','klj',20,0),('karuturi','hh','ww',33,'male','btech','2014-12-30','123456','klj',21,0),('karuturi','hh','ww',33,'male','btech','2014-04-30','123456','klj',22,0),('raju','','',24,'M','btech','2014-04-10','123456','',23,1),('raju','','',224,'M','gg','2013-04-01','46464','',24,1),('raju','','',224,NULL,'gg','2013-04-01','46464','fw',25,1),('raju','','',224,'M','gg','2013-04-01','46464','fw',26,1),('raju','','',224,'M','gg','2013-04-01','46464','fw',27,1),('raju','kk','ss',24,'M','bba','2013-04-01','46464','fw',28,0),('dddddddd','','',24,'M','btech','2013-04-15','46464','wfwf',29,0);

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

insert  into `room`(`roomId`,`roomNumber`,`noOfBeds`,`deleted`,`hostelId`) values (1,'222',4,1,20),(3,'77',6,1,18),(4,'77',7,1,18),(5,'33',4,1,6),(6,'333',4,0,5),(7,'33',4,1,6),(17,'44',4,1,4),(18,'77',7,0,1),(19,'55',5,0,5),(20,'220',22,0,1),(21,'666',6,0,7),(22,'123',5,0,1),(23,'4445',4,0,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
