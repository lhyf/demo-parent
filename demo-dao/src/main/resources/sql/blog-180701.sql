/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 01/07/2018 17:30:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uri` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `category_id` int(11) NULL DEFAULT NULL COMMENT '所属栏目id',
  `user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hits` int(6) NULL DEFAULT NULL,
  `pv` int(6) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `allow_feed` bit(1) NULL DEFAULT NULL,
  `allow_ping` bit(1) NULL DEFAULT NULL,
  `allow_comment` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsgqpqfl0p7olcr7694a3pjl0q`(`user_id`) USING BTREE,
  INDEX `FKsgqp234pertlcr7694a3pjl0q`(`category_id`) USING BTREE,
  INDEX `title`(`title`) USING BTREE,
  CONSTRAINT `t_article_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_article_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (1, 'mybatis', '', 'resultType：使用resultType实现较为简单，如果pojo中没有包括查询出来的列名，需要增加列名对应的属性，即可完成映射。', 1, 1, '2018-06-15 11:07:56', 'publish', 12, 32, '2018-06-26 21:16:35', b'1', b'1', b'1');
INSERT INTO `t_article` VALUES (2, 'mysql', 'aaaaa', 'resultMap可以实现延迟加载，resultType无法实现延迟加载。', 1, 1, '2018-06-15 11:26:51', 'publish', 32, 5222, '2018-06-26 21:17:56', b'1', b'1', b'1');
INSERT INTO `t_article` VALUES (3, 'aaa', 'aaa', '**adasdwqeqweqwe**', 2, 1, '2018-06-21 22:55:45', 'publish', 0, 0, '2018-06-26 21:16:02', b'1', b'1', b'1');
INSERT INTO `t_article` VALUES (4, 'abc', 'abc', 'aafsdfer', 2, 1, '2018-06-21 22:56:22', 'publish', 0, 0, '2018-06-26 21:18:40', b'1', b'0', b'1');
INSERT INTO `t_article` VALUES (5, 'cctest', 'cc', 'cccccc', 1, 1, '2018-07-01 14:49:04', 'publish', 0, 0, '2018-07-01 14:49:22', b'1', b'1', b'1');

-- ----------------------------
-- Table structure for t_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_article_tag`;
CREATE TABLE `t_article_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL,
  `tag_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKewe8lxg2m9qerry15erwy`(`article_id`) USING BTREE,
  INDEX `FKewe8lxgwer9q23ry1dfsr`(`tag_id`) USING BTREE,
  CONSTRAINT `t_article_tag_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `t_article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_article_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article_tag
-- ----------------------------
INSERT INTO `t_article_tag` VALUES (5, 4, 5);
INSERT INTO `t_article_tag` VALUES (7, 3, 1);
INSERT INTO `t_article_tag` VALUES (8, 3, 3);
INSERT INTO `t_article_tag` VALUES (9, 3, 7);
INSERT INTO `t_article_tag` VALUES (10, 3, 8);
INSERT INTO `t_article_tag` VALUES (11, 1, 2);
INSERT INTO `t_article_tag` VALUES (12, 1, 4);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, 'mybatis', 3);
INSERT INTO `t_category` VALUES (2, 'java', 2);
INSERT INTO `t_category` VALUES (3, 'spring', 0);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `agent` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_id` int(11) NULL DEFAULT NULL,
  `parent` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKlsvvc2ob8lxg2m9qqry15ru0y`(`article_id`) USING BTREE,
  INDEX `FKlsvvc2o232ewer9qqry15ru0y`(`parent`) USING BTREE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `t_article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `add_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_picture
-- ----------------------------
INSERT INTO `t_picture` VALUES (4, '第二列33', '介绍2', '/picture/bfcdc8fdafc34664bab7e6d8fb2abcfb.jpg', '2018-06-30 10:52:26', '2018-07-01 14:50:28', '地点2');
INSERT INTO `t_picture` VALUES (6, '测试上传', '是否开始', '/picture/136c47ea458f4065a30f3838d9719b75.jpg', '2018-06-30 16:36:05', NULL, '设计师姐夫');
INSERT INTO `t_picture` VALUES (7, '23', '34', '/picture/6dd15d34ad5440ceb5ae57b16e75ee84.jpg', '2018-06-30 16:36:33', NULL, '243');
INSERT INTO `t_picture` VALUES (8, '额', '沙发斯蒂芬', '/picture/d19ca80a66894251a2b3f6704522b008.jpg', '2018-06-30 16:36:57', NULL, '多放水');
INSERT INTO `t_picture` VALUES (10, '无法发送', '色弱翁', '/picture/5e5025ede9c24505860d4ec485b6eb83.jpg', '2018-06-30 16:37:29', NULL, '十二五');
INSERT INTO `t_picture` VALUES (11, '舒服舒服xvc', '胜多负少', '/picture/1236d9483bab4eee89ec7e9b75bb75ad.jpg', '2018-06-30 16:37:47', NULL, '徐陈小春续');
INSERT INTO `t_picture` VALUES (12, '水电费', '收发文', '/picture/ff5ad3e6a645411490c2b233ccd1a98b.jpg', '2018-06-30 16:38:04', NULL, '水电费文');
INSERT INTO `t_picture` VALUES (13, '问', '水电费', '/picture/25d70f4958e44622b7b497e9ab5f6570.jpg', '2018-06-30 16:38:26', NULL, '等待戈多');
INSERT INTO `t_picture` VALUES (14, '且', '阿瓦达发展第三方', '/picture/4775d2568f5d4193bca83958a85e9bc5.jpg', '2018-06-30 16:39:55', NULL, '玩儿翁');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag_count` int(8) NULL DEFAULT NULL COMMENT '该标签出现的次数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, 'aa', 1, '2018-06-21 22:55:45');
INSERT INTO `t_tag` VALUES (2, 'bb', 1, '2018-06-21 22:55:45');
INSERT INTO `t_tag` VALUES (3, 'c', 1, '2018-06-21 22:55:45');
INSERT INTO `t_tag` VALUES (4, 'd', 1, '2018-06-21 22:55:45');
INSERT INTO `t_tag` VALUES (5, 'java', 1, '2018-06-21 22:56:22');
INSERT INTO `t_tag` VALUES (6, 'e', 0, '2018-06-26 21:13:08');
INSERT INTO `t_tag` VALUES (7, 'g', 1, '2018-06-26 21:14:35');
INSERT INTO `t_tag` VALUES (8, 'df', 1, '2018-06-26 21:16:02');
INSERT INTO `t_tag` VALUES (9, 'mysql', 0, '2018-06-26 21:17:28');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `last_login_date` datetime(0) NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '2018-06-15 10:39:45', NULL, 'tom', '昵称', '93c3ef4bc1b01b865028192eeda1a41d', 'online');

SET FOREIGN_KEY_CHECKS = 1;
