/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : geek

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 25/11/2020 08:18:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单编号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `order_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单状态',
  `payment_method` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '付款方式',
  `district_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `payment_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `shipping_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `address_id` int(11) NULL DEFAULT NULL COMMENT '收获地址id',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '确认收货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_detail`;
CREATE TABLE `tbl_order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单编号',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品名称',
  `product_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品主图',
  `unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `buy_num` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_product
-- ----------------------------
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE `tbl_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '所属分类id',
  `product_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品编码',
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品名称',
  `product_subtitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品副标题',
  `product_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '商品详情',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `product_stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `product_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品状态 1-未发布 2-已发布 3-已删除',
  `weight` double(5, 2) NULL DEFAULT NULL COMMENT '商品重量',
  `length` double NULL DEFAULT NULL COMMENT '商品长度',
  `width` double NULL DEFAULT NULL COMMENT '商品宽度',
  `height` double NULL DEFAULT NULL COMMENT '商品高度',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_product_pic
-- ----------------------------
DROP TABLE IF EXISTS `tbl_product_pic`;
CREATE TABLE `tbl_product_pic`  (
  `id` int(11) NOT NULL,
  `product_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `pic_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品图片url',
  `pic_order` int(2) NULL DEFAULT NULL COMMENT '排序',
  `pic_desc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图片描述',
  `is_master` tinyint(1) NULL DEFAULT NULL COMMENT '是否主图：0.非主图1.主图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品图片信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系电话',
  `head_img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `regist_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_user_address
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_address`;
CREATE TABLE `tbl_user_address`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '收货人联系电话',
  `receiver_province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所在省份',
  `receiver_city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所在城市',
  `receiver_district` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所在区县',
  `receiver_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '详细地址',
  `receiver_zip` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮编',
  `is_default` tinyint(1) NULL DEFAULT NULL COMMENT '是否默认地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户地址表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
