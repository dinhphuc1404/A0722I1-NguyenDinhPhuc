create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
	class_id int not null primary key auto_increment,
    class_name varchar(60) not null,
    start_date datetime not null,
    status bit
);
create table student(
	student_id int not null primary key auto_increment,
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    status bit,
    class_id int not null,
    foreign key(class_id) references class(class_id)
);
create table subject(
	sub_id int not null primary key auto_increment,
    sub_name varchar(30) not null,
    credit tinyint not null default 1 check (credit>=1),
    status bit default 1
);
create table mark(
	mark_id int not null primary key auto_increment,
    sub_id int not null ,
    student_id int not null,
    mark float default 0 check(mark between 0 and 100),
    exam_times tinyint default 1,
    unique(sub_id, student_id),
    foreign key(sub_id) references subject(sub_id),
    foreign key(student_id) references student(student_id)
);
insert into class
values (1,'A1','2008-12-20',1);
insert into class
values (2,'A2','2008-12-22',1);
insert into class
values (3,'B3',current_date,0);

insert into student(student_name,address,phone,status,class_id)
values ('Hung', 'Ha Noi','0905064568',1,1);
insert into student(student_name,address,status,class_id)
values ('Hoa','Hai Phong',1,1);
insert into student(student_name,address,phone,status,class_id)
values('Manh','HCM','0123456789',0,2);

insert into subject
values (1,'CF',5,1),
		(2,'C',6,1),
        (3,'HDJ',5,1),
        (4,'RDBMS',10,1);
        
insert into mark(sub_id,student_id,mark, exam_times)
values (1,1,8,1),
		(1,2,10,2),
		(2,1,12,1);
        
-- truy vấn
-- hiển thị tất cả student
select*from student;
--  status là trang thái học tập của học viên true: đang học, fasle: nghỉ học
select*from student where status = true;
-- Sử dụng điều kiện where Credit < 10 và from Subject để lấy ra danh sách các môn học có thời gian học nhỏ hơn 10
select*from subject where credit<10;
-- câu lệnh Join và where để hiển thị danh sách học viên lớp A1
select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id = c.class_id;

-- BÀI TẬP 
-- hiển thị tất cả sinh viên có tên bắt đầu bằng 'h'
select * from student where student_name like 'h%';
-- hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select*from class where month(start_date)=12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject where credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student set class_id = 2 where student_name = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student_name,sub_name,mark from student join mark using (student_id) join subject using (sub_id) 
order by mark desc, student_name;



		


