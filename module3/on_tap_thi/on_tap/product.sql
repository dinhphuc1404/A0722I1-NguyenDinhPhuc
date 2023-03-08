create database product;
use product;
create table danh_muc(
	id_danh_muc int primary key auto_increment,
    ten_danh_muc varchar(45)
);

create table san_pham(
	id int primary key auto_increment,
    name varchar(45),
    gia double,
    so_luong int,
    color varchar(45),
    mo_ta varchar(45),
    id_danh_muc int ,
    foreign key(id_danh_muc) references danh_muc(id_danh_muc)
);
select san_pham.id, san_pham.name, san_pham.gia, san_pham.so_luong, san_pham.color, san_pham.mo_ta, danh_muc.ten_danh_muc from san_pham join
danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc;