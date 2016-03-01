-- MySQL dump 10.13  Distrib 5.7.10, for Win64 (x86_64)
--
-- Host: localhost    Database: playesdb
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Table structure for table `leagues`
--

DROP TABLE IF EXISTS `leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leagues` (
  `League_id` int(11) NOT NULL AUTO_INCREMENT,
  `League_name` varchar(30) NOT NULL,
  `League_picture` varchar(100) NOT NULL,
  PRIMARY KEY (`League_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leagues`
--

LOCK TABLES `leagues` WRITE;
/*!40000 ALTER TABLE `leagues` DISABLE KEYS */;
INSERT INTO `leagues` VALUES (1,'Barclays PL','l13.png'),(2,'Liga BBVA','l53.png'),(3,'Serie A','l31.png'),(4,'Bundesliga','l20.png');
/*!40000 ALTER TABLE `leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nations`
--

DROP TABLE IF EXISTS `nations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nations` (
  `Nation_id` int(11) NOT NULL AUTO_INCREMENT,
  `Nation_name` varchar(30) NOT NULL,
  `Nation_picture` varchar(100) NOT NULL,
  PRIMARY KEY (`Nation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nations`
--

LOCK TABLES `nations` WRITE;
/*!40000 ALTER TABLE `nations` DISABLE KEYS */;
INSERT INTO `nations` VALUES (1,'Spain','45.png'),(2,'Brazil','54.png'),(3,'France','18.png'),(4,'Argentina','52.png'),(5,'Germany','21.png'),(6,'Italy','27.png'),(7,'England','14.png'),(8,'Portugal','38.png'),(9,'Netherlands','34.png'),(10,'Belgium','7.png'),(11,'Colombia','56.png'),(13,'Uruguay','60.png'),(15,'Ivory Coast','108.png'),(16,'Poland','37.png'),(17,'Croatia','10.png'),(18,'Chile','55.png');
/*!40000 ALTER TABLE `nations` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clubs` (
  `Club_id` int(11) NOT NULL AUTO_INCREMENT,
  `Club_league_id` int(11) NOT NULL,
  `Club_name` varchar(30) NOT NULL,
  `Club_picture` varchar(100) NOT NULL,
  PRIMARY KEY (`Club_id`),
  KEY `Club_league_id` (`Club_league_id`),
  CONSTRAINT `clubs_ibfk_1` FOREIGN KEY (`Club_league_id`) REFERENCES `leagues` (`League_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubs`
--

LOCK TABLES `clubs` WRITE;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
INSERT INTO `clubs` VALUES (1,1,'Arsenal','s1.png'),(2,1,'Chelsea','s5.png'),(3,1,'Manchester City','s10.png'),(4,1,'Liverpool','s9.png'),(5,1,'Tottenham Hotspur','s18.png'),(6,1,'Manchester United','s11.png'),(7,2,'Real Madrid','s243.png'),(8,2,'FC Barcelona','s241.png'),(9,2,'Atletico Madrid','s240.png'),(10,2,'Sevilla','s481.png'),(11,2,'Valencia','s461.png'),(12,3,'Juventus','s45.png'),(13,3,'Napoli','s48.png'),(14,3,'Roma','s52.png'),(15,3,'Fiorentina','s110374.png'),(16,3,'AC Milan','s47.png'),(17,4,'FC Bayern','s21.png'),(18,4,'Borussia Dortmund','s22.png'),(19,4,'VfL Wolfsburg','s175.png'),(20,4,'Schalke','s34.png');
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `Player_nation_id` int(11) NOT NULL,
  `Player_club_id` int(11) DEFAULT NULL,
  `Player_name` varchar(30) NOT NULL,
  `Player_birthday` date DEFAULT NULL,
  `Player_picture` varchar(100) DEFAULT NULL,
  `Player_position` varchar(30) DEFAULT NULL,
  `Player_height` int(11) DEFAULT NULL,
  `Player_number` int(11) DEFAULT NULL,
  `Player_foot` enum('Left','Right','Both') NOT NULL,
  PRIMARY KEY (`player_id`),
  KEY `Player_nation_id` (`Player_nation_id`),
  KEY `Player_club_id` (`Player_club_id`),
  CONSTRAINT `players_ibfk_1` FOREIGN KEY (`Player_nation_id`) REFERENCES `nations` (`Nation_id`),
  CONSTRAINT `players_ibfk_2` FOREIGN KEY (`Player_club_id`) REFERENCES `clubs` (`Club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,4,8,'Messi','1987-06-24','158023.png','Attacker',170,45,'Left'),(2,8,7,'Cristiano Ronaldo','1985-02-05','20801.png','Attacker',185,24,'Right'),(3,2,8,'Neymar','1992-02-05','190871.png','Attacker',174,57,'Right'),(4,13,8,'Suárez','1987-01-24','176580.png','Attacker',182,7,'Right'),(5,10,2,'Hazard','1991-01-07','183277.png','Medfilder',173,64,'Right'),(6,9,17,'Robben','1984-01-23','9014.png','Attacker',180,86,'Left'),(7,5,1,'Özil','1988-10-15','176635.png','Medfilder',183,53,'Left'),(8,16,17,'Lewandowski','1988-08-21','188545.png','Attacker',185,65,'Right'),(10,4,3,'Agüero','1988-06-02','153079.png','Attacker',172,62,'Right'),(11,1,8,'Iniesta','1984-05-11','41.png','Medfilder',171,96,'Right'),(12,11,7,'Rodríguez','1991-07-12','198710.png','Medfilder',180,33,'Left'),(13,5,17,'Boateng','1988-09-03','183907.png','Defender',192,57,'Right'),(14,5,7,'Kroos','1990-01-04','182521.png','Medfilder',182,17,'Right'),(15,3,17,'Ribéry','1983-04-07','156616.png','Medfilder',170,90,'Right'),(16,6,12,'Chiellini','1984-08-14','138956.png','Defender',186,59,'Left'),(17,4,13,'Higuaín','1987-12-10','167664.png','Attacker',184,6,'Right'),(18,13,9,'Godín','1986-02-16','182493.png','Defender',185,73,'Right'),(19,3,12,'Pogba','1993-03-15','195864.png','Medfilder',188,23,'Right'),(20,5,18,'Reus','1989-05-31','188350.png','Attacker',180,20,'Right'),(21,18,1,'Sánchez','1988-12-19','184941.png','Medfilder',169,11,'Right'),(22,5,18,'Hummels','1988-12-16','178603.png','Defender',191,65,'Right'),(23,3,7,'Benzema','1987-12-19','165153.png','Attacker',187,26,'Right'),(24,5,6,'Schweinsteiger','1984-08-01','121944.png','Medfilder',183,70,'Right'),(25,7,6,'Rooney','1985-10-24','54050.png','Attacker',176,7,'Right'),(27,3,1,'Koscielny','1985-09-10','165229.png','Defender',186,75,'Right'),(28,1,1,'Santi Cazorla','1984-12-13','146562.png','Medfilder',168,39,'Right'),(29,5,1,'Mertesacker','1984-09-29','53612.png','Defender',198,83,'Right'),(30,10,2,'Courtois','1992-05-11','192119.png','GoalKeeper',199,99,'Left'),(31,2,2,'Willian','1988-08-09','180403.png','Medfilder',175,51,'Right'),(32,7,2,'Cahill','1985-12-19','164468.png','Defender',193,40,'Right'),(34,1,2,'Azpilicueta','1989-08-28','184432.png','Defender',178,31,'Right'),(36,10,3,'Kompany','1986-04-10','139720.png','Defender',192,82,'Right'),(37,4,3,'Zabaleta','1985-01-16','142784.png','Defender',178,4,'Right'),(38,15,3,'Touré','1983-05-13','20289.png','Medfilder',189,51,'Right'),(39,3,3,'Nasri','1987-06-26','165239.png','Medfilder',175,55,'Right'),(40,10,4,'Mignolet','1988-03-06','173426.png','GoalKeeper',193,47,'Right'),(41,3,4,'Sakho','1990-02-13','183285.png','Defender',187,2,'Left'),(42,7,4,'Henderson','1990-06-17','183711.png','Medfilder',182,42,'Right'),(43,2,4,'Coutinho','1992-06-12','189242.png','Medfilder',171,55,'Right'),(44,7,4,'Sturridge','1989-09-01','171833.png','Attacker',188,31,'Left'),(45,3,5,'Lloris','1986-12-26','167948.png','GoalKeeper',188,39,'Left'),(46,10,5,'Vertonghen','1987-04-24','172871.png','Defender',189,85,'Left'),(47,4,5,'Lamela','1992-03-04','170368.png','Medfilder',183,71,'Left'),(48,13,5,'Eriksen','1992-02-14','190460.png','Medfilder',177,37,'Right'),(49,7,13,'Townsend','1991-07-16','194932.png','Medfilder',181,8,'Left'),(50,1,6,'Juan Mata','1988-04-28','178088.png','Medfilder',170,77,'Left'),(51,7,6,'Carrick','1981-07-28','21146.png','Medfilder',188,36,'Right'),(52,10,6,'Fellaini','1987-11-22','176944.png','Medfilder',194,22,'Right'),(53,17,8,'Rakitić','1988-03-10','168651.png','Medfilder',184,15,'Right'),(54,1,9,'Juanfran','1985-01-09','146760.png','Defender',180,60,'Right'),(55,3,9,'Griezmann','1991-03-21','194765.png','Attacker',176,14,'Left'),(56,1,9,'Koke','1992-01-08','193747.png','Medfilder',178,85,'Right'),(57,4,10,'Banega','1988-06-29','178562.png','Medfilder',174,23,'Right'),(58,1,10,'Reyes','1983-09-01','111093.png','Medfilder',176,16,'Left'),(59,1,10,'Vitolo','1989-11-02','199715.png','Medfilder',184,71,'Right'),(60,11,16,'Bacca','1986-09-08','207664.png','Attacker',181,89,'Right'),(61,5,11,'Mustafi','1992-04-17','192227.png','Defender',184,81,'Right'),(62,1,11,'Parejo','1989-04-16','189513.png','Medfilder',180,89,'Right'),(63,4,11,'Piatti','1989-03-31','183899.png','Attacker',163,48,'Left'),(64,6,14,'Florenzi','1991-03-11','203551.png','Defender',173,36,'Right'),(65,10,14,'Nainggolan','1988-05-04','178518.png','Medfilder',176,16,'Right'),(66,6,14,'Totti','1976-09-27','1238.png','Attacker',180,41,'Right'),(67,15,14,'Gervinho','1987-05-27','170733.png','Attacker',179,26,'Right'),(68,17,15,'Badelj','1989-02-25','201144.png','Medfilder',186,14,'Right'),(69,1,15,'Borja Valero','1985-01-12','161956.png','Medfilder',175,7,'Right'),(72,6,15,'Pasqual','1982-03-13','154634.png','Defender',178,82,'Left'),(74,6,16,'De Sciglio','1992-10-20','206058.png','Defender',183,83,'Right'),(75,6,16,'Montolivo','1985-01-18','159287.png','Medfilder',182,65,'Right'),(76,6,16,'Abbiati','1977-07-08','1219.png','GoalKeeper',191,60,'Right'),(78,8,19,'Vieirinha','1986-01-24','177553.png','Medfilder',172,10,'Right'),(79,2,19,'Luiz Gustavo','1987-07-23','185221.png','Medfilder',187,96,'Left'),(80,5,19,'Draxler','1993-09-20','202166.png','Medfilder',187,96,'Right'),(81,5,20,'Aogo','1987-01-14','164491.png','Defender',184,71,'Left'),(82,9,20,'Huntelaar','1983-08-12','148803.png','Attacker',186,90,'Right');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_username` varchar(30) NOT NULL,
  `User_password` char(32) NOT NULL,
  `User_type` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`User_id`),
  UNIQUE KEY `User_username` (`User_username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'meezo','123456',0),(4,'test','test',1),(11,'justin','123456',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-01  7:41:25
