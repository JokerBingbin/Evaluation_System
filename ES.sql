/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.50-log : Database - evaluation_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`evaluation_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `evaluation_system`;

/*Table structure for table `classinfo` */

DROP TABLE IF EXISTS `classinfo`;

CREATE TABLE `classinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Subject` varchar(32) NOT NULL,
  `Grade` varchar(32) NOT NULL,
  `TeacherName` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `科目` (`Subject`),
  KEY `老师名称` (`TeacherName`),
  KEY `年级` (`Grade`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `classinfo` */

insert  into `classinfo`(`id`,`Name`,`Subject`,`Grade`,`TeacherName`) values (1,'小升初1班','数学','六年级','张瑞'),(2,'中考数学冲刺班','数学','九年级','张瑞');

/*Table structure for table `exam` */

DROP TABLE IF EXISTS `exam`;

CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classID` int(11) NOT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classID` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `exam` */

insert  into `exam`(`id`,`name`,`classID`,`time`) values (1,'第一次月考',1,'2021-02-08');

/*Table structure for table `exam_ability` */

DROP TABLE IF EXISTS `exam_ability`;

CREATE TABLE `exam_ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `exam_ability` */

insert  into `exam_ability`(`id`,`examId`,`name`,`score`) values (1,1,'基础知识',12),(2,1,'基础运算',18),(3,1,'综合运算',36),(4,1,'分析判断',8),(5,1,'阅读理解',24),(6,1,'综合运用',2);

/*Table structure for table `exam_diff` */

DROP TABLE IF EXISTS `exam_diff`;

CREATE TABLE `exam_diff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `exam_diff` */

insert  into `exam_diff`(`id`,`examId`,`name`,`score`) values (1,1,'基础题',38),(2,1,'中档题',38),(3,1,'较难题',24);

/*Table structure for table `exam_scope` */

DROP TABLE IF EXISTS `exam_scope`;

CREATE TABLE `exam_scope` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `exam_scope` */

insert  into `exam_scope`(`id`,`examId`,`name`,`score`) values (1,1,'数的认识',6),(2,1,'数的运算',34),(3,1,'比和比例',6),(4,1,'数学思考',2),(5,1,'图像与几何',18),(6,1,'式和方程',26),(7,1,'综合运用',8);

/*Table structure for table `exam_type` */

DROP TABLE IF EXISTS `exam_type`;

CREATE TABLE `exam_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `exam_type` */

insert  into `exam_type`(`id`,`examId`,`name`,`score`) values (1,1,'选择题',12),(2,1,'填空题',12),(3,1,'解答题',76);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`id`,`name`) values (1,'六年级'),(2,'七年级'),(3,'八年级'),(4,'九年级');

/*Table structure for table `question_ability` */

DROP TABLE IF EXISTS `question_ability`;

CREATE TABLE `question_ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SubjectId` (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `question_ability` */

insert  into `question_ability`(`id`,`name`,`subjectId`,`gradeId`) values (1,'基础知识',2,1),(2,'基础运算',2,1),(3,'综合运算',2,1),(4,'分析判断',2,1),(5,'阅读理解',2,1),(6,'综合运用',2,1);

/*Table structure for table `question_difficulty` */

DROP TABLE IF EXISTS `question_difficulty`;

CREATE TABLE `question_difficulty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diff` varchar(32) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `question_difficulty` */

insert  into `question_difficulty`(`id`,`diff`,`subjectId`,`gradeId`) values (1,'基础题',2,1),(5,'中档题',2,1),(6,'较难题',2,1);

/*Table structure for table `question_info` */

DROP TABLE IF EXISTS `question_info`;

CREATE TABLE `question_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `qustionId` int(11) NOT NULL,
  `score` float NOT NULL,
  `point` varchar(32) NOT NULL,
  `difficulty` varchar(32) NOT NULL,
  `ability` varchar(32) NOT NULL,
  `scope` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `question_info` */

insert  into `question_info`(`id`,`examId`,`qustionId`,`score`,`point`,`difficulty`,`ability`,`scope`,`type`) values (1,1,1,2,'比和分数除法的关系','基础题','基础运算','比和比例','填空题'),(2,1,2,2,'数的改写','基础题','基础知识','数的运算','填空题'),(3,1,3,2,'比例尺的应用','基础题','基础知识','比和比例','填空题'),(4,1,4,2,'圆柱的周长','基础题','综合运算','图像与几何','填空题'),(5,1,5,2,'长方体正方体体积','基础题','综合运算','图像与几何','填空题'),(6,1,6,2,'简单周期找规律','中档题','分析判断','数学思考','填空题'),(7,1,7,2,'比的意义','基础题','基础运算','比和比例','选择题'),(8,1,8,2,'最简分数','基础题','基础运算','数的认识','选择题'),(9,1,9,2,'分数大小比较','基础题','综合运算','数的认识','选择题'),(10,1,10,2,'有理数的乘方','中档题','综合运算','数的运算','选择题'),(11,1,11,2,'面积大小比较','基础题','综合运用','图像与几何','选择题'),(12,1,12,2,'三角形的度数','基础题','综合运算','数的认识','选择题'),(13,1,13,12,'计算','基础题','基础运算','数的运算','解答题'),(14,1,14,10,'计算','较难题','综合运算','数的运算','解答题'),(15,1,15,10,'分数四则运算','中档题','综合运算','式和方程','解答题'),(16,1,16,6,'图像与计算','基础题','分析判断','图像与几何','解答题'),(17,1,17,6,'图像与计算','较难题','综合运算','图像与几何','解答题'),(18,1,18,8,'分数四则运算','中档题','基础知识','数的运算','解答题'),(19,1,19,8,'形成问题','中档题','阅读理解','式和方程','解答题'),(20,1,20,8,'圆柱的特征','中档题','阅读理解','式和方程','解答题'),(21,1,21,8,'商品利润问题','较难题','阅读理解','综合运用','解答题');

/*Table structure for table `question_scope` */

DROP TABLE IF EXISTS `question_scope`;

CREATE TABLE `question_scope` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `SubjectId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `SubjectId` (`SubjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='考试范围';

/*Data for the table `question_scope` */

insert  into `question_scope`(`id`,`name`,`SubjectId`,`gradeId`) values (1,'数的认识',2,1),(2,'数的运算',2,1),(3,'比和比例',2,1),(4,'数学思考',2,1),(5,'图形与几何',2,1),(6,'式和方程',2,1),(7,'综合运用',2,1);

/*Table structure for table `question_score` */

DROP TABLE IF EXISTS `question_score`;

CREATE TABLE `question_score` (
  `examId` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `score` float NOT NULL,
  KEY `examId` (`examId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question_score` */

/*Table structure for table `question_type` */

DROP TABLE IF EXISTS `question_type`;

CREATE TABLE `question_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Qtype` varchar(32) NOT NULL,
  `sujectId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `examId` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `question_type` */

insert  into `question_type`(`id`,`Qtype`,`sujectId`,`gradeId`) values (1,'选择题',2,1),(2,'填空题',2,1),(3,'解答题',2,1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `classId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_ibfk_1` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`classId`) values (1,'丸子',1),(2,'林玥',1),(3,'卡卡罗特',1),(4,'贝吉塔',1),(5,'库里',2),(6,'欧文',2);

/*Table structure for table `student_ability` */

DROP TABLE IF EXISTS `student_ability`;

CREATE TABLE `student_ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `student_ability` */

insert  into `student_ability`(`id`,`examId`,`studentId`,`name`,`score`) values (31,1,1,'基础知识',12),(32,1,1,'基础运算',18),(33,1,1,'综合运算',36),(34,1,1,'分析判断',8),(35,1,1,'阅读理解',24),(36,1,1,'综合运用',2),(37,1,2,'基础知识',10),(38,1,2,'基础运算',18),(39,1,2,'综合运算',32),(40,1,2,'分析判断',8),(41,1,2,'阅读理解',16),(42,1,2,'综合运用',2);

/*Table structure for table `student_diff` */

DROP TABLE IF EXISTS `student_diff`;

CREATE TABLE `student_diff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `student_diff` */

insert  into `student_diff`(`id`,`examId`,`studentId`,`name`,`score`) values (16,1,1,'基础题',38),(17,1,1,'中档题',38),(18,1,1,'较难题',24),(19,1,2,'基础题',38),(20,1,2,'中档题',26),(21,1,2,'较难题',22);

/*Table structure for table `student_scope` */

DROP TABLE IF EXISTS `student_scope`;

CREATE TABLE `student_scope` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

/*Data for the table `student_scope` */

insert  into `student_scope`(`id`,`examId`,`studentId`,`name`,`score`) values (36,1,1,'数的认识',6),(37,1,1,'数的运算',34),(38,1,1,'比和比例',6),(39,1,1,'数学思考',2),(40,1,1,'图像与几何',18),(41,1,1,'式和方程',26),(42,1,1,'综合运用',8),(43,1,2,'数的认识',6),(44,1,2,'数的运算',32),(45,1,2,'比和比例',6),(46,1,2,'数学思考',2),(47,1,2,'图像与几何',16),(48,1,2,'式和方程',16),(49,1,2,'综合运用',8);

/*Table structure for table `student_score` */

DROP TABLE IF EXISTS `student_score`;

CREATE TABLE `student_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `questionNum` int(11) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

/*Data for the table `student_score` */

insert  into `student_score`(`id`,`examId`,`studentId`,`questionNum`,`score`) values (114,1,1,1,2),(115,1,1,2,2),(116,1,1,3,2),(117,1,1,4,2),(118,1,1,5,2),(119,1,1,6,2),(120,1,1,7,2),(121,1,1,8,2),(122,1,1,9,2),(123,1,1,10,2),(124,1,1,11,2),(125,1,1,12,2),(126,1,1,13,12),(127,1,1,14,10),(128,1,1,15,10),(129,1,1,16,6),(130,1,1,17,6),(131,1,1,18,8),(132,1,1,19,8),(133,1,1,20,8),(134,1,1,21,8),(135,1,2,1,2),(136,1,2,2,2),(137,1,2,3,2),(138,1,2,4,2),(139,1,2,5,2),(140,1,2,6,2),(141,1,2,7,2),(142,1,2,8,2),(143,1,2,9,2),(144,1,2,10,2),(145,1,2,11,2),(146,1,2,12,2),(147,1,2,13,12),(148,1,2,14,10),(149,1,2,15,8),(150,1,2,16,6),(151,1,2,17,4),(152,1,2,18,6),(153,1,2,19,0),(154,1,2,20,8),(155,1,2,21,8);

/*Table structure for table `student_score_write` */

DROP TABLE IF EXISTS `student_score_write`;

CREATE TABLE `student_score_write` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `isWrite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `student_score_write` */

insert  into `student_score_write`(`id`,`examId`,`studentId`,`isWrite`) values (1,1,1,1),(2,1,2,1),(3,1,3,0),(4,1,4,0);

/*Table structure for table `student_type` */

DROP TABLE IF EXISTS `student_type`;

CREATE TABLE `student_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `student_type` */

insert  into `student_type`(`id`,`examId`,`studentId`,`name`,`score`) values (16,1,1,'选择题',12),(17,1,1,'填空题',12),(18,1,1,'解答题',76),(19,1,2,'选择题',12),(20,1,2,'填空题',12),(21,1,2,'解答题',62);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `subject` */

insert  into `subject`(`id`,`name`) values (1,'语文'),(2,'数学'),(3,'英语'),(4,'物理'),(5,'化学');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `power` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`name`,`power`) values (1,'root','admin','张瑞',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
