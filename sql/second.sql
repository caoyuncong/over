DROP TABLE IF EXISTS db_1702.login;
CREATE TABLE db_1702.login (
  id       INT                   AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  email    VARCHAR(255) UNIQUE
  COMMENT '邮箱',
  username VARCHAR(255) NOT NULL
  COMMENT '用户名',
  password VARCHAR(255) NOT NULL
  COMMENT '密码',
  role     VARCHAR(255) NOT NULL DEFAULT 'user'
  COMMENT '角色：user-用户；admin-管理员'
)
  COMMENT '注册表';
DESC db_1702.message;

DROP TABLE IF EXISTS db_1702.message;
CREATE TABLE db_1702.message (
  id       INT               AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  word     TEXT     NOT NULL
  COMMENT '留言',
  dateTime DATETIME NOT NULL DEFAULT now()
  COMMENT '日期时间',
  loginId  INT      NOT NULL
  COMMENT 'FK'
)
  COMMENT '留言表';

ALTER TABLE db_1702.message
  ADD CONSTRAINT
  message_fk_loginId
FOREIGN KEY (loginId)
REFERENCES db_1702.login (id);

# 实现以下功能对应的 SQL 语句：（50分）
# 用户注册
INSERT INTO db_1702.login (email, username, password) VALUE ('2780837020@qq.com', 'Jerry', '123');

# 用户登录判断
SELECT *
FROM db_1702.login
WHERE email = '2780837020@qq.com' AND password = '123';

# 用户发布留言
INSERT INTO db_1702.message (word, loginId) VALUE ('One day,new day!', 1);
SELECT *
FROM db_1702.login;
# 添加管理员
INSERT INTO db_1702.login VALUE (NULL, 'admin@qq.com', 'Tom', '123', 'admin');

# 管理员查看所有留言
SELECT
  l.username,
  m.word,
  m.dateTime
FROM db_1702.message m INNER JOIN db_1702.login l
    ON l.id = m.loginId;
# 管理员删除一条留言
DELETE FROM db_1702.message
WHERE id = 1;

SELECT *
FROM db_1702.message;

SHOW TABLES IN db_1702;
