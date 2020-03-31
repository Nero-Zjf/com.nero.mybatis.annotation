# Mybatis-注解配置Annotation demo
文档：Mybatis-注解配置Annotation
## 演示了mybatis 注解配置
- Test 演示了基本注解的使用
- DynamicTest 演示了动态SQL注解的使用

## 目录结构
- provider 动态SQL的provider存放目录

## 数据库SQL
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user(id,`name`,sex)
VALUES(1,'tom',1),(2,'jerry',1);

DROP TABLE IF EXISTS id_card;
CREATE TABLE id_card (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '身份证',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `card_num` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `date` datetime COMMENT '颁发日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO id_card(user_id,card_num,date)
VALUES(1,'440222584455584154','2020-03-28'),(2,'440222188584449457','2020-03-28');

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `order`(user_id,order_num)
VALUES(1,'OD001'),(1,'OD002'),(2,'OD003'),(2,'OD004');
```