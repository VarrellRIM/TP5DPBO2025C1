/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.7.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: db_mahasiswa
-- ------------------------------------------------------
-- Server version	11.7.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `mahasiswa`
--

DROP TABLE IF EXISTS `mahasiswa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `semester` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mahasiswa`
--

LOCK TABLES `mahasiswa` WRITE;
/*!40000 ALTER TABLE `mahasiswa` DISABLE KEYS */;
INSERT INTO `mahasiswa` VALUES
(1,'2203999','Amelia Zalfa Julianti','Perempuan',3),
(2,'2202292','Muhammad Iqbal Fadhilah','Laki-laki',4),
(3,'2202346','Muhammad Rifky Afandi','Laki-laki',2),
(4,'2210239','Muhammad Hanif Abdillah','Laki-laki',1),
(5,'2202046','Nurainun','Perempuan',5),
(6,'2205101','Kelvin Julian Putra','Laki-laki',3),
(7,'2200163','Rifanny Lysara Annastasya','Perempuan',6),
(8,'2202869','Revana Faliha Salma','Perempuan',2),
(9,'2209489','Rakha Dhifiargo Hariadi','Laki-laki',4),
(10,'2203142','Roshan Syalwan Nurilham','Laki-laki',3),
(11,'2200311','Raden Rahman Ismail','Laki-laki',5),
(12,'2200978','Ratu Syahirah Khairunnisa','Perempuan',2),
(13,'2204509','Muhammad Fahreza Fauzan','Laki-laki',1),
(14,'2205027','Muhammad Rizki Revandi','Laki-laki',3),
(16,'2200481','Marvel Ravindra Dioputra','Laki-laki',6),
(17,'2209889','Muhammad Fadlul Hafiizh','Laki-laki',2),
(18,'2206697','Rifa Sania','Perempuan',3),
(19,'2207260','Imam Chalish Rafidhul Haque','Laki-laki',5),
(20,'2204343','Meiva Labibah Putri','Perempuan',4),
(25,'69420','Varrell Rizky Irvanni Mahkota','Laki-laki',4);
/*!40000 ALTER TABLE `mahasiswa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-03-30 11:09:40
