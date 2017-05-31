# 1.使用合理的数据类型、约束和规范的语句创建以上各表（40分）
DROP DATABASE IF EXISTS db_exam;
CREATE DATABASE db_exam;

DROP TABLE IF EXISTS db_exam.student;
CREATE TABLE db_exam.student (
  id           INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  name         VARCHAR(255) COMMENT '姓名',
  age          INT COMMENT '年龄',
  gender       VARCHAR(255) COMMENT '性别',
  dob          VARCHAR(255) COMMENT '出生日期',
  departmentId INT COMMENT 'FK'
)
  COMMENT '学生表';

DROP TABLE IF EXISTS db_exam.department;
CREATE TABLE db_exam.department (
  id    INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  title VARCHAR(255) COMMENT '系别名',
  tel   VARCHAR(255) COMMENT '电话'
)
  COMMENT '系别表';


DROP TABLE IF EXISTS db_exam.course;
CREATE TABLE db_exam.course (
  id     INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  title  VARCHAR(255) COMMENT '课程名称',
  credit INT COMMENT '学分'
)
  COMMENT '课程表';

DROP TABLE IF EXISTS db_exam.student_course;
CREATE TABLE db_exam.student_course (
  id        INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  studentId INT COMMENT 'FK',
  courseId  INT COMMENT 'FK',
  grade     INT COMMENT '考试成绩'
)
  COMMENT '选课表';

# 2.写出查询各表字段注释、各表名注释的语句 (10分)
SHOW FULL COLUMNS FROM db_exam.department;
SHOW CREATE TABLE db_exam.department;
SHOW FULL COLUMNS FROM db_exam.student;
SHOW CREATE TABLE db_exam.student;
SHOW FULL COLUMNS FROM db_exam.course;
SHOW CREATE TABLE db_exam.course;
SHOW FULL COLUMNS FROM db_exam.student_course;
SHOW CREATE TABLE db_exam.student_course;

# 3.为存在关联的表追加合理的外键（10分）
ALTER TABLE db_exam.student
  ADD CONSTRAINT
  fk_student_departmentId
FOREIGN KEY (departmentId)
REFERENCES db_exam.department (id);

ALTER TABLE db_exam.student_course
  ADD CONSTRAINT
  fk_student_course_studentId
FOREIGN KEY (studentId)
REFERENCES db_exam.student (id)
ON DELETE CASCADE ;

ALTER TABLE db_exam.student_course
  ADD CONSTRAINT
  fk_student_course_courseId
FOREIGN KEY (courseId)
REFERENCES db_exam.course (id);

# 4.为各表添加 5 条样本数据（10分）
INSERT INTO db_exam.department VALUE (NULL, 'CS', 5632);
INSERT INTO db_exam.department VALUE (NULL, 'ES', 8956);
INSERT INTO db_exam.department VALUE (NULL, 'EE', 4852);
INSERT INTO db_exam.department VALUE (NULL, 'CC', 8963);
INSERT INTO db_exam.department VALUE (NULL, 'SS', 8961);

INSERT INTO db_exam.student VALUE (NULL, '王静', 17, '女', '2000-06-09', 1);
INSERT INTO db_exam.student VALUE (NULL, 'Tom', 17, '女', '2000-06-09', 2);
INSERT INTO db_exam.student VALUE (NULL, 'Jerry', 17, '女', '2000-06-09', 3);
INSERT INTO db_exam.student VALUE (NULL, '王伟', 17, '女', '2000-06-09', 3);
INSERT INTO db_exam.student VALUE (NULL, 'Kim', 17, '女', '2000-06-09', 4);

INSERT INTO db_exam.course VALUES (NULL, 'JS', 2);
INSERT INTO db_exam.course VALUES (NULL, 'CSS', 2);
INSERT INTO db_exam.course VALUES (NULL, 'Java', 2);
INSERT INTO db_exam.course VALUES (NULL, 'MySQL', 2);
INSERT INTO db_exam.course VALUES (NULL, 'English', 2);

INSERT INTO db_exam.student_course VALUES (NULL, 1, 1, 60);
INSERT INTO db_exam.student_course VALUES (NULL, 1, 2, 60);
INSERT INTO db_exam.student_course VALUES (NULL, 2, 2, 90);
INSERT INTO db_exam.student_course VALUES (NULL, 3, 3, 80);
INSERT INTO db_exam.student_course VALUES (NULL, 4, 4, 70);
INSERT INTO db_exam.student_course VALUES (NULL, 5, 5, 98);

# 5.修改选课表 grade 字段，改名为 score（10分）
ALTER TABLE db_exam.student_course
  CHANGE grade score INT;

SELECT *
FROM db_exam.course;

SELECT *
FROM db_exam.department;

SELECT *
FROM db_exam.student;

SELECT *
FROM db_exam.student_course;

# 6.查询所有姓王的学生（10分）
SELECT *
FROM db_exam.student
WHERE name LIKE '王%';
# 7.删除各表，删除数据库（10分）
DROP TABLE db_exam.student_course;
DROP TABLE db_exam.student;
DROP TABLE db_exam.course;
DROP TABLE db_exam.department;
DROP DATABASE db_exam;
