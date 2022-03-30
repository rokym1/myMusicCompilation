-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: music-db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ARTIST_idx` (`artist_id`),
  CONSTRAINT `FK_ARTIST` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'Violator',1),(2,'Music For The Masses',1),(3,'Under a Blood Red Sky',2),(4,'The Man-Machine',3),(12,'A Collection of Great Dance Songs',6),(13,'Non-Stop Erotic Cabaret',8),(14,'The Wedding Album',9),(28,'Eat to the Beat',5),(29,'New gold dream (81-82-83-84)',10),(30,'Upstairs at Eric\'s',7);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `artist_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NAME_UNIQUE` (`name`),
  KEY `FK_DETAIL_idx` (`artist_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`artist_detail_id`) REFERENCES `artist_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Depeche Mode',1),(2,'U2',2),(3,'Kraftwerk',3),(5,'Blondie',4),(6,'Pink Floyd',5),(7,'Yazoo',6),(8,'Soft Cell',7),(9,'Duran Duran',8),(10,'Simple Minds',9);
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist_detail`
--

DROP TABLE IF EXISTS `artist_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `web_page` varchar(128) DEFAULT NULL,
  `facebook` varchar(128) DEFAULT NULL,
  `instagram` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist_detail`
--

LOCK TABLES `artist_detail` WRITE;
/*!40000 ALTER TABLE `artist_detail` DISABLE KEYS */;
INSERT INTO `artist_detail` VALUES (1,'http://www.depechemode.com/','https://www.facebook.com/depechemode','https://www.instagram.com/depechemode/'),(2,'https://www.u2.com/','https://www.facebook.com/u2','https://instagram.com/u2'),(3,'https://kraftwerk.com/','https://www.facebook.com/Kraftwerk','https://www.instagram.com/kraftwerkofficial/'),(4,'https://www.blondie.net/','https://blondie.lnk.to/Facebookwe','https://blondie.lnk.to/Instawe'),(5,'https://www.pinkfloyd.com/','https://www.facebook.com/pinkfloyd/','https://www.instagram.com/PinkFloyd/'),(6,'https://yazooinfo.com/','https://www.facebook.com/AlisonMoyet/','https://twitter.com/Alisonmoyetnews'),(7,'https://www.softcell.co.uk/','https://www.facebook.com/softcellband','http://instagram.com/softcellhq'),(8,'https://duranduran.com/','http://www.facebook.com/duranduran','https://www.instagram.com/duranduran/?hl=en'),(9,'https://www.simpleminds.com/','https://www.facebook.com/simpleminds','https://www.instagram.com/simplemindsmusic/');
/*!40000 ALTER TABLE `artist_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist_genre`
--

DROP TABLE IF EXISTS `artist_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist_genre` (
  `artist_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`artist_id`,`genre_id`),
  KEY `FK_ARTIST_idx` (`artist_id`),
  KEY `FK_GENRE` (`genre_id`),
  CONSTRAINT `FK_ARTIST_3` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`),
  CONSTRAINT `FK_GENRE` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist_genre`
--

LOCK TABLES `artist_genre` WRITE;
/*!40000 ALTER TABLE `artist_genre` DISABLE KEYS */;
INSERT INTO `artist_genre` VALUES (1,1),(1,2),(1,5),(1,6),(2,1),(2,3),(2,4),(3,5),(3,6);
/*!40000 ALTER TABLE `artist_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'new wave'),(2,'electronic rock'),(3,'rock'),(4,'alternative rock'),(5,'electronic'),(6,'synth-pop');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  `album_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ARTIST_idx` (`artist_id`),
  KEY `FK_ALBUM` (`album_id`),
  CONSTRAINT `FK_ALBUM` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  CONSTRAINT `FK_ARTIST_2` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'The Model',3,4),(2,'Gloria',2,3),(3,'Sunday Bloody Sunday',2,3),(4,'Never Let Me Down Again',1,2),(5,'Behind the Wheel',1,2),(6,'World in My Eyes',1,1),(7,'Enjoy the Silence',1,1),(8,'Frustration',8,13),(9,'Tainted Love',8,13),(10,'Seedy Films',8,13),(11,'Youth',8,13),(12,'Sex Dwarf',8,13),(13,'Entertaine Me',8,13),(14,'Chips On My Shoulder',8,13),(15,'Bedsitter',8,13),(16,'Too Much Information',9,14),(17,'Ordinary World',9,14),(18,'Come Undone',9,14),(19,'Femme Fatale',9,14),(20,'Shelter',9,14),(21,'None of the Above',9,14),(22,'Sin of the City',9,14),(23,'Strangelove',1,2),(32,'Dreaming',5,28),(33,'The Hardest Part',5,28),(34,'Union City Blue',5,28),(35,'Shayla',5,28),(36,'Eat to the Beat',5,28),(37,'Atomic',5,28),(38,'Die Young Stay Pretty',5,28),(39,'Personal Jesus',1,1),(40,'Waiting for the Night',1,1),(41,'Policy of Truth',1,1),(42,'Clean',1,1),(43,'Sweetest Perfection',1,1),(44,'Halo',1,1),(45,'Little 15',1,2),(46,'I Want You Now',1,2),(47,'Nothing',1,2),(48,'The Things You Said',1,2),(49,'The Robots',3,4),(50,'Spacelab',3,4),(51,'Metropolis',3,4),(52,'The Model',3,4),(53,'Neon Lights',3,4),(54,'One of These Days',6,12),(55,'Money',6,12),(56,'Sheep',6,12),(57,'Shine On You Crazy Diamond',6,12),(58,'Wish You Were Here',6,12),(59,'Another Brick in the Wall',6,12),(60,'Someone Somewhere in Summertime',10,29),(61,'New Gold Dream (81-82-83-84)',10,29),(62,'Somebody Up There Likes You',10,29),(63,'Big Sleep',10,29),(64,'King Is White And In The Crowd',10,29),(65,'Hunter and the Hunted',10,29),(66,'Gloria',2,3),(67,'I Will Follow',2,3),(68,'Party Girl',2,3),(69,'New Year\'s Day',2,3),(70,'Don\'t Go',7,30),(71,'Too Pieces',7,30),(72,'Bad Connection',7,30),(73,'In My Room',7,30),(74,'Only You',7,30),(75,'Goodbye 70\'s',7,30),(76,'Winter Kills',7,30);
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-29 20:28:28

