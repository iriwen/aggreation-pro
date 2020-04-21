-- DROP TABLE IF EXISTS `popu_base`;
CREATE TABLE `popu_base`
(
    `row_id`           VARCHAR(32)  NOT NULL AUTO_INCREMENT COMMENT 'rowId',
    `name`             VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'name',
    `sex`              VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'sex',
    `id_no`            VARCHAR(30)  NOT NULL DEFAULT '' COMMENT 'idNo',
    `used_name`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'usedName',
    `nation`           VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'nation',
    `original_place`   VARCHAR(50)  NOT NULL DEFAULT '' COMMENT 'originalPlace',
    `born_date`        DATETIME     NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'bornDate',
    `phone`            VARCHAR(50)  NOT NULL DEFAULT '' COMMENT 'phone',
    `org_code`         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT 'orgCode',
    `doorplate_code`   VARCHAR(32)  NOT NULL DEFAULT '' COMMENT 'doorplateCode',
    `political_status` VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'politicalStatus',
    `edu_degree`       VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'eduDegree',
    `marital_status`   VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'maritalStatus',
    `religion`         VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'religion',
    `career_type`      VARCHAR(5)   NOT NULL DEFAULT '' COMMENT 'careerType',
    `career`           VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'career',
    `company`          VARCHAR(32)  NOT NULL DEFAULT '' COMMENT 'company',
    `work_code`        VARCHAR(50)  NOT NULL DEFAULT '' COMMENT 'workCode',
    `opt_status`       VARCHAR(10)  NOT NULL DEFAULT '' COMMENT 'optStatus',
    `opt_is_enable`    VARCHAR(10)  NOT NULL DEFAULT '' COMMENT 'optIsEnable',
    `opt_sort_by`      VARCHAR(10)  NOT NULL DEFAULT '' COMMENT 'optSortBy',
    `createtor`        VARCHAR(32)  NOT NULL DEFAULT '' COMMENT 'createdBy',
    `create_time`      BIGINT(20)   NOT NULL DEFAULT -1 COMMENT 'createTime',

    PRIMARY KEY (`row_id`)
) ENGINE = InnoDB  AUTO_INCREMENT = 1001 DEFAULT CHARSET = utf8mb4 COMMENT '`popu_base`';

-- DROP TABLE IF EXISTS `urchin_article`;
CREATE TABLE `urchin_article`
(
    `id`                    BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`                 VARCHAR(64)   NOT NULL DEFAULT '' COMMENT '内容标题',
    `body`                  MEDIUMTEXT    NOT NULL COMMENT '正文',
    `source`                VARCHAR(64)   NOT NULL DEFAULT '' COMMENT '来源：原创；转发自微信',
    `wechat_title`          VARCHAR(64)   NOT NULL DEFAULT '' COMMENT '在微信分享卡中的标题',
    `wechat_text`           VARCHAR(256)  NOT NULL DEFAULT '' COMMENT '在微信分享卡中的正文摘要',
    `wechat_thumb_url`      VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '微信缩略图url',
    `origin_url`            VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '内容所引用的源url',
    `creator_uid`           BIGINT(20)    NOT NULL DEFAULT -1 COMMENT '员工uid 不暴露给前端',
    `accid`                 VARCHAR(64)   NOT NULL DEFAULT '' COMMENT '员工账户accountId',
    `eid`                   BIGINT(20)    NOT NULL DEFAULT -1 COMMENT 'entId,bf均衡字段',
    `shared`                INT(11)       NOT NULL DEFAULT 1 COMMENT 'shared是否共享 0是私有不共享 1是企业内共享 -1为删除',
    `auto_tag_read_seconds` BIGINT(20)    NOT NULL DEFAULT -1 COMMENT '阅读文章达到多少秒自动打标签',
    `labels`                VARCHAR(256)  NOT NULL DEFAULT '' COMMENT '文章自动打的标签',
    `modifier_uid`          BIGINT(20)    NOT NULL DEFAULT -1 COMMENT '修改者uid',
    `publish_time`          BIGINT(20)    NOT NULL DEFAULT -1 COMMENT '发布时间',
    `create_time`           BIGINT(20)    NOT NULL DEFAULT -1 COMMENT 'createTime',
    `update_time`           BIGINT(20)    NOT NULL DEFAULT -1 COMMENT 'updateTime',
    PRIMARY KEY (`id`),
    INDEX EID (`eid`, `id`, shared)
) ENGINE = InnoDB  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8mb4 COMMENT '`urchin_article`';
