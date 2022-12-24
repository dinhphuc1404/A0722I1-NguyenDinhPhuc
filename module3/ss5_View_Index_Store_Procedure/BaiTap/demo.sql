create database demo;
use demo;
create table products (
id int primary key,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_desc varchar(45),
product_status varchar(45)
);
insert into products values
(1,'A0534','iPhone5',2000,10,'Hàng mới','còn hàng'),
(2,'A0Re4','iPhone6',3000,11,'Hàng cũ','còn hàng'),
(3,'A05f4','iPhone7',4000,12,'Hàng mới','còn hàng'),
(4,'A0cy4','iPhone8',5000,13,'Hàng cũ','còn hàng'),
(5,'B0534','iPhone9',6000,14,'Hàng mới','còn hàng'),
(6,'Uf534','iPhone10',7000,15,'Hàng cũ','còn hàng'),
(7,'E0534','iPhone11',8000,167,'Hàng mới','còn hàng'),
(8,'I0534','iPhone12',9000,17,'Hàng cũ','còn hàng');

-- Bước 3
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index
alter table products add unique index product_index(product_code);
explain select * from products where product_code = 'Uf534';
alter table products add index composite_index(product_name, product_price);
explain select * from products where product_name = 'iPhone12' and product_price = 9000;

-- Bước 4
-- Tạo view
create view product_views as
select product_code, product_name, product_price, product_status from products;
select * from product_views;
-- Sửa view
update product_views set  product_name = 'iPhone5s' where product_code = 'A0534';
-- xóa view 
delete from product_views where product_code = 'A0534';

-- Bước 5
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter $$
create procedure show_product()
begin 
	select*from products;
end; $$
delimiter ;
call show_product();
-- Tạo store procedure thêm một sản phẩm mới
delimiter $$
create procedure add_product( in id int , in `code` varchar(45), in `name` varchar(45), in price int, 
in amount int, in `desc` varchar(45),in `status` varchar(45))
begin
insert into products values(id,`code`,`name`,price,amount,`desc`,`status`);
end; $$
delimiter ;
call add_product(9,'A0734','iphone13',10020,20,'Hàng mới','còn hàng');
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter $$
create procedure update_product (in idx int, in `code` varchar(45), in `name` varchar(45),in price int, in amount int, in `desc` varchar(45),in `status` varchar(45))
begin
update products set
product_code = `code`,
product_name = `name`,
product_price = price,
product_amount = amount,
product_desc = `desc`,
product_status = `status`
where idx = id;
end; $$
delimiter ;
call update_product(2,'A0123','Iphone6',3000,11,'Hàng cũ','còn hàng');
-- Tạo store procedure xoá sản phẩm theo id
delimiter $$
create procedure remove_product(in idx int)
begin
delete from products where id = idx;
end; $$
delimiter ;
call remove_product(9);



