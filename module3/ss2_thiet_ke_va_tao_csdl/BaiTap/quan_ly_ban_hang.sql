create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
	c_ID int auto_increment primary key not null,
    c_Name varchar(255) not null,
    c_Age int not null
);

create table order_1 (
	o_ID int primary key auto_increment not null,
    c_ID int not null,
    o_Date datetime not null,
    o_TotalPrice float not null,
    foreign key (c_ID) references customer (c_ID)
);
create table product(
	p_ID int  primary key auto_increment not null,
    p_Name varchar(255) not null,
    p_Price float not null
);
create table order_detail(
	o_ID int not null,
    p_ID int not null,
    od_QTY int not null,
    primary key (o_ID,p_ID),
    foreign key (o_ID) references order_1(o_ID),
    foreign key (p_ID) references product(p_ID)
);