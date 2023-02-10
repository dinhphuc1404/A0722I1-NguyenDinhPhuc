create database sinh_vien;
use sinh_vien;
create table student(
	ma_sinh_vien int primary key,
    ten_sinh_vien varchar(45),
    tuoi int
);
insert into student 
values (1,"Phuc",22),
		(2,"Hoai Anh",21);

select*from student;
delete from student where ma_sinh_vien = 5;
	
