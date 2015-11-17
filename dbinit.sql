SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `icon_class` varchar(100) DEFAULT NULL COMMENT '菜单图标，只支持font awesome',
  `href` varchar(255) DEFAULT NULL COMMENT '菜单链接地址',
  `level` int(20) DEFAULT NULL COMMENT '等级',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父级ID',
  `sequence` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`),
  KEY `FK2jrf4gb0gjqi8882gxytpxnhe` (`parent_id`),
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '经营分析', 'fa fa-bar-chart-o', null, '1', null, '1'), ('2', '市场分析', 'fa fa-table', null, '2', '1', '1'), ('3', '销售状况', 'fa fa-area-chart', null, '1', null, '2'), ('4', '竟品分析', 'fa fa-cubes', null, '2', '3', '1'), ('5', '区域市场', 'fa fa-building-o', null, '2', '3', '2'), ('6', '广告拓展', 'fa fa-suitcase', null, '2', '3', '3');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Gordon');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
