/*一个图书馆管理系统的基本功能：
管理员登录后维护图书信息
读者可以查询图书信息
读者登录后可以借阅图书
读者登录后可以归还图书
读者登录后查询自己的借阅记录
管理员登录后查询图书借阅情况*/

# 1.创建数据库 db_library

DROP DATABASE IF EXISTS db_library;
CREATE DATABASE db_library;

# 2.创建数据库帐号为 library_admin，指定密码为 library_admin_password

CREATE USER library_admin@'localhost'
  IDENTIFIED BY 'library_admin_password';

DROP USER library_admin@'localhost';
SHOW GRANTS FOR library_admin@'localhost';

# 3 向 library_admin 授予在 db_library 上的所有权限
USE db_library;

GRANT ALL ON db_library.* TO library_admin@'localhost';

# 4 创建用户表
# -- user table
# id -- PK
# username -- 用户名
# password -- 密码
# role -- 角色: 管理员-admin; 用户-user

DROP TABLE IF EXISTS db_library.user;
CREATE TABLE db_library.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  username VARCHAR(255) NOT NULL
  COMMENT '用户名',
  password VARCHAR(255) NOT NULL
  COMMENT '密码',
  role     VARCHAR(255) NOT NULL
  COMMENT '角色'
)
  COMMENT '用户表';
# 5 创建图书表
# -- book table
# id -- PK
# title -- 书名
# author -- 作者
# publisher -- 出版社
# date -- 出版日期
# price -- 定价
# amount -- 存书量

DROP TABLE IF EXISTS db_library.book;
CREATE TABLE db_library.book (
  id        INT PRIMARY KEY AUTO_INCREMENT
  COMMENT 'PK',
  title     VARCHAR(255) COMMENT '书名',
  author    VARCHAR(255) COMMENT '作者',
  publisher VARCHAR(255) COMMENT '出版社',
  date      DATE COMMENT '出版日期',
  price     DECIMAL(6, 2) COMMENT '定价',
  amount    INT COMMENT '存书量'
)
  COMMENT '图书表';

# 6 创建用户借书表
# -- user_book table
# id -- PK
# borrowTime -- 借书时间
# returnTime -- 还书时间
# userId -- FK
# bookId -- FK

DROP TABLE IF EXISTS db_library.user_book;
CREATE TABLE db_library.user_book (
  id         INT PRIMARY KEY AUTO_INCREMENT
  COMMENT 'PK',
  borrowTime DATE COMMENT '借书时间',
  returnTime DATE COMMENT '还书时间',
  userId     INT COMMENT 'FK',
  bookId     INT COMMENT 'FK'
)
  COMMENT '用户借书表';
USE db_library;
SHOW TABLES;
# 7 修改 user_book 表，追加外键

ALTER TABLE db_library.user_book
  ADD CONSTRAINT
  fk_user_book_userId
FOREIGN KEY (userId)
REFERENCES db_library.user (id);

ALTER TABLE db_library.user_book
  ADD CONSTRAINT
  fk_user_book_bookId
FOREIGN KEY (bookId)
REFERENCES db_library.book (id);

DESC user_book;
# 8 向用户表添加一个管理员和三个读者记录

INSERT INTO db_library.user VALUE (NULL, 'admin', '123', 'admin');
INSERT INTO db_library.user VALUE (NULL, 'Jerry', '456', 'user');
INSERT INTO db_library.user VALUE (NULL, 'LiMing', '789', 'user');
INSERT INTO db_library.user VALUE (NULL, 'Jack', '012', 'user');

# 9 向图书表添加十条记录
INSERT INTO db_library.book VALUES (NULL, 'HTML', 'Sheirk', '清华大学出版社', '2000-04-06', 34.0, 3899);
INSERT INTO db_library.book VALUES (NULL, 'CSS', 'Mosuton', '北京大学出版社', '2010-07-17', 69.0, 36889);
INSERT INTO db_library.book VALUES (NULL, 'Java', 'Joff', '浙江大学出版社', '2015-06-24', 78.0, 13009);
INSERT INTO db_library.book VALUES (NULL, 'MySQL', 'Bike', '青岛大学出版社', '2008-11-06', 99.0, 5399);
INSERT INTO db_library.book VALUES (NULL, 'JSP', 'Jkel', '南开大学出版社', '2007-12-26', 34.0, 3869);
INSERT INTO db_library.book VALUES (NULL, 'JavaScript', 'Sina', '美国出版社', '2016-12-06', 78.0, 99);
INSERT INTO db_library.book VALUES (NULL, 'JQuery', 'Emind', '河北大学出版社', '2009-04-30', 500.0, 3959);
INSERT INTO db_library.book VALUES (NULL, '框架技术', 'Poolk', '清华大学出版社', '2008-09-28', 89.0, 899);
INSERT INTO db_library.book VALUES (NULL, 'PHP', 'Gjkom', '北京交通大学出版社', '2010-10-13', 63.0, 329);
INSERT INTO db_library.book VALUES (NULL, 'SEO', 'Oikrk', '上海出版社', '2017-04-18', 80.0, 1099);
# 10 为图书名称添加索引
CREATE INDEX idx_title
  ON db_library.book (title);

# 11 管理员登录判断语句
SELECT *
FROM db_library.user
WHERE username = 'admin' AND password = '123' AND user.role = 'admin';

# 12 读者根据书名查询图书语句
SELECT *
FROM db_library.book
WHERE title LIKE '%title%';

# 13 读者借阅图书语句   一次事务
UPDATE db_library.book
SET amount = amount - 1
WHERE id = 1;

INSERT INTO db_library.user_book VALUES (NULL, current_time, NULL, 1, 1);
# 14 读者归还图书语句   一次事务
UPDATE db_library.book
SET amount = amount + 1
WHERE id = 1;

UPDATE db_library.user_book
SET returnTime = current_time
WHERE userId = 1 AND bookId = 1;
# 15 读者查询自己的借阅记录语句
SELECT
  b.title,
  ub.borrowTime,
  ub.returnTime
FROM db_library.book b INNER JOIN db_library.user u
  INNER JOIN db_library.user_book ub
    ON b.id = ub.bookId AND u.id = ub.userId
WHERE u.id = 1;
# 16 管理员查询图书借阅情况语句
SELECT
  u.username,
  b.title,
  ub.borrowTime,
  ub.returnTime
FROM db_library.user AS u
  INNER JOIN db_library.user_book AS ub
  , db_library.book AS b
WHERE u.id = ub.userId AND b.id = ub.bookId;

# 17 根据上题的查询，创建图书借阅视图
CREATE VIEW db_library.v_user_book
AS
  SELECT
    u.username,
    b.title,
    ub.borrowTime,
    ub.returnTime
  FROM db_library.user AS u
    INNER JOIN db_library.user_book AS ub
    , db_library.book AS b
  WHERE u.id = ub.userId AND b.id = ub.bookId;

DESC db_library.v_user_book;
# 18 根据视图查询借阅情况语句
SELECT *
FROM db_library.v_user_book;
;
# 19 删除视图
DROP VIEW db_library.v_user_book;
# 20 删除图书名称索引
DROP INDEX idx_title
ON db_library.book;