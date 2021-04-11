/*
 Navicat Premium Data Transfer

 Source Server         : mysql-8.0数据库
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : scenicticket

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 11/04/2021 22:17:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for conductor
-- ----------------------------
DROP TABLE IF EXISTS `conductor`;
CREATE TABLE `conductor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
  `realname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名，注册后实名认证成功方可显示',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `profile_img` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像链接url',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `mailbox` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间，自动生成',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '注销标识，0或1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '营业员基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor
-- ----------------------------
INSERT INTO `conductor` VALUES (1, '张晓', '男', '0057.jpg', '你好明天', '15223231609', '232343234@qq.com', '530382199806122953', '2020-12-05 11:07:44', b'0');
INSERT INTO `conductor` VALUES (2, '杨莉', '女', '0056.jpg', '', '15223231609', '232343234@qq.com', '530382199806122953', '2020-12-05 11:07:44', b'0');
INSERT INTO `conductor` VALUES (3, '何晓', '女', '0055.jpg', '', '15223231609', '232343234@qq.com', '530382199806122953', '2020-12-05 11:07:44', b'0');
INSERT INTO `conductor` VALUES (4, '张彩', '女', '0049.jpg', '', '15223231609', '232343234@qq.com', '530382199806122953', '2020-12-05 11:07:44', b'0');
INSERT INTO `conductor` VALUES (5, '王旭', '', '0048.jpg', '', '15223231609', '232343234@qq.com', '530382199806122953', '2020-12-05 11:07:44', b'0');
INSERT INTO `conductor` VALUES (6, '张丽', '女', '0047.jpg', 'sky_123', '19923876321', '222314223@qq.com', '1234567890', '2020-12-17 18:50:36', b'0');
INSERT INTO `conductor` VALUES (7, '', '', 'profile.jpg', '', '', '', '', NULL, b'0');
INSERT INTO `conductor` VALUES (8, '张丽', '女', 'profile.jpg', '小猪猪', '19959372282', '220949199@qq.com', '530381199823143231', NULL, b'0');
INSERT INTO `conductor` VALUES (9, '', '', 'profile.jpg', '', '', '', '', NULL, b'0');
INSERT INTO `conductor` VALUES (10, '123', '231', 'profile.jpg', '你好', '', '', '', NULL, b'0');

-- ----------------------------
-- Table structure for conductor_refund
-- ----------------------------
DROP TABLE IF EXISTS `conductor_refund`;
CREATE TABLE `conductor_refund`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `conductor_record_id` bigint(20) NULL DEFAULT NULL COMMENT '售票订单ID',
  `refund_date` datetime NULL DEFAULT NULL COMMENT '退票时间',
  `refund_money` float NULL DEFAULT NULL COMMENT '退回金额',
  `refund_size` int(11) NULL DEFAULT NULL COMMENT '退票数量',
  `conductor_bill_id` bigint(20) NULL DEFAULT NULL COMMENT '营业员账单ID',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '删除标记：0或1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '营业员退票订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor_refund
-- ----------------------------
INSERT INTO `conductor_refund` VALUES (1, 1, '2021-04-11 17:41:13', 30, 1, 0, b'0');
INSERT INTO `conductor_refund` VALUES (2, 2, '2021-04-11 17:47:06', 30, 1, 0, b'0');

-- ----------------------------
-- Table structure for conductor_ticket_bill
-- ----------------------------
DROP TABLE IF EXISTS `conductor_ticket_bill`;
CREATE TABLE `conductor_ticket_bill`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `payer_id` bigint(20) NULL DEFAULT NULL COMMENT '付款人ID',
  `receiver_id` bigint(20) NULL DEFAULT NULL COMMENT '收款人ID',
  `deal_money` float NULL DEFAULT NULL COMMENT '交易金额',
  `deal_time` datetime NULL DEFAULT NULL COMMENT '交易时间',
  `deal_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易类型:退票、购票',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '营业员-售票/退票账单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor_ticket_bill
-- ----------------------------
INSERT INTO `conductor_ticket_bill` VALUES (1, 3, 3, 100, '2020-12-17 03:40:44', '普通票');

-- ----------------------------
-- Table structure for conductor_ticket_record
-- ----------------------------
DROP TABLE IF EXISTS `conductor_ticket_record`;
CREATE TABLE `conductor_ticket_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `scenic_id` bigint(20) NULL DEFAULT NULL COMMENT '景点ID',
  `conductor_id` bigint(20) NULL DEFAULT NULL COMMENT '营业员ID',
  `varify_id` bigint(20) NULL DEFAULT NULL COMMENT '核对顾客ID',
  `enter_time` time NULL DEFAULT NULL COMMENT '进入景点时间',
  `leave_time` time NULL DEFAULT NULL COMMENT '离开景点时间',
  `order_date` date NULL DEFAULT NULL COMMENT '门票使用日期，当天、未来15天内',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期时间',
  `ticket_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门票类型：老人（65+）、小孩（6-)、团体(0-120)、普通(7-64)',
  `pay_money` float NULL DEFAULT NULL COMMENT '支付金额',
  `ticket_size` int(11) NULL DEFAULT 1 COMMENT '购票数量',
  `deal_note` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易备注：退票则备注',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '删除标记：0或1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '营业员售票信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor_ticket_record
-- ----------------------------
INSERT INTO `conductor_ticket_record` VALUES (1, 0, 1, 213215, '07:30:00', '17:00:00', '2021-04-11', '2021-04-11 17:41:11', '标准票', 30, 1, '退票', b'0');
INSERT INTO `conductor_ticket_record` VALUES (2, 0, 1, 213216, '07:30:00', '17:00:00', '2021-04-11', '2021-04-11 17:47:04', '标准票', 30, 1, '退票', b'0');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
  `realname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名，注册后实名认证成功方可显示',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `profile_img` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像链接url',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `mailbox` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间，自动生成',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '注销标识，0或1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游客基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_account
-- ----------------------------
DROP TABLE IF EXISTS `customer_account`;
CREATE TABLE `customer_account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '游客ID',
  `acconut_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户名',
  `balance` float NULL DEFAULT NULL COMMENT '账户余额',
  `payment_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游客资金账户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_recharge
-- ----------------------------
DROP TABLE IF EXISTS `customer_recharge`;
CREATE TABLE `customer_recharge`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
  `conductor_id` bigint(20) NULL DEFAULT NULL COMMENT '营业员ID',
  `deal_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易类型：充值、提现',
  `deal_time` datetime NULL DEFAULT NULL COMMENT '交易时间',
  `deal_money` float NULL DEFAULT NULL COMMENT '交易金额',
  `open_acconut_id` bigint(20) NULL DEFAULT NULL COMMENT '对公ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客充值/提现信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_varify
-- ----------------------------
DROP TABLE IF EXISTS `customer_varify`;
CREATE TABLE `customer_varify`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游客姓名',
  `id_number` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '游客身份证号',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '手机号,可选',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 213215 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '核对顾客身份信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_varify
-- ----------------------------
INSERT INTO `customer_varify` VALUES (213214, NULL, NULL, '');
INSERT INTO `customer_varify` VALUES (213215, 'xxx', '530382199806122453', '15329291231');
INSERT INTO `customer_varify` VALUES (213216, 'xxx', '530382199806122453', '15329291231');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片唯一标识',
  `suffix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片后缀',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for open_account
-- ----------------------------
DROP TABLE IF EXISTS `open_account`;
CREATE TABLE `open_account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '管理员ID',
  `acconut_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账户名',
  `balance` float NULL DEFAULT NULL COMMENT '账户余额',
  `payment_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '对公资金账户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `scenic_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '景点名称',
  `scenic_img` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '景点图片',
  `scenic_discription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '景点描述',
  `open_time` time NULL DEFAULT NULL COMMENT '开放时间',
  `close_time` time NULL DEFAULT NULL COMMENT '关闭时间',
  `fee` float NULL DEFAULT NULL COMMENT '门票基准费用',
  `ticket_size` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '门票数量',
  `remain_size` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '当日剩余数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '景点信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES (1, '福州三坊七巷门票', '1.png', '福州至今还保存相当一部分自唐宋以来形成的坊巷，成为历史名城的重要标志之一。这些坊巷中最为著名的要算\"三坊七巷\"街区。三坊七巷地处市中心，东临八一七北路，西靠通湖路，北接杨桥路，南达吉庇巷、光禄坊，占地约40公顷，现居民3678户，人口14000余人。 ', '08:30:00', '17:00:00', 96, '3000', '3000');
INSERT INTO `scenic` VALUES (2, '杭州灵隐寺', '2.png', '进灵隐寺，需要先进飞来峰景区，并先购买飞来峰景区门票。', '07:30:00', '17:00:00', 30, '2000', '2000');
INSERT INTO `scenic` VALUES (3, '厦门鼓浪屿上船门票', '3.png', '鼓浪屿是个宁静美丽的小岛，这里有着各种风格迥异、中西合壁的建筑，汇集了各种特色的食铺和商铺，充满了文艺范儿。2017年7月8日，在波兰克拉科夫举行的第41届世界遗产大会上，鼓浪屿申遗成功，成为中国第52项世界遗产。', '00:00:00', '23:59:59', 35, '3000', '3000');
INSERT INTO `scenic` VALUES (4, '千岛湖门票+船票', '4.png', '杭州市千岛湖风景名胜区位于中国浙江杭州西效淳安县境内的千岛湖，东距杭州129公里、西距黄山140公里，是长江三角洲地区的后花园，景区内碧水呈奇，千岛百姿 ，自然风光旖旎，生态环境佳绝，因湖内拥有1078座翠岛而得名。千岛湖以千岛、秀水、金腰带 （岛屿与湖水相接处环绕着有一层金黄色的土带，称之名 “金腰带”） 为主要特色景观。千岛湖是中国首批国家级风景名胜区之一，也是中国面积最大的森林公园 ，是“杭州——千岛湖——黄山”名山名水名城黄金旅游线上的一颗璀璨明珠。\r\n千岛湖年接待游客500多万人次，跻身全国文明森林公园 ，并被台湾游客和媒体评为台湾市民赴大陆旅游的三大热点之一，与北京、长江三峡齐名 。2001年又被评为首批 中国AAAA级旅游区。2002年被评为全国保护旅游消费者权益示范景区和浙江青年文明号示范景区。', '08:00:00', '16:00:00', 205, '3000', '3000');
INSERT INTO `scenic` VALUES (5, '济南大明湖', '5.png', '大明湖公园位于济南市区的偏北方向。 面积甚大，几乎占了旧城的四分之一。\r\n大明湖景色优美秀丽， 湖上鸢飞鱼跃，荷花满塘，画舫穿行，岸边杨柳荫浓，繁花似锦，游人如织，其间又点缀着各色亭、台、楼、阁，远山近水与晴空融为一色，犹如一幅巨大的彩色画卷。大明湖一年四季美景纷呈，尤以天高气爽的秋天最为宜人。春日，湖上暖风吹拂，柳丝轻摇，微波荡漾；夏日，湖中荷浪迷人，葱绿片片，嫣红点点；秋日，湖中芦花飞舞，水鸟翱翔；冬日，湖面虽暂失碧波，但银装素裹，分外妖娆。', '07:00:00', '17:00:00', 30, '3000', '3000');
INSERT INTO `scenic` VALUES (6, '绵山', '6.png', '绵山，亦名绵上，后因春秋晋国介之推携母隐居被焚又称介山。 古老神奇的绵山，历史悠久，2640年的历史博大精深。人文景观雄壮宏伟，自然风光优美，集秦山之雄奇、无水不秀、无涧不幽、无景不典；气势恢弘，巧夺天工，苍松翠柏，山环水绕，人称北方九寨沟。 绵山的吃、住、行、游、购、娱各具特色，住在悬崖上，吃在岩沟边，行在云雾中，游在飘飘欲仙，似仙非仙。登介公岭拜介公，游仙洞，龙头寺观日落。远眺中国最大道观建筑群大罗宫，穿越天桥漫步一斗泉，拾阶朱家凹，观佛教圣地云峰寺，探秘九曲一线天栖贤谷，远足龙脊岭，畅游自然景观北方九寨沟--十里画廊水涛沟，令游客目不暇接，流连忘返。绵山之所以享誉海内外，千百年来登临者络绎不绝，在于她步步有景，景景有典，奇岩、秀水、古柏、唐碑、宋塑、名刹、巨宫和真神介之推，空王真佛以及流传千年而不衰的寒食清明节习俗，形成了绵山独特的魅力，吸引了众多的游客纷至踏来。绵山人间仙境，旅游好去处，堪称全国之“最”，千山万水看不尽绵山，游绵山，看尽千山万水。', '08:00:00', '19:30:00', 105, '3000', '3000');
INSERT INTO `scenic` VALUES (7, '四川峨眉山', '7.jpg', ' 峨眉山位于中国四川峨眉山市境内，景区面积154平方公里，最高峰万佛顶海拔3099米。地势陡峭，风景秀丽，有\"秀甲天下\"之美誉。气候多样，植被丰富，共有3000多种植物，其中包括世界上稀有的树种。山路沿途有较多猴群，常结队向游人讨食，胜为峨眉一大特色。它是中国四大佛教名山之一，有寺庙约26座，重要的有八大寺庙，佛事频繁。1996年12月6日，峨眉山乐山大佛作为文化与自然双重遗产被联合国教科文组织列入世界遗产名录。\r\n    峨眉山景区面积154平方公里，包括大峨、二峨、三峨、四峨四座大山。大峨山为峨眉山的主峰，通常说的峨眉山就是指的大峨山。大峨、二峨两山相对，远远望去，双峰缥缈，犹如峨眉山画眉，这种陡峭险峻、横空出世的雄伟气势，使唐代诗人李白发\"峨眉高出西极天\"、\"蜀国多仙山，峨眉邈难匹\"之赞叹。峨眉山以多雾著称，常年云雾缭绕，雨丝霏霏。弥漫山间的云雾，变化万千，把峨眉山装点得婀娜多姿。 ', '07:00:00', '18:00:00', 185, '5000', '5000');
INSERT INTO `scenic` VALUES (8, '山西省忻州市五台山风景区', '8.jpg', '山西省忻州市五台山风景区，位于山西省的东北部，属太行山系的北端。跨忻州地区的五台县、繁峙县、代县、原平县、定襄县，周五百余里。中心地区台怀镇，距五台县城90公里，忻州市160公里，山西省会太原市240公里。\r\n五台山，是地球上最早露出水面的陆地之一。它的孕育，可以追溯到太古代的26亿年以前。到震旦纪时期，又经历了著名的“五台隆起”运动，形成了华北地区最雄浑壮伟的山地。第四纪时期，冰川覆盖了五台山，至今留下了弥足珍贵的冰缘地貌。五台山地层，完整丰富。特别是前寒武系地层，发育典型，已经成为全国研究对比的重点地区。五台山境内的绝大部分地层组段，都是以本地区的山、水、村、镇命名，充分显示了其在地学位置中的作用。\r\n五台山，最低处海拔仅624米，最高处海拔达3061米，为华北最高峰。层峦叠蟑，峰岭交错，大自然为其造就了许多独特的景观。奇峰灵崖，随处皆是，著名者达五十余处。其中写字崖，用水洒湿以后，拿手帕仔细拭擦，崖面会显示出类似篆隶体字迹，水干字隐。有人曾揭去表皮石层，结果下层仍能擦出字来。层层有字，字字不同。据载曾发现过“天之三宝日月星，地之三宝水火风，人之三宝精气神”的联句。', '00:00:00', '23:59:59', 135, '5000', '5000');
INSERT INTO `scenic` VALUES (9, '神农架地质公园', '9.png', '包括神农顶、大九湖国家湿地公园、神农祭坛、天生桥、官门山景区、天燕风景区6大景区门票。\r\n    神农架是世界中纬度地区唯一一块保存完好的绿色宝地，具有比其它温带森林生态系统更为丰富的具有全球意义的生物多样性。神农架林区位于中国亚热带向温带过渡的地区，亿万年前曾经是片汪洋大海，喜玛拉雅造山运动使其变成了高山，成为“华中屋脊”，这里海拔超过3000米的高山就有六座。由于特殊的地理环境，神农架成为第四纪冰川时期各种动植物的避难所和栖息地，几乎囊括了北自漠河、南至西双版纳、东自日本中部、西至喜玛拉的所有动植物物种。现知神农架林区有高等维管束植物199科、872属、2671种，其中列为国家一、二级保护的树种有39种；动物500多种，其中列为国家重点保护的有50多种；可入药的动、植物达2013种。因此，神农架被世人誉为“物种基因库”、“天然动物园”和“绿色宝库”。 神农架保存完好的自然生态为世人所瞩目。1986年，国务院批准神农架为“国家森林和野生动物类型保护区”；1990年，联合国教科文组织将神农架列为国际“人与生物圈保护网”成员；1992年，世界自然基金会又将神农架定为“生物多样性保护示范点”。', '08:30:00', '17:30:00', 320, '5000', '5000');
INSERT INTO `scenic` VALUES (10, '山西晋中平遥古城', '10.jpg', '山西省晋中市平遥古城，是一座具有2700多年历史的文化名城，与同为第二批国家历史文化名城的四川阆中、云南丽江、安徽歙县并称为“保存最为完好的四大古城”，也是目前我国唯一以整座古城申报世界文化遗产获得成功的古县城。平遥旧称“古陶”，明朝初年，为防御外族南扰，始建城墙，洪武三年（公元一三七零年）在旧墙垣基础上重筑扩修，并全面包砖。以后景德、正德、嘉靖、隆庆和万历各代进行过十次在的补修和修葺，更新城楼，增设敌台。康熙四十三年（公元一七零三年）因皇帝西巡路经平遥，而筑了四面大城楼，使城池更加壮观。平遥城墙总周长6163米，墙高约12米，把面积约2.25平方公里的平遥县城一隔为两个风格迥异的世界。城墙以内街道、铺面、市楼保留明清形制；城墙以外称新城。这是一座古代与现代建筑各成一体、交相辉映、令人遐思不已的佳地。', '08:00:00', '17:30:00', 130, '5000', '5000');
INSERT INTO `scenic` VALUES (11, '四川省阿坝藏族羌族自治州南坪县九寨沟风景名', '11.png', '\r\n11	四川省阿坝藏族羌族自治州南坪县九寨沟风景名	11.png	九寨沟风景名胜区位于四川省阿坝藏族羌族自治州南坪县境内，距离成都市400多公里，是一条纵深40余公里的山沟谷地，因周围有9 个藏族村寨而得名，总面积约620平方公里，大约有52％的面积被茂密的原始森林所覆盖。林中夹生的箭竹和各种奇花异草，使举世闻名的大熊猫、金丝猴、白唇鹿等珍稀动物乐于栖息在此。沟中地僻人稀，景物特异，富于原始自然风貌，有“童话世界”之誉。有长海、剑岩、诺日朗、树正、扎如、黑海六大景区，以翠海、叠瀑、彩林、雪峰、藏情这五绝而驰名中外。\r\n九寨沟蓝天、白云、雪山、森林、尽融于瀑、河、滩、缀成一串串宛若从天而降的珍珠；篝火、烤羊、锅庄和古老而美丽的传说，展现出藏羌人热情强悍的民族风情。九寨沟，一个五彩斑斓、绚丽奇绝的瑶池玉盆，一个原始古朴、神奇梦幻的人间仙境，一个不见纤尘、自然纯净的“童话世界”!她以神妙奇幻的翠海、飞瀑、彩林、雪峰等无法尽览的自然与人文景观，成为全国唯一拥有“世界自然遗产”和“世界生物圈保护区”两顶桂冠的圣地。 九寨沟以原始的生态环境，一尘不染的清新空气和雪山、森林、湖泊组合成神妙、奇幻、幽美的自然风光，显现“自然的美，美的自然”，被誉为“童话世界九寨沟”的高峰、彩林、翠海、叠瀑和藏情被称为“五绝”。因其独有的原始景观，丰富的动植物资源被誉为“人间仙境”。', '07:00:00', '18:00:00', 80, '5000', '5000');
INSERT INTO `scenic` VALUES (12, '中科院西双版纳热带植物园门票', '12.png', '如果说云南是“动植物王国”，那么中国科学院西双版纳热带植物园就是植物王国凤冠霞岐上最璀璨的绿宝石。纯美多姿的热带植物及自然风光，周围万亩自然保护区的森林精气将植物园塑造成氧吧；年均温21.5℃，使这里成为理想的避寒胜地；长达半年的雾凉季里乳汁般的薄雾让人感觉置身天堂；森林一石林复合的奇观使人对大自然的鬼斧神工叹为观止；罗梭江穿境而过，如玉带、如彩绸；昆曼国际大通道将植物园纳入了大湄公河次区域黄金旅游圈；贝叶文化博大精深、“香发公主”传说亦幻亦真……给人一种返璞归真、人与自然和谐相处的轻松与愉快，充分感受边睡“世外桃源”的情趣。', '07:00:00', '18:00:00', 75, '5000', '5000');
INSERT INTO `scenic` VALUES (13, '福州鼓山', '20210411171921499.jpeg', '关于该景点的介绍', '17:18:00', '17:19:00', 500, '5000', '5000');
INSERT INTO `scenic` VALUES (14, '100', '20210411172328356.jpeg', '测试----', '18:22:00', '20:24:00', 200, '5000', '5000');

-- ----------------------------
-- Table structure for scenic_ticket
-- ----------------------------
DROP TABLE IF EXISTS `scenic_ticket`;
CREATE TABLE `scenic_ticket`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `scenic_id` bigint(20) NULL DEFAULT NULL COMMENT '景点ID',
  `ticket_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门票类型：老人（65+）、小孩（6-)、团体(0-120)、普通(7-64)',
  `discount_rate` float NULL DEFAULT NULL COMMENT '折扣率，0-1之间，如：0.75',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '景点-门票信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_ticket
-- ----------------------------
INSERT INTO `scenic_ticket` VALUES (1, 1, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (2, 1, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (3, 1, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (4, 1, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (5, 2, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (6, 2, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (7, 2, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (8, 2, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (9, 3, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (10, 3, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (11, 3, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (12, 3, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (13, 4, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (14, 4, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (15, 4, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (16, 4, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (17, 5, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (18, 5, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (19, 5, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (20, 5, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (21, 6, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (22, 6, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (23, 6, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (24, 6, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (25, 7, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (26, 7, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (27, 7, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (28, 7, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (29, 8, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (30, 8, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (31, 8, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (32, 8, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (33, 9, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (34, 9, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (35, 9, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (36, 9, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (37, 10, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (38, 10, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (39, 10, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (40, 10, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (41, 11, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (42, 11, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (43, 11, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (44, 11, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (45, 12, '儿童票', 0.75);
INSERT INTO `scenic_ticket` VALUES (46, 12, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (47, 12, '老人票', 0.7);
INSERT INTO `scenic_ticket` VALUES (48, 12, '团体票', 0.9);
INSERT INTO `scenic_ticket` VALUES (49, 13, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (50, 13, '儿童票', 1);
INSERT INTO `scenic_ticket` VALUES (51, 13, '老人票', 1);
INSERT INTO `scenic_ticket` VALUES (52, 13, '团体票', 1);
INSERT INTO `scenic_ticket` VALUES (53, 14, '标准票', 1);
INSERT INTO `scenic_ticket` VALUES (54, 14, '儿童票', 1);
INSERT INTO `scenic_ticket` VALUES (55, 14, '老人票', 1);
INSERT INTO `scenic_ticket` VALUES (56, 14, '团体票', 1);

-- ----------------------------
-- Table structure for user_user
-- ----------------------------
DROP TABLE IF EXISTS `user_user`;
CREATE TABLE `user_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库自增主键，非用户唯一标识',
  `user_id` bigint(20) NOT NULL COMMENT '整数的用户ID，唯一标识',
  `authc_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '授权类型（PHONE，EAMIL）',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录名，手机号码、邮箱',
  `userpw` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加密后的32位字符串，即密码',
  `salt` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用于加密的随机盐',
  `user_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户分类：游客、管理员、营业员',
  `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态，默认正常，用于登录安全控制',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录或注册认证信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_user
-- ----------------------------
INSERT INTO `user_user` VALUES (1, 1, '3', '100', '2020-12-17 03:40:44', '', 'CONDUCTOR', NULL);
INSERT INTO `user_user` VALUES (2, 2, '', 'yangli', 'pw666666', '', 'CONDUCTOR', NULL);
INSERT INTO `user_user` VALUES (3, 3, '', 'test', '666666', '', 'CONDUCTOR', NULL);

SET FOREIGN_KEY_CHECKS = 1;
