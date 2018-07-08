-- drop database if exists example_docker_db;
-- create database example_docker_db;
USE `tmdt`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tmdt
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `bai_hoc`
--

DROP TABLE IF EXISTS `bai_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bai_hoc` (
  `ma_bai_hoc` varchar(50) NOT NULL,
  `tieu_de` varchar(100) DEFAULT NULL,
  `noi_dung` text,
  `ma_chuong_muc` varchar(50) DEFAULT NULL,
  `luot_xem` int(11) DEFAULT '0',
  PRIMARY KEY (`ma_bai_hoc`),
  KEY `fk_bai_hoc_chuong_muc_idx` (`ma_chuong_muc`),
  CONSTRAINT `fk_bai_hoc_chuong_muc` FOREIGN KEY (`ma_chuong_muc`) REFERENCES `chuong_muc` (`ma_chuong_muc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_hoc`
--

LOCK TABLES `bai_hoc` WRITE;
/*!40000 ALTER TABLE `bai_hoc` DISABLE KEYS */;
INSERT INTO `bai_hoc` VALUES ('KH19CH12BH25','Bài 1- Cài đặt Laravel','1oziJ0ZOnfSamXVcdqoxfFxqkFzNVQY7I','KH19CH12',0),('KH19CH12BH26','Bài 2- Route','1NFLmxLQjqCF1h63SEysIDSWcMsXTGjF2','KH19CH12',0),('KH19CH12BH27','Bài 3- Quản lý cơ sở dữ liệu với Migrate','1KouLZZ2Kg7jDkZA2jkFZo_Rs9Ec9hCQr','KH19CH12',0),('KH19CH12BH28','Bài 4- Truy vấn dữ liệu với Model','1e1VwmXkuPC7a5cfbplu3Rtte0KzvrRu9','KH19CH12',0),('KH19CH12BH29','Bài 5- Xây dựng ResfullController 1','1KZa6kI1rezuBYjXFEoNXorAX9mgBYHzO','KH19CH12',0),('KH19CH12BH30','Bài 6- RestfulController 2','1VbkCP7z1MmGbP2cLkiWvF3ejDoDGD_81','KH19CH12',0),('KH19CH12BH31','Bài 7-  RestfulController 3','1lnvbs3lCeDa3CJxUjOdSyupECmE2hmbJ','KH19CH12',0),('KH19CH13BH32','Bài 2_ Thiết kế layout màn hình thêm sản phẩm','127BnjgFsXB1l4oyDyMRb4JaZfjHMDlZp','KH19CH13',0),('KH19CH13BH33','Bài 4_ Tạo class SanPham và SanPhamAdapter','1xs1VVRwDh2kJgny3L9HtYOA5UhTFmjXF','KH19CH13',0),('KH19CH13BH34','Bài 5_ Custom Adapter Listview','1mTqe2EqZRHocLPNZENUoPcMW9czB2P3E','KH19CH13',0),('KH19CH13BH35','Bài 6_ Lấy dữ liệu','1BC0SAVn8QdyavbIECxNanJUmsKpFBfbT','KH19CH13',0),('KH19CH13BH36','Bài 6_ Lấy dữ liệu','1BC0SAVn8QdyavbIECxNanJUmsKpFBfbT','KH19CH13',0),('KH19CH13BH37','Bài 7_ Thiết kế layout và load chi tiết sản phẩm','1fTJeaP0rgJfjbPlrf4ydyzLM8iC-Nyav','KH19CH13',0),('KH19CH14BH38','Bài 4_  Màn hình danh sách sản phẩm','13e6ZADhR_FGs0_nkTvm3UhWdvIZ2NPUX','KH19CH14',0),('KH19CH14BH39','Bài 1_  Màn hình thêm sản phẩm','1o73V1qLjVIOjmNwh8bTa9NryakvGB5C3','KH19CH14',0),('KH19CH14BH40','Bài 2_  Thiết lập camera','1ivTpIJowlI-aalqEZrv-qk4lDipet-fB','KH19CH14',0),('KH19CH14BH41','Bài 3_  Thêm Sản Phẩm','1o64AcffNnhQr0D3HNX5Hvf2a1Xun3rpC','KH19CH14',0),('KH19CH14BH42','Bài 5_  Danh sách sản phẩm','1UhjPbRPy3qdQT2RmlhmGwFQUaBjli28o','KH19CH14',0),('KH19CH14BH43','Bài 6_  Chi tiết sản phẩm','1L1MXn13ae4-f0eAkQv2gTd6cxBXqhmSC','KH19CH14',0),('KH19CH14BH44','Bài 7_  Cập nhật sản phẩm','16O3X_fyvDL37sNzKHNybFn6TG1nwU3Q5','KH19CH14',0),('KH19CH14BH45','Bài 8_  Xoá sản phẩm','1V6yDj9mrR5d0oz2KsTn9c1q4nUY2wFA8','KH19CH14',0),('KH20CH15BH46','Bài 0_ Giới thiệu','1rN0BzD7K4fc3OWGeAVMNNn5UXgSgv2IX','KH20CH15',0),('KH20CH15BH47','Bài 1_  Cài đặt môi trường','1G5Zh5YjUl_VSaY0wPpvJRP7UQuYs70yd','KH20CH15',0),('KH20CH15BH48','Bài 2_  Tạo component','19VQRau_yK8K9oWA_jNYFyi_rmt2C0p6f','KH20CH15',0),('KH20CH15BH49','Bài 3_  Cài đặt react router','1QRGF-uz9vNGVWI-7nxZatfZWAuOjkN9Q','KH20CH15',0),('KH20CH15BH50','Bài 4_  Link và IndexLink','1UmFVkyjm9uskZIL6F1C22EPtou_rhbC0','KH20CH15',0),('KH20CH15BH51','Bài 5_  React router onEnter','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH20CH15',0),('KH20CH16BH52','Bài 6_  Giao diện đăng nhập','18TAtm0eyVYOO859jV7D-1ea-rH-JA_a2','KH20CH16',0),('KH20CH16BH53','Bài 7_  Giả lập đăng nhập -  đăng xuất','1Pz2_ED5ke0pDEHGP3XJHGIE6hb1fq6cF','KH20CH16',0),('KH20CH16BH54','Bài 8_  Module axios','1wC6tnbhVGiv14bL-8CoagSzHiD4zPe83','KH20CH16',0),('KH20CH16BH55','Bài 9_  Đăng nhập phía server với axios','1CaqTWQbhYnc-v4YxzFy3l1yfVdSssqsS','KH20CH16',0),('KH20CH16BH56','Bài 10_  Lưu phiên đăng nhập với express session','1eo0IsU1zBNid_ys8NiqEZmDWJ3ciyc8r','KH20CH16',0),('KH20CH17BH57','Bài 11_  Chức năng logout','1dNf6l2pGlz_HCV5LjWFomfPM7PSCY_bc','KH20CH17',0),('KH20CH17BH58','Bài 12_  Component Notification','1lbBT6l-XTo2fR3uPtXQPqTxNGOLOVaeI','KH20CH17',0),('KH20CH17BH59','Bài 13_  Cài đặt foundation css','11_bUdzozzYMAwhoc9KqWZBMP_g3VJKum','KH20CH17',0),('KH20CH17BH60','Bài 14_  Cài đặt foundation javascript','1tYVJEZ10D8QftaFkFS7kqo0dIPjcBXHc','KH20CH17',0),('KH20CH17BH61','Bài 15_  Đóng gói css với webpack','10HxHl9mT6ggAiGkFOZxAmBRbFmZSfgD5','KH20CH17',0),('KH20CH17BH62','Bài 16_ Làm việc với foundation scss','1UWrlSCCTBjsEHs2CVjgrslW6gpRVA8xf','KH20CH17',0),('KH21CH18BH63','Giới thiệu về Sass','1DEiMSez7YNdvZmsBWOo7Tevjt2wRe6CJ','KH21CH18',0),('KH21CH18BH64','Cài đặt Sass','1LcofcGrQY-S3qdrTZVKqUTL51ATX6gyw','KH21CH18',0),('KH21CH19BH65','Nested Rule','1RNYw5m09XlbZ63HIt5NunoJlEGqJb4zs','KH21CH19',0),('KH21CH19BH66','Variables','1jTN852FlXt48aElklRo1mpAFDSQ_z40_','KH21CH19',0),('KH21CH19BH67','Mixin','1tJ_DJ7E0kuaZa2gv0lac1rH4KOnGDcIR','KH21CH19',0),('KH21CH19BH68','Extend','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH19',0),('KH21CH19BH69','Placeholder Selectors','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH19',0),('KH21CH19BH70','Operations','1eUkhw1VujQi0ftQt_Dw6t_I8VYl1Fx52','KH21CH19',0),('KH21CH19BH71','Interpolations','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH19',0),('KH21CH20BH72','If trong Sass','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH20',0),('KH21CH20BH73','For trong Sass','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH20',0),('KH21CH20BH74','Each trong Sass','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH20',0),('KH21CH20BH75','While trong Sass','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH20',0),('KH21CH20BH76','Demomenu','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH21CH20',0),('KH22CH21BH77','Giới thiệu và bắt đầu tạo project','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH22CH21',0),('KH22CH22BH78','Mở camera, microphone và play local stream','1_1itwPG58uMQuvE6WDGy3UTm7ESLMmyQ','KH22CH22',0),('KH22CH22BH79','Kết nối với server PeerJS','1xtND5Qyw460oLDmGiGDyO3M4eokEZlaZ','KH22CH22',0),('KH22CH22BH80','Thực hiện cuộc gọi video giữa các client','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH22CH22',0),('KH22CH22BH81','Tạo server socket.io','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH22CH22',0),('KH22CH23BH82','Quản lý các user đang online','1smtYnfkkjBSVJkxzqVgZD3Opadn-lCtN','KH22CH23',0),('KH22CH23BH83','Hiển thị các user đang online','1TpB9g3BYbFzso1JuKjB5Uio5a_KZz9Vp','KH22CH23',0),('KH22CH24BH84','Bắt sự kiện ngắt kết nối','154VjrObfmhx4B2K45aud91xp-TuR1lxR','KH22CH24',0),('KH22CH24BH85','Thực hiện cuộc gọi bằng click','1Cj9WFLqBmrMRikQMDgKDM4eh2u4-Rpue','KH22CH24',0),('KH22CH24BH86','Deploy ứng dụng lên github và heroku','1INEi6NShlCsTECTeFfhrleBqrJfwqYTg','KH22CH24',0),('KH22CH24BH87','Clone server PeerJS lên heroku','1_F9DSC7S98r-0LApR3OTAqOzxX2v9NPQ','KH22CH24',0),('KH22CH24BH88','Tích hợp server TURN','19oxq2wezZ5tA8suWGGhzRMIs9SprwNwL','KH22CH24',0),('KH23CH25BH89','Lập trình TypeScript - Bài 1 Xin chào TypeScript','1LCyeKvjkBzTE0JBIzHsCszXC48Ph8rbO','KH23CH25',0),('KH23CH25BH90','Lập trình TypeScript - Bài 2 Xin chào','1ue2GJfAG8Ne_q6wV52m7QiGGueWzZfbR','KH23CH25',0),('KH23CH25BH91','Lập trình TypeScript - Bài 3 Xin chào TypeScript','1BtsQRLHq9DYy7E2edXnOVCQ1rpqIe0jJ','KH23CH25',0),('KH23CH25BH92','Lập trình TypeScript - Bài 4 Xin chào TypeScript','1YR4atSJMJhUP-4hPk5SmRmyDUnu2pOKa','KH23CH25',0),('KH23CH25BH93','Lập trình TypeScript - Bài 5 Xin chào TypeScript','1u8N0_lS9rS8kjFEpMDEMJ8swBu50frra','KH23CH25',0),('KH23CH25BH94','Lập trình TypeScript - Bài 6 Variable & Data Type','18SxXhA5UJrraxFNAHNOmSFfmvYOwpXAQ','KH23CH25',0),('KH23CH25BH95','Lập trình TypeScript - Bài 7 Variable & Data Type - Array - ','1KP-ZkJ1EbUtLBFH1_SWeyqQRGJvhRNbE','KH23CH25',0),('KH23CH25BH96','Lập trình TypeScript - Bài 8 Variable & Data Type','1krrh9NHHPXcCWtyH0nwoMVo5AU0fNcbt','KH23CH25',0),('KH23CH25BH97','Lập trình TypeScript - Bài 9 Variable & Data Type ','1xKEm5w1RJwt0jD_S697VM5lOFfwAGg5p','KH23CH25',0),('KH23CH26BH100','Lập trình TypeScript - Bài 12 Variable & Data Type ','1vI_d82kq7vLF5onlWzGdQR7tE3-ZdQaY','KH23CH26',0),('KH23CH26BH101','Lập trình TypeScript - Bài 13 Variable & Data Type - Interface object','1tNDtMECKxLq-SHI0rUDi33jDNwwPEuPn','KH23CH26',0),('KH23CH26BH102','Lập trình TypeScript - Bài 14 Variable & Data Type - Interface array','1ey0AHp4sc63TDmn7-yJQ0IpsZfKZGz73','KH23CH26',0),('KH23CH26BH98','Lập trình TypeScript - Bài 10 Variable & Data Type','1ePIesnbdzQsEbvvz718dAA-mQnGsJCrK','KH23CH26',0),('KH23CH26BH99','Lập trình TypeScript - Bài 11 Variable & Data Type - Void','1rT-q22Y9qc70VumqDMtiCzR1m9lrYFaX','KH23CH26',0),('KH23CH27BH103','Lập trình TypeScript - Bài 15 Functions - return','17teGZ3AGfEcr35NYPAAjQyZhjkHWBlwE','KH23CH27',0),('KH23CH27BH104','Lập trình TypeScript - Bài 16 Functions - Param 01 ','1oAQh1ECy-Z7x4KVAQw9mWndZWk5t9_Kc','KH23CH27',0),('KH23CH27BH105','Lập trình TypeScript - Bài 17 Functions - Param 02','1JCwKu2UYZxu2twAi7faOIa0-KaFJPrGF','KH23CH27',0),('KH23CH27BH106','Lập trình TypeScript - Bài 18 Functions - Rest params','1dQHnr74sXp50iFSfSdwwpbhSZz7ZJl9C','KH23CH27',0),('KH23CH27BH107','Lập trình TypeScript - Bài 19 Functions - Function types','1CPBp-UyG3yLtlf9ROgrLSm9_KHMO-X72','KH23CH27',0),('KH23CH28BH108','Lập trình TypeScript - Bài 20 Functions - Arrow Functions','1ytpA2bfy3y2HpAUFk3sZDPfLg46Ue0xE','KH23CH28',0),('KH23CH28BH109','Lập trình TypeScript - Bài 21 Functions - Overload','18hd-xhRvREl_NYGh9aeZnyFgh63UpNpY','KH23CH28',0),('KH23CH28BH110','Lập trình TypeScript - Bài 22 OOP - Class 01 ','1ydZfWTQV90uM5xwL6zte1KayFqfvuHf3','KH23CH28',0),('KH23CH28BH111','Lập trình TypeScript - Bài 23 OOP - Class 02 ','1TjTrKl4zgm6W6fSTrJO6FrppdqfEXrkf','KH23CH28',0),('KH23CH29BH112','Lập trình TypeScript - Bài 24 OOP - Static','1tuwi0DYcVjKSYVhpEx37dL1dGwd-d-ZV','KH23CH29',0),('KH23CH29BH113','Lập trình TypeScript - Bài 25 OOP - Inheritance ','1DEG4NZjpoKnfuHi95JvjZXgiGVDzhwxH','KH23CH29',0),('KH23CH29BH114','Lập trình TypeScript - Bài 27 OOP - Accessors','1N1sXpWLjmK6Kva7OvwMx5pB5W7DsJMFO','KH23CH29',0),('KH23CH29BH115','Lập trình TypeScript - Bài 28 OOP - Abstract','1lvjBGdbtDsQXZVwc2gdT7mEgjydylA1V','KH23CH29',0),('KH23CH29BH116','Lập trình TypeScript - Bài 29 OOP - Interface ','1GrmB0KYL-lpaJIX_dUnbNUtXcjaEq7Ni','KH23CH29',0),('KH23CH29BH117','Lập trình TypeScript - Bài 30 Generic - Basic','1M-buK3pwGVw8w72WLy54LVaaEihTlIoc','KH23CH29',0),('KH23CH29BH118','Lập trình TypeScript - Bài 31 Generic - Method','1kz70f-FbZYwPfGOW957BCcyJ4c0DfRxj','KH23CH29',0),('KH23CH29BH119','Lập trình TypeScript - Bài 32 Generic - Class','1UfWOz81dfO4bRO4XNoB0gtjjQGt3w69E','KH23CH29',0),('KH23CH30BH120','Lập trình TypeScript - Bài 33 Module & Namepace - Basic','1xrqh2AOmI1BGPvqnE2XSRLkEkJhxhl64','KH23CH30',0),('KH23CH30BH121','Lập trình TypeScript - Bài 34 Module & Namepace - Namespace ','1QJ1F-ju0swMyoTQ7o3JCHQYLNi-Up9DG','KH23CH30',0),('KH23CH30BH122','Lập trình TypeScript - Bài 35 Module & Namepace - Module 01','1HMJGXBaBM8MUwwBSGaAuKDBWRXcX-h2U','KH23CH30',0),('KH23CH30BH123','Lập trình TypeScript - Bài 36 Module & Namepace - Module 02','1UyvnlwAVaeCGeHysCCVfqnT1Rs3zHSTX','KH23CH30',0),('KH23CH30BH124','Lập trình TypeScript - Bài 37 Module & Namepace - Import Export ','1juh4wwedDQVtn5wJWA7E2T6opcsTQLtP','KH23CH30',0),('KH23CH30BH125','Lập trình TypeScript - Bài 38 Hệ thống kiến thức - Review chapter','1niFfobnNpP6WSRUXJ620XKvoCqG_w1bp','KH23CH30',0),('KH24CH31BH126','Lập trình Android A-Z – Bài 1- Tạo project','1aPMmFf6cgPifPnqHFSKPZmIZgqNkd2-d','KH24CH31',0),('KH24CH31BH127','Lập trình Android A-Z – Bài 2- Giới thiệu Android Studio','14j0PHbggKrJg8xPlShwdk5rY9_uix0iw','KH24CH31',0),('KH24CH31BH128','Lập trình Android A-Z – Bài 3- Ôn tập Java ','15S7Q6m-uxsQy4Tc_DxOr5xqCYU007SYi','KH24CH31',0),('KH24CH32BH129','Lập trình Android A-Z – Bài 4- Ôn tập Java - phần 2','1UwStS-kY0MAY_KkcRdqC33pbXeNAXqcW','KH24CH32',0),('KH24CH32BH130','Lập trình Android A-Z – Bài 5- Ôn tập Java - phần 3','1Pk2RD0LdgEA-FsbOEwP9QDPjlwIhY9iD','KH24CH32',0),('KH24CH32BH131','Lập trình Android A-Z – Bài 6- Ôn tập Java - phần 4 ','16tlj9YMWv71qaM_0aC5AQgqq--f8XV4g','KH24CH32',0),('KH24CH32BH132','Lập trình Android A-Z – Bài 7- Ôn tập Java - phần 5','1qdb1Uo7faW70eCU_DJVD1GUjkWJCh0Xq','KH24CH32',0),('KH24CH33BH133','Lập trình Android A-Z – Bài 8- Khái niệm View và ViewGroup','14EQJAqjXfbsUmTWcnLrBqzYbxumjSQ91','KH24CH33',0),('KH24CH33BH134','Lập trình Android A-Z – Bài 9- Linear Layout ','1xrcZdFyjQUWORwcfm870yzm-lyhZQQCY','KH24CH33',0),('KH24CH33BH135','Lập trình Android A-Z – Bài 10- Linear Layout với thuộc tính layout weight','1z8JQ4zUDszagwDGpMPuSCCnPtj7MZD7b','KH24CH33',0),('KH24CH33BH136','Lập trình Android A-Z – Bài 10- Linear Layout với thuộc tính layout weight','1z8JQ4zUDszagwDGpMPuSCCnPtj7MZD7b','KH24CH33',0),('KH24CH33BH137','Lập trình Android A-Z – Bài 10- Linear Layout với thuộc tính layout weight','1z8JQ4zUDszagwDGpMPuSCCnPtj7MZD7b','KH24CH33',0),('KH3CH5BH7','Giới thiệu khóa học','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH5',400),('KH3CH5BH8','Giới thiệu Visual C# 2010 và tạo chương trình Winform đầu tiên','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH5',700),('KH3CH5BH9','Thuộc tính của form và một số control cơ bản','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH5',500),('KH3CH6BH10','Kiểu dữ liệu đã tích hợp sẵn (built-in) trong C#','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH6',800),('KH3CH6BH11','Biến (variable) trong C#','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH6',700),('KH3CH6BH12','Các toán tử (operator) phổ biến trong C#','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH6',466),('KH3CH7BH13','Câu lệnh điều kiện if','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH7',560),('KH3CH7BH14','Câu lệnh điều kiện if - else','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH7',900),('KH3CH7BH15','Câu lệnh điều kiện if - else if','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH3CH7',1000),('KH4CH8BH16','Slide bài giảng C/C++ ','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH4CH8',400),('KH4CH8BH17','Source code C/C++ ','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH4CH8',1200),('KH4CH9BH18','Làm quen với cấu trúc C/C++','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH4CH9',400),('KH4CH9BH19','Các bài tập C/C++ cơ bản','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH4CH9',700),('KH4CH9BH20','Tìm hiểu cấu trúc if else và switch case','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH4CH9',1400),('KH5CH10BH21',' Giới thiệu công cụ JsBin','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH5CH10',400),('KH5CH10BH22','Hướng dẫn cách khai báo biến (Varriable)','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH5CH10',500),('KH5CH10BH23',' Hướng dẫn sử dụng thẻ Input ','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH5CH10',600),('KH6CH11BH24','Cài đặt chương trình và Tạo ứng dụng “Helloworld” đầu tiên','1yVKaEv4bxm1YYaj-Pk67r9xrrPHrK4au','KH6CH11',1000);
/*!40000 ALTER TABLE `bai_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_ma_bai_hoc_insert
before insert on bai_hoc for each row
begin 
declare v_new_ma_bai_hoc varchar(50) default null;
		select concat(new.ma_chuong_muc,concat('BH',( select cast(substring(b.ma_bai_hoc 
        from  position('BH' in b.ma_bai_hoc )+char_length('CH')) as unsigned)+1 as result from bai_hoc b order by result  desc limit 1)))into v_new_ma_bai_hoc from dual;
  set new.ma_bai_hoc=v_new_ma_bai_hoc;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `binh_luan`
--

DROP TABLE IF EXISTS `binh_luan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binh_luan` (
  `ma_binh_luan` int(11) NOT NULL AUTO_INCREMENT,
  `ma_bai_hoc` varchar(50) DEFAULT NULL,
  `ma_nguoi_dung` varchar(50) DEFAULT NULL,
  `noi_dung` text,
  `thoi_gian_binh_luan` datetime DEFAULT NULL,
  PRIMARY KEY (`ma_binh_luan`),
  KEY `fk_binh_luan_bai_hoc_idx` (`ma_bai_hoc`),
  KEY `fk_binh_luan_nguoi_dung_idx` (`ma_nguoi_dung`),
  CONSTRAINT `fk_binh_luan_bai_hoc` FOREIGN KEY (`ma_bai_hoc`) REFERENCES `bai_hoc` (`ma_bai_hoc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_binh_luan_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binh_luan`
--

LOCK TABLES `binh_luan` WRITE;
/*!40000 ALTER TABLE `binh_luan` DISABLE KEYS */;
/*!40000 ALTER TABLE `binh_luan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_thoi_gian_binh_luan_insert
before insert on binh_luan for each row
begin 
set new.thoi_gian_binh_luan = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `chu_de`
--

DROP TABLE IF EXISTS `chu_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chu_de` (
  `ma_chu_de` varchar(50) NOT NULL,
  `tieu_de` varchar(100) DEFAULT NULL,
  `mo_ta` text,
  `trang_thai` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ma_chu_de`),
  FULLTEXT KEY `ft_chu_de_mo_ta_tieu_de` (`tieu_de`,`mo_ta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chu_de`
--

LOCK TABLES `chu_de` WRITE;
/*!40000 ALTER TABLE `chu_de` DISABLE KEYS */;
INSERT INTO `chu_de` VALUES ('CD1','Lập trình căn bản','Lập trình căn bản cung cấp các khóa học cho các học viên với các kiến thức căn bản nhất',0),('CD10','React','Hướng dẫn lập trình React',1),('CD11','Angular','Hướng dẫn lập trình Angular',1),('CD12','Node.js','Hướng dẫn lập trình Node.js',1),('CD13','CSS','Hướng dẫn tạo những trang web kinh ngạc với CSS',1),('CD14','PHP','Hướng dẫn lập trình PHP',1),('CD15','HTML5','Hướng dẫn tạo trang web với HTML5',1),('CD16','Java','Hướng dẫn lập trình Java',1),('CD17','REST API','Hướng dẫn lập trình REST API',1),('CD18','Python','Hướng dẫn lập trình Python',1),('CD19','Unit Testing','Hướng dẫn Unit Testing',1),('CD2','Lập trình di động','Lập trình di động cung cấp các khóa học trên các nền tảng di động như android, IOS, Windowphone',1),('CD20','MySQL','Hướng dẫn lập trình MySQL',1),('CD21','SQL Server','Hướng dẫn lập trình SQL Server',1),('CD22','Oracle SQL','Hướng dẫn lập trình Oracle SQL',1),('CD23','Oracle Certification','Hướng dẫn Oracle Certification',1),('CD24','SQL','Hướng dẫn lập trình SQL',1),('CD25','Xamarin','Hướng dẫn lập trình Xamarin',1),('CD26','SQL','Hướng dẫn lập trình SQL',1),('CD27','C#','Hướng dẫn lập trình C#',1),('CD28','Data Analysis','Hướng dẫn Data Analysis',1),('CD29','Object Oriented Programming','Hướng dẫn lập trình hướng đối tượng',1),('CD3','Lập trình web','Hướng dẫn lập trình web',1),('CD30','Lập trình AngularJS','Lập trình AngularJS',1),('CD31','Đây là test','Đây là test',0),('CD32','Đây là test','Đây là test',0),('CD33','1','1',0),('CD34','1','1',0),('CD35','1','1',0),('CD36','Test','Test',1),('CD37','Test2','Test2',1),('CD38','Test','Test',1),('CD4','Lập trình game','Hướng dẫn lập trình game',1),('CD5','Lập trình mạng','Hướng dẫn lập trình mạng',1),('CD6','Lập trình nền tảng','Hướng dẫn lập trình nền tảng',1),('CD7','Lập trình phần mềm','Hướng dẫn lập trình phần mềm',1),('CD8','SEO','Hướng dẫn SEO',1),('CD9','JavaScript','Hướng dẫn lập trình JavaScript',1);
/*!40000 ALTER TABLE `chu_de` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_ch_de_insert
before insert on chu_de for each row
begin 
declare v_new_ma_chu_de varchar(50) default null;
select concat('CD',(select 1+(select count(*) from chu_de))) into v_new_ma_chu_de from dual;
/*
 if ma_nguoi_dung ton tai thi lay ma nguoi dung cuoi cung + 1
*/
if (select exists (select 1 from chu_de c where c.ma_chu_de =v_new_ma_chu_de)) then
		select (select substring(c.ma_chu_de from 3) +1 from chu_de c order by c.ma_chu_de desc limit 1) into v_new_ma_chu_de from dual;
    end if	;
set new.ma_chu_de=v_new_ma_chu_de;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `chuong_muc`
--

DROP TABLE IF EXISTS `chuong_muc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuong_muc` (
  `ma_chuong_muc` varchar(50) NOT NULL,
  `ma_khoa_hoc` varchar(50) DEFAULT NULL,
  `tieu_de` varchar(200) DEFAULT NULL,
  `noi_dung` varchar(200) DEFAULT NULL,
  `tom_tat` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ma_chuong_muc`),
  KEY `fk_chuong_muc_khoa_hoc_idx` (`ma_khoa_hoc`),
  CONSTRAINT `fk_chuong_muc_khoa_hoc` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuong_muc`
--

LOCK TABLES `chuong_muc` WRITE;
/*!40000 ALTER TABLE `chuong_muc` DISABLE KEYS */;
INSERT INTO `chuong_muc` VALUES ('KH19CH12','KH19','Phần 1','Tiếp cận với laravel','Tiếp cận với laravel'),('KH19CH13','KH19','Phần 2','Kiến thức nâng cao xử lý với laravel','Kiến thức nâng cao xử lý với laravel'),('KH19CH14','KH19','Phần 3','Tạo chức năng với laravel','Tạo chức năng với laravel'),('KH20CH15','KH20','Phần 1','Seri  5 bài học cơ bản đầu tiên','Seri  5 bài học cơ bản đầu tiên'),('KH20CH16','KH20','Phần 2','Seri 5 bài học nâng cao','Seri 5 bài học nâng cao'),('KH20CH17','KH20','Phần 3','Bộ bài học kết thúc chương trình ','Bộ bài học kết thúc chương trình '),('KH21CH18','KH21','Chương 1: Giới thiệu','Tổng quan về Sass','Giới thiệu và cài đặt Sass'),('KH21CH19','KH21','Sử dụng Sass','Sử dùng Sass để viết Css','Sử dụng Sass căn bản để viết nhanh Css'),('KH21CH20','KH21','SassScript','Sử dụng SassScript','Trở thành master Sass'),('KH22CH21','KH22','Giới thiệu','Giới thiệu WebRTC','Giới thiệu WebRTC và project mở đầu'),('KH22CH22','KH22','Bắt đầu WebRTC','Bắt đầu xây dựng WebRTC','Bắt đầu việc xây dựng 1 trang WebRTC real time'),('KH22CH23','KH22','Quản lý người dùng','Quản lý người dùng','Quản lý và hiển thị các user đang online'),('KH22CH24','KH22','Sự kiện và kết nối','Bắt sự kiện và deploy','Bắt sự kiện và bắt đầu deploy web'),('KH23CH25','KH23','Phần 1','Tổng quan về TS','Giới thiệu và cài đặt'),('KH23CH26','KH23','Phần 2 ','Cú pháp cơ bản','Làm quen với các cú pháp cơ bản của TS'),('KH23CH27','KH23','Phần 3','Lập trình hàm','Cú pháp lập trình hàm trong TS'),('KH23CH28','KH23','Phần 4','Lập trình hướng đối tượng trong TS','Làm quen với lập trình hướng đối tượng trong TS'),('KH23CH29','KH23','Phần 5','Hướng dẫn module','Hướng dẫn làm quen với module trong TS'),('KH23CH30','KH23','Phần 6','Tổng kết khóa học','Tổng kết khóa học'),('KH24CH31','KH24','Phần 1','Cài đặt môi trường','Cài đặt môi trường lập trình cho adroid'),('KH24CH32','KH24','Phần 2','Java cơ bản','Hệ thống kiến thức java để lập trình android'),('KH24CH33','KH24','Phần 3','Các thành phần cơ bản trong adroid','Giới thiệu các thành phần cơ bản trong android'),('KH3CH5','KH3','Làm quen với Visual Studio 2010','Làm quen với Visual Studio 2010','Làm quen với Visual Studio 2010'),('KH3CH6','KH3','Kiểu dữ liệu và biến','Kiểu dữ liệu và biến','Kiểu dữ liệu và biến'),('KH3CH7','KH3','Các câu lệnh điều kiện','Các câu lệnh điều kiện','Các câu lệnh điều kiện'),('KH4CH8','KH4','Source code và slide C/C++','Source code và slide C/C++','Source code và slide C/C++'),('KH4CH9','KH4','Làm quen với C/C++','Làm quen với C/C++','Làm quen với C/C++'),('KH5CH10','KH5','Giới thiệu Công Cụ JsBin','Giới thiệu Công Cụ JsBin','Giới thiệu Công Cụ JsBin'),('KH6CH11','KH6','Giới thiệu và cài đặt','Giới thiệu và cài đặt','Giới thiệu và cài đặt');
/*!40000 ALTER TABLE `chuong_muc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_ma_chuong_muc_insert
before insert on chuong_muc for each row
begin 
declare v_new_ma_chuong_muc varchar(50) default null;
select concat(new.ma_khoa_hoc,concat('CH',(select cast(substring(n.ma_chuong_muc from position('CH' in n.ma_chuong_muc)+char_length('CH')) as unsigned
)+1 as result from chuong_muc n order by result  desc  limit 1)))into v_new_ma_chuong_muc from dual;
    
set new.ma_chuong_muc=v_new_ma_chuong_muc;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `dang_ky_khoa_hoc`
--

DROP TABLE IF EXISTS `dang_ky_khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dang_ky_khoa_hoc` (
  `ma_nguoi_dung` varchar(50) NOT NULL,
  `ma_khoa_hoc` varchar(50) NOT NULL,
  `ngay_dang_ky` datetime DEFAULT NULL,
  PRIMARY KEY (`ma_nguoi_dung`,`ma_khoa_hoc`),
  KEY `fk_dang_ki_khoa_hoc_nguoi_dung_idx` (`ma_nguoi_dung`),
  KEY `fk_khoa_hoc_dang_ky_khoa_hoc_idx` (`ma_khoa_hoc`),
  CONSTRAINT `fk_khoa_hoc_dang_ky_khoa_hoc` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nguoi_dung_dang_ky_khoa_hoc` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dang_ky_khoa_hoc`
--

LOCK TABLES `dang_ky_khoa_hoc` WRITE;
/*!40000 ALTER TABLE `dang_ky_khoa_hoc` DISABLE KEYS */;
INSERT INTO `dang_ky_khoa_hoc` VALUES ('ND1','KH1','2018-01-02 14:42:07'),('ND1','KH2','2018-01-03 11:52:46'),('ND2','KH5','2018-01-02 14:42:24'),('ND4','KH5','2018-01-02 15:03:25');
/*!40000 ALTER TABLE `dang_ky_khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_ngay_dang_ky_insert
before insert on tmdt.dang_ky_khoa_hoc for each row
begin 
set new.ngay_dang_ky = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `dang_ky_xem_sau`
--

DROP TABLE IF EXISTS `dang_ky_xem_sau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dang_ky_xem_sau` (
  `ma_nguoi_dung` varchar(50) NOT NULL,
  `ma_khoa_hoc` varchar(50) NOT NULL,
  PRIMARY KEY (`ma_nguoi_dung`,`ma_khoa_hoc`),
  KEY `fk_dang_ky_xem_sau_khoa_hoc_idx` (`ma_khoa_hoc`),
  CONSTRAINT `fk_dang_ki_xem_sau_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dang_ky_xem_sau_khoa_hoc` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dang_ky_xem_sau`
--

LOCK TABLES `dang_ky_xem_sau` WRITE;
/*!40000 ALTER TABLE `dang_ky_xem_sau` DISABLE KEYS */;
INSERT INTO `dang_ky_xem_sau` VALUES ('ND1','KH1'),('ND2','KH1'),('ND1','KH2'),('ND2','KH2');
/*!40000 ALTER TABLE `dang_ky_xem_sau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dinh_kem_bai_hoc`
--

DROP TABLE IF EXISTS `dinh_kem_bai_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dinh_kem_bai_hoc` (
  `ma_dinh_kem_bai_hoc` int(11) NOT NULL AUTO_INCREMENT,
  `ma_bai_hoc` varchar(50) DEFAULT NULL,
  `noi_dung` text,
  `ngay_them` datetime DEFAULT NULL,
  PRIMARY KEY (`ma_dinh_kem_bai_hoc`),
  KEY `fk_dinh_kem_bai_hoc_bai_hoc_idx` (`ma_bai_hoc`),
  CONSTRAINT `fk_dinh_kem_bai_hoc_bai_hoc` FOREIGN KEY (`ma_bai_hoc`) REFERENCES `bai_hoc` (`ma_bai_hoc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dinh_kem_bai_hoc`
--

LOCK TABLES `dinh_kem_bai_hoc` WRITE;
/*!40000 ALTER TABLE `dinh_kem_bai_hoc` DISABLE KEYS */;
INSERT INTO `dinh_kem_bai_hoc` VALUES (9,'KH3CH5BH7','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:01'),(10,'KH3CH5BH8','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:01'),(11,'KH3CH5BH9','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:01'),(12,'KH3CH6BH10','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:02'),(13,'KH4CH8BH16','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:02'),(14,'KH4CH8BH17','https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','2017-12-19 15:37:02'),(15,'KH4CH9BH18','https://drive.google.com/uc?id=1uOMrAbYxL-y7qaBdhGH8320S7uGXEKA6','2017-12-20 17:23:47'),(16,'KH4CH9BH19','https://drive.google.com/uc?id=1uOMrAbYxL-y7qaBdhGH8320S7uGXEKA6','2017-12-20 17:23:47'),(17,'KH4CH9BH20','https://drive.google.com/uc?id=1uOMrAbYxL-y7qaBdhGH8320S7uGXEKA6','2017-12-20 17:23:47'),(18,'KH5CH10BH21','https://drive.google.com/uc?id=1uOMrAbYxL-y7qaBdhGH8320S7uGXEKA6','2017-12-20 17:23:47'),(19,'KH5CH10BH21','https://drive.google.com/uc?id=1qGdpMH8Eorl_S-ZdzeFqe4CBwlftj_B7','2017-12-20 17:23:47'),(20,'KH5CH10BH22','https://drive.google.com/uc?id=1qGdpMH8Eorl_S-ZdzeFqe4CBwlftj_B7','2017-12-20 17:23:47'),(25,'KH5CH10BH22','https://drive.google.com/uc?id=1qGdpMH8Eorl_S-ZdzeFqe4CBwlftj_B7','2017-12-20 17:22:02'),(28,'KH5CH10BH22','test','2018-01-04 12:43:24'),(29,'KH5CH10BH22','Test','2018-01-04 13:52:50'),(30,'KH19CH12BH25','https://drive.google.com/uc?id=1vDrHbHFnN0XYHEKN6yFh-b_2EPOSjEgX','2018-01-18 21:52:34'),(31,'KH19CH12BH27','https://drive.google.com/uc?id=1Sbjp-oy9gq1kV-GIraWfXKAL34zVHMnc','2018-01-18 21:53:42'),(32,'KH19CH12BH27','https://drive.google.com/uc?id=1OZVpiaIFTDUNO9xLhnezOOabCtZHkFvZ','2018-01-18 21:53:42'),(33,'KH19CH12BH27','https://drive.google.com/uc?id=1zFpb0w1CsdyOMV2FJCYbWjO_X4WubTsH','2018-01-18 21:53:42'),(34,'KH19CH12BH27','https://drive.google.com/uc?id=1UTWxKSvTEFelLyTJvJR-NoNM8NgSWwzJ','2018-01-18 21:53:42'),(35,'KH19CH12BH27','https://drive.google.com/uc?id=1EGw8GY8UzT51ymz69azVjuh_R7JldLkf','2018-01-18 21:53:42'),(36,'KH19CH12BH27','https://drive.google.com/uc?id=1VeLPC55i7ZQcfTaD4Bubdla0mZHEVdln','2018-01-18 21:53:42'),(37,'KH19CH14BH45','https://drive.google.com/uc?id=1PCR-6jsujBvSrVv4MDHDiyq4E8s6-h-d','2018-01-18 21:54:30'),(38,'KH19CH14BH45','https://drive.google.com/uc?id=1sZNEPJG1YipLzqdiEO-sev4WYV4TZ_F2','2018-01-18 21:54:30'),(39,'KH19CH14BH45','https://drive.google.com/uc?id=1keYp643j-h0YcrenhCAKWULbUc3-pErm','2018-01-18 21:54:30'),(40,'KH19CH14BH45','https://drive.google.com/uc?id=18z-1k3H0sLY2Eo55XLevQ3JbAKnUa5hC','2018-01-18 21:54:30'),(41,'KH23CH25BH89','https://drive.google.com/open?id=1i8BDDT0K6tFvn6mgHWxKEX4BThoeA-bz','2018-01-19 01:57:55'),(42,'KH23CH25BH90','https://drive.google.com/open?id=1i8BDDT0K6tFvn6mgHWxKEX4BThoeA-bz','2018-01-19 01:57:55'),(43,'KH23CH25BH91','https://drive.google.com/open?id=1i8BDDT0K6tFvn6mgHWxKEX4BThoeA-bz','2018-01-19 01:57:55'),(44,'KH23CH25BH92','https://drive.google.com/open?id=1i8BDDT0K6tFvn6mgHWxKEX4BThoeA-bz','2018-01-19 01:57:55'),(45,'KH24CH31BH126','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:02'),(46,'KH24CH31BH127','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(47,'KH24CH31BH128','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(48,'KH24CH32BH129','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(49,'KH24CH32BH130','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(50,'KH24CH32BH131','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(51,'KH24CH32BH132','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(52,'KH24CH33BH133','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(53,'KH24CH33BH134','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03'),(54,'KH24CH33BH135','https://drive.google.com/open?id=1oju51_4l_2nK-4iiwra4qULCcqcGX6X_','2018-01-19 02:04:03');
/*!40000 ALTER TABLE `dinh_kem_bai_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_dinh_kem_bai_hoc_ngay_them before insert on dinh_kem_bai_hoc
for each row
begin
set new.ngay_them = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_dinh_kem_bai_hoc_ngay_them_update before update on dinh_kem_bai_hoc
for each row
begin
	set  new.ngay_them = now() ;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `hinh_thuc_giao_dich`
--

DROP TABLE IF EXISTS `hinh_thuc_giao_dich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hinh_thuc_giao_dich` (
  `ma_hinh_thuc_giao_dich` varchar(50) NOT NULL,
  `ten_hinh_thuc_giao_dich` varchar(100) DEFAULT NULL,
  `mo_ta` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ma_hinh_thuc_giao_dich`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinh_thuc_giao_dich`
--

LOCK TABLES `hinh_thuc_giao_dich` WRITE;
/*!40000 ALTER TABLE `hinh_thuc_giao_dich` DISABLE KEYS */;
INSERT INTO `hinh_thuc_giao_dich` VALUES ('DN','donate','donate'),('MKH','mua khóa học','mua khóa học'),('NT','nạp tiền','nạp tiền');
/*!40000 ALTER TABLE `hinh_thuc_giao_dich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa_hoc`
--

DROP TABLE IF EXISTS `khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` varchar(50) NOT NULL,
  `tieu_de` varchar(200) DEFAULT NULL,
  `mo_ta` text,
  `ma_nguoi_dung` varchar(50) DEFAULT NULL COMMENT 'mã người dùng tạo ra khóa học',
  `ngay_tao` datetime DEFAULT NULL,
  `don_gia` int(11) DEFAULT NULL,
  `ma_loai_khoa_hoc` varchar(50) DEFAULT NULL,
  `id_admin_duyet` varchar(50) DEFAULT NULL COMMENT 'mã admin duyệt khóa học',
  `ma_chu_de` varchar(50) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0' COMMENT '0:chua duyet 1:duyet 2:khac',
  `ngay_duyet` datetime DEFAULT NULL,
  `luot_truy_cap` int(11) DEFAULT '0',
  `anh_dai_dien` varchar(200) DEFAULT NULL,
  `chi_tiet_khoa_hoc` text,
  PRIMARY KEY (`ma_khoa_hoc`),
  KEY `fk_khoa_hoc_chu_de_idx` (`ma_chu_de`),
  KEY `fk_khoa_hoc_loai_khoa_hoc_idx` (`ma_loai_khoa_hoc`),
  KEY `fk_khoa_hoc_nguoi_dung_idx` (`ma_nguoi_dung`),
  KEY `fk_khoa_hoc_nguoi_dung_duyet_idx` (`id_admin_duyet`),
  CONSTRAINT `fk_khoa_hoc_chu_de` FOREIGN KEY (`ma_chu_de`) REFERENCES `chu_de` (`ma_chu_de`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_khoa_hoc_loai_khoa_hoc` FOREIGN KEY (`ma_loai_khoa_hoc`) REFERENCES `loai_khoa_hoc` (`ma_loai_khoa_hoc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_khoa_hoc_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_khoa_hoc_nguoi_dung_duyet` FOREIGN KEY (`id_admin_duyet`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_hoc`
--

LOCK TABLES `khoa_hoc` WRITE;
/*!40000 ALTER TABLE `khoa_hoc` DISABLE KEYS */;
INSERT INTO `khoa_hoc` VALUES ('KH1','Lập trình Android','Lập trình Android từ căn bản đến nâng cao','ND1','2017-11-24 23:53:35',0,'CO','ND1','CD1',0,'2018-01-16 23:27:21',46,'',''),('KH10','Tạo ứng dụng GALLERY trên Android','Hệ điều hành Android hiện nay là một hệ điều hành có số lượng người dùng lớn, với\n các ưu điểm vượt trội của nó. Công nghệ càng phát triển, và dung lượng bộ nhớ trên các thiết bị Android ngày càng được mở rộng để đáp ứng tốt cho người dùng.','ND2','2017-12-09 14:41:16',0,'NCO','ND1','CD2',1,NULL,0,'https://drive.google.com/uc?id=19irqb2vz_7xTxJ4ePfRg3VQER-5ROx02','Sau khi hoàn thành khóa học các bạn có thể nắm được các kiến thức\n về Fragment, Tab, ViewPager, Content Provider… Và ngoài ra các bạn cũng sẽ biết được cách làm một ứng dụng Gallery đơn giản bằng các class trên. Ngoài ra các bạn có thể kết học\n ViewPager và Tab để làm ra một ứng dụng đọc báo hay tin tức chỉ với 1 cái vuốt nhẹ trên màn hình.'),('KH11','Front-End: Cốt lõi thiết kế website với HTML, CSS, JavaScript , Jquery, Responsive, Bootstrap, dàn layout từ Photoshop','Hiện nay, thiết kế website là rất cần thiết cho doanh nghiệp, website mang đến những thông tin cập nhật nhanh nhất về các dịch vụ của doanh nghiệp. Với sự phát triển của cơ sở\n hạ tầng, băng thông mạnh hơn hẳn, các phần mềm cũng dẫn chuyển sang nền tảng web.','ND2','2017-12-09 14:41:16',0,'NCO','ND1','CD3',1,NULL,0,'https://drive.google.com/uc?id=1cE8dHR4FOswwH0INT4S5db06ofMztEUN','Khoá học cũng mang đến cho các bạn những khái niệm cơ bản và quan trọng của các thẻ HTML, CSS, javascript, jquery,…, trong từng bài học, tôi cố gắng trình bày kèm theo nhiều ví dụ trực quan,\n một số layout dạng thực tế để các bạn dễ tiếp cận và vận dụng. Một trong những khái niệm và kỹ thuật quan trọng như boostrap web, responsive web là gì cũng được tôi trình bày và vận dụng trong khoá học này.'),('KH12','Lập trình ASP.NET MVC5 toàn tập qua dự án Web bán hàng','Đây là một trong những đề tài rất hot hiện nay nhờ vào sự hỗ\n trợ mạnh mẽ của Microsoft với ASP.NET cùng với mô hình lập trình kinh điển MVC, mà nay đã được Microsoft tích hợp và nâng cấp thành một framework với phiên bản thứ 5, hỗ trợ rất\n nhiều tính năng và tiện ích cho người lập trình.','ND1','2017-12-09 14:41:17',600,'CO','ND4','CD3',1,NULL,0,'https://drive.google.com/uc?id=1jYY66NPMAiEwerxafbKFrSsniWJcj0lo','Đây hứa hẹn\n sẽ là một sản phẩm cực kì có lợi cho các bạn học viên khi các bạn đi tìm việc làm. Các bạn sẽ có những sản phẩm thực tế để show cho nhà tuyển dụng để chứng minh khả năng của mình.'),('KH13','Làm dự án thực tế với ASP.NET MVC, WebAPI và AngularJS','Với một khóa học tổng hợp và chuyên sâu các kỹ năng cần thiết để làm\n dự án các bạn được học cả backend với C#, Entity Framework, các design pattern đồng thời cả những kiến thức frontend như Jquery, AngularJs.','ND4','2017-12-09 14:41:17',1000,'CO','ND2','CD3',1,NULL,0,'https://drive.google.com/uc?id=1NWoNxLYPHp5FzyIQ-X9h1YqtLl21tSEA','Với mong muốn tạo ra giá trị cao nhất cho các bạn khi tham gia khóa học này, mình đã cố gắng đưa những best practices\n vào dự án giúp các bạn dễ dàng thích nghi với môi trường công việc, dễ dàng mở rộng cũng như đáp ứng các nhu cầu khác nhau của khách hàng trong tương lai.'),('KH14','Lập trình php căn bản đến nâng cao - web bán hàng','PHP là một ngôn ngữ kịch bản phía máy chủ nguồn mở  được sử dụng để phát triển\n các trang web. PHP cho sử dụng miễn phí và tương thích với các nền tảng khác nhau bao gồm cả Linux, UNIX, Windows, và Mac OS X.','ND2','2017-12-09 14:41:18',0,'NCO','ND3','CD3',1,NULL,0,'https://drive.google.com/uc?id=1TwIKDlIhA6B918DXYvplEWtueSvq6OvT','Trong khóa học này, bên cạnh cung cấp các kiến thức nền tảng, giảng viên cung cấp đầy đủ các kiến thực lập trình nâng\n cao của PHP. Cuối cùng, giảng viên cũng hướng dẫn đầy đủ các thao tác từ việc thiết kế cơ sở dữ liệu, thiết kế website, chọn template, xử lý bootstrap, responsive web, xây dựng hầu hết các\n tính năng của một website bán hàng theo xu thế hiện nay.'),('KH15','Front-End: Làm dự án thực tế với Angular 2 + Web API - Restful Service','Angular 2 đã phát hành và được nhiều công ty sử dụng. Việc nắm rõ\n Angular 2 giúp bạn thực hiện được các dự án lớn và khả năng tìm được việc làm rất lớn.','ND3','2017-12-09 14:41:18',1200,'CO','ND1','CD3',1,NULL,0,'https://drive.google.com/uc?id=1xPdwqRs8cQxSqfJPidX6gsCncUWgN2i2','Khóa học Angular 2 sẽ giúp các bạn nắm rõ các kiến thức từ căn bản đến chuyên sâu về Angular. Trong khóa học cũng sử dụng công nghệ Web Service - Web API để các bạn tương tác với backend như một phần của hệ thống.'),('KH16','Lập trình Android nâng cao','Lập trình Android từ căn bản đến nâng cao','ND1','2017-12-12 13:52:25',500,'CO',NULL,'CD2',0,NULL,0,'https://drive.google.com/uc?id=0B27mfRY62YKZWFUyME44WjdiUTg','<p>Ngày nay thị phần của các thiết bị chạy hệ điều hành Android đã vượt qua các thiết bị chạy hệ điều khác , để trở thành hệ điều hành được mọi người yêu thích nhất, nhưng để góp phần vào sự phát triển cũng như sự thành công của hệ điều hành Android phải kể đến các ứng dụng mà nó mang lại cho cuộc sống hằng ngày của chúng ta. Bạn chưa từng ngủ dậy muộn nhờ ứng dụng báo thức, với Google Map bạn không còn phải ngại ngùng khi phải hỏi đường người khác hay bạn thư giản với những bản nhạc Ballad ngọt ngào. Có khi nào bạn đã tự hỏi họ đã làm những ứng dụng đó như thế nào chưa ?, có khi nào bạn đã từng ao ước làm cho mình một ứng dụng để có thể khoe với bạn bè hoặc phục vụ cho cộng đồng với nhãn hiệu make by me chưa ? , hoặc bạn muốn làm để phục vụ cho công ty. Nếu bạn đã nghĩ đến những điều đó và muốn thực hiện nó những lại không biết phải bắt đầu từ đâu không biết nên làm thế nào hoặc đối với những bạn tự tim hiểu rào cản ngôn ngữ luôn là trở ngại lớn đối với các bạn.</p>'),('KH17','Lập trình Android nâng cao','Lập trình Android từ căn bản đến nâng cao','ND1','2017-12-12 14:37:23',500,'CO',NULL,'CD2',0,NULL,0,'https://drive.google.com/uc?id=0B27mfRY62YKZWFUyME44WjdiUTg','<p>Ngày nay thị phần của các thiết bị chạy hệ điều hành Android đã vượt qua các thiết bị chạy hệ điều khác </p>'),('KH18','Lập trình Android nâng cao','<p>Ngày nay thị phần của các thiết bị chạy hệ điều hành Android đã vượt qua các thiết bị chạy hệ điều khác </p>','ND2','2017-12-12 15:20:15',500,'CO','ND1','CD2',0,'2018-01-16 21:53:31',0,'https://drive.google.com/uc?id=0B27mfRY62YKZWFUyME44WjdiUTg','Lập trình Android từ căn bản đến nâng cao'),('KH19','Xây dựng Webservice bằng Laravel framework','<p><span style=\"color: rgb(17, 17, 17);\">Khóa học lập trình Laravel tại Khoa Phạm</span></p><p><span style=\"color: rgb(17, 17, 17);\">Đây là một phần trích từ KHÓA HỌC LẬP TRÌNH PHP tại KhoaPham.Vn </span><a href=\"https://www.youtube.com/redirect?v=XJwhQumKCxU&amp;event=video_description&amp;redir_token=nVVbIbkani0VVqRUqHbYLRx7tB18MTUxNjM3MDc1NUAxNTE2Mjg0MzU1&amp;q=http%3A%2F%2Fkhoapham.vn%2Flap-trinh-php.html\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://khoapham.vn/lap-trinh-php.html</a></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Hỗ trợ kỹ thuật trực tiếp tại Trung Tâm Đào Tạo Tin Học Khoa Phạm (90-92 Lê Thị Riêng, P.Bến Thành, Q1, TPHCM). Hotline 0966908907 (Thứ hai đến thứ bảy, </span><a href=\"https://www.youtube.com/watch?v=XJwhQumKCxU&amp;t=480s\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">08:00</a><span style=\"color: rgb(17, 17, 17);\"> đến </span><a href=\"https://www.youtube.com/watch?v=XJwhQumKCxU&amp;t=960s\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">16:00</a><span style=\"color: rgb(17, 17, 17);\">).</span></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Tư vấn ghi danh: 0942764080</span></p>','ND1','2018-01-18 21:08:46',120,'CO',NULL,'CD14',2,NULL,20,'https://drive.google.com/uc?id=1xG_Fmcl4r-CpnA4z5HF_9F7ODvYm34FD',''),('KH2','Cấu trúc dữ liệu & giải thuật','Cấu trúc dữ liệu & giải thuật qua ví dụ kinh điển - C++ nền tảng, nâng cao, phỏng vấn xin việc','ND2','2017-11-29 15:51:52',10000,'CO','ND2','CD1',0,NULL,1,'https://drive.google.com/uc?id=0B27mfRY62YKZWFUyME44WjdiUTg','<div class=\"GTKH\">\r <ul>\r<li><strong>Giới thiệu về Cấu trúc dữ liệu và thuật toán:</strong></li>\r </ul>\r \r <p>Thực hiện một đề án tin học là chuyển bài toán thực tế thành bài toán có thể giải quyết trên máy tính. Một bài toán thực tế bất kỳ đều bao gồm các đối tượng dữ liệu và các yêu cầu xử lý trên những đối tượng đó. Vì thế, để xây dựng một mô hình tin học phản ánh được bài toán thực tế cần chú trọng đến hai vấn đề :</p>\r \r <ul>\r 	<li><strong>Tổ chức biểu diễn các đối tượng thực tế :</strong></li>\r </ul>\r \r <p>Các thành phần dữ liệu thực tế đa dạng, phong phú và thường chứa đựng những quan hệ nào đó với nhau, do đó trong mô hình tin học của bài toán, cần phải tổ chức , xây dựng các cấu trúc thích hợp nhất sao cho vừa có thể phản ánh chính xác các dữ liệu thực tế này, vừa có thể dễ dàng dùng máy tính để xử lý. Công việc này được gọi là xây dựng <strong><em>cấu trúc dữ liệu</em> </strong>cho bài toán.</p>\r \r <ul>\r 	<li><strong>Xây dựng các thao tác xử lý dữ liệu:</strong></li>\r </ul>\r \r <p>Từ những yêu cầu xử lý thực tế, cần tìm ra các giải thuật tương ứng để xác định trình tự các thao tác máy tính phải thi hành để cho ra kết quả mong muốn, đây là bước xây dựng <strong><em>giải thuật </em></strong>cho bài toán. Tuy nhiên khi giải quyết một bài toán trên máy tính, chúng ta thường có khuynh hướng chỉ chú trọng đến việc xây dựng giải thuật mà quên đi tầm quan trọng của việc tổ chức dữ liệu trong bài toán. Giải thuật phản ánh các phép xử lý , còn đối tượng xử lý của giải thuật lại là dữ liệu, chính dữ liệu chứa đựng các thông tin cần thiết để thực hiện giải thuật. Để xác định được giải thuật phù hợp cần phải biết nó tác động đến loại dữ liệu nào (ví dụ để làm nhuyễn các hạt đậu , người ta dùng cách xay chứ không băm bằng dao, vì đậu sẽ văng ra ngoài) và khi chọn lựa cấu trúc dữ liệu cũng cần phải hiểu rõ những thao tác nào sẽ tác động đến nó (ví dụ để biểu diễn các điểm số của sinh viên người ta dùng số thực thay vì chuỗi ký tự vì còn phải thực hiện thao tác tính trung bình từ những điểm số đó). Như vậy trong một đề án tin học, giải thuật và cấu trúc dữ liệu có mối quan hệ chặt chẽ với nhau, được thể hiện qua công thức :</p>\r \r <h3 align=\"center\"><span style=\"color: #ff0000;\"><strong>Cấu trúc dữ liệu + Giải thuật = Chương trình</strong></span></h3>\r \r <p>Với một cấu trúc dữ liệu đã chọn, sẽ có những giải thuật tương ứng, phù hợp. Khi cấu trúc dữ liệu thay đổi thường giải thuật cũng phải thay đổi theo để tránh việc xử lý gượng ép, thiếu tự nhiên trên một cấu trúc không phù hợp. Hơn nữa, một cấu trúc dữ liệu tốt sẽ giúp giải thuật xử lý trên đó có thể phát huy tác dụng tốt hơn, vừa đáp ứng nhanh vừa tiết kiệm vật tư, giải thuật cũng dễ hiễu và đơn giản hơn.</p>\r \r <ul>\r 	<li>Đây là khoá học rất nền tảng và là bước đệm để các bạn tiến sâu hơn trong nghề nghiệp lập trình của mình. Các bạn học tốt môn này, các bạn nắm được các tư duy thuật toản, tư duy giải thuật, các bạn sẽ là một lập trình viên giỏi. Các tư duy này giúp bạn vận dụng để giải quyết các công việc, các bài toán, các nghiệp vụ trong tất cả phần mềm sau này</li>\r 	<li>Việc học Cấu trúc dữ liệu và Thuật toán giúp bạn có một cái nhìn chuyên sâu, tối ưu hoá được nhiều vấn đề trong lập trình. Việc tối ưu hoá là cực kì quan trọng để các bạn xây dựng các phần mềm chạy nhanh, hiệu quả.</li>\r 	<li>Trong hầu hết các bài <strong><span style=\"color: #ff0000;\">PHỎNG VẤN</span></strong> để tuyển chọn người tài, các công ty đều kiểm tra khả năng xử lý và tư duy của các bạn thông qua các trường hợp từ môn học này. Một lập trình nhanh nhạy, một ứng cử viên sáng giá cho một vị trí tại công ty phụ thuộc vào khả năng bạn xử lý các vấn đề, tư duy giải quyết vấn đề dựa vào các thuật toán, thuật giải và tối ưu chương trình.</li>\r 	<li>Khoá học được trình bày rất chi tiết với hầu hết các thuật toán và giải thuật thường gặp trong thực tế qua nhiều ví dụ minh hoạ dễ hiểu và vận dụng</li>\r 	<li>Các thuật toán được trình bày, minh hoạ trực quan qua hệ thống <a href=\"http://algo.myclass.vn\" target=\"_blank\">http://algo.myclass.vn</a>&nbsp;để các bạn học một cách dễ hiểu nhất.</li>\r 	<li><strong>CẤU TRÚC DỮ LIỆU VÀ THUẬT TOÁN LUÔN CẦN THIẾT TRONG SUỐT CUỘC ĐỜI CỦA MỘT LẬP TRÌNH VIÊN (VÍ DỤ CÁC THUẬT TOÁN CŨNG CÓ TRONG PHỎNG VẤN CỦA GOOGLE :&nbsp;<a href=\"https://grouplens.org/blog/preparing-for-a-google-technical-interview/)\" target=\"_blank\">https://grouplens.org/blog/preparing-for-a-google-technical-interview/)</a></strong></li>\r </ul>\r \r <p><span style=\"font-weight: bold; color: rgb(0, 128, 0);\">***** ĐẶC BIỆT HƠN CẢ, TÔI CŨNG SẼ BÀN SÂU VỀ CÁC ƯU NHƯỢC ĐIỂM, CẢI TIẾN CÁC THUẬT TOÁN, <span style=\"color: #ff0000;\">BÀN LUẬN VỀ CÁC VẤN ĐỀ</span> TRONG CUỐN SÁCH CỰC KÌ NỔI TIẾNG VỀ CẤU TRÚC DỮ LIỆU VÀ THUẬT TOÁN:</span>&nbsp;<span style=\"color: #ff0000;\"><strong>\"Data Structures and Algorithms Made Easy: Data Structure and Algorithmic Puzzles by Karumanchi, Narasimha\" - xuất bản năm 2011 với gần 90.000 lượt xuất bản khắp thế giới.</strong></span></p>\r \r <p><span style=\"font-weight: bold; color: rgb(0, 128, 0);\">Rất nhiều công ty nổi tiếng sử dụng các Problem trong này để làm câu hỏi phỏng vấn các ứng cử viên của mình.</span>&nbsp;<strong><a href=\"https://www.amazon.com/Data-Structures-Algorithms-Made-Easy/dp/B00RKQJP0I/ref=sr_1_9?s=books&amp;ie=UTF8&amp;qid=1486571115&amp;sr=1-9&amp;keywords=Data+Structures+and+Algorithms+Made+Easy\" target=\"_blank\">Link sách trên Amazon</a></strong><img alt=\"cau truc du lieu va giai thuat - myclass.vn\" class=\"aligncenter\" height=\"499\" src=\"https://images-na.ssl-images-amazon.com/images/I/51RiQhVgO9L._SX384_BO1,204,203,200_.jpg\" width=\"386\"></p>\r         </div>'),('KH20','Lập trình ReactJS với React Router & Foundation','<p><span style=\"color: rgb(17, 17, 17);\">React Router  &amp; Foundation</span></p><p><span style=\"color: rgb(17, 17, 17);\">Khóa học ReactJS tại KhoaPham.Vn: </span><a href=\"https://www.youtube.com/redirect?redir_token=wvDc3NciRinGYmWVNhl4RrM7RF18MTUxNjM3NDgwMEAxNTE2Mjg4NDAw&amp;v=1LFqfxghAa0&amp;q=http%3A%2F%2Fkhoapham.vn%2Fkhoa-hoc-lap-trinh-react-js.html&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://khoapham.vn/khoa-hoc-lap-trinh...</a></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">React Router là một thư viện được dùng để tạo ra các route, giúp cho người dùng chuyển hướng website sang các page khác nhau mà không cần phải reload lại toàn bộ trang web, điều này giúp cho trải nghiệm người dùng tốt hơn khi giảm bớt được thời gian tải website.</span></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Foundation là một thư viện dùng để định dạng website nhanh chóng. Điểm mạnh của foundation là sử dụng scss – giúp cho việc tùy biến nhanh chóng và hiệu quả hơn.</span></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Tư vấn ghi danh: 0942764080</span></p><p><span style=\"color: rgb(17, 17, 17);\">Hỗ trợ kỹ thuật: 0967908907 (Thứ hai đến thứ sáu từ 13 - 16h)</span></p><p><span style=\"color: rgb(17, 17, 17);\">Fanpage: </span><a href=\"https://www.youtube.com/redirect?redir_token=wvDc3NciRinGYmWVNhl4RrM7RF18MTUxNjM3NDgwMEAxNTE2Mjg4NDAw&amp;v=1LFqfxghAa0&amp;q=https%3A%2F%2Fwww.facebook.com%2Fkhoapham.vn%2F&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">https://www.facebook.com/khoapham.vn/</a></p>','ND1','2018-01-18 22:14:46',200,'CO',NULL,'CD10',0,NULL,2,'https://drive.google.com/uc?id=1_alG57kkxgYDzK2_gSngkZ0vDW59TH8I',''),('KH21','Lập trình Front-End với SASS','<p><span style=\"color: rgb(17, 17, 17);\">Khoá học Front-End tại Khoa Phạm: </span></p><p><a href=\"https://www.youtube.com/redirect?redir_token=zViQTj0Ofp27ZOQHZgT6jBTyja18MTUxNjM4NDIzNUAxNTE2Mjk3ODM1&amp;q=https%3A%2F%2Fkhoapham.vn%2Fkhoa-hoc-lap-trinh-front-end.html&amp;event=video_description&amp;v=zjW8LpCHasE\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">https://khoapham.vn/khoa-hoc-lap-trin...</a></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">SASS là một CSS Preprocessor cung cấp thêm các quy tắc như nested rule, variable, mixin, ... Với SASS bạn có thể viết CSS theo thứ tự rõ ràng, quản lý các biến đã được định nghĩa sẵn, có thể tự động nén tập tin CSS lại để bạn tiết kiệm dung lượng.</span></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Hỗ trợ kỹ thuật: 0967908908 </span></p><p><span style=\"color: rgb(17, 17, 17);\">Tư vấn, ghi danh: 0942764080 </span></p><p><span style=\"color: rgb(17, 17, 17);\">Email: khoaphamtraining@gmail.com</span></p>','ND1','2018-01-19 00:55:41',300,'CO',NULL,'CD13',0,NULL,10,'https://drive.google.com/uc?id=1jC37q51UGR1wrwgekurir5xi9gQ-Z7dJ','<p><span style=\"color: rgb(11, 26, 51);\">SASS là một CSS Preprocessor cung cấp thêm các quy tắc như nested rule, variable, mixin, ... Với SASS bạn có thể viết CSS theo thứ tự rõ ràng, quản lý các biến đã được định nghĩa sẵn, có thể tự động nén tập tin CSS.</span></p><h3>Cài đặt và sử dụng SASS</h3><h4>1. Cài đặt</h4><ul><li>Cài đặt ruby:</li></ul><p>SASS là một ứng dụng viết bằng Ruby nên trước tiên bạn cần cài đặt Ruby trên máy nhé.</p><ul><li>Cài đặt SASS</li></ul><p><code style=\"background-color: rgb(246, 246, 247);\">gem install sass</code></p><ul><li>Chuyển đổi tập tin .sass sang .css</li></ul><p><code style=\"background-color: rgb(246, 246, 247);\">sass app.scss app.css</code></p><ul><li>Tự động thực hiện chuyển đổi trong quá trình làm việc:</li></ul><p><code style=\"background-color: rgb(246, 246, 247);\">sass --watch app.scss:app.css</code></p><ul><li>Chuyển đổi tất cả một thư mục trong quá trình làm việc:</li></ul><p><code style=\"background-color: rgb(246, 246, 247);\">sass --watch app/sass:public/css</code></p><h4>2. Sử dụng SASS</h4><p>Một số quy tắc viết SASS:</p><ul><li>Quy tắc xếp chồng</li></ul><p>Sass cho phép CSS được lồng trong nhau. Ví dụ:</p><pre spellcheck=\"false\">#container {\n    width: 69%;\n    p, div {\n        font-size: 69px;\n        a {\n            font-weight: bold;\n        }\n    }\n}\n</pre><p>Sau khi biên dịch sẽ được:</p><pre spellcheck=\"false\">#container {\n    width: 69%;\n}\n#container p, #container div {\n    font-size: 69px;\n}\n#container p a, #container div a {\n    font-weight: bold;\n}\n</pre><p>Tham khảo:&nbsp;<a href=\"http://sass-lang.com/documentation/file.SASS_REFERENCE.html#nested_rules\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation/file.SASS_REFERENCE.html#nested_rules</a></p><ul><li>Sử dụng biến trong SASS</li></ul><p>Cách đơn giản nhất để sử dụng Sass là sử dụng biến. Biến bắt đầu bằng ký hiệu $ và được thiết lập như các thuộc tính CSS. Ví dụ:</p><pre spellcheck=\"false\">$width: 69px;\n#container {\n    width: $width;\n}\n\n#main {\n    max-width: $width;\n}\n\n</pre><p>Sau khi biên dịch sẽ được:</p><pre spellcheck=\"false\">#container {\n  width: 69px;\n}\n\n#main {\n  max-width: 69px;\n}\n</pre><p>Tham khảo:&nbsp;<a href=\"http://sass-lang.com/documentation/file.SASS_REFERENCE.html#variables_\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation/file.SASS_REFERENCE.html#variables_</a></p><ul><li>**Quy tắc Mixin **</li></ul><p>Mixins cho phép bạn khai báo 1 đoạn css có thể được tái sử dụng.</p><p>Khai báo Mixins:</p><pre spellcheck=\"false\">@mixin required {\n    font-size: 13px;\n    font-weight: bold;\n    color: red;\n}\n</pre><p>Sử dụng Mixin:</p><pre spellcheck=\"false\">.required{\n    @include required;\n    padding: 6px;\n    margin: 9px;\n}\n</pre><p>Sau khi biên dịch sẽ được:</p><pre spellcheck=\"false\">.required {\n    font-size: 13px;\n    font-weight: bold;\n    color: red;\n    padding: 6px;\n    margin: 9px;\n}\n</pre><p>Tham khảo:&nbsp;<a href=\"http://sass-lang.com/documentation/file.SASS_REFERENCE.html#mixins\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation/file.SASS_REFERENCE.html#mixins</a></p><ul><li>Quy tắc kế thừa</li></ul><p>Tính năng kế thừa cho phép bạn chỉ định cho một thành phần nào đó thừa hưởng tất cả các thuộc tính của một vùng chọn nào đó bất kỳ mà bạn đã khai báo sẵn.</p><p>Ví dụ:</p><pre spellcheck=\"false\">.error {\n  color: red;\n}\n.error-bold {\n  @extend .error;\n  font-weight: bold\n}\n</pre><p>Sau khi biên dịch sẽ được:</p><pre spellcheck=\"false\">.error, .error-bold {\n    color: red;\n}\n.error-bold {\n    font-weight: bold;\n}\n</pre><p>Tham khảo:&nbsp;<a href=\"http://sass-lang.com/documentation/file.SASS_REFERENCE.html#extend\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation/file.SASS_REFERENCE.html#extend</a></p><ul><li>** Mệnh đề điều kiện trong SASS**</li></ul><p>SASS hỗ trợ rất nhiều mệnh đề điều kiện khác nhau như IF, FOR, EACH, WHILE. Các bạn có thể tham khảo tại:</p><p><a href=\"http://sass-lang.com/documentation/file.SASS_REFERENCE.html#control_directives__expressions\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation/file.SASS_REFERENCE.html#control_directives__expressions</a></p><p>Hy vọng với bài viết này các bạn đã có một cái nhìn tổng quan về SASS cũng như những lợi ích mà SASS mang lại.</p><p>Tham khảo thêm về SASS tại:</p><ul><li><a href=\"http://sass-lang.com/\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com</a></li><li><a href=\"http://sass-lang.com/documentation\" target=\"_blank\" style=\"background-color: transparent;\">http://sass-lang.com/documentation</a></li></ul><p><br></p>'),('KH22','Hướng dẫn xây dựng WebRTC','<p>Hương dẫn WebRTC xây dựng web stream real time</p>','ND1','2018-01-19 01:19:35',200,'CO',NULL,'CD12',0,NULL,1,'https://drive.google.com/uc?id=1y4PmjMdF9vQJWMHCcsF4JHXohnvU444A','<p><span style=\"color: rgb(17, 17, 17);\">WebRTC là công nghệ giúp chúng ta xây dựng ứng dụng stream audio, video, chia sẻ file, desktop, ... thông qua kết nối peer to peer (kết nối trực tiếp giữa các client mà không cần truyền dữ liệu qua server trung gian). Loạt bài này sẽ giúp các bạn có thể tích hợp công nghệ WebRTC vào ứng dụng web của bạn.</span></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Bạn chuẩn bị trước các tài khoản các trang sau: </span></p><p><a href=\"https://www.youtube.com/redirect?q=http%3A%2F%2Fheroku.com%2F&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://heroku.com/</a></p><p><a href=\"https://www.youtube.com/redirect?q=http%3A%2F%2Fpeerjs.com%2F&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://peerjs.com/</a></p><p><a href=\"https://www.youtube.com/redirect?q=http%3A%2F%2Fxirsys.com%2F&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://xirsys.com/</a></p><p><a href=\"https://www.youtube.com/redirect?q=https%3A%2F%2Fgithub.com%2F&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">https://github.com/</a></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Project khởi đầu: </span></p><p><a href=\"https://www.youtube.com/redirect?q=https%3A%2F%2Fgithub.com%2Fvanpho93%2Frtc-start-kit&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">https://github.com/vanpho93/rtc-start...</a></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">Project kết thúc:</span></p><p><a href=\"https://www.youtube.com/redirect?q=https%3A%2F%2Fgithub.com%2Fvanpho93%2Fkhoapham-rtc&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">https://github.com/vanpho93/khoapham-rtc</a></p><p><span style=\"color: rgb(17, 17, 17);\">Các bạn có thể theo dõi project cuối mỗi video trong mục commit</span></p><p><br></p><p><br></p><p><span style=\"color: rgb(17, 17, 17);\">- Xem thêm khoá học Lập trình Nodejs tại Khoa Phạm: </span><a href=\"https://www.youtube.com/redirect?q=http%3A%2F%2Fkhoapham.vn%2Fkhoa-hoc-lap-trinh-nodejs.html&amp;v=6nVcngJG-Eg&amp;redir_token=DQ7JPEnaccFXL7rh8mb5fXZYmvV8MTUxNjM4NTcyOUAxNTE2Mjk5MzI5&amp;event=video_description\" target=\"_blank\" style=\"color: var(--yt-endpoint-visited-color, var(--yt-endpoint-color));\">http://khoapham.vn/khoa-hoc-lap-trinh...</a></p>'),('KH23','Lập Trình TypeScript','Hướng dẫn lập trình typeScript','ND2','2018-01-19 01:50:18',200,'CO','ND1','CD2',1,'2018-01-16 23:27:21',0,'https://drive.google.com/uc?id=1KV7hAlJBjdiNT1mB2aVLXjmZy3-mgnqN','Nếu bạn là mới bắt đầu làm quen với JavaScript thì khóa học lập trình Javascript cơ bản này'),('KH24','Lập Trình Android từ A-Z','Hướng dẫn lập trình adroid toàn tập','ND2','2018-01-19 01:58:27',200,'CO','ND1','CD2',1,'2018-01-16 23:27:21',0,'https://drive.google.com/uc?id=1aX5MwHC3uKCkt-f8CMHdD9ZgdRjp4ERB','Android đang là hệ điều hành chiếm lĩnh thị trường thiết bị động hiện nay. Hàng trăm ngàn thiết bị từ ti vi, máy nghe nhạc... cho đến điện thoại di động đều có thể chạy trên nền Android.'),('KH3','Lập Trình Visual C# Căn Bản','C# thông dụng ở chỗ \n nó rất dễ học, dễ nắm bắt và với một trình soạn thảo trực quan nó cho phép chúng ta dễ dàng thiết kế giao diện người dùng,\n kiểm tra lỗi.....','ND1','2017-12-09 14:41:13',0,'NCO','ND2','CD1',1,NULL,4,'https://drive.google.com/file/d/1U-PJRNMY6GYQxFbW87F6RJYy-np-5dw3/view','Để có thể giúp các bạn làm quen với ngôn ngữ C# , ngày hôm nay tôi xin gửi đến các bạn khóa học Lập Trình C# Căn Bản. Mục đích của khóa học giúp cho\n các bạn làm quen với môi trường C# và làm sao để có thể tạo ra một ứng dụng với C#.'),('KH4','Lập trình C/C++ căn bản','Sau khi hoàn thành khóa học lập trình C, C++ căn bản này bạn có thể làm\n quen được với môi trường làm việc của C/C++ và có thể làm những bài toán đơn giản với C/C++ ở mức khó hơn.','ND4','2017-12-09 14:41:13',1000,'CO','ND2','CD1',1,NULL,0,'https://drive.google.com/uc?id=1uOMrAbYxL-y7qaBdhGH8320S7uGXEKA6','Mục tiêu của C++ là tiếp cận những ý tưởng của phương pháp luận hướng đối tượng và trừu tượng dữ liệu. C++\n là một ngôn ngữ lập trình tiến tiến, mạnh trong các ngôn ngữ lập trình hiện nay, nó được sử dụng bởi hàng triệu lập trình viên trên thế giới. Các đặc tính của C ++ cho phép người\n lập trình xây dựng những thư viện phần mềm có chất lượng cao phục vụ những đề án lớn.'),('KH5','Lập Trình JavaScript Cơ Bản','JavaScript là một ngôn ngữ lập trình dựa trên nguyên mẫu với cú pháp phát\n triển từ C. Giống như C, JavaScript có khái niệm từ khóa, do đó, JavaScript gần như không thể được mở rộng.','ND3','2017-12-09 14:41:14',800,'CO','ND1','CD1',1,NULL,0,'https://drive.google.com/uc?id=1qGdpMH8Eorl_S-ZdzeFqe4CBwlftj_B7','Nếu bạn là mới bắt đầu làm quen với JavaScript thì khóa học lập trình Javascript cơ bản này\n sẽ giúp các bạn tìm hiểu về các thao tác , các kiến thức nền tảng về JavaScript.'),('KH6','Lập trình JAVA căn bản','Java không còn là một ngôn ngữ xa lạ với cộng đồng lập trình. Với việc có lợi thế\n khi được sinh ra với tiêu chí “Write Once, Run Anywhere” (WORA) – tức là “Viết một lần, thực thi khắp nơi”','ND2','2017-12-09 14:41:14',150,'CO','ND4','CD1',1,NULL,0,'https://drive.google.com/uc?id=1EXlrZzARsdz4GKrWmzH9wI0-qrrnpliw','Hòa nhịp vào thế mạnh của Java, khóa học “Lập trình JAVA căn bản” với mục đích cung cấp cho \n các bạn học viên có những kiến thức cơ bản nhất về nguyên lý lập trình bằng ngôn ngữ Java, qua đó giúp các bạn có một nền tảng vững chắc về Java và có thể dùng ngôn\n ngữ này để lập trình với các Engine hay Framework nâng cao.'),('KH7','Lập Trình Android Qua Ứng Dụng OrderFood','Khóa học sẽ giúp bạn hiểu được cách thức xây dựng được ứng dụng\n cũng như cách thức phân tích yêu cầu của khách hàng.','ND3','2017-12-09 14:41:15',100,'NCO','ND4','CD2',1,NULL,0,'https://drive.google.com/uc?id=1cohNd-B54V1Q8pszU-Hcqx2nLG0K5wAi','Bạn  có thể biết được quy trình khi viết một ứng dụng nên bắt đầu và kết thúc từ đâu, bạn có thể\n áp dụng những điều đã học cho nhiều ứng dụng khác nhau. Vậy nên các bạn hãy tự tin đăng ký khóa học để có thể làm nên một ứng dụng hoàn chỉnh mang phong cách riêng\n của chính bản thân mình nhé !'),('KH8','App ANDROID giống App Mua sắm LAZADA','Với sự phát triển ngày càng mạnh và được ứng dụng ngày càng nhiều vào \n thực tế của các ứng dụng Android, chính vì điều đó đã làm cho nó trở thành một ngành hot nhất hiện nay và thu hút được nhiều sự quan tâm của các bạn trẻ đam mê lập trình.','ND4','2017-12-09 14:41:15',200,'CO','ND1','CD2',1,NULL,0,'https://drive.google.com/uc?id=1_9SaNoQ8gBW5byjHQL5wwJygCA9abho3','Thông qua khóa học Lazada này các bạn sẽ nắm bắt được cách vận dụng các kiến thức cơ bản của android\n để hoàn thành ứng dụng, ngoài ra các bạn sẽ còn biết được cách tổ chức code theo mô hình MVP pattern để có thể quản lý code tốt hơn, không những vậy các bạn sẽ nắm bắt được\n cách thức tạo Webservice với cả 2 ngôn ngữ lập trình Web hot nhất hiện nay là PHP và ASP.NET cũng như cách trao đổi dữ liệu của Webservice và ứng dụng Android.'),('KH9','Game Tôm Cua Bầu Cá Android','Các bạn có muốn tự mình làm 1 game bầu cua trên android không nào, với những kiến thức\n căn bản từ các khóa Android Căn Bản, Media Player Trong Android và CSDL','ND2','2017-12-09 14:41:15',100,'CO','ND3','CD2',1,NULL,0,'https://drive.google.com/uc?id=1ZAJxeJDGXE_FJM111kXOjABqcIPYZK6y','Khi đến với khóa học này các bạn còn có thể  tiếp thu thêm các kiến thức mớic về Handler, Timer,\n CountDown, Animation List và ngoài ra các bạn còn biết dc cách áp dụng các kiến thức cũ đã được học để hoàn chỉnh khả năng của chính mình. Hãy đến với khóa học này và tạo ra\n game bầu cua cho chính mình bạn nhé');
/*!40000 ALTER TABLE `khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_khoa_hoc_insert
before insert on tmdt.khoa_hoc for each row
begin 
declare v_new_ma_khoa_hoc varchar(50) default null;
select concat('KH',(select 1+(select count(*) from khoa_hoc))) into v_new_ma_khoa_hoc from dual;
/*
 if ma_nguoi_dung ton tai thi lay ma nguoi dung cuoi cung + 1
*/
if (select exists (select 1 from khoa_hoc k where k.ma_khoa_hoc =v_new_ma_khoa_hoc)) then
		select concat('KH',(select substring(n.ma_khoa_hoc from 3) +1 from 
       khoa_hoc k order by k.ma_khoa_hoc desc limit 1) )into v_new_ma_khoa_hoc from dual;
    end if	;
set new.ma_khoa_hoc=v_new_ma_khoa_hoc;
set new.ngay_tao = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `lich_su_giao_dich`
--

DROP TABLE IF EXISTS `lich_su_giao_dich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lich_su_giao_dich` (
  `ma_lich_su_giao_dich` varchar(50) NOT NULL,
  `ngay_giao_dich` datetime DEFAULT NULL,
  `no` double DEFAULT NULL,
  `ma_hinh_thuc_giao_dich` varchar(50) DEFAULT NULL,
  `co` double DEFAULT NULL,
  `ma_nguoi_dung` varchar(50) DEFAULT NULL,
  `noi_dung_giao_dich` varchar(100) DEFAULT NULL COMMENT 'nội dung giao dịch donate mua khóa học hoặc đổi tiền',
  PRIMARY KEY (`ma_lich_su_giao_dich`),
  KEY `fk_lich_su_giao_dich_hinh_thuc_giao_dich_idx` (`ma_hinh_thuc_giao_dich`),
  KEY `fk_lich_su_giao_dich_nguoi_dung_idx` (`ma_nguoi_dung`),
  CONSTRAINT `fk_lich_su_giao_dich_hinh_thuc_giao_dich` FOREIGN KEY (`ma_hinh_thuc_giao_dich`) REFERENCES `hinh_thuc_giao_dich` (`ma_hinh_thuc_giao_dich`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lich_su_giao_dich_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_su_giao_dich`
--

LOCK TABLES `lich_su_giao_dich` WRITE;
/*!40000 ALTER TABLE `lich_su_giao_dich` DISABLE KEYS */;
INSERT INTO `lich_su_giao_dich` VALUES ('GD1','2017-12-30 15:58:26',100,'DN',0,'ND2','KH1CH1BH1'),('GD10','2018-01-01 18:56:17',0,'NT',2200,'ND1','Nạp vào tài khoảnlang.tt16@gmail.com 2200.0 điểm'),('GD11','2018-01-01 19:24:58',0,'NT',220,'ND1','Nạp vào tài khoảnlang.tt16@gmail.com 220.0 điểm'),('GD12','2018-01-02 14:23:30',100,'MKH',0,'ND1','KH7'),('GD13','2018-01-02 14:23:30',200,'MKH',0,'ND1','KH8'),('GD14','2018-01-05 14:08:25',0,'NT',220,'ND1','Nạp vào tài khoảnlang.tt16@gmail.com 220.0 điểm'),('GD2','2017-12-30 15:59:46',100,'DN',0,'ND2','KH1CH1BH1'),('GD3','2017-12-30 16:21:29',100,'DN',0,'ND2','KH1CH1BH1'),('GD4','2017-12-31 21:42:24',100,'MKH',0,'ND1','KH7'),('GD5','2017-12-31 21:42:24',200,'MKH',0,'ND1','KH8'),('GD6','2017-12-31 21:46:13',100,'MKH',0,'ND1','KH7'),('GD7','2017-12-31 21:46:14',200,'MKH',0,'ND1','KH8'),('GD8','2017-12-31 21:46:57',100,'MKH',0,'ND1','KH7'),('GD9','2017-12-31 21:46:58',200,'MKH',0,'ND1','KH8');
/*!40000 ALTER TABLE `lich_su_giao_dich` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_lich_su_giao_dich_insert
before insert on lich_su_giao_dich for each row
begin 
declare v_ma_lich_su_giao_dich varchar(50) default null;
select concat('GD',(select 1+(select count(*) from lich_su_giao_dich))) into v_ma_lich_su_giao_dich from dual;
/*
 if ma_nguoi_dung ton tai thi lay ma nguoi dung cuoi cung + 1
*/
if (select exists (select 1 from lich_su_giao_dich l where l.ma_lich_su_giao_dich =v_ma_lich_su_giao_dich)) then
		select concat('GD',(select substring(l.ma_lich_su_giao_dich from 3) +1 from lich_su_giao_dich l order by l.ma_lich_su_giao_dich desc limit 1)) into v_ma_lich_su_giao_dich from dual;
    end if	;
set new.ma_lich_su_giao_dich=v_ma_lich_su_giao_dich;
set new.ngay_giao_dich =now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `loai_khoa_hoc`
--

DROP TABLE IF EXISTS `loai_khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loai_khoa_hoc` (
  `ma_loai_khoa_hoc` varchar(50) NOT NULL,
  `tieu_de` varchar(200) NOT NULL,
  `mo_ta` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ma_loai_khoa_hoc`),
  UNIQUE KEY `ma_loai_khoa_hoc_UNIQUE` (`ma_loai_khoa_hoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_khoa_hoc`
--

LOCK TABLES `loai_khoa_hoc` WRITE;
/*!40000 ALTER TABLE `loai_khoa_hoc` DISABLE KEYS */;
INSERT INTO `loai_khoa_hoc` VALUES ('CO','Thương mại hóa','Khóa học mang hình thức thương mại'),('NCO','Phi thương mại','khóa học miễn phí');
/*!40000 ALTER TABLE `loai_khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nguoi_dung` (
  `ma_nguoi_dung` varchar(50) NOT NULL,
  `ten_nguoi_dung` varchar(100) DEFAULT NULL,
  `ngay_dang_ky` datetime DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `anh_dai_dien` varchar(2000) DEFAULT 'https://drive.google.com/uc?id=1Fx2VnHBcmjn7RXshIriuZaW8M8rMdadN',
  `mat_khau` varchar(100) NOT NULL,
  `diem` double DEFAULT '0',
  `trang_thai` int(5) DEFAULT '0',
  `dia_chi` varchar(2000) DEFAULT NULL,
  `sdt` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ma_nguoi_dung`),
  UNIQUE KEY `ma_nguoi_dung_UNIQUE` (`ma_nguoi_dung`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES ('ND1','Trương Tam Lang','2017-11-24 23:53:35','lang.tt16@gmail.com','https://drive.google.com/uc?id=0B27mfRY62YKZRDNxWWZHdl9aUjA','$2a$10$XsFlD8/G1odLhxZNNSPrnue3pXMmwKPDwKvResVohO4AU0h34Lon6',2640,1,'Đồng Tháp','01642222992'),('ND2','Trần Văn Thắng','2017-11-24 23:53:35','cnttk40@gmail.com','https://drive.google.com/uc?id=0B27mfRY62YKZRDNxWWZHdl9aUjA','$2a$10$7t0DI.Gs2rydJ6cSN7rb0u86WPAt67da6Q9Bs5Ns6.P2clHHwXOFK',300,1,'Đồng Tháp','01642222993'),('ND3','Trần Văn Thắng','2017-11-29 13:56:36','ttlang162@gmail.com','https://drive.google.com/uc?id=0B27mfRY62YKZRDNxWWZHdl9aUjA','$2a$10$uSUPBtXdmcOkRanQ8g7rGemAFR1e12RYLoXcI9W40.gMzFbXoGljS',400,1,'Thủ Đức','01642222992'),('ND4','Nguyễn Tấn Phát','2017-11-29 13:56:36','ttlang163@gmail.com','https://drive.google.com/uc?id=0B27mfRY62YKZRDNxWWZHdl9aUjA','$2a$10$oLJJJ44IPhPOSqZQd/a5cueZ8jY4IJs3.XUBERlV4ftZ5ziR3ipPO',800,1,'Đồng Tháp','01642222992'),('ND5','Trương Tam Lang','2018-01-02 16:31:35','lang.tt163@gmail.com','https://drive.google.com/uc?id=1Fx2VnHBcmjn7RXshIriuZaW8M8rMdadN','$2a$10$jnqkLZ2/1FoIdyev5ZV.Eu9krwXOYufvPaX7IJ3K25KWk7JU6idUq',0,1,NULL,NULL),('ND6','Trương Tam Lang','2018-01-21 15:53:18','lang.tt162@gmail.com','https://drive.google.com/uc?id=1Fx2VnHBcmjn7RXshIriuZaW8M8rMdadN','$2a$10$A6UzMaXkux02ma4owhkkpujvhXkdUw8QwjhJlTkSjDwtrFqoYn0ZC',0,1,NULL,NULL);
/*!40000 ALTER TABLE `nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_ma_nguoi_dung_insert
before insert on tmdt.nguoi_dung for each row
begin 
declare v_new_ma_nguoi_dung varchar(50) default null;
select concat('ND',(select 1+(select count(*) from nguoi_dung))) into v_new_ma_nguoi_dung from dual;
/*
 if ma_nguoi_dung ton tai thi lay ma nguoi dung cuoi cung + 1
*/
if (select exists (select 1 from nguoi_dung n where n.ma_nguoi_dung =v_new_ma_nguoi_dung)) then
		select concat('ND',(select substring(n.ma_nguoi_dung from 3) +1 from 
        nguoi_dung n order by n.ma_nguoi_dung desc limit 1) )into v_new_ma_nguoi_dung from dual;
    end if	;
set new.ma_nguoi_dung=v_new_ma_nguoi_dung;
set new.ngay_dang_ky = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_nguoi_dung_add_quyen_truy_cap 
after insert on tmdt.nguoi_dung for each row 
begin
	insert into quyen_truy_cap value (new.ma_nguoi_dung,1);
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_nguoi_dung_add_ngay_cap_nhat_mk 
 after insert  on tmdt.nguoi_dung for each row
 begin
	insert into nguoi_dung_cn(ma_nguoi_dung,ngay_cap_nhat_mk) values (new.ma_nguoi_dung,now());
 end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tg_nguoi_dung_add_ngay_cap_nhat_mk_update
after update on tmdt.nguoi_dung for each row
begin
if new.mat_khau <> old.mat_khau then
	insert into nguoi_dung_cn(ma_nguoi_dung,ngay_cap_nhat_mk) values (new.ma_nguoi_dung,now());
end if ;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `nguoi_dung_cn`
--

DROP TABLE IF EXISTS `nguoi_dung_cn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nguoi_dung_cn` (
  `ma_nguoi_dung` varchar(50) NOT NULL,
  `key_reset` varchar(200) DEFAULT NULL,
  `ngay_cap_nhat_mk` datetime DEFAULT NULL,
  UNIQUE KEY `key_reset_UNIQUE` (`key_reset`),
  KEY `fk_nguoi_dung` (`ma_nguoi_dung`),
  CONSTRAINT `fk_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung_cn`
--

LOCK TABLES `nguoi_dung_cn` WRITE;
/*!40000 ALTER TABLE `nguoi_dung_cn` DISABLE KEYS */;
INSERT INTO `nguoi_dung_cn` VALUES ('ND1',NULL,'2017-11-25 11:27:49'),('ND1',NULL,'2017-11-25 11:28:44'),('ND2',NULL,'2017-11-27 08:10:32'),('ND2',NULL,'2017-11-27 08:10:32'),('ND1',NULL,'2017-11-28 01:02:20'),('ND1','8J/KJVtO3x6IQUolNbJ/3g_L9/BLLHJ/nfimQdNQmKN5g_nO0d8K+IHoXOYTzfik8ImA',NULL),('ND1','8J/KJVtO3x6IQUolNbJ/3g_L9/BLLHJ/nfimQdNQmKN5g_dwmESMjsmXF6AFM2oo5i9Q',NULL),('ND3',NULL,'2017-11-28 12:02:37'),('ND1',NULL,'2017-11-28 12:58:24'),('ND1',NULL,'2017-11-28 13:18:57'),('ND1',NULL,'2017-11-28 13:31:05'),('ND4',NULL,'2017-11-29 13:56:36'),('ND1',NULL,'2017-12-13 12:33:21'),('ND2',NULL,'2017-12-13 12:33:22'),('ND3',NULL,'2017-12-13 12:33:22'),('ND4',NULL,'2017-12-13 12:33:22'),('ND2',NULL,'2017-12-13 12:48:47'),('ND3',NULL,'2017-12-13 12:48:47'),('ND4',NULL,'2017-12-13 12:48:47'),('ND1','8J/KJVtO3x6IQUolNbJ/3g_GxsB9yLmRjPC+D/whvC5Wg_eFCE7mVWUVdYhn6d8YX9vQ',NULL),('ND5',NULL,'2018-01-02 16:31:35'),('ND1','EC-2YD511802T9906032',NULL),('ND1','EC-0TV01059YV032604S',NULL),('ND1','EC-0UV08244PH334380D',NULL),('ND1','8J/KJVtO3x6IQUolNbJ/3g_Nlowpx6Cv5qh0+trB0qzgw_oW5929cwRE/M12H6wk9rTw',NULL),('ND6',NULL,'2018-01-21 15:53:18');
/*!40000 ALTER TABLE `nguoi_dung_cn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen`
--

DROP TABLE IF EXISTS `quyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quyen` (
  `ma_quyen` int(11) NOT NULL AUTO_INCREMENT,
  `ten_quyen` varchar(100) NOT NULL,
  PRIMARY KEY (`ma_quyen`),
  UNIQUE KEY `ma_quyen_UNIQUE` (`ma_quyen`),
  UNIQUE KEY `ten_quyen_UNIQUE` (`ten_quyen`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen`
--

LOCK TABLES `quyen` WRITE;
/*!40000 ALTER TABLE `quyen` DISABLE KEYS */;
INSERT INTO `quyen` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `quyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen_truy_cap`
--

DROP TABLE IF EXISTS `quyen_truy_cap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quyen_truy_cap` (
  `ma_nguoi_dung` varchar(50) NOT NULL,
  `ma_quyen` int(11) NOT NULL,
  PRIMARY KEY (`ma_nguoi_dung`,`ma_quyen`),
  KEY `fk_quyen_truy_cap_quyen_idx` (`ma_quyen`),
  CONSTRAINT `fk_quyen_truy_cap_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_quyen_truy_cap_quyen` FOREIGN KEY (`ma_quyen`) REFERENCES `quyen` (`ma_quyen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen_truy_cap`
--

LOCK TABLES `quyen_truy_cap` WRITE;
/*!40000 ALTER TABLE `quyen_truy_cap` DISABLE KEYS */;
INSERT INTO `quyen_truy_cap` VALUES ('ND1',1),('ND2',1),('ND3',1),('ND4',1),('ND5',1),('ND6',1),('ND1',2);
/*!40000 ALTER TABLE `quyen_truy_cap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tmdt'
--
/*!50003 DROP PROCEDURE IF EXISTS `change_mat_khau_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `change_mat_khau_nguoi_dung`(IN p_ma_nguoi_dung varchar(50), IN p_mat_khau_moi varchar(100),OUT result integer)
begin
update nguoi_dung set mat_khau =p_mat_khau_moi where ma_nguoi_dung =p_ma_nguoi_dung;
select row_count() into result from dual;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `change_trang_thai_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `change_trang_thai_nguoi_dung`(IN p_ma_nguoi_dung varchar(50),IN p_trang_thai_moi integer, OUT result integer)
begin
	update nguoi_dung set trang_thai = p_trang_thai_moi where ma_nguoi_dung =p_ma_nguoi_dung;
    select row_count() into result from dual;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_chu_de` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_chu_de`(
	in p_tieu_de varchar(100),
	in p_mo_ta text,
	in p_trang_thai tinyint(4),
	out result varchar(50)
)
begin
	insert into chu_de(tieu_de, mo_ta, trang_thai) values(p_tieu_de, p_mo_ta, p_trang_thai);
	select concat('CD',max(convert(substring_index(c.ma_chu_de,'CD',-1),unsigned int))) into result from chu_de c;
   
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_khoa_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_khoa_hoc`(IN p_tieu_de varchar(200),IN p_mo_ta text,IN p_ma_nguoi_dung varchar(50),IN p_don_gia int,
IN p_ma_loai_khoa_hoc varchar(50),IN p_ma_chu_de varchar(50),IN p_anh_dai_dien varchar(200),IN p_chi_tiet_khoa_hoc text)
begin
		declare ma_khoa_hoc varchar(50) default null;
        declare  result_update integer default 0;
		insert into khoa_hoc(tieu_de,mo_ta,ma_nguoi_dung,don_gia,ma_loai_khoa_hoc,ma_chu_de,anh_dai_dien,chi_tiet_khoa_hoc)
        values(p_tieu_de,p_mo_ta,p_ma_nguoi_dung,p_don_gia,p_ma_loai_khoa_hoc,p_ma_chu_de,p_anh_dai_dien,p_chi_tiet_khoa_hoc);
        
        select row_count() into result_update;
			if(result_update>0) then
					select c.ma_khoa_hoc into ma_khoa_hoc from khoa_hoc c order by 
                    (convert(substring_index(c.ma_khoa_hoc,'KH',-1),unsigned int)) desc limit 1; 
                end if;
          select ma_khoa_hoc as courseID from dual;       
        
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_nguoi_dung`(IN p_ten_nguoi_dung varchar(100), IN p_email varchar(100), IN p_mat_khau varchar(100),out result integer)
begin
	insert into nguoi_dung(ten_nguoi_dung,email,mat_khau) values (p_ten_nguoi_dung,p_email,p_mat_khau);
    
    select row_count() into result from dual;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_key_reset_by_ma_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_key_reset_by_ma_nguoi_dung`(IN p_ma_nguoi_dung varchar(50))
begin 
	select n.key_reset from nguoi_dung_cn n where n.ma_nguoi_dung =p_ma_nguoi_dung  and n.key_reset is not null;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_ngay_cap_nhat_mk_by_ma_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_ngay_cap_nhat_mk_by_ma_nguoi_dung`(IN p_ma_nguoi_dung varchar(50))
begin
	select n.ngay_cap_nhat_mk from nguoi_dung_cn n where n.ma_nguoi_dung=p_ma_nguoi_dung order by n.ngay_cap_nhat_mk desc limit 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_nguoi_dung_by_email` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_nguoi_dung_by_email`(IN p_email varchar(50))
begin
	select * from nguoi_dung n where n.email =p_email;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_nguoi_dung_by_ma_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_nguoi_dung_by_ma_nguoi_dung`(IN p_ma_nguoi_dung varchar(50))
begin
	select * from nguoi_dung n where n.ma_nguoi_dung =p_ma_nguoi_dung;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_nguoi_dung_quyen_by_ma_nguoi_dung` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_nguoi_dung_quyen_by_ma_nguoi_dung`(IN p_ma_nguoi_dung  varchar(50) )
BEGIN

select q2.* from nguoi_dung n inner join quyen_truy_cap q 
on n.ma_nguoi_dung=q.ma_nguoi_dung inner join quyen q2 on 
q.ma_quyen=q2.ma_quyen where n.ma_nguoi_dung=p_ma_nguoi_dung;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_bai_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_bai_hoc`(in p_tieu_de varchar(100),in p_noi_dung text,in p_ma_chuong_muc varchar(50),out result varchar(50))
BEGIN
	insert into bai_hoc(tieu_de,noi_dung,ma_chuong_muc) values(p_tieu_de,p_noi_dung,p_ma_chuong_muc);

	select concat(p_ma_chuong_muc,'BH',max(convert(substring_index(b.ma_bai_hoc,'BH',-1),unsigned int))) into result from bai_hoc b ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_chuong_muc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_chuong_muc`(in p_ma_khoa_hoc varchar(50),
in p_tieu_de varchar(200),in p_noi_dung varchar(200),in p_tom_tat varchar(200), out result varchar(50))
BEGIN
	insert into chuong_muc(ma_khoa_hoc,tieu_de,noi_dung,tom_tat) values(p_ma_khoa_hoc,p_tieu_de,p_noi_dung,p_tom_tat);
    
	select concat(p_ma_khoa_hoc,'CH',max(convert(substring_index(c.ma_chuong_muc,'CH',-1),unsigned int))) into result  from chuong_muc c ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_dang_ki_khoa_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_dang_ki_khoa_hoc`(IN p_ma_khoa_hoc varchar(50),IN p_ma_nguoi_dung varchar(50),OUT result varchar(50))
begin
	insert into dang_ky_khoa_hoc(ma_khoa_hoc,ma_nguoi_dung) values (p_ma_khoa_hoc,p_ma_nguoi_dung);
   
   select id_dkkh into result  from dang_ky_khoa_hoc order by  id_dkkh desc limit 1;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_dinh_kem_bai_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_dinh_kem_bai_hoc`(in p_ma_bai_hoc varchar(50),in p_noi_dung text,out result int)
BEGIN
	insert into dinh_kem_bai_hoc(ma_bai_hoc,noi_dung) values (p_ma_bai_hoc,p_noi_dung);
    select max(ma_dinh_kem_bai_hoc) into result  from dinh_kem_bai_hoc ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_lich_su_giao_dich` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_lich_su_giao_dich`(in  p_ma_hinh_thuc_giao_dich varchar(50),in p_no DOUBLE,
    in p_co DOUBLE,in p_ma_nguoi_dung varchar(50),in p_noi_dung_giao_dich varchar(100),out result varchar(50))
begin 
		insert into lich_su_giao_dich(`ma_hinh_thuc_giao_dich`,`no`,`co`,`ma_nguoi_dung`,`noi_dung_giao_dich`)
        values(p_ma_hinh_thuc_giao_dich,p_no,p_co,p_ma_nguoi_dung,p_noi_dung_giao_dich);
        
	select concat('GD',max(convert(substring_index(l.ma_lich_su_giao_dich,'GD',-1),unsigned int))) into result from lich_su_giao_dich l;
    
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_insert_user_role` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_insert_user_role`(IN p_userID varchar(50), OUT result integer)
begin
	set result := 0;
	insert into quyen_truy_cap(ma_nguoi_dung, ma_quyen) values(p_userID, 2);
    select row_count() into result;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_paging_query` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_paging_query`(IN p_page_number integer,IN p_size integer,out p_sum_page integer,out p_sum_records integer,IN sql_query varchar(255))
begin
declare v_start integer;
declare v_end integer ;
declare v_total_item integer default 0;

set v_start =(((p_page_number - 1) * p_size));
-- set v_end =(v_start+p_size)-1;


-- caculate number of record in table use input
set @qr =concat('select count(*) into @total_item from ( ',sql_query,' ) q');
prepare stmt from  @qr;
execute stmt;
deallocate prepare stmt;  
select @total_item into v_total_item;

-- set value
set p_sum_records=v_total_item;

-- caculate number of pages

if (v_total_item mod p_size =0) then
	set p_sum_page =v_total_item div p_size;
    else
    set p_sum_page =(v_total_item div p_size)+1;
    end if;

-- result of paging
set @qr2 =concat('select * from ( ',sql_query,' ) q  limit ',p_size,' OFFSET ',v_start);
prepare stmt from  @qr2;
execute stmt;
deallocate prepare stmt; 

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_paging_table` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_paging_table`(IN p_page_number integer,IN p_size integer,out p_sum_page integer,out p_sum_records integer,IN p_table_name varchar(255))
begin
declare v_start integer;
declare v_end integer ;
declare v_total_item integer default 0;

set v_start =(((p_page_number - 1) * p_size));
-- set v_end =(v_start+p_size-1)+1;


-- caculate number of record in table use input
set @qr =concat('select count(*) into @total_item from ',p_table_name,' n where n.trang_thai=1');
prepare stmt from  @qr;
execute stmt;
deallocate prepare stmt;  
select @total_item into v_total_item;

-- set value
set p_sum_records=v_total_item;

-- caculate number of pages

if (v_total_item mod p_size =0) then
	set p_sum_page =v_total_item div p_size;
    else
    set p_sum_page =(v_total_item div p_size)+1;
    end if;

-- result of paging
set @qr2 =concat('select * from ',p_table_name,' n where n.trang_thai=1 limit ',p_size,' OFFSET ',v_start);
prepare stmt from  @qr2;
execute stmt;
deallocate prepare stmt; 

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_remove_user_role` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_remove_user_role`(IN p_userID varchar(50), OUT result integer)
begin
	set result := 0;
	delete from quyen_truy_cap where ma_nguoi_dung = p_userID and ma_quyen = 2;
    select row_count() into result;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_thong_ke_theo_chu_de` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_thong_ke_theo_chu_de`(IN p_rows_limit integer, OUT totalCourse integer)
begin
	select cd.tieu_de as tenChuDe, count(kh.ma_khoa_hoc) as soLuongKhoaHoc 
	from chu_de cd left outer join khoa_hoc kh on cd.ma_chu_de = kh.ma_chu_de
	group by cd.ma_chu_de
	order by count(kh.ma_khoa_hoc) desc
	limit p_rows_limit;

	select sum(TEMP.SL) from (
		select count(kh.ma_khoa_hoc)  as SL from chu_de cd left outer join khoa_hoc kh on cd.ma_chu_de = kh.ma_chu_de
		group by cd.ma_chu_de order by  count(kh.ma_khoa_hoc) desc) TEMP into totalCourse;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_thong_ke_theo_khoa_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_thong_ke_theo_khoa_hoc`(IN p_rows_limit integer, OUT totalView integer)
begin
	select kh.tieu_de as tenKH, kh.luot_truy_cap as luotXem
    from tmdt.khoa_hoc kh
    order by kh.luot_truy_cap desc
    limit p_rows_limit;

	select sum(kh.luot_truy_cap) tongLuotXem
    from tmdt.khoa_hoc kh
    order by kh.luot_truy_cap desc
    into totalView;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove_key_reset` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove_key_reset`(IN p_ma_nguoi_dung varchar(50), IN p_key_reset varchar(200),OUT result integer)
begin 
	delete from nguoi_dung_cn where ma_nguoi_dung = p_ma_nguoi_dung and key_reset =p_key_reset;
    select row_count() into result from dual;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `save_key_reset` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `save_key_reset`(IN p_ma_nguoi_dung varchar(50), IN p_key_reset varchar(200),OUT result integer)
begin
insert into nguoi_dung_cn(ma_nguoi_dung,key_reset) values(p_ma_nguoi_dung,p_key_reset);
select row_count() into result from dual;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `thong_ke_diem_nguoi_dunng` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `thong_ke_diem_nguoi_dunng`(IN rows_num integer, OUT  total integer)
begin
select nd.ten_nguoi_dung , nd.diem 
from nguoi_dung nd
order by nd.diem
desc limit rows_num;
select SUM(nd.diem) 
from nguoi_dung nd
order by nd.diem
desc limit rows_num INTO total;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `thong_ke_top_khoa_hoc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `thong_ke_top_khoa_hoc`(IN rows_num integer , OUT  total integer)
begin
select kh.tieu_de , kh.luot_truy_cap 
from khoa_hoc kh
order by kh.luot_truy_cap
desc limit rows_num;
SELECT  SUM(kh.luot_truy_cap ) FROM khoa_hoc kh INTO total;
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-21 18:16:22
