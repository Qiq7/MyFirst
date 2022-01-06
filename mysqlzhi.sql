/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : mysqlzhi

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 06/01/2022 13:15:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `fileId` int(11) NOT NULL COMMENT '文件id（与项目id一致）',
  `fileName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `fileLevel` int(11) NOT NULL COMMENT '项目访问等级',
  `filePath` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  PRIMARY KEY (`fileId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of files
-- ----------------------------

-- ----------------------------
-- Table structure for iterm
-- ----------------------------
DROP TABLE IF EXISTS `iterm`;
CREATE TABLE `iterm`  (
  `itermId` int(11) NOT NULL AUTO_INCREMENT,
  `itermName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `itermContent` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目简介',
  `proposalWay` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目筹划书存储路径',
  `startDate` date NULL DEFAULT NULL COMMENT '项目开始时间',
  `status` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '项目状态（项目进度）（1初创，2种子，3成长）',
  `memberNum` int(11) NULL DEFAULT NULL COMMENT '项目成员数量',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目类型',
  `userId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '发起人id',
  `life` int(11) NULL DEFAULT NULL COMMENT '生命状态（1：为存在，0：为以删除）',
  `itermAddr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目地址',
  `budget` int(11) NULL DEFAULT NULL COMMENT '项目预算',
  `picWay` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `technical` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技术要求',
  `authority` int(11) NULL DEFAULT NULL COMMENT '权限（1：公开，0：私密）',
  PRIMARY KEY (`itermId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of iterm
-- ----------------------------
INSERT INTO `iterm` VALUES (1, '定制智能网关', '智能网关是集网关、路由、网路管理等多项功能于一体，支持WIFI和Zigbee两种通讯模式的智能主机，并以此和其它智能产品实现联动，实现智能产品的远程控制。 方便用户使用各种移动智能终端，轻松控制相关设备无线数据高速、安全、可靠传输,并且可实现以太网的互通互联。', NULL, '2021-08-02', 3, 2, '物联网', 2, 1, '福建省', 8000, 'itermPic\\158801607607.jpg', 'Android', 0);
INSERT INTO `iterm` VALUES (2, '智慧消防云管理平台', '这是一款SaaS化的智慧消防平台，实现各类传感器实时监测预警、 智能巡检等功能，可以在火警初期快速发出提醒，及早的发现并解 决各种安全隐患', NULL, '2021-08-16', 2, 11, '物联网', 2, 1, '福建省', 6000, 'itermPic\\158801607608.jpg', 'Web前端开发,网络工程师,Android', 0);
INSERT INTO `iterm` VALUES (7, 'UI/VI高端定制设计', '大庆运盛网络服务是国内领先的企业全网营销解决方案供应商，致力于用高品质的一站式服务，传统企业互联网+转型的大量人力成本、时间成本和经济成本，让科技，更简单。', NULL, '2021-08-02', 1, 10, '网站开发', 2, 1, '福建省', 5000, 'itermPic\\0.jpg', 'Web前端开发,网络工程师,Android', 1);

-- ----------------------------
-- Table structure for iterms
-- ----------------------------
DROP TABLE IF EXISTS `iterms`;
CREATE TABLE `iterms`  (
  `itermId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '项目id',
  `userId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '用户id\r\n',
  `limit1` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '用户权限（1：创建者，所有权限、2：管理者，拥有所有查看、下载、部分修改权限、3参与者，查看权限）',
  `time` date NULL DEFAULT NULL COMMENT '成员加入时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '成员状态（0：退出，1：参与，2：审核中，-1：拒绝）',
  `itermsId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自身id',
  `boosId` int(11) NOT NULL COMMENT '项目创建者id',
  PRIMARY KEY (`itermsId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of iterms
-- ----------------------------
INSERT INTO `iterms` VALUES (1, 3, 2, NULL, 1, 2, 2);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `itermId` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `memberName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成员姓名',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别（1，男，0，女）',
  `education` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `authority` int(11) NULL DEFAULT NULL COMMENT '权限（2：管理，3，普通成员）',
  `manageId` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NULL DEFAULT NULL COMMENT '成员年龄',
  `userId` int(11) NULL DEFAULT NULL COMMENT '成员id',
  PRIMARY KEY (`manageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, '小红', 0, '本科', 2, 2, 23, 3);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for relations
-- ----------------------------
DROP TABLE IF EXISTS `relations`;
CREATE TABLE `relations`  (
  `userId` int(11) NOT NULL COMMENT '主用户id',
  `frienId` int(11) NOT NULL COMMENT '好友id',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relations
-- ----------------------------

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `resumeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别（1：男，0：女）',
  `nowAddr` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居地',
  `schoolDate` date NULL DEFAULT NULL COMMENT '毕业时间',
  `school` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `education` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `salary` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '薪资期望',
  `type` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作类型',
  `addr` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作地址',
  `function` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职能',
  `workDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在职时间',
  `company` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作公司',
  `post` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作职位',
  `workContent` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '工作描述',
  `picWay` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像路径',
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `age` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`resumeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES (1, 2, 1, '河南省', '2020-09-01', '莆田学院', '本科', '软件工程', 7000, '全职', '湖北省', 'Web前端开发', '2', '志同道合创业有限公司', ' 前端技术开发', '一个人的公司', 'resumePic/2158801607601.jpg', '小刚', '15880160760', '2316601146@qq.com', 20);
INSERT INTO `resume` VALUES (2, 4, 1, '福建省', '2021-08-10', '莆田学院', '本科', '软件工程', 8000, '全职', '福建省', 'ui美工', '2', '志同道合有限公司', 'ui美工', '担任ui美工。', 'resumePic/41234562.jpg', '小明', '15759925982', '123@qq.com', 20);
INSERT INTO `resume` VALUES (3, 3, 0, '河北省', '2021-08-24', '莆田学院', '本科', '软件工程', 8000, '全职', '福建省', 'Java开发', '3', '志同道合有限公司', 'java开发', '担任java开发。', 'resumePic/31231.jpg', '小红', '15759925980', '123@qq.com', 23);
INSERT INTO `resume` VALUES (9, 11, 0, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'image/13.jpg', '小强', '15759925983', '123@qq.com', 0);

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text`  (
  `textId` int(11) NOT NULL AUTO_INCREMENT COMMENT '测试id',
  `textContent` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '测试文本',
  `textDate` date NOT NULL COMMENT '测试日期\r\n测试日期',
  PRIMARY KEY (`textId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES (1, '哈哈哈哈哈', '2020-01-01');
INSERT INTO `text` VALUES (2, '呼呼呼呼呼呼呼', '2020-01-02');
INSERT INTO `text` VALUES (3, '随便测测', '2021-05-03');
INSERT INTO `text` VALUES (4, '的撒娇啊实打实的阿斯顿阿斯顿撒旦阿斯顿阿达阿松大阿松大阿达阿松大阿迪斯阿松大阿松大阿松大阿松大阿松大', '2019-01-02');
INSERT INTO `text` VALUES (5, '卡萨丁那可能爱看点卡你开单看到', '2021-07-26');
INSERT INTO `text` VALUES (6, '那是多久那时的阿松大阿松大阿达哎爱', '2021-08-02');
INSERT INTO `text` VALUES (7, '阿三大苏打实打实的那啊啊的', '2021-07-19');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名(昵称)',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `roles` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户身份(1：管理员，0：用户)',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthdate` date NULL DEFAULT NULL COMMENT '出生日期',
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `picWay` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '福建福州', 'yhj', '123456', 1, '12345678910', '12345678910@qq.com', '2000-10-05', 'yhj', 'headSculpture/1.jpg');
INSERT INTO `users` VALUES (2, '莆田', 'xiaogang', 'Aa123456', 0, '15880160760', '2316601146@qq.com', '2000-01-01', '小刚', 'headSculpture/2158801607602.jpg');
INSERT INTO `users` VALUES (3, '福建省', 'xiaohong', 'Aa123456', 0, '15759925981', '123@qq.com', '2021-08-28', '小红', 'headSculpture/3157599259811.jpg');
INSERT INTO `users` VALUES (4, '河南', 'xiaoming', 'Aa123456', 0, '15759925982', '123@qq.com', '2021-07-14', '小明', 'headSculpture/4157599259822.jpg');
INSERT INTO `users` VALUES (5, NULL, 'hjx', 'Aa123456', 0, '18542569871', '123@qq.com', NULL, '何佳欣', 'image/13.jpg');
INSERT INTO `users` VALUES (11, NULL, 'xiaoqiang', 'Aa123456', 0, '15759925983', '123@qq.com', NULL, '小强', 'image/13.jpg');

SET FOREIGN_KEY_CHECKS = 1;
