CREATE TABLE community (
  cno bigint NOT NULL AUTO_INCREMENT,
  id varchar(100) DEFAULT NULL,
  writer varchar(100) NOT NULL,
  title varchar(100) NOT NULL,
  content text,
  reg_at datetime DEFAULT CURRENT_TIMESTAMP,
  mod_at datetime DEFAULT CURRENT_TIMESTAMP,
  read_count int DEFAULT '0',
  image_file text,
  PRIMARY KEY (cno)
)

CREATE TABLE course (
  csno bigint NOT NULL AUTO_INCREMENT,
  sno bigint NOT NULL,
  email varchar(100) NOT NULL,
  user_name varchar(100) NOT NULL,
  course_name varchar(1000) NOT NULL,
  professor_id varchar(100) NOT NULL,
  professor_name varchar(100) NOT NULL,
  course_major varchar(100) NOT NULL,
  start_at date NOT NULL,
  end_at date NOT NULL,
  PRIMARY KEY (csno)
)

CREATE TABLE reply (
  rpno bigint NOT NULL AUTO_INCREMENT,
  cno bigint NOT NULL,
  id varchar(100) DEFAULT NULL,
  replier varchar(100) NOT NULL,
  content text,
  reg_at datetime DEFAULT CURRENT_TIMESTAMP,
  mod_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (rpno)
)

CREATE TABLE review (
  rvno bigint NOT NULL AUTO_INCREMENT,
  sno bigint NOT NULL,
  title varchar(100) NOT NULL,
  id varchar(100) NOT NULL,
  writer varchar(100) NOT NULL,
  score int NOT NULL,
  content text,
  reg_at datetime DEFAULT CURRENT_TIMESTAMP,
  mod_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (rvno)
)

CREATE TABLE subject (
  sno bigint NOT NULL AUTO_INCREMENT,
  title varchar(100) NOT NULL,
  id varchar(100) NOT NULL,
  writer varchar(100) NOT NULL,
  major varchar(100) NOT NULL,
  description text,
  image_file text NOT NULL,
  class_limit int NOT NULL,
  attends int DEFAULT '0',
  start_at date NOT NULL,
  end_at date NOT NULL,
  reg_at datetime DEFAULT CURRENT_TIMESTAMP,
  mod_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (sno)
)

CREATE TABLE user (
  email varchar(100) NOT NULL,
  pwd varchar(100) NOT NULL,
  user_name varchar(100) NOT NULL,
  reg_at datetime DEFAULT CURRENT_TIMESTAMP,
  last_login datetime DEFAULT NULL,
  grade tinyint DEFAULT '10',
  major varchar(100) NOT NULL,
  PRIMARY KEY (email)
)

update user set
grade = 101
where email = 'admin@admin.com';