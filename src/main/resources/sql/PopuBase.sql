-- auto Generated on 2020-04-02 16:22:29 
-- DROP TABLE IF EXISTS `popu_base`; 
CREATE TABLE `popu_base`(
    `row_id` VARCHAR (32) NOT NULL AUTO_INCREMENT COMMENT 'rowId',
    `name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'name',
    `sex` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'sex',
    `id_no` VARCHAR (30) NOT NULL DEFAULT '' COMMENT 'idNo',
    `used_name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'usedName',
    `nation` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'nation',
    `original_place` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'originalPlace',
    `born_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'bornDate',
    `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'phone',
    `org_code` VARCHAR (32) NOT NULL DEFAULT '' COMMENT 'orgCode',
    `doorplate_code` VARCHAR (32) NOT NULL DEFAULT '' COMMENT 'doorplateCode',
    `political_status` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'politicalStatus',
    `edu_degree` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'eduDegree',
    `marital_status` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'maritalStatus',
    `religion` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'religion',
    `career_type` VARCHAR (5) NOT NULL DEFAULT '' COMMENT 'careerType',
    `career` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'career',
    `company` VARCHAR (32) NOT NULL DEFAULT '' COMMENT 'company',
    `work_code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'workCode',
    `opt_status` VARCHAR (10) NOT NULL DEFAULT '' COMMENT 'optStatus',
    `opt_is_enable` VARCHAR (10) NOT NULL DEFAULT '' COMMENT 'optIsEnable',
    `opt_sort_by` VARCHAR (10) NOT NULL DEFAULT '' COMMENT 'optSortBy',
    `created_by` VARCHAR (32) NOT NULL DEFAULT '' COMMENT 'createdBy',
    `updated_by` VARCHAR (32) NOT NULL DEFAULT '' COMMENT 'updatedBy',
    PRIMARY KEY (`row_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`popu_base`';
