-- --------------------------------------------------------
-- 主机:                           192.168.188.101
-- 服务器版本:                        5.7.24 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 coderiver_codeforum_db.user_profile 结构
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  `email` varchar(255) COLLATE utf16_bin NOT NULL,
  `phone` varchar(255) COLLATE utf16_bin DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf16_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL,
  `description` varchar(255) COLLATE utf16_bin DEFAULT NULL,
  `workdaystarttime` int(11) DEFAULT NULL,
  `workdayendtime` int(11) DEFAULT NULL,
  `weekendstarttime` int(11) DEFAULT NULL,
  `weekendendtime` int(11) DEFAULT NULL,
  `createtime` bigint(20) NOT NULL,
  `updatetime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
