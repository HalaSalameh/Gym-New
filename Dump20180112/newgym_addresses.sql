-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: newgym
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `addressId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `building` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'BIS','Ramallah','Masyyon'),(2,'theBuilding','Ramallah','Balou'),(3,'theBuilding','ramallah','Balou'),(4,'theBuilding','Ramallah','balou'),(5,'kdkhls','ojf;sdo','zhldf;'),(6,'kdkhls','ojf;sdo','zhldf;'),(7,'jfdk','dsk','jdgfsk'),(8,'KMKSNDKLND','dsdsd','ssssjhbjhb'),(9,'fcgfcfgc','hfhgfv','tdgdgfcfgc'),(10,'theBuilding','Ramallah','Balou'),(11,'jgdk','kgdl','kes'),(12,'isdfl','khlds','jdsl'),(13,'jbcx,','fdkhs;','ugkcx'),(14,'jdks','bxcj,z','jgdk'),(15,'dsgk','kfshl','dfkhsl'),(16,'sfk.n','el','jfsk'),(17,'TheBuilding','Ramallah','Balou'),(18,'dsjk','ldsk','lhzxz'),(19,'dkg','dhlsf','jdsk'),(20,'gcbgc','s','hgcgc'),(21,'jhvhvhvh','assa','gcghcc'),(22,'fsdhgk','dfjsk','ugksd'),(23,'jksdf','bdsjk','dskj'),(24,'kxbz','aksl','dksj'),(25,'theBuilding','Ramallah','Balou'),(26,'jhbhjv','dsjbdjb','vjhvhjv'),(27,'theBuilding','Ramallah','Balou'),(28,'theBuilding','Ramallah','Balou'),(29,'jbkas','bksd','jdsk'),(30,'theBuilding','Der Debwan','theStreet'),(31,'theBuilding','Der Debwan','theStreet'),(32,'Bridge','rammaleh ','birnabale');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-12 23:38:59
