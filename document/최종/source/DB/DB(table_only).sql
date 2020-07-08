-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssafydb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `dongcode`
--

DROP TABLE IF EXISTS `dongcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dongcode` (
  `code` char(10) NOT NULL,
  `sido` varchar(20) NOT NULL,
  `sigungu` text,
  `dong` text,
  `dongri` text,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fav_area`
--

DROP TABLE IF EXISTS `fav_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fav_area` (
  `memno` int NOT NULL,
  `dongcode` char(10) NOT NULL,
  PRIMARY KEY (`memno`,`dongcode`),
  KEY `dongcode` (`dongcode`),
  CONSTRAINT `fav_area_ibfk_1` FOREIGN KEY (`memno`) REFERENCES `members` (`no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fav_area_ibfk_2` FOREIGN KEY (`dongcode`) REFERENCES `dongcode` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `free_board`
--

DROP TABLE IF EXISTS `free_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free_board` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '번호',
  `title` varchar(300) NOT NULL COMMENT '제목',
  `contents` varchar(4000) NOT NULL COMMENT '내용',
  `views` int DEFAULT NULL COMMENT '조회수',
  `createDate` varchar(30) NOT NULL COMMENT '작성일자 및 수정일자(now)',
  `memno` int NOT NULL COMMENT '작성자번호',
  PRIMARY KEY (`no`),
  KEY `free_to_mem_fk1` (`memno`),
  CONSTRAINT `free_to_mem_fk1` FOREIGN KEY (`memno`) REFERENCES `members` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='자유게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `housedeal`
--

DROP TABLE IF EXISTS `housedeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `housedeal` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `dealAmount` varchar(50) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `dealYear` varchar(30) DEFAULT NULL,
  `dealMonth` varchar(30) DEFAULT NULL,
  `dealDay` varchar(30) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  `floor` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `rentMoney` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `housedeal_FK_1` (`code`),
  CONSTRAINT `housedeal_FK_1` FOREIGN KEY (`code`) REFERENCES `dongcode` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=131081 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `houseinfo`
--

DROP TABLE IF EXISTS `houseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `houseinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `dong` varchar(30) NOT NULL,
  `AptName` varchar(50) NOT NULL,
  `code` varchar(30) NOT NULL,
  `buildYear` varchar(30) DEFAULT NULL,
  `jibun` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `houseinfo_FK_1` (`code`),
  CONSTRAINT `houseinfo_FK_1` FOREIGN KEY (`code`) REFERENCES `dongcode` (`code`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8202 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `userId` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `news_board`
--

DROP TABLE IF EXISTS `news_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news_board` (
  `news_no` int NOT NULL AUTO_INCREMENT COMMENT '번호',
  `news_title` text NOT NULL COMMENT '제목',
  `news_contents` text NOT NULL COMMENT '내용',
  `news_views` int DEFAULT NULL COMMENT '조회수',
  `news_createDate` varchar(30) NOT NULL COMMENT '작성일자 및 수정일자(now)',
  `news_memno` int NOT NULL COMMENT '작성자번호',
  `ref_writer` text NOT NULL COMMENT '원작자',
  `ref_source` text NOT NULL COMMENT '출처',
  `ref_date` varchar(30) DEFAULT NULL COMMENT '원작 작성일자(yyyy-mm-dd)',
  PRIMARY KEY (`news_no`),
  KEY `news_to_mem_fk1` (`news_memno`),
  CONSTRAINT `news_to_mem_fk1` FOREIGN KEY (`news_memno`) REFERENCES `members` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='오늘의뉴스게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notice_board`
--

DROP TABLE IF EXISTS `notice_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_board` (
  `no` int NOT NULL AUTO_INCREMENT COMMENT '번호',
  `title` text NOT NULL COMMENT '제목',
  `contents` text NOT NULL COMMENT '내용',
  `views` int DEFAULT NULL COMMENT '조회수',
  `createDate` varchar(30) NOT NULL COMMENT '작성일자 및 수정일자(now)',
  `memno` int NOT NULL COMMENT '작성자번호',
  PRIMARY KEY (`no`),
  KEY `notice_to_mem_fk1` (`memno`),
  CONSTRAINT `notice_to_mem_fk1` FOREIGN KEY (`memno`) REFERENCES `members` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='공지사항게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `qna_board`
--

DROP TABLE IF EXISTS `qna_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna_board` (
  `qna_no` int NOT NULL AUTO_INCREMENT COMMENT '질문번호',
  `qna_title` varchar(300) NOT NULL COMMENT '질문제목',
  `qna_content` varchar(4000) NOT NULL COMMENT '질문내용',
  `qna_memno` int NOT NULL COMMENT '질문자번호',
  `qna_datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '질문일시',
  `reply` int DEFAULT '0' COMMENT '답변개수(0-no,1-yes)',
  `reply_content` varchar(4000) DEFAULT NULL COMMENT '답변내용',
  `reply_datetime` timestamp NULL DEFAULT NULL COMMENT '답변일시',
  `reply_memno` int DEFAULT NULL COMMENT '답변자아이디',
  PRIMARY KEY (`qna_no`),
  KEY `qna_to_mem_fk1` (`qna_memno`),
  KEY `qna_to_mem_fk2` (`reply_memno`),
  CONSTRAINT `qna_to_mem_fk1` FOREIGN KEY (`qna_memno`) REFERENCES `members` (`no`),
  CONSTRAINT `qna_to_mem_fk2` FOREIGN KEY (`reply_memno`) REFERENCES `members` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='질문게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `storeinfo`
--

DROP TABLE IF EXISTS `storeinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storeinfo` (
  `no` int DEFAULT NULL,
  `shopname` varchar(60) NOT NULL,
  `localname` text,
  `upjongLCode` char(1) NOT NULL,
  `upjongMCode` char(3) NOT NULL,
  `upjongSCode` char(6) NOT NULL,
  `code4` text,
  `codename4` text,
  `dongcode` char(10) NOT NULL,
  `jibunaddress` text,
  `address` text,
  `oldpostcode` int DEFAULT NULL,
  `postcode` int DEFAULT NULL,
  `lng` text,
  `lat` text,
  KEY `FK1` (`dongcode`),
  KEY `FK2` (`upjongLCode`),
  KEY `FK3` (`upjongMCode`),
  KEY `FK4` (`upjongSCode`),
  CONSTRAINT `FK1` FOREIGN KEY (`dongcode`) REFERENCES `dongcode` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2` FOREIGN KEY (`upjongLCode`) REFERENCES `upjongl` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3` FOREIGN KEY (`upjongMCode`) REFERENCES `upjongm` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK4` FOREIGN KEY (`upjongSCode`) REFERENCES `upjongs` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `upjongl`
--

DROP TABLE IF EXISTS `upjongl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upjongl` (
  `code` char(1) NOT NULL,
  `codenm` varchar(40) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `upjongm`
--

DROP TABLE IF EXISTS `upjongm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upjongm` (
  `code` char(3) NOT NULL,
  `codenm` varchar(60) NOT NULL,
  `upjongLcode` char(1) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `upjongLcode` (`upjongLcode`),
  CONSTRAINT `upjongm_ibfk_1` FOREIGN KEY (`upjongLcode`) REFERENCES `upjongl` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `upjongs`
--

DROP TABLE IF EXISTS `upjongs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upjongs` (
  `code` char(6) NOT NULL,
  `codenm` varchar(60) NOT NULL,
  `upjongMcode` char(3) NOT NULL,
  PRIMARY KEY (`code`),
  KEY `upjongMcode` (`upjongMcode`),
  CONSTRAINT `upjongs_ibfk_1` FOREIGN KEY (`upjongMcode`) REFERENCES `upjongm` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 11:27:02
