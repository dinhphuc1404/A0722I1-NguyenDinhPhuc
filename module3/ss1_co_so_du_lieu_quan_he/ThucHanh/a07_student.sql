-- câu lệnh tạo database;
create database a07_student;
-- chọn database mong muốn làm việc;
use a07_student;
-- tạo table;
create table mon_hoc (
	ma_mh int ,
    ten_mh varchar(255)
);
-- lấy nội dung toàn bộ table
select * from mon_hoc;
-- thêm dữ liệu vào table
insert into mon_hoc(ma_mh, ten_mh)
value (1, "toan");

insert into mon_hoc(ma_mh, ten_mh)
value
	(2,"hoa"),
    (3,"ly"),
    (4,"sinh");
select ten_mh from mon_hoc;
