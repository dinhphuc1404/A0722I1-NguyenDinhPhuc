create database student_management;
use student_management;
create table student(
	id int,
    name_student varchar(255),
    age_student int,
    country varchar(255)
);
create table class(
	id int,
    name_class varchar(255)
);
create table teacher(
	id int,
    name_teacher varchar(255),
    age_teacher int,
    country varchar(255)
);