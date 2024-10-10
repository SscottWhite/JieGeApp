/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.31 : Database - jiegeapp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `jiegeapp`;

/*Table structure for table `login_success` */

DROP TABLE IF EXISTS `login_success`;

CREATE TABLE `login_success` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `token` varchar(500) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3;

/*Data for the table `login_success` */

insert  into `login_success`(`id`,`user_name`,`user_password`,`token`,`intime`) values 
(1,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE0ODQ1NCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTQ5MzU0fQ.N_YQqhgpATYim_ZM7C9MzJGOcaVuGHOYel5epbwWMugJbVxmqIyUvWpFq7KXVZpAm5wllC0tfXbJa50Eljp5Hg','2022-06-02 13:40:54'),
(2,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE0OTYxMCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTUwNTExfQ.8IydD8ehMuZw_6ryC334RSAVPQQXds3uDSEXEMIvhIvEMU2UBrjohkmcX9Gh3LqxnAskMTbLojDfQ_5xBySpIg','2022-06-02 14:00:13'),
(3,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE0OTg3MywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTUwNzc0fQ.vWo6tPhwns1WgTTe5FAFD6qzk4XoKakWMGHbuoMUm1Ut-7Y7sdSxbXkDqX8JvXQ5PTjkpCnH-Imajs31eolWEQ','2022-06-02 14:04:35'),
(4,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1NjA3NCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTU2MjU0fQ.3CGwxm9ixN0GZn75dgNsYTMvXs4RPkufjDHeJVvEFuwBGeopppnS0eOBSeW8XxhTAeh6DG11eBo1d8AK6rHzjw','2022-06-02 15:47:57'),
(5,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1NjQ2MywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTU2NjQzfQ.vaMWrqN5JWLeZNqgaAewVmNHIOxoaR0943JOIrZxAQ9LSEXysMKMZjv9MRNAFwiuQQ4o5HdjGiUwCcvPP3nOvA','2022-06-02 15:54:24'),
(6,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1NjY5NSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTU2ODc1fQ.i8KOaj-tRZE0QT8RNKHQ1IJF2ERuQIbmYFExJMUipfpOFhNv-qWxft0fqxQcdi-6aBVF6N1oc4JjrPiK5i7tDA','2022-06-02 15:58:17'),
(7,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1ODU2NCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTU4NzQ1fQ.vHH-NiyqUWh78dj_HjSCoSyArcb5BS9jPEowYynPM3zOHpZhqvdqoFS8i22qmP9NiXwCdcpOrrUfKRBnavsYqw','2022-06-02 16:29:27'),
(8,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1OTYyNiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0MTU5ODA2fQ.CjHA82Xnx_6sQRlo_WQRzmRGPEs__uAlnOSlycRpaKN11DY5BNIhLwuRdkXg1WzYlmxugaTyS3AGEi-ttK_KpQ','2022-06-02 16:47:06'),
(9,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDE1OTkyNCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU0NzY0NzI1fQ.rmbpP4WjlVG8nfzyPxU1_nnwOtF7aA4yMqHXNop5VpR7KfJtiFo0v2NadoNFCzYVLxjzbk9aTU_Be6lpOM2DpQ','2022-06-02 16:52:06'),
(10,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQxOTEyNSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU1MDIzOTI1fQ.v5McL2BsfTPDAsg96E6bhIBoc3x50Y6TfoH57ZhVo6WyoI6na9BdhyChbIKcuSZB28iBMJ7yXAbElC2JYdpNYg','2022-06-05 16:52:06'),
(11,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3NjQ0MCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJudWxsIiwiZXhwIjoxNjU1MDgxMjQwfQ.3JJyGM9nCSOVqeDGLQVcEUdO_yS2QuVRoEJuUMSCiv1UN9VxnAgOdkaMSVyup5Swztgj6HFJ4ctd97-4kGoGBA','2022-06-06 08:47:21'),
(12,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3Njg1NSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOXCJ9XSIsImV4cCI6MTY1NTA4MTY1NX0.TIu71Tq1dv6DTctesY9UxA1xLszRvbvom0Q6YrwryXHDEvlzARE_2h9L_SrMQ_IRnVpoq6bT-dBxo3LntZvjsw','2022-06-06 08:54:16'),
(13,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3NzQyNiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOXCJ9XSIsImV4cCI6MTY1NTA4MjIyNn0.Mvs8F7kCOpJO5h9hYLJpvhOIXO8Mh5Y8aXepeW2qAktWfwKLm6Kjl990ySxEQVgaIAUDqtTHeoyFAJ799VLoxA','2022-06-06 09:03:47'),
(14,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3NzcwMCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODI1MDB9.kYvVoE3zLe5B8jq4ufP7hqAgUlR7BxD1XxlXj2PcS5p85ipTEgD8Q_BtDRZ81MxQKSOU80cOR64ZtkixFxbJ-w','2022-06-06 09:08:21'),
(16,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3OTUwMCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODQzMDB9.2otKeoPTsDTuC1kXH_37TuzKnq1KhqpNzeE7y0jxDiwG7RZ1FY7HX-EnhS4N_SzVVepXKXfRz15CVKxESTsvBA','2022-06-06 09:38:21'),
(17,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3OTg0NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODQ2NDZ9.aTmJNbGRbsXvVjEv7CDe2h2Y68k1KifxZbhy6wp-j45Yn6bP4bv4aq5h9bftsB7SEPaHscMa_mYKZAL7I-ppYw','2022-06-06 09:44:07'),
(18,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ3OTk4OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODQ3ODl9.uAhoiU7tlwYKFm4Wuvfn3aYKBI1wDCY8lmA0-MHQlzvMkH0ONe0KWryVZQsAFqdBv-HxlcHyBXmjE0hYLfSQlw','2022-06-06 09:46:30'),
(20,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4MjMxMiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODcxMTJ9.JNR5b2Yjf9a3ceM7HRrFsQVpmSYtSGF5uHH7tK2P7QXwSvM0p-LbAaAqgaYtLm1jEyuXySHohrY4pt6ayPcDuw','2022-06-06 10:25:13'),
(21,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4MjY3MiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODc0NzJ9.47IlZwdhjDzaz1Ixzdtz5Vh00rhqnCXloXoTkkoOTReyxWHZQBa06DjJiUN3npX9wNUXJSSz1A-0Caoy8s_l3g','2022-06-06 10:31:13'),
(22,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4MjgyNSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTUwODc2MjV9.FThrPFW0vP8RivMBs5AXv6_aQ1GzhalTjMR9kthrMhOcAFAsMAWr01OLXXXc_ZTzdt_3wEx2VqhiYJZvYyexEA','2022-06-06 10:33:46'),
(23,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4MzA1NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTQ0ODMwNjZ9.fRaY_bGIJD0X5HkVDrj-Q-4WYL677loDDNQMZp2EKRdHFOIEMDWc-02z_-gios0truFC2QipvR0uuC1ZmJF5QQ','2022-06-06 10:37:36'),
(24,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4NTEzOSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTQ0ODUxNDl9.yaV8cbGR_jM3AhFx5UBUfWeMmKiIzbHVIB1cS7v2Cm3PA5rKLh7oGDELwME-T0jAVa0h7WPSldJCy0zcURPyRQ','2022-06-06 11:12:20'),
(25,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4NTI3NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOMVwifSx7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU4yXCJ9LHtcImF1dGhvcml0eVwiOlwiUk9MRV9BRE1JTlwifV0iLCJleHAiOjE2NTQ0ODUyODZ9.d2KFAPbrq8BU0gHcFqMXToIszXfq4loUb6X1cluDaDRvkISXz5BLSMgf8u2kzFCUyCoAZ2hLeplgsjBm-7qZYA','2022-06-06 11:14:37'),
(26,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4NTcxNCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX1VTRVJcIn1dIiwiZXhwIjoxNjU0NDg1NzI0fQ.bKKyJpWsY_6JpgRvaolJc3nrgCdbKnKwxTy0IO3-uouJUtsmWFUH4CeiGwRrqItrPOFxyRQrB3Ekzu5bniymtw','2022-06-06 11:21:55'),
(27,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4NTc3MiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX1VTRVJcIn1dIiwiZXhwIjoxNjU0NDg2MDcyfQ.LWIXwh7ESjQUQIMTh58IHkg84YjOOb4ys6G_kLu0bc0y61fpLcEcw-LdJi4r2WB0n48zJs_xmYSVSCUBXTPxMg','2022-06-06 11:22:53'),
(28,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4NjAzMywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX1VTRVJcIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX0FETUlOXCJ9XSIsImV4cCI6MTY1NDQ4NjMzM30.I44kO9PyEhiTyXPST6o6LB6CCfIw8X5zEV_IGTrqB8oBFpjNDHPNEPQHm6gVecAyGPfTVJA2mHG7coWV7IETaQ','2022-06-06 11:27:13'),
(29,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ4Njc4NywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDg3MDg3fQ.9TGx_Cww3020CyEg3OivPqjT-55_U0d8bvRXE3zOvUooPPcU0zMLvoP2BIwpjDduREo2p2xjsD9UtSDz2K_6Hg','2022-06-06 11:39:47'),
(30,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5MjYyMywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDkyOTIzfQ.fcOf_RMd-a5HQfMi22jc7jZtREjO4BSeMFpr_DSDzeBn6O8g__8vN33PIiQTwvYUUceVlH0Du_RexzxC5Gvu8Q','2022-06-06 13:17:04'),
(31,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5MzgzMywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk0MTMzfQ.W4giF24Qrf-020duKxqn7RbGFihksTl51ICCgnOSjZc6IVLyc-dn-25bq7NgUd9ZEq7LU82pN7bT01HgBVGBvg','2022-06-06 13:37:13'),
(32,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5Mzg3NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk0MTc2fQ.0pgNzskPlKET-kdCvRmPol9EI71Uk6cpvIsY9YTL08dL6HDVDRYPa4qsKrWNS9VTS9jxH_mMsRyu3iVALvM05Q','2022-06-06 13:37:57'),
(33,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5NDc3NywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk1MDc3fQ.HXZrMAmGD9llKOY5-5NT04xS-eqsDU6_rsO6Ju5PeoAwwSsAO3d7QrGrRUHJiTfzA4NqFTmxleR7MojfM9MMPQ','2022-06-06 13:52:57'),
(34,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5NTcyOCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk2MDI4fQ.UAE_OuT_rP-h5IiuVvgE3vrpUdKpWjG8EvzqdObykZMRNxGoeRPRiEBBIfaRyXkEJutL9dVQFZ5DBX76wFn1cw','2022-06-06 14:08:48'),
(35,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5NzAzMywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk3MzMzfQ.hqtVwdg8nXLzuIxUjoihRZBikReMohy9Onvp97S2V4xsuxcKGphMzhhLpx-oj5gVc2j8ZRFUzFySO9-lGNrH8w','2022-06-06 14:30:33'),
(36,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5OTMzNSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NDk5NjM1fQ.-58CT0hquEVnWTcdLbwY4cT2K59bg_mzsiQlhffhDIsNv3JnObpWN02b_bW2r_ey03k3o1OsmcIJgKiGwTpA5Q','2022-06-06 15:08:56'),
(37,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDQ5OTgyNiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTAwMTI2fQ.0vr_bdltAZBkIjFCHsdXn8gAPys1vTBfm4h7_WlFnPgCLsPgraHZbT1RqM8Dvv_uIPLpdYbwxXUK4QwNU-0LVg','2022-06-06 15:17:07'),
(38,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDUwMjA4NywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTAyMzg3fQ.5j11bwIoTbXd7-zw_X5togNwT_kkzTqgEZ8ps-OZDboHlEiwzw7r00iWqK0Uh9LIAjY6NgbKNUS-LuWZyYccYQ','2022-06-06 15:54:47'),
(39,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDUwMzcwNywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTA0MDA3fQ.w85BEcDENrT4NEVn6edtcaWgOsxWAIuSzKPC93AiGUvUiGBLrEUlMZJw2S6tb1teFQaw5tiqZ4A1TiQMkYCJvQ','2022-06-06 16:21:48'),
(40,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDUwMzkxNywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTA0MjE3fQ.5YyCSFe__QkiWmcs7Y_jH60hyMdoTl0hQTZcTqvDpKZViPlcm44JosXDYO47eyinP6fE4Gb9fIKHn08kR9PwGA','2022-06-06 16:25:17'),
(41,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDUwNDAzOSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTA0MzM5fQ.p5EV8vj-LvGtkU_1S7RnaE5dJUZqq9Ymses-o-C6omXXq-K6_ak8fJWqa0e7wUwdpHBUffjS7Q3w09jIKtX82Q','2022-06-06 16:27:20'),
(42,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NDUwNDUyMiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU0NTA0ODIyfQ.-LTla5q2S4l3hYqrVXsVUVFAOSWsmrpdvo1LvicGsAOmAcMNlcAVHwRUMwzpzNextvwmNNmyYvIZCYOMnU1lqg','2022-06-06 16:35:23'),
(43,'locl','nmfd1V1bxhk=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyIiwic3ViIjoibG9jbCIsImlhdCI6MTY1NzMzMTg5OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNjU3MzMyMTk5fQ.L4ZnK7PP6rjg4wKx-pY9T9ag0WRcFqmdac3qBioGTLxwOWx_lGkYBT0F5Qg6lx4GAZ-M4CZu1CF_wIDHZzMMnQ','2022-07-09 09:58:20'),
(44,'locl11','2356','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoibG9jbDExIiwiaWF0IjoxNjgyNjQ5MzgxLCJpc3MiOiJTc2NvdHQiLCJhdXRob3JpdGllcyI6IltdIiwiZXhwIjoxNjgyNjQ5NjgxfQ.E-S8T3H9pmTZkO0AuNPnsdF1vlZyfWQOmIzoLwXzQOZLACd7SRUXsF2--ePS_gmWVRJlR5UM8MEZcfNNnUT1xQ','2023-04-28 10:36:23'),
(45,'locl11','2356','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoibG9jbDExIiwiaWF0IjoxNjgyNjQ5NTkyLCJpc3MiOiJTc2NvdHQiLCJhdXRob3JpdGllcyI6IltdIiwiZXhwIjoxNjgyNjQ5ODkyfQ.LLR9OSDTWneKLB2c4EYIG7F9F1mBPXo7C8EiNGsX4e73RL_ehnISZujvbQiAISl7QhCkeSn5Jpa3Ai1AozQ72g','2023-04-28 10:39:53'),
(46,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTY4ODA5MDQ1OCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTY4ODA5MDc1OH0.bd6TUBSv0iNjJpTo1xDyAsmuyK_Neia829HVmh9hkj3guWyB1G-5ZUelijtqFZG_yZ34JMLELwwPBkr1otFHcg','2023-06-30 10:01:00'),
(47,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTY4ODQ0MTg5OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTY4ODQ0MjE5OX0.M7mQpt-QjZ9mdJWP9doYUfezKJs1e1XfIQpYTrdPSyfJ7DxZR8UKXPg9597E340au-NmWG9VvAwQUGizNTKkjQ','2023-07-04 11:38:23'),
(48,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTY4ODQ0MTg5OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTY4ODQ0MjE5OX0.M7mQpt-QjZ9mdJWP9doYUfezKJs1e1XfIQpYTrdPSyfJ7DxZR8UKXPg9597E340au-NmWG9VvAwQUGizNTKkjQ','2023-07-04 11:38:23'),
(49,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTc4OTgxOSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTc5MDExOX0.qas2SWfAVernjMsihWCB2kej5d3fcLvGCW_TpLPS7CZSFfOeL25MxBQUcGlyFOa9bBGtMhKkjbwrCIg7bTyX8A','2024-03-07 13:37:03'),
(50,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTc5MTEyNSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTc5MTQyNX0.OX1ih2yq32EptqoGYQhOSaRF4AKkLi6wzU32lJ6kWvrb4FodiCDv52yiiEsc1ni7jr9cicYZBgYFIgCqglZNeg','2024-03-07 13:58:46'),
(51,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTc5NzE5NSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTc5NzQ5NX0.iinFZRHjuD-pp3JIRnMXHESQAZ2ffg0NhGMFLnYufEU8aVPhKdjw0CkgsB2-4mqSRMuE9HJG86Y0NCV-vHO7ZA','2024-03-07 15:39:57'),
(52,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTc5NzE5NSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTc5NzQ5NX0.iinFZRHjuD-pp3JIRnMXHESQAZ2ffg0NhGMFLnYufEU8aVPhKdjw0CkgsB2-4mqSRMuE9HJG86Y0NCV-vHO7ZA','2024-03-07 15:39:57'),
(53,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTc5NzgzOSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTc5ODEzOX0.spHyfCM2wdaNmyyd05ol_VZUBxnUpCZAOxBKMoJmBt6s8aGVjAzDhwon_4u8t_DwyI-dUHy7T9pkuJtrh5nb2g','2024-03-07 15:50:40'),
(54,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTg2MzUwMywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTg2MzgwNH0.JnSHwq0Fp8GZnrIMeVSGwCMT7mgCSrl20bdf-Mv5lh1KC_CiAn5MsO9nnFzZW84KhGDSZ0SP-7IoHs7Wm6z6Yw','2024-03-08 10:05:06'),
(55,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTg2NDY3MSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTg2NDk3MX0.UxzCZCwryCBNd1Lzp7m9G7LXbKTE4BKw5PZMOFc93K5oI25DLlJrTXVmEiAoSPSpnAUG0MLTXVMZ_lOBBKrd3w','2024-03-08 10:24:32'),
(56,'rose','123','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzIiwic3ViIjoicm9zZSIsImlhdCI6MTcwOTg2NTgyNSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbXSIsImV4cCI6MTcwOTg2NjEyNX0.S4-_EJ6nilAQitaI3Fuy_QWz-vXZZWGg42K40UTJZskGD3RHX8ZhG4rR8UkFoz0yNM7B69LTIdUT3ZXhuCNo_Q','2024-03-08 10:43:46'),
(57,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2NTg4MCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY2MTgwfQ.DTXH6rMn-Dfc1iXRBe0xtkU2d6V4mDIQMvYsqcoOwFXrjQOd3_wlfHOnmtAoA0rdTzr_-Do0Zr02SywpcgnfXA','2024-03-08 10:44:41'),
(58,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2NjAwNywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY2MzA3fQ.lUeTABDI_ltfgLfDCefgvRkrOJLKiiF7q0DpJF_CRnuMUAppMMDyGG72B1Q5goXYkw6cf6uX8dASErbm5Qz8JQ','2024-03-08 10:46:47'),
(59,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2NjAzOSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY2MzM5fQ.TuJ0Xb-Vpj6VFaOy7DuD4dJMfuQRZgy6QiLHrnSWoVhxplJte7OXRQZWlRFi9NougX40utgMmZ7RRCX-ZOcvVw','2024-03-08 10:47:19'),
(60,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2NzE5NywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY3NDk3fQ.za33-20svvRSx7o_XV3WA3a0Mi2kzNjG5cUnNMloEc31Pv9JG3-9EwUzCHJfNu76N8PMGxy-ayuFUfXKBmriPg','2024-03-08 11:06:38'),
(61,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2ODA0OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY4MzQ5fQ.tUWSX49JdVTx0mwusJXd55Iwa15_HbM-7JWsX48K2RGGPpNAZr1FCqJzoin2MTV79tt4uO0_zzwmW0bZhqjG7Q','2024-03-08 11:20:50'),
(62,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2OTEzOCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY5NDM4fQ.-HXmZpRY2t_6pFzwup6dWZqX2I0FiU1iRJbdidhuU8TDLFrSg8hDZro-9DVHgIury18U_6OdHLBdqZBkYNI85Q','2024-03-08 11:38:59'),
(63,'jack','jack','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg2OTEzNywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODY5NDM4fQ.HtslGjBK_B72EcPF1zxqO6IGGJxteyom3j2mWNMA6loqg1WspYgwL4l3M09pyLEn1QXhKL7oJdcnzT7NGuPPyg','2024-03-08 11:38:59'),
(64,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3NDU2MCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc0ODYwfQ.Yn58VZQYalbdSpSwjd1u5MXE875olr_fRz1S1WopHhhVNl0solUYtTJSjXvUP03Nip5MuK4wbJemeOArPrYSwg','2024-03-08 13:09:21'),
(65,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3NTg4NywiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc2MTg3fQ.OJOplQ7nRKkC0SOpaCr_b7Y5zpPrDe3rgZ7-BWv8mTiBhk7Vp5khhScWUYcT-nO4lovjvN89ir6uu_PIPNnJbg','2024-03-08 13:31:28'),
(66,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3NjI3NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc2NTc2fQ.XRiBa-odf8I9KqTVWjlNnMbA7KgdR0rscAj_on5ArcTV_NZqQseJuMDvzSFj4bHQJwfXeXCyL5BNpCeUDxciuA','2024-03-08 13:37:57'),
(67,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3NzMyNiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc3NjI3fQ.IbHsPKwOYHLzN9gkuIYKuqVaK8a-lQFKKxiEgnxeDpHEVbhNSswjyf3Pe7g08R0vCnkHxo2KIwEYUymB-hZscA','2024-03-08 13:55:28'),
(68,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3ODQ5OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc4Nzk5fQ.42OqVY_tclyOsXNTR2Q6-G4DBC8xOtxWsbBTomHfEYFOVzawzATO-AT_5p4-5FxY3-zzNCLOqBkCfLtGYQ3WOg','2024-03-08 14:15:00'),
(69,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3ODg5OSwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc5MTk5fQ.6xXGBLoa0-fxTYIqCsguJOnb0US9AP3ogE1f3Y7Rx-dCgIe3tM_z5ysD1tGkzKXDBRz2xIi2lzI8iMSwgDJFfw','2024-03-08 14:21:40'),
(70,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg3OTM1NiwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODc5NjU2fQ.2Nb8fwuUBF769JZnO584LhAiADClgmyDLZeAB1Dtkxc9xTN5p5MEqzCTNu3gZxZzGn9ni8fEemYu8lsfDmuxcA','2024-03-08 14:29:17'),
(71,'jack','srfpw8hh1S4=','whiteeyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlhdCI6MTcwOTg4MDQyNCwiaXNzIjoiU3Njb3R0IiwiYXV0aG9yaXRpZXMiOiJbe1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czp1c2VyOmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czptZW51OmluZm9cIn0se1wiYXV0aG9yaXR5XCI6XCJST0xFX3N5czpyb2xlOmluZm9cIn1dIiwiZXhwIjoxNzA5ODgwNzI0fQ.uwssilOxJIr1DDJYzNlsHhUFZr5Gxl-3Uqe3-S2EmiAPg3btIobSo3p9_I3ywRbZteWpZ44xPCPyfGWmulsrgg','2024-03-08 14:47:05');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`name`,`permission`) values 
(1,'查看用户信息','sys:user:info'),
(2,'查看所有权限','sys:menu:info'),
(3,'查看所有角色','sys:role:info'),
(4,'',NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`) values 
(1,'ADMIN'),
(2,'USER');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='角色与权限关系表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values 
(1,1,1),
(2,1,2),
(3,1,3),
(4,2,1);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `status` varchar(10) DEFAULT NULL COMMENT '状态 PROHIBIT：禁用 NORMAL：正常',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='系统用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`password`,`status`) values 
(1,'admin','$2a$10$5T851lZ7bc2U87zjt/9S6OkwmLW62tLeGLB2aCmq3XRZHA7OI7Dqa','NORMAL'),
(2,'user','$2a$10$szHoqQ64g66PymVJkip98.Fap21Csy8w.RD8v5Dhq08BMEZ9KaSmS','NORMAL');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='用户与角色关系表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values 
(1,2,1),
(2,2,2),
(3,1,2),
(4,1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `user_age` int DEFAULT NULL COMMENT '用户年龄',
  `user_permission` varchar(100) DEFAULT NULL COMMENT '用户权限',
  `user_gender` char(2) DEFAULT NULL COMMENT '用户性别',
  `user_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `status` varchar(50) DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`user_age`,`user_permission`,`user_gender`,`user_password`,`status`) values 
(1,'jack',12,'no','未知','srfpw8hh1S4=','NORMAL'),
(2,'locl',33,'goog','男','nmfd1V1bxhk=','NORMAL'),
(3,'rose',12,'goog','男','123','NORMAL');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;