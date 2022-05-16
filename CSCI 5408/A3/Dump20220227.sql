-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: a3
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
-- Table structure for table `annual_ticket_sales`
--

DROP TABLE IF EXISTS `annual_ticket_sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annual_ticket_sales` (
  `YEAR` int DEFAULT NULL,
  `TICKETS SOLD` text,
  `TOTAL BOX OFFICE` text,
  `TOTAL INFLATION ADJUSTED BOX OFFICE` text,
  `AVERAGE TICKET PRICE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annual_ticket_sales`
--

LOCK TABLES `annual_ticket_sales` WRITE;
/*!40000 ALTER TABLE `annual_ticket_sales` DISABLE KEYS */;
INSERT INTO `annual_ticket_sales` VALUES (2021,'42,37,74,881','$3,881,777,912','$3,881,777,912','$9.16'),(2020,'22,36,38,958','$2,048,534,616','$2,048,534,616','$9.16'),(2019,'1,22,85,41,629','$11,253,443,955','$11,253,444,050','$9.16'),(2018,'1,31,15,36,128','$11,948,096,650','$12,013,670,952','$9.11'),(2017,'1,22,56,39,761','$10,993,991,460','$11,226,860,216','$8.97'),(2016,'1,30,25,56,378','$11,267,115,924','$11,931,416,424','$8.65'),(2015,'1,32,33,56,776','$11,155,900,636','$12,121,948,075','$8.43'),(2014,'1,25,74,02,920','$10,272,985,008','$11,517,810,744','$8.17'),(2013,'1,33,91,68,926','$10,887,446,341','$12,266,787,382','$8.13'),(2012,'1,38,09,21,942','$10,992,141,616','$12,649,244,986','$7.96'),(2011,'0','$10,173,519,704','$11,751,502,955','$7.93'),(2010,'1,32,85,49,021','$10,482,254,025','$12,169,509,032','$7.89'),(2009,'1,41,85,67,388','$10,639,257,284','$12,994,051,137','$7.50'),(2008,'1,35,80,42,073','$9,750,744,148','$12,439,665,380','$7.18'),(2007,'1,42,00,36,680','$9,769,854,914','$13,007,535,993','$6.88'),(2006,'1,39,87,38,283','$9,161,738,221','$12,812,442,671','$6.55'),(2005,'1,37,29,80,280','$8,800,805,718','$12,576,499,367','$6.41'),(2004,'1,49,56,51,298','$9,287,996,519','$13,700,165,883','$6.21'),(2003,'1,52,45,89,620','$9,193,277,289','$13,965,240,914','$6.03'),(2002,'1,57,57,56,527','$9,155,147,215','$14,433,929,789','$5.81'),(2001,'1,46,58,74,205','$8,296,849,636','$13,427,407,722','$5.66'),(2000,'1,39,74,60,079','$7,532,311,479','$12,800,734,319','$5.39'),(1999,'1,44,46,64,086','$7,338,894,852','$13,233,123,027','$5.08'),(1998,'1,44,38,32,471','$6,771,575,283','$13,225,505,439','$4.69'),(1997,'1,35,73,49,648','$6,230,235,770','$12,433,322,785','$4.59'),(1996,'1,30,52,21,290','$5,769,078,886','$11,955,781,912','$4.42'),(1995,'1,22,17,05,907','$5,314,421,390','$11,190,826,105','$4.35');
/*!40000 ALTER TABLE `annual_ticket_sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `highest_grossers`
--

DROP TABLE IF EXISTS `highest_grossers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `highest_grossers` (
  `YEAR` int DEFAULT NULL,
  `MOVIE` text,
  `GENRE` text,
  `MPAA RATING` text,
  `DISTRIBUTOR` text,
  `TOTAL FOR YEAR` text,
  `TOTAL IN 2019 DOLLARS` text,
  `TICKETS SOLD` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `highest_grossers`
--

LOCK TABLES `highest_grossers` WRITE;
/*!40000 ALTER TABLE `highest_grossers` DISABLE KEYS */;
INSERT INTO `highest_grossers` VALUES (1995,'Batman Forever','Drama','PG-13','Warner Bros.','$184,031,112','$387,522,978','4,23,06,002'),(1996,'Independence Day','Adventure','PG-13','20th Century Fox','$306,169,255','$634,504,608','6,92,69,062'),(1997,'Men in Black','Adventure','PG-13','Sony Pictures','$250,650,052','$500,207,943','5,46,07,854'),(1998,'Titanic','Adventure','PG-13','Paramount Pictures','$443,319,081','$865,842,808','9,45,24,324'),(1999,'Star Wars Ep. I: The Phantom Menace','Adventure','PG','20th Century Fox','$430,443,350','$776,153,749','8,47,32,942'),(2000,'How the Grinch Stole Christmas','Adventure','PG','Universal','$253,367,455','$430,583,644','4,70,06,948'),(2001,'Harry Potter and the Sorcerers Stone','Adventure','PG','Warner Bros.','$300,404,434','$486,166,890','5,30,74,988'),(2002,'Spider-Man','Adventure','PG-13','Sony Pictures','$403,706,375','$636,480,273','6,94,84,746'),(2003,'Finding Nemo','Adventure','G','Walt Disney','$339,714,367','$516,050,346','5,63,37,374'),(2004,'Shrek 2','Adventure','PG','Dreamworks SKG','$441,226,247','$650,826,473','7,10,50,925'),(2005,'Star Wars Ep. III: Revenge of the Sith','Action','PG-13','20th Century Fox','$380,270,577','$543,413,171','5,93,24,582'),(2006,'Pirates of the Caribbean: Dead Mans Chest','Action','PG-13','Walt Disney','$423,315,812','$591,995,851','6,46,28,368'),(2007,'Spider-Man 3','Adventure','PG-13','Sony Pictures','$336,530,303','$448,054,878','4,89,14,288'),(2008,'The Dark Knight','Adventure','PG-13','Warner Bros.','$531,001,578','$677,433,772','7,39,55,652'),(2009,'Transformers: Revenge of the Fallen','Action','PG-13','Paramount Pictures','$402,111,870','$491,112,631','5,36,14,916'),(2010,'Toy Story 3','Action','G','Walt Disney','$415,004,880','$481,805,411','5,25,98,844'),(2011,'Harry Potter and the Deathly Hallows: Part II','Action','PG-13','Warner Bros.','$381,011,219','$440,108,798','4,80,46,812'),(2012,'The Avengers','Adventure','PG-13','Walt Disney','$623,357,910','$717,331,462','7,83,11,295'),(2013,'Iron Man 3','Adventure','PG-13','Walt Disney','$408,992,272','$460,808,016','5,03,06,552'),(2014,'Guardians of the Galaxy','Adventure','PG-13','Walt Disney','$333,055,258','$373,413,235','4,07,65,637'),(2015,'Star Wars Ep. VII: The Force Awakens','Action','PG-13','Walt Disney','$742,208,942','$806,480,887','8,80,43,765'),(2016,'Finding Dory','Action','PG','Walt Disney','$486,295,561','$514,967,322','5,62,19,140'),(2017,'Star Wars Ep. VIII: The Last Jedi','Action','PG-13','Walt Disney','$517,218,368','$528,173,936','5,76,60,910'),(2018,'Black Panther','Action','PG-13','Walt Disney','$700,059,566','$703,901,821','7,68,45,177'),(2019,'Avengers: Endgame','','PG-13','Walt Disney','$858,373,000','$858,373,002','9,37,08,843'),(2020,'Bad Boys For Life','','R','Sony Pictures','$204,417,855','$204,417,848','2,23,16,359'),(2021,'Shang-Chi and the Legend of the Ten Rings','','PG-13','Walt Disney','$224,226,704','$224,226,704','2,44,78,897');
/*!40000 ALTER TABLE `highest_grossers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `popular_creative_types`
--

DROP TABLE IF EXISTS `popular_creative_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `popular_creative_types` (
  `RANK` int DEFAULT NULL,
  `CREATIVE TYPES` text,
  `MOVIES` text,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popular_creative_types`
--

LOCK TABLES `popular_creative_types` WRITE;
/*!40000 ALTER TABLE `popular_creative_types` DISABLE KEYS */;
INSERT INTO `popular_creative_types` VALUES (1,'Contemporary Fiction','7,442','$96,203,727,036','$12,927,133','40.46%'),(2,'Kids Fiction','564','$32,035,539,746','$56,800,602','13.47%'),(3,'Science Fiction','724','$29,922,660,857','$41,329,642','12.59%'),(4,'Fantasy','759','$21,724,062,575','$28,621,953','9.14%'),(5,'Super Hero','129','$20,273,157,911','$157,156,263','8.53%'),(6,'Historical Fiction','1,487','$18,521,260,744','$12,455,454','7.79%'),(7,'Dramatization','1,175','$15,715,191,699','$13,374,631','6.61%'),(8,'Factual','2,467','$2,960,327,207','$1,199,970','1.25%'),(9,'Multiple Creative Types','42','$117,574,526','$2,799,393','0.05%');
/*!40000 ALTER TABLE `popular_creative_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_distributors`
--

DROP TABLE IF EXISTS `top_distributors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `top_distributors` (
  `RANK` int DEFAULT NULL,
  `DISTRIBUTORS` text,
  `MOVIES` int DEFAULT NULL,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_distributors`
--

LOCK TABLES `top_distributors` WRITE;
/*!40000 ALTER TABLE `top_distributors` DISABLE KEYS */;
INSERT INTO `top_distributors` VALUES (1,'Walt Disney',588,'$40,472,424,278','$68,830,654','17.02%'),(2,'Warner Bros.',824,'$36,269,425,479','$44,016,293','15.25%'),(3,'Sony Pictures',747,'$29,113,002,302','$38,973,229','12.24%'),(4,'Universal',535,'$28,089,932,569','$52,504,547','11.81%'),(5,'20th Century Fox',525,'$25,857,839,756','$49,253,028','10.88%'),(6,'Paramount Pictures',493,'$24,361,425,304','$49,414,656','10.25%'),(7,'Lionsgate',426,'$9,631,837,781','$22,609,948','4.05%'),(8,'New Line',209,'$6,195,268,024','$29,642,431','2.61%'),(9,'Dreamworks SKG',77,'$4,278,649,271','$55,566,874','1.80%'),(10,'Miramax',385,'$3,836,019,208','$9,963,686','1.61%');
/*!40000 ALTER TABLE `top_distributors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_genres`
--

DROP TABLE IF EXISTS `top_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `top_genres` (
  `RANK` int DEFAULT NULL,
  `GENRES` text,
  `MOVIES` text,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_genres`
--

LOCK TABLES `top_genres` WRITE;
/*!40000 ALTER TABLE `top_genres` DISABLE KEYS */;
INSERT INTO `top_genres` VALUES (1,'Adventure','1,102','$64,529,536,530','$58,556,748','27.14%'),(2,'Action','1,098','$49,339,974,493','$44,936,224','20.75%'),(3,'Drama','5,479','$35,586,177,269','$6,495,013','14.97%'),(4,'Comedy','2,418','$33,687,992,318','$13,932,172','14.17%'),(5,'Thriller/Suspense','1,186','$19,810,201,102','$16,703,374','8.33%'),(6,'Horror','716','$13,430,378,699','$18,757,512','5.65%'),(7,'Romantic Comedy','630','$10,480,124,374','$16,635,118','4.41%'),(8,'Musical','201','$4,293,988,317','$21,363,126','1.81%'),(9,'Documentary','2,415','$2,519,513,142','$1,043,277','1.06%'),(10,'Black Comedy','213','$2,185,433,323','$10,260,250','0.92%');
/*!40000 ALTER TABLE `top_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_grossing_ratings`
--

DROP TABLE IF EXISTS `top_grossing_ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `top_grossing_ratings` (
  `RANK` int DEFAULT NULL,
  `MPAA RATINGS` text,
  `MOVIES` text,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_grossing_ratings`
--

LOCK TABLES `top_grossing_ratings` WRITE;
/*!40000 ALTER TABLE `top_grossing_ratings` DISABLE KEYS */;
INSERT INTO `top_grossing_ratings` VALUES (1,'PG-13','3,243','$113,524,789,243','$35,006,102','47.75%'),(2,'R','5,480','$63,497,164,978','$11,587,074','26.71%'),(3,'PG','1,535','$49,124,317,794','$32,002,813','20.66%'),(4,'G','395','$9,572,240,391','$24,233,520','4.03%'),(5,'Not Rated','5,820','$1,918,358,283','$329,615','0.81%'),(6,'NC-17','24','$44,850,139','$1,868,756','0.02%'),(7,'Open','5','$5,489,687','$1,097,937','0.00%'),(8,'GP','7','$552,618','$78,945','0.00%');
/*!40000 ALTER TABLE `top_grossing_ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_grossing_sources`
--

DROP TABLE IF EXISTS `top_grossing_sources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `top_grossing_sources` (
  `RANK` int DEFAULT NULL,
  `SOURCES` text,
  `MOVIES` text,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_grossing_sources`
--

LOCK TABLES `top_grossing_sources` WRITE;
/*!40000 ALTER TABLE `top_grossing_sources` DISABLE KEYS */;
INSERT INTO `top_grossing_sources` VALUES (1,'Original Screenplay','7,946','$106,375,196,782','$13,387,264','44.74%'),(2,'Based on Fiction Book/Short Story','2,150','$47,005,613,207','$21,863,076','19.77%'),(3,'Based on Comic/Graphic Novel','249','$23,369,989,130','$93,855,378','9.83%'),(4,'Remake','328','$12,832,659,970','$39,123,963','5.40%'),(5,'Based on Real Life Events','3,225','$11,398,356,297','$3,534,374','4.79%'),(6,'Based on TV','231','$11,305,006,312','$48,939,421','4.75%'),(7,'Based on Factual Book/Article','295','$7,443,681,990','$25,232,820','3.13%'),(8,'Spin-Off','41','$3,833,128,331','$93,490,935','1.61%'),(9,'Based on Folk Tale/Legend/Fairytale','78','$3,406,118,495','$43,668,186','1.43%'),(10,'Based on Play','271','$2,111,190,923','$7,790,372','0.89%');
/*!40000 ALTER TABLE `top_grossing_sources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_production_methods`
--

DROP TABLE IF EXISTS `top_production_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `top_production_methods` (
  `RANK` int DEFAULT NULL,
  `PRODUCTION METHODS` text,
  `MOVIES` text,
  `TOTAL GROSS` text,
  `AVERAGE GROSS` text,
  `MARKET SHARE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_production_methods`
--

LOCK TABLES `top_production_methods` WRITE;
/*!40000 ALTER TABLE `top_production_methods` DISABLE KEYS */;
INSERT INTO `top_production_methods` VALUES (1,'Live Action','14,613','$179,637,201,848','$12,292,972','75.56%'),(2,'Animation/Live Action','264','$30,346,622,254','$114,949,327','12.76%'),(3,'Digital Animation','365','$23,920,180,508','$65,534,741','10.06%'),(4,'Hand Animation','164','$2,960,497,487','$18,051,814','1.25%'),(5,'Stop-Motion Animation','37','$676,490,120','$18,283,517','0.28%'),(6,'Multiple Production Methods','26','$43,728,300','$1,681,858','0.02%'),(7,'Rotoscoping','4','$8,468,385','$2,117,096','0.00%');
/*!40000 ALTER TABLE `top_production_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wide_releases_count`
--

DROP TABLE IF EXISTS `wide_releases_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wide_releases_count` (
  `YEAR` int DEFAULT NULL,
  `WARNER BROS` int DEFAULT NULL,
  `WALT DISNEY` int DEFAULT NULL,
  `20TH CENTURY FOX` int DEFAULT NULL,
  `PARAMOUNT PICTURES` int DEFAULT NULL,
  `SONY PICTURES` int DEFAULT NULL,
  `UNIVERSAL` int DEFAULT NULL,
  `TOTAL MAJOR 6` int DEFAULT NULL,
  `TOTAL OTHER STUDIOS` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wide_releases_count`
--

LOCK TABLES `wide_releases_count` WRITE;
/*!40000 ALTER TABLE `wide_releases_count` DISABLE KEYS */;
INSERT INTO `wide_releases_count` VALUES (2021,17,7,0,4,16,17,61,38),(2020,5,3,1,3,9,13,34,23),(2019,18,10,11,9,18,21,87,44),(2018,19,10,11,10,16,20,86,58),(2017,18,8,14,10,16,15,81,50),(2016,17,12,16,12,16,22,95,46),(2015,22,11,18,9,13,20,93,33),(2014,17,12,17,10,17,15,88,37),(2013,17,8,15,8,14,16,78,42),(2012,16,11,15,13,18,17,90,42),(2011,20,13,15,13,21,19,101,35),(2010,20,12,18,12,17,17,96,30),(2009,25,14,20,10,21,21,111,30),(2008,19,11,22,14,19,19,104,48),(2007,30,13,17,16,22,20,118,50),(2006,26,17,25,13,26,21,128,31),(2005,20,20,19,12,19,17,107,30),(2004,27,25,18,14,15,14,113,25),(2003,28,19,13,14,19,13,106,23),(2002,32,23,15,16,20,13,119,21),(2001,30,16,16,14,17,10,103,25),(2000,29,22,13,12,15,13,104,27),(1999,27,20,15,13,22,16,113,19),(1998,27,21,11,11,20,16,106,20),(1997,31,22,12,16,22,11,114,22),(1996,31,23,13,16,24,13,120,22),(1995,27,22,11,12,20,17,109,27);
/*!40000 ALTER TABLE `wide_releases_count` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-28  2:23:55
