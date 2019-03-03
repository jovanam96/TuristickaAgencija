/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.28-MariaDB : Database - turisticka_agencija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`turisticka_agencija` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `turisticka_agencija`;

/*Table structure for table `drzava` */

DROP TABLE IF EXISTS `drzava`;

CREATE TABLE `drzava` (
  `drzavaid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`drzavaid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `drzava` */

insert  into `drzava`(`drzavaid`,`naziv`) values 
(1,'Velika Britanija'),
(2,'Francuska'),
(3,'Italija'),
(4,'Spanija'),
(5,'Grcka'),
(6,'Nemacka'),
(7,'Austrija');

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `gradid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `drzavaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gradid`),
  KEY `drzavaid` (`drzavaid`),
  CONSTRAINT `grad_ibfk_1` FOREIGN KEY (`drzavaid`) REFERENCES `drzava` (`drzavaid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `grad` */

insert  into `grad`(`gradid`,`naziv`,`drzavaid`) values 
(1,'London',1),
(2,'Pariz',2),
(3,'Nica',2),
(4,'Rim',3),
(5,'Milano',3),
(6,'Venecija',3),
(7,'Barselona',4),
(8,'Valensija',4),
(9,'Madrid',4),
(10,'Berlin',6),
(11,'Atina',5),
(12,'Bec',7);

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotelid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresa` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefon` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gradid` int(11) DEFAULT NULL,
  PRIMARY KEY (`hotelid`),
  KEY `gradid` (`gradid`),
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`gradid`) REFERENCES `grad` (`gradid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `hotel` */

insert  into `hotel`(`hotelid`,`naziv`,`adresa`,`telefon`,`email`,`gradid`) values 
(1,'Hotel 1','Pariska','065234165','hotelpariz@gmail.com',2),
(2,'La Villa des Ternes','97 Avenue des Ternes ','+3356314655','laviladesternes@gmail.com',2),
(3,'Les Jardins De La Villa','5 Rue Belidor','+33461532','lesjardinas@gmail.com',2),
(4,'Acacias Etoile','11 rue des Acacias','+336532656','acaciasetoile@gmail.com',2),
(5,'Catalonia Atenas','Sant Marti','+34563255','cataloniaatenas@gmail.com',7),
(6,'Cram','Eixample','+34486513','cram@gmail.com',7),
(7,'Royal Passeig de Gracia','Eixample','+346453223','royalpasseigdegracia@gmail.com',7),
(8,'Hotel Via Castellana','Chamartin','+34641312','hotelviacastellana@gmail.com',9),
(9,'Vertice Roomspace','Villaverde','+348543266','verticeroomspace@gmail.com',9),
(10,'Gran Versalles','Chamberi','+3496846533','granversalles@gmail.com',9),
(11,'Ilunion Valencia 3','Benicalap','+3463513','ilunionvalencia@gmail.com',8),
(12,'Eurostars Rey Don Jaime','Camins al Grau','+3486536958','reydonjaime@gmail.com',8),
(13,'Aparthotel VEGA','Charlottenburg-Wilmersdoft','+4953231','vega@gmail.com',10),
(14,'Park Inn','Mitte','+49468463','parkinn@gmail.com',10),
(15,'Leonardo Hotel Vienna','06.Mariahilf','+434613285','leonardohotel@gmail.com',12),
(16,'Austia Trend Hotel','04.Wieden','+438613996','austriatrendhotel@gmail.com',12),
(17,'Hotel London Kensington','Kensington and Chelsea','+4458446513','kensington@gmail.com',1),
(18,'Park Plaza','Lambeth','+4458446513','parkplaza@gmail.com',1),
(19,'The Mad Hatter Hotel','Southwark','+446513589','themadhatterhotel@gmail.com',1),
(20,'Central Park Hotel','Westminster Borough','+4494653963','centralparkhotel@gmail.com',1),
(21,'Fifty House','P. Vittoria','+3978541258','fiftyhohouse@gmail.com',5),
(22,'Ibis Milano Centro','Central Station','+39895656874','ibismilano@gmail.com',5),
(23,'Hotel Sole Roma','Navona','+397486322','soleroma@gmail.com',4),
(24,'Hotel Cristoforo Colombo','Eur & Garbatella','+39468465389','hotelcristoforocolombo@gmail.com',4),
(25,'Hotel Metropole','Castello','+39684135','metropole@gmail.com',6),
(26,'Antico Panada','San Marco','+39496322','anticopanada@gmail.com',6),
(27,'Athens Luxuy Suits','Syntagma','+304635526','athensluxurysuites@gmail.com',11),
(28,'The Stanley','Metaxourgeio','+30489465329','thestanley@gmail.com',11),
(29,'Radisson Blu Hotel Nice','Fabron','+33484615','radissonblu@gmail.com',3),
(30,'Appart Hotel Villa Leonie','Nice Port','+33468536','villaleonie@gmail.com',3),
(31,'Hotel hotel','Berlinska','+4974856263','hotelhotel@gmail.com',10),
(32,'Grand Hotel','Berlinska 56','+3924863856','grandhotel@gmail.cm',10);

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `klijentid` int(11) NOT NULL AUTO_INCREMENT,
  `jmbg` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brojpasosa` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`klijentid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`klijentid`,`jmbg`,`ime`,`prezime`,`email`,`telefon`,`brojpasosa`) values 
(1,'2707996979656','Jovana','Mitrovic','jovana_996@yahoo.com','0601558424','332211'),
(2,'230799496893','Andjelka','Mitrovic','andjelka94@yahoo.com','0604545998','85236'),
(3,'1234567899876','Marko','Markovic','markomarkovic@gmail.com','063125483','121212'),
(4,'1234567898533','Pera','Peric','peraperic@gmail.com','0654965963','563856'),
(5,'1408656329555','Nikola','Nikolic','nikolan@gmail.com','06512496325','1235963'),
(6,'24011996715118','Ana','Dzudovic','anadzudovic1@gmail.com','0694559828','85858585'),
(7,'2704996715137','Mila','Zarkovic','milazarkovic@hotmail.com','0643634865','009936889'),
(8,'2608473951563','Zika','Zikic','zikazikic@gmail.com','0635268746','56862'),
(9,'123456789','Marko','Markovic','markomarkovic@gmail.com','0635968652','123569'),
(10,'123467899465','Marija','Nikolic','marijangmail.com','063524963','138683'),
(11,'1204567896542','Ana','Markovic','anam@gmail.com','0635246645','68453');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikid` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `korisnickoime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lozinka` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`korisnikid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikid`,`ime`,`prezime`,`korisnickoime`,`lozinka`) values 
(1,'Jovana','Mitrovic','admin','admin');

/*Table structure for table `ponuda` */

DROP TABLE IF EXISTS `ponuda`;

CREATE TABLE `ponuda` (
  `ponudaid` int(11) NOT NULL AUTO_INCREMENT,
  `datumod` date DEFAULT NULL,
  `datumdo` date DEFAULT NULL,
  `hotelid` int(11) DEFAULT NULL,
  `gradid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ponudaid`),
  KEY `hotelid` (`hotelid`),
  KEY `gradid` (`gradid`),
  CONSTRAINT `ponuda_ibfk_1` FOREIGN KEY (`hotelid`) REFERENCES `hotel` (`hotelid`),
  CONSTRAINT `ponuda_ibfk_2` FOREIGN KEY (`gradid`) REFERENCES `grad` (`gradid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ponuda` */

insert  into `ponuda`(`ponudaid`,`datumod`,`datumdo`,`hotelid`,`gradid`) values 
(3,'2019-01-18','2019-01-18',1,2),
(4,'2019-01-04','2019-01-04',1,2),
(7,'2019-01-20','2019-01-20',21,5),
(8,'2019-01-17','2019-01-17',7,7),
(9,'2019-01-04','2019-01-04',2,2),
(10,'2019-01-21','2019-01-21',17,1),
(11,'2019-01-18','2019-01-18',28,11),
(12,'2019-01-18','2019-01-18',28,11),
(13,'2019-01-18','2019-01-18',14,10),
(14,'2019-01-11','2019-01-11',15,12),
(15,'2019-01-11','2019-01-11',23,4),
(16,'2019-01-22','2019-01-22',20,1),
(17,'2019-01-07','2019-01-07',28,11),
(18,'2019-01-03','2019-01-03',4,2),
(19,'2019-01-18','2019-01-18',4,2),
(20,'2019-01-18','2019-01-18',16,12),
(21,'2019-01-02','2019-01-02',16,12);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `brojrezervacije` int(11) NOT NULL AUTO_INCREMENT,
  `klijentid` int(11) NOT NULL,
  `stavkaponudeid` int(11) NOT NULL,
  `ponudaid` int(11) NOT NULL,
  `datumKreiranja` date DEFAULT NULL,
  PRIMARY KEY (`brojrezervacije`,`klijentid`,`stavkaponudeid`,`ponudaid`),
  KEY `klijentid` (`klijentid`),
  KEY `rezervacija_ibfk_2` (`stavkaponudeid`),
  KEY `rezervacija_ibfk_3` (`ponudaid`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`klijentid`) REFERENCES `klijent` (`klijentid`),
  CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`stavkaponudeid`) REFERENCES `stavkaponude` (`rb`),
  CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`ponudaid`) REFERENCES `stavkaponude` (`ponudaid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`brojrezervacije`,`klijentid`,`stavkaponudeid`,`ponudaid`,`datumKreiranja`) values 
(5,1,1,7,'2019-01-20'),
(6,4,2,8,'2019-01-20'),
(7,5,1,10,'2019-01-21'),
(8,6,1,3,'2019-01-22'),
(9,7,2,9,'2019-01-22'),
(10,7,2,9,'2019-01-22'),
(11,1,1,16,'2019-01-22'),
(12,1,2,16,'2019-01-22'),
(13,1,1,17,'2019-01-23'),
(14,1,1,10,'2019-01-27'),
(15,5,1,12,'2019-01-28');

/*Table structure for table `stavkaponude` */

DROP TABLE IF EXISTS `stavkaponude`;

CREATE TABLE `stavkaponude` (
  `ponudaid` int(11) NOT NULL,
  `rb` int(11) NOT NULL,
  `cena` decimal(10,0) DEFAULT NULL,
  `kapacitet` int(11) DEFAULT NULL,
  `tipsobeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ponudaid`,`rb`),
  KEY `ponudaid` (`rb`),
  KEY `tipsobeid` (`tipsobeid`),
  CONSTRAINT `stavkaponude_ibfk_1` FOREIGN KEY (`ponudaid`) REFERENCES `ponuda` (`ponudaid`),
  CONSTRAINT `stavkaponude_ibfk_2` FOREIGN KEY (`tipsobeid`) REFERENCES `tipsobe` (`tipsobeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaponude` */

insert  into `stavkaponude`(`ponudaid`,`rb`,`cena`,`kapacitet`,`tipsobeid`) values 
(3,1,150,19,1),
(3,2,200,10,2),
(4,1,500,5,4),
(7,1,200,8,1),
(7,2,300,10,2),
(8,1,300,10,2),
(8,2,250,3,5),
(9,1,350,3,3),
(9,2,500,0,4),
(10,1,400,1,3),
(11,1,450,5,7),
(11,2,300,4,1),
(11,3,455,3,7),
(11,4,900,1,8),
(12,1,300,3,1),
(13,1,300,5,2),
(13,2,200,3,1),
(14,1,200,2,1),
(14,2,250,2,2),
(15,1,200,2,1),
(15,2,250,2,2),
(16,1,500,1,1),
(16,2,600,1,2),
(17,1,350,4,1),
(18,1,200,2,1),
(19,1,200,2,1),
(20,1,200,2,2),
(21,1,200,2,1),
(21,2,300,3,2);

/*Table structure for table `tipsobe` */

DROP TABLE IF EXISTS `tipsobe`;

CREATE TABLE `tipsobe` (
  `tipsobeid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tipsobeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tipsobe` */

insert  into `tipsobe`(`tipsobeid`,`naziv`) values 
(1,'Apartman 1/2'),
(2,'Apartman 1/3'),
(3,'Apartman 1/4'),
(4,'Apartman 1/5'),
(5,'Studio 1/2'),
(6,'Studio 1/3'),
(7,'Studio 1/4'),
(8,'Studio 1/5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
