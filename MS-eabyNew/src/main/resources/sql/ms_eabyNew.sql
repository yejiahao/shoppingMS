/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : ms_eabynew

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 06/02/2018 10:12:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (1, '鞋子');
INSERT INTO `classify` VALUES (2, '衬衫');
INSERT INTO `classify` VALUES (3, '手机');
INSERT INTO `classify` VALUES (4, '电子产品');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `commodity_number` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `commodity_made` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commodity_price` decimal(18, 2) NOT NULL,
  `commodity_balance` int(7) NOT NULL,
  `commodity_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `commodity_id` int(11) NOT NULL,
  PRIMARY KEY (`commodity_number`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '沃特篮球鞋', '佛山', 180.00, 500, '001.jpg', 1);
INSERT INTO `commodity` VALUES (2, '安踏运动鞋', '福州', 120.00, 800, '002.jpg', 1);
INSERT INTO `commodity` VALUES (3, '耐克运动鞋', '广州', 500.00, 1000, '003.jpg', 1);
INSERT INTO `commodity` VALUES (4, '阿迪达斯T血衫', '上海', 388.00, 600, '004.jpg', 2);
INSERT INTO `commodity` VALUES (5, '李宁文化衫', '广州', 180.00, 900, '005.jpg', 2);
INSERT INTO `commodity` VALUES (6, '小米3', '北京', 1999.00, 3000, '006.jpg', 3);
INSERT INTO `commodity` VALUES (7, '小米2S', '北京', 1299.00, 1000, '007.jpg', 3);
INSERT INTO `commodity` VALUES (8, 'thinkpad笔记本', '北京', 6999.00, 500, '008.jpg', 4);
INSERT INTO `commodity` VALUES (9, 'dell笔记本', '北京', 3900.00, 500, '009.jpg', 4);
INSERT INTO `commodity` VALUES (10, 'ipad5', '北京', 5900.00, 500, '010.jpg', 4);

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `commodity_price` decimal(18, 2) NOT NULL,
  `sum` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userpass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
