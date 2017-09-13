# Student 表的定义
# id
# name
# gender
# dob出生日期
# department系名称
# address
# Score 表的定义
# id
# studentId
# course课程名
# grade
# 创建student和score表
DROP DATABASE IF EXISTS db_third;
CREATE DATABASE db_third;

DROP TABLE IF EXISTS db_third.Student;
CREATE TABLE db_third.Student (
  id         INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  name       VARCHAR(255) COMMENT '姓名',
  gender     VARCHAR(255) COMMENT '性别',
  dob        DATE COMMENT '出生日期',
  department VARCHAR(255) COMMENT '系名称',
  address    VARCHAR(255) COMMENT '地址'
)
  COMMENT '学生表';

DROP TABLE IF EXISTS db_third.Score;
CREATE TABLE db_third.Score (
  id        INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  studentId INT COMMENT '学生 ID FK',
  course    VARCHAR(255) COMMENT '课程名',
  grade     INT COMMENT '分数'
)
  COMMENT '分数表';
# 创建合理的外键关联
ALTER TABLE db_third.Score
  ADD CONSTRAINT
  Score_fk_studentId
FOREIGN KEY (studentId)
REFERENCES db_third.Student (id);

# 为student表和score表各增加5条记录
INSERT INTO db_third.Student VALUE (NULL, '李四', 'M', '1999-010-01', '电子系', '湖南');
INSERT INTO db_third.Student VALUE (NULL, '王静', 'F', '1995-010-01', '计算机系', '湖南');
INSERT INTO db_third.Student VALUE (NULL, '张三', 'M', '1996-010-01', '外语系', '河北');
INSERT INTO db_third.Student VALUE (NULL, 'Jerry', 'F', '1997-010-01', '中文系', '北京');
INSERT INTO db_third.Student VALUE (NULL, 'Tom', 'M', '2000-010-01', '计算机系', '上海');

INSERT INTO db_third.Score VALUE (NULL, 1, '机械', 99);
INSERT INTO db_third.Score VALUE (NULL, 2, 'Chinese', 66);
INSERT INTO db_third.Score VALUE (NULL, 3, '计算机', 77);
INSERT INTO db_third.Score VALUE (NULL, 4, '计算机', 72);
INSERT INTO db_third.Score VALUE (NULL, 5, 'English', 95);

# 查询student表的所有记录
SELECT *
FROM db_third.Student;
# 查询student表的第2条到4条记录
SELECT *
FROM db_third.Student
LIMIT 1, 3;
# 从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息
SELECT
  id,
  name,
  department
FROM db_third.Student;
# 从student表中查询计算机系和电子系的学生的信息
SELECT *
FROM db_third.Student
WHERE department = '电子系' OR department = '计算机系';
# 从student表中查询年龄18~22岁的学生信息 ------

SELECT *
FROM db_third.Student s
WHERE curdate() - s.dob IN (18, 22);

# 从student表中查询每个院系有多少人
SELECT
  department,
  count(*)
FROM db_third.Student
GROUP BY department;
# 从score表中查询每个科目的最高分 --
SELECT *
FROM db_third.Score
GROUP BY course
ORDER BY grade DESC;
# 查询李四的考试科目（c_name）和考试成绩（grade）
SELECT
  sd.name,
  sc.course,
  sc.grade
FROM db_third.Student sd INNER JOIN db_third.Score sc
    ON sd.id = sc.studentId
WHERE sd.name = '李四';
# 用连接的方式查询所有学生的信息和考试信息
SELECT
  sd.*,
  sc.course,
  sc.grade
FROM db_third.Student sd INNER JOIN db_third.Score sc
    ON sd.id = sc.studentId;

# 计算每个学生的总成绩 ---
SELECT
  sd.name,
  sum(sc.grade)
FROM db_third.Student sd INNER JOIN db_third.Score sc
    ON sd.id = sc.studentId
GROUP BY sd.name;
# 计算每个考试科目的平均成绩 --
SELECT
  course,
  avg(grade)
FROM db_third.Score
GROUP BY course;
# 查询计算机成绩低于95的学生信息
SELECT
  sd.*,
  sc.grade
FROM db_third.Score sc INNER JOIN db_third.Student sd
    ON sd.id = sc.studentId
WHERE sc.grade < 95;

# 查询同时参加计算机和英语考试的学生的信息 --- ?
SELECT
  sd.*,
  sc.grade,
  sc.course
FROM db_third.Score sc INNER JOIN db_third.Student sd
    ON sd.id = sc.studentId
WHERE sc.course IN ('计算机', 'English');

# 将计算机考试成绩按从高到低进行排序
SELECT
  course,
  grade
FROM db_third.Score
WHERE course = '计算机'
ORDER BY grade DESC;
# 从student表和score表中查询出学生的学号，然后合并查询结果 -- ?
SELECT DISTINCT
  sd.*,
  sc.*,
  sd.id,
  sc.studentId
FROM db_third.Score sc INNER JOIN db_third.Student sd
    ON sd.id = sc.studentId;

# 查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
SELECT DISTINCT
  sd.name,
  sd.department,
  sc.course,
  sc.grade
FROM db_third.Score sc INNER JOIN db_third.Student sd
    ON sd.id = sc.studentId
WHERE sd.name REGEXP '张' OR sd.name REGEXP '王';

# 查询都是湖南的学生的姓名、年龄、院系和考试科目及成绩 --
SELECT DISTINCT
  sd.name,
  curdate() - sd.dob,
  sd.department,
  sc.course,
  sc.grade
FROM db_third.Score sc INNER JOIN db_third.Student sd
    ON sd.id = sc.studentId
WHERE sd.address REGEXP '湖南';

SELECT *
FROM db_third.Student;

