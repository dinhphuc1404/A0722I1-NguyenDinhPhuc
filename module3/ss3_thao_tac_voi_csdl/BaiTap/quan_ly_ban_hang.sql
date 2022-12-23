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
-- BÀI TẬP
insert into customer(c_Name,c_Age)
values ('Minh Quan',10),
		('Ngoc Oanh',20),
        ('Hong Hoa',50);
select*from customer;
insert into order_1(c_ID,o_Date,o_TotalPrice)
 values (1,'2006-3-21',2300),
		(2,'2006-3-23',2300),
        (1,'2006-3-16',2300);
select*from order_1;
insert into product(p_Name,p_Price)
values ('May Giat',3),
		('Tu Lanh',5),
        ('Dieu Hoa',7),
        ('Quat',1),
        ('Bep Dien',2);
select*from product;
insert into order_detail(o_ID,p_ID,od_QTY)
values (1,1,3),
		(1,3,7),
        (1,4,2),
        (2,1,1),
        (3,1,8),
        (2,5,4),
        (2,3,3);
select * from order_detail;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_ID,o_Date,o_TotalPrice from order_1;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c_Name,p_Name from customer join order_1 using (c_ID) join order_detail using(o_ID)  join product using (p_ID);
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c_Name from customer left join order_1 using (c_ID) where o_ID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o_ID, o_Date, od_QTY, p_Price, od_QTY*p_Price as o_TotalPrice from order_1 join order_detail using (o_ID) join product using (p_ID);

        
        

		