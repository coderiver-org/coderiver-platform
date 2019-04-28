-- --------------------------------------------------------
-- 主机:                           192.168.0.201
-- 服务器版本:                        5.7.25 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 coderiver_base 的数据库结构
CREATE DATABASE IF NOT EXISTS `coderiver_base` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `coderiver_base`;

-- 导出  表 coderiver_base.project_category 结构
CREATE TABLE IF NOT EXISTS `project_category` (
  `id` varchar(64) NOT NULL COMMENT '项目类型id',
  `name` varchar(255) DEFAULT NULL COMMENT '类目类型名称',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目类型表';

-- 数据导出被取消选择。
-- 导出  表 coderiver_base.project_info 结构
CREATE TABLE IF NOT EXISTS `project_info` (
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名字',
  `project_difficulty` float DEFAULT NULL COMMENT '项目难度',
  `category_id` varchar(64) NOT NULL COMMENT '项目类型类目编号',
  `project_status` int(11) DEFAULT '0' COMMENT '项目状态, 0招募中，1 进行中，2已完成，3失败，4延期，5删除',
  `project_desc` varchar(512) DEFAULT NULL COMMENT '项目简介',
  `project_creater_id` varchar(64) NOT NULL COMMENT '项目创建者id',
  `team_id` varchar(64) DEFAULT NULL COMMENT '项目所属团队id',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`project_id`),
  KEY `project_creator_id` (`project_creater_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。
-- 导出  表 coderiver_base.project_like_user 结构
CREATE TABLE IF NOT EXISTS `project_like_user` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `user_id` varchar(64) NOT NULL COMMENT '点赞的用户id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '点赞状态，0 取消点赞，1点赞',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型 1点赞 ',
  `create_time` bigint(64) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(64) DEFAULT NULL COMMENT '更新时间 ',
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  KEY `liked_post_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。
-- 导出  表 coderiver_base.project_picture 结构
CREATE TABLE IF NOT EXISTS `project_picture` (
  `id` varchar(64) NOT NULL COMMENT '图片id',
  `project_id` varchar(64) NOT NULL COMMENT '项目id',
  `picture_url` varchar(255) NOT NULL COMMENT '图片地址',
  `picture_url_32` varchar(255) DEFAULT NULL,
  `picture_url_64` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目截图';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
