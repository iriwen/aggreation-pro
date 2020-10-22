-- auto Generated on 2020-10-20 15:09:37 
-- DROP TABLE IF EXISTS `popu_base`; 
CREATE TABLE `popu_base`(
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `sex` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sex',
    `id_no` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'idNo',
    `nation` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'nation',
    `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'phone',
    `create_time` BIGINT (20) NOT NULL DEFAULT -1 COMMENT 'createTime',
    `update_time` BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`popu_base`';
