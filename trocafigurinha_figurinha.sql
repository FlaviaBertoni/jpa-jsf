CREATE DATABASE  IF NOT EXISTS `trocafigurinha` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `trocafigurinha`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: trocafigurinha
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

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
-- Table structure for table `figurinha`
--

DROP TABLE IF EXISTS `figurinha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `figurinha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `grupo` varchar(45) DEFAULT NULL,
  `album_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `album_id` (`album_id`),
  CONSTRAINT `figurinha_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=813 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `figurinha`
--

LOCK TABLES `figurinha` WRITE;
/*!40000 ALTER TABLE `figurinha` DISABLE KEYS */;
INSERT INTO `figurinha` VALUES (1,'0','Troféu','Basileirão',1),(2,'1',' Victor ',' Atlético Mineiro',1),(3,'2',' Marcos Rocha ',' Atlético Mineiro',1),(4,'3',' Jemerson ',' Atlético Mineiro',1),(63,'63',' Roger ',' Chapecoense',1),(64,'64',' Wiliam Barbio ',' Chapecoense',1),(65,'65',' Cássio ',' Corinthians',1),(67,'67',' Edu Dracena ',' Corinthians',1),(69,'69',' Gil ',' Corinthians',1),(71,'71',' Cristian ',' Corinthians',1),(72,'72',' Danilo ',' Corinthians',1),(73,'73',' Elias ',' Corinthians',1),(75,'75',' Ralf ',' Corinthians',1),(76,'76',' Renato Augusto ',' Corinthians',1),(77,'77',' Luciano ',' Corinthians',1),(78,'78',' Malcom ',' Corinthians',1),(79,'79',' Mendoza ',' Corinthians',1),(81,'81',' Vaná ',' Coritiba',1),(83,'83',' Norberto ',' Coritiba',1),(84,'84',' Bonfim ',' Coritiba',1),(85,'85',' Luccas Claro ',' Coritiba',1),(86,'86',' Walisson Maia ',' Coritiba',1),(87,'87',' Carlinhos ',' Coritiba',1),(88,'88',' Alan Santos ',' Coritiba',1),(89,'89',' Cáceres ',' Coritiba',1),(90,'90',' Helder ',' Coritiba',1),(91,'91',' João Paulo ',' Coritiba',1),(92,'92',' Rosinei ',' Coritiba',1),(93,'93',' Thiago Galhardo ',' Coritiba',1),(94,'94',' Negueba ',' Coritiba',1),(95,'95',' Rafhael Lucas ',' Coritiba',1),(96,'96',' Keirrison ',' Coritiba',1),(97,'97',' Fábio ',' Cruzeiro',1),(99,'99',' Ceará ',' Cruzeiro',1),(100,'100',' Léo ',' Cruzeiro',1),(101,'101',' Manoel ',' Cruzeiro',1),(186,'186',' Maicon ',' Grêmio',1),(187,'187',' Maxi Rodríguez ',' Grêmio',1),(188,'188',' Walace ',' Grêmio',1),(189,'189',' Braian ',' Grêmio',1),(190,'190',' Fernandinho ',' Grêmio',1),(191,'191',' Luan ',' Grêmio',1),(192,'192',' Mamute ',' Grêmio',1),(193,'193',' Alisson ',' Internacional',1),(194,'194',' William ',' Internacional',1),(195,'195',' Ernando ',' Internacional',1),(196,'196',' Juan ',' Internacional',1),(197,'197',' Réver ',' Internacional',1),(198,'198',' Geferson ',' Internacional',1),(199,'199',' Alex ',' Internacional',1),(200,'200',' Anderson ',' Internacional',1),(201,'201',' Aránguiz ',' Internacional',1),(202,'202',' D\'Alessandro ',' Internacional',1),(203,'203',' Rodrigo Dourado ',' Internacional',1),(204,'204',' Valdivia ',' Internacional',1),(205,'205',' Eduardo Sasha ',' Internacional',1),(206,'206',' Lisandro López ',' Internacional',1),(207,'207',' Nilmar ',' Internacional',1),(208,'208',' Rafael Moura ',' Internacional',1),(237,'237',' Dudu ',' Palmeiras',1),(238,'238',' Gabriel de Jesus ',' Palmeiras',1),(239,'239',' Lucas Barrios ',' Palmeiras',1),(240,'240',' Rafael Marques ',' Palmeiras',1),(268,'268',' Gabriel Barbosa ',' Santos',1),(269,'269',' Geuvânio ',' Santos',1),(270,'270',' Marcos Gabriel ',' Santos',1),(271,'271',' Neto Berola ',' Santos',1),(272,'272',' Ricardo Oliveira ',' Santos',1),(273,'273',' Denis ',' São Paulo',1),(274,'274',' Rogério Ceni ',' São Paulo',1),(275,'275',' Bruno ',' São Paulo',1),(276,'276',' Lucão ',' São Paulo',1),(277,'277',' Rafael Toloi ',' São Paulo',1),(278,'278',' Rodrigo Caio ',' São Paulo',1),(279,'279',' Carlinhos ',' São Paulo',1),(280,'280',' Boschilia ',' São Paulo',1),(281,'281',' Centurion ',' São Paulo',1),(456,'E16 ',' Escudo ',' Corinthians',1),(457,'E17 ',' Uniforme ',' Corinthians',1),(458,'E18 ',' Mascote ',' Corinthians',1),(459,'E19 ',' Bandeira ',' Corinthians',1),(460,'E20 ',' Escudo ',' Coritiba',1),(461,'E21 ',' Uniforme ',' Coritiba',1),(462,'E22 ',' Mascote ',' Coritiba',1),(463,'E23 ',' Bandeira ',' Coritiba',1),(464,'E24 ',' Escudo ',' Cruzeiro',1),(465,'E25 ',' Uniforme ',' Cruzeiro',1),(466,'E26 ',' Mascote ',' Cruzeiro',1),(467,'E27 ',' Bandeira ',' Cruzeiro',1),(468,'E28 ',' Escudo ',' Figueirense',1),(469,'E29 ',' Uniforme ',' Figueirense',1),(470,'E30 ',' Mascote ',' Figueirense',1),(471,'E31 ',' Bandeira ',' Figueirense',1),(472,'E32 ',' Escudo ',' Flamengo',1),(473,'E33 ',' Uniforme ',' Flamengo',1),(474,'E34 ',' Mascote ',' Flamengo',1),(475,'E35 ',' Bandeira ',' Flamengo',1),(476,'E36 ',' Escudo ',' Fluminense',1),(477,'E37 ',' Uniforme ',' Fluminense',1),(478,'E38 ',' Mascote ',' Fluminense',1),(479,'E39 ',' Bandeira ',' Fluminense',1),(480,'E40 ',' Escudo ',' Goiás',1),(481,'E41 ',' Uniforme ',' Goiás',1),(482,'E42 ',' Mascote ',' Goiás',1),(483,'E43 ',' Bandeira ',' Goiás',1),(484,'E44 ',' Escudo ',' Grêmio',1),(485,'E45 ',' Uniforme ',' Grêmio',1),(486,'E46 ',' Mascote ',' Grêmio',1),(487,'E47 ',' Bandeira ',' Grêmio',1),(488,'E48 ',' Escudo ',' Internacional',1),(489,'E49 ',' Uniforme ',' Internacional',1),(490,'E50 ',' Mascote ',' Internacional',1),(491,'E51 ',' Bandeira ',' Internacional',1),(492,'E52 ',' Escudo ',' Joinville',1),(493,'E53 ',' Uniforme ',' Joinville',1),(494,'E54 ',' Mascote ',' Joinville',1),(495,'E55 ',' Bandeira ',' Joinville',1),(496,'E56 ',' Escudo ',' Palmeiras',1),(497,'E57 ',' Uniforme ',' Palmeiras',1),(498,'E58 ',' Mascote ',' Palmeiras',1),(499,'E59 ',' Bandeira ',' Palmeiras',1),(500,'E60 ',' Escudo ',' Ponte Preta',1),(501,'E61 ',' Uniforme ',' Ponte Preta',1),(502,'E62 ',' Mascote ',' Ponte Preta',1),(503,'E63 ',' Bandeira ',' Ponte Preta',1),(504,'E64 ',' Escudo ',' Santos',1),(505,'E65 ',' Uniforme ',' Santos',1),(506,'E66 ',' Mascote ',' Santos',1),(507,'E67 ',' Bandeira ',' Santos',1),(508,'E68 ',' Escudo ',' São Paulo',1),(509,'E69 ',' Uniforme ',' São Paulo',1),(510,'E70 ',' Mascote ',' São Paulo',1),(511,'E71 ',' Bandeira ',' São Paulo',1),(512,'E72 ',' Escudo ',' Sport',1),(513,'E73 ',' Uniforme ',' Sport',1),(514,'E74 ',' Mascote ',' Sport',1),(515,'E75 ',' Bandeira ',' Sport',1),(516,'E76 ',' Escudo ',' Vasco',1),(517,'E77 ',' Uniforme ',' Vasco',1),(518,'E78 ',' Mascote ',' Vasco',1),(519,'E79 ',' Bandeira ',' Vasco',1),(520,'E80 ',' Escudo ',' ABC',1),(521,'E81 ',' Mascote ',' ABC',1),(600,'1','Mike',' ',3),(601,'2','Olaf',' ',3),(602,'3','Mickey',' ',3),(603,'4','Mickey Cl',' ',3),(604,'5','Mickey',' ',3),(605,'6','Mickey',' ',3),(606,'7','Mickey Fantasia',' ',3),(607,'8','Mickey Rockstar',' ',3),(608,'9','Mickey',' ',3),(609,'10','Mickey',' ',3),(610,'11','Pluto',' ',3),(611,'12','Minnie',' ',3),(612,'13','Mickey',' ',3),(613,'14',' Mickey',' ',3),(614,'15','Pato Donald',' ',3),(615,'16','Pluto',' ',3),(616,'17','Pato Donald',' ',3),(617,'18','Figment',' ',3),(618,'19','Branca de Neve',' ',3),(619,'20','Rainha M',' ',3),(620,'21','Grilo Falante',' ',3),(621,'22','Chapeleiro Maluco',' ',3),(622,'23','Coelho Branco',' ',3),(623,'24','Gato de Cheshire',' ',3),(624,'25','Gato de Cheshire',' ',3),(625,'26','Gato de Cheshire',' ',3),(626,'27','Chapeleiro Maluco',' ',3),(627,'28','Coelho Branco',' ',3),(628,'29','Peter Pan',' ',3),(629,'30','Tic Tac',' ',3),(630,'31','Capit',' ',3),(631,'32','Peter Pan',' ',3),(632,'33','Capit',' ',3),(633,'34','Aurora',' ',3),(634,'35','Aurora',' ',3),(635,'36','Aurora',' ',3),(636,'37','Cruella De Vil',' ',3),(637,'38','Cruella De Vil',' ',3),(638,'39','Cruella De Vil',' ',3),(639,'40','Marie',' ',3),(640,'41','Marie',' ',3),(641,'42','Marie',' ',3),(642,'43','Sebasti',' ',3),(643,'44','Zip',' ',3),(644,'45','Bela',' ',3),(645,'46','Bela',' ',3),(646,'47','Bela',' ',3),(647,'48','Jafar',' ',3),(648,'49','Iago',' ',3),(649,'50','Jack',' ',3),(650,'51','Jack',' ',3),(651,'52','Jack',' ',3),(652,'53','Simba',' ',3),(653,'54','Simba',' ',3),(654,'55','Simba',' ',3),(655,'56','Simba',' ',3),(656,'57','Simba',' ',3),(657,'58','Alien',' ',3),(658,'59','Imperador Zurg',' ',3),(659,'60','Imperador Zurg',' ',3),(660,'61','Lotso',' ',3),(661,'62','Lotso',' ',3),(662,'63','Rex',' ',3),(663,'64','Alien',' ',3),(664,'65','Alien',' ',3),(665,'66','Imperador Zurg',' ',3),(666,'67','Sid',' ',3),(667,'68','Lotso',' ',3),(668,'69','Rex',' ',3),(669,'70','Rex',' ',3),(670,'71','Sargento',' ',3),(671,'72','Sargento',' ',3),(672,'73','Sargento',' ',3),(673,'74','Mulan',' ',3),(674,'75','Mulan',' ',3),(675,'76','Mulan',' ',3),(676,'77','Mushu',' ',3),(799,'A56','Barba Negra',' ',3),(800,'A57','Kermit, o Sapo',' ',3),(801,'A58','Merida',' ',3),(802,'A59','Sparky',' ',3),(803,'A60','Olaf',' ',3),(804,'001',NULL,NULL,2),(805,'002',NULL,NULL,2),(806,'003',NULL,NULL,2),(807,'004',NULL,NULL,2),(808,'005',NULL,NULL,2),(809,'006',NULL,NULL,2),(810,'007',NULL,NULL,2),(811,'008',NULL,NULL,2),(812,'009',NULL,NULL,2);
/*!40000 ALTER TABLE `figurinha` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-14  9:48:19
