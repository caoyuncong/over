# 2.
# 设计个人好友管理系统，包含以下核心功能：
#1. 显示所有好友基本信息，包括：
# 姓名
# 性别
# 生日
# 手机
# 住址
# 微信
# QQ
# 工作或学习的地点
# 爱好
# 认识时间
# 认识方式
# 特点
# 亲密程度 （亲密-一般：1-10）

# 2.记录每一次与朋友沟通时的信息，包括：
# 沟通时间
# 沟通方式
# 沟通内容
# TA 当前的工作或学习的地点
# 当前的亲密程度

# 创建表和关联
DROP DATABASE IF EXISTS db_thrid2;
CREATE DATABASE db_thrid2;

DROP TABLE IF EXISTS db_thrid2.user;
CREATE TABLE db_thrid2.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  name     VARCHAR(255) COMMENT '姓名',
  gender   VARCHAR(255) COMMENT '性别',
  birthday DATE COMMENT '生日'
)
  COMMENT '用户表';

DROP TABLE IF EXISTS db_thrid2.info;
CREATE TABLE db_thrid2.info (
  id          INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID FK',
  phone       VARCHAR(255) COMMENT '手机',
  address     VARCHAR(255) COMMENT '住址',
  wechat      VARCHAR(255) COMMENT '微信',
  qq          VARCHAR(255) COMMENT 'QQ',
  work_study  VARCHAR(255) COMMENT '工作或学习的地点',
  hobby       VARCHAR(255) COMMENT '爱好',
  meettime    DATE COMMENT '认识时间',
  meet_method VARCHAR(255) COMMENT '认识方式',
  feature     VARCHAR(255) COMMENT '特点',
  userId      INT COMMENT '用户 ID FK'
)
  COMMENT '信息表';

DROP TABLE IF EXISTS db_thrid2.communicate;
CREATE TABLE db_thrid2.communicate (
  id                     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  time                   TIME COMMENT '沟通时间',
  method                 VARCHAR(255) COMMENT '沟通方式',
  content                VARCHAR(255) COMMENT '沟通内容',
  now_work_study         VARCHAR(255) COMMENT '当前工作或学习的地点',
  now_friendliness_level INT COMMENT '当前的亲密程度 （亲密-一般：1-10）',
  userId                 INT COMMENT '用户 ID FK'
)
  COMMENT '沟通信息';

ALTER TABLE db_thrid2.info
  ADD CONSTRAINT
  info_fk_userId
FOREIGN KEY (userId)
REFERENCES db_thrid2.user (id);

ALTER TABLE db_thrid2.communicate
  ADD CONSTRAINT
  communicate_fk_userId
FOREIGN KEY (userId)
REFERENCES db_thrid2.user (id);

# 添加样本数据
INSERT INTO db_thrid2.user VALUE (NULL, 'Jerry', 'F', '1996-04-05');
INSERT INTO db_thrid2.user VALUE (NULL, 'Tom', 'M', '1997-04-05');
INSERT INTO db_thrid2.info
  VALUE (NULL, '123', '北京海淀区', '4668', '7899666', '上海', '散步', '2000-09-23', 'meet with', 'lively', 1);
INSERT INTO db_thrid2.info
  VALUE (NULL, '123569', '北京朝阳区', '4638', '78995556', '上海', '散步', '2000-09-23', 'meet with', 'lively', 2);

INSERT INTO db_thrid2.communicate VALUE (NULL, '20:30:23', 'qq', 'do you like hiking?', 'New York', 2, 1);
INSERT INTO db_thrid2.communicate VALUE (NULL, '20:30:23', 'qq', 'do you like hiking?', 'New York', 6, 1);
INSERT INTO db_thrid2.communicate VALUE (NULL, '20:30:23', 'wechat', 'do you like hiking?', 'New York', 8, 2);
INSERT INTO db_thrid2.communicate VALUE (NULL, '20:30:23', 'wechat', 'do you like hiking?', 'New York', 2, 2);
# 查询所有朋友及每次沟通记录
SELECT
  u.name,
  c.*
FROM db_thrid2.user u INNER JOIN db_thrid2.communicate c
    ON u.id = c.userId;
# 列出一个朋友的工作或学习的变迁
UPDATE db_thrid2.info
SET work_study = 'New York'
WHERE userId = 1;
SELECT *
FROM db_thrid2.info;
# 计算每个朋友的平均亲密程度，降序排序 --
SELECT
  u.name,
  round(avg(now_friendliness_level))
FROM db_thrid2.user u INNER JOIN db_thrid2.communicate c
    ON u.id = c.userId
GROUP BY u.name
ORDER BY 2 DESC ;