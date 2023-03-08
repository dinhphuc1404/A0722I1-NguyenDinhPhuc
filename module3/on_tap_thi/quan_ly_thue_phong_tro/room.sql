create database room;
use room;
create table room(
	id int primary key auto_increment,
    name varchar(45),
    phone varchar(45),
    day date,
    id_thanh_toan int,
    foreign key(id_thanh_toan) references pay(id_thanh_toan)
);

create table pay(
	id_thanh_toan int primary key auto_increment,
    ten_thanh_toan varchar(45)
);