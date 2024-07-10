/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 10/07/2024 14:55:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `press` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1018 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1001, '三国演义', 19.90, '新华出版社', '罗贯中', 5);
INSERT INTO `book` VALUES (1004, '战国世纪', 8.88, '歪歪出版色', '王文杰', 4);
INSERT INTO `book` VALUES (1007, '我的从医生涯', 12.00, '文杰出版社', '王文杰', 1);
INSERT INTO `book` VALUES (1008, '我', 12.00, '文杰出版社', 'li文杰', 0);
INSERT INTO `book` VALUES (1009, '小崔的生活', 6.66, '瑜航出版社', '崔瑜航', 2);
INSERT INTO `book` VALUES (1010, '茶花女', 7.99, '人民出版社', '小仲马', 6);
INSERT INTO `book` VALUES (1011, '红与黑', 5.99, '灵魂出版社', ' 司汤达', 8);
INSERT INTO `book` VALUES (1012, '傲慢与偏见', 9.99, ' 德国出版社', ' 简·奥斯汀', 10);
INSERT INTO `book` VALUES (1013, '一个陌生女人的来信', 8.88, ' 歪日出版社', ' 茨威格', 9);
INSERT INTO `book` VALUES (1014, ' 罗密欧与朱丽叶', 5.99, ' 沙俄出版社', ' 威廉·莎士比亚', 8);
INSERT INTO `book` VALUES (1015, ' 爱情故事', 6.66, '美国出版社', ' 西格尔', 8);
INSERT INTO `book` VALUES (1016, '情书', 3.99, ' 日本出版社', ' 岩井俊二', 1);
INSERT INTO `book` VALUES (1017, '文杰在哪', 10.00, '瑜航出版社', '崔瑜航', 2);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `brid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `bid` int(11) NULL DEFAULT NULL,
  `btime` datetime(0) NULL DEFAULT NULL,
  `rtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`brid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `borrow_ibfk_2`(`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 10001, 1001, '2024-06-21 15:24:27', '2024-07-09 14:51:07');
INSERT INTO `borrow` VALUES (2, 10002, 1002, '2024-06-20 15:24:48', '2024-07-08 15:34:47');
INSERT INTO `borrow` VALUES (4, 10001, 1001, '2024-06-22 15:24:30', '2024-07-09 14:51:07');
INSERT INTO `borrow` VALUES (14, 10002, 1002, '2024-06-22 17:05:52', '2024-07-08 15:34:47');
INSERT INTO `borrow` VALUES (15, 10004, 1004, '2024-06-26 19:37:40', '2024-06-26 19:38:04');
INSERT INTO `borrow` VALUES (16, 10002, 1001, '2024-07-06 14:55:41', '2024-07-09 14:51:07');
INSERT INTO `borrow` VALUES (17, 10002, 1007, '2024-07-08 13:58:38', '2024-07-08 14:27:41');
INSERT INTO `borrow` VALUES (18, 10002, 1008, '2024-07-09 14:50:52', NULL);
INSERT INTO `borrow` VALUES (19, 10002, 1009, '2024-07-09 19:05:43', '2024-07-09 19:05:50');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10016 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10001, 'admin', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10002, 'wenjie', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10003, '杰哥', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10004, '王文杰', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10009, 'jiba', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10014, '崔新科', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES (10015, 'lyx88682', '202cb962ac59075b964b07152d234b70');

SET FOREIGN_KEY_CHECKS = 1;
