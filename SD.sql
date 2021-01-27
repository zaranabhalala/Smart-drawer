/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt : Database - smart_drawer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smart_drawer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smart_drawer`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(25) NOT NULL default '',
  `password` varchar(15) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`username`,`password`) values ('askdhyan@gmail.com','goOd2168'),('ritu.fichadiya','2012'),('zaranap21@gmail.com','123456');

/*Table structure for table `drawer` */

DROP TABLE IF EXISTS `drawer`;

CREATE TABLE `drawer` (
  `Drawerid` int(10) NOT NULL,
  `Drawername` varchar(10) default NULL,
  PRIMARY KEY  (`Drawerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `drawer` */

insert  into `drawer`(`Drawerid`,`Drawername`) values (1,'Room101A'),(2,'Room101B');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `Item_ID` int(12) NOT NULL auto_increment,
  `Item_Name` varchar(15) NOT NULL,
  `Item_Description` varchar(50) default NULL,
  `Batch_No` varchar(10) default '',
  `Time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`Item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`Item_ID`,`Item_Name`,`Item_Description`,`Batch_No`,`Time`) values (1,'IPhone7','A products of apple.','App107','2017-06-19 14:24:26'),(2,'Mi note 3','A product of xiomi','i101','2017-06-19 14:25:14'),(3,'Lenovo k5 note','a good product of lenovo','s741','2017-06-19 14:25:48'),(4,'One plus 3','a good camera phone','p78','2017-06-19 14:26:17');

/*Table structure for table `map_tag_item` */

DROP TABLE IF EXISTS `map_tag_item`;

CREATE TABLE `map_tag_item` (
  `Tag_Serial_No` varchar(16) NOT NULL default '',
  `Item_ID` int(12) NOT NULL,
  `Drawerid` int(11) NOT NULL default '0',
  `Time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`Tag_Serial_No`,`Item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `map_tag_item` */

insert  into `map_tag_item`(`Tag_Serial_No`,`Item_ID`,`Drawerid`,`Time`) values ('1800894F9B45',1,0,'2017-06-19 16:43:47'),('1800896DB34F',2,0,'2017-06-19 16:43:51'),('3B002AD923EB',3,1,'2017-06-19 15:53:46'),('3C001733CCD4',4,0,'2017-06-19 15:53:48');

/*Table structure for table `map_tag_person` */

DROP TABLE IF EXISTS `map_tag_person`;

CREATE TABLE `map_tag_person` (
  `Tag_Serial_No` varchar(16) NOT NULL,
  `Addhar_ID` decimal(12,0) NOT NULL,
  `TimeStamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`Tag_Serial_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `map_tag_person` */

insert  into `map_tag_person`(`Tag_Serial_No`,`Addhar_ID`,`TimeStamp`) values ('1800895A5E95',1234567890,'2017-06-19 14:36:11'),('3B00294D530C',1234567891,'2017-06-19 14:36:16');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `First_Name` varchar(10) NOT NULL,
  `Last_Name` varchar(10) NOT NULL,
  `Contact_No` decimal(10,0) default NULL,
  `Address` varchar(50) default '',
  `Addhar_ID` decimal(12,0) NOT NULL,
  PRIMARY KEY  (`Addhar_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`First_Name`,`Last_Name`,`Contact_No`,`Address`,`Addhar_ID`) values ('Dhyan','Patel',8460559527,'Maninagar',1234567890),('Zarna','Pansuriya',8184618766,'Rajkot                                           ',1234567891);

/*Table structure for table `tag_bank` */

DROP TABLE IF EXISTS `tag_bank`;

CREATE TABLE `tag_bank` (
  `tagid` varchar(20) NOT NULL,
  PRIMARY KEY  (`tagid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag_bank` */

insert  into `tag_bank`(`tagid`) values ('1800894F9B45'),('1800895A5E95'),('1800896DB34F'),('3B00294D530C'),('3B002AD923EB'),('3C001733CCD4');

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `Transaction_ID` int(10) NOT NULL auto_increment,
  `Tag_Serial_No` varchar(26) NOT NULL,
  `Drawerid` int(11) NOT NULL,
  `TimeStamp` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `Addhar_ID` decimal(12,0) default '1234567890',
  PRIMARY KEY  (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transaction` */

insert  into `transaction`(`Transaction_ID`,`Tag_Serial_No`,`Drawerid`,`TimeStamp`,`Addhar_ID`) values (1,'3B002AD923EB',1,'2017-06-19 16:46:40',1234567890),(2,'3B002AD923EB',1,'2017-06-19 16:46:43',1234567890),(3,'3B002AD923EB',1,'2017-06-19 16:46:50',1234567890),(4,'3C001733CCD4',1,'2017-06-19 16:47:01',1234567890),(5,'3C001733CCD4',1,'2017-06-19 16:47:02',1234567890),(6,'1800894F9B45',1,'2017-06-19 16:47:13',1234567890),(7,'1800894F9B45',1,'2017-06-19 16:47:15',1234567890),(8,'1800896DB34F',1,'2017-06-19 16:52:12',1234567890),(9,'1800896DB34F',1,'2017-06-19 16:52:14',1234567890);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
