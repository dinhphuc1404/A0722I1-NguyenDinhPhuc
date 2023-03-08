create database final;
use final;
create table mat_bang(
	id int primary key auto_increment,
    ma_mat_bang varchar(45),
    trang_thai varchar(255),
    dien_tich double,
    tang int ,
    loai_mat_bang varchar(45),
    gia_tien double,
    mo_ta varchar(45),
    ngay_bat_dau date,
    ngay_ket_thuc date
);
select * from mat_bang;