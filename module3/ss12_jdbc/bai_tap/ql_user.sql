create database ql_user;
use ql_user;
create table users(
	id int(3) not null auto_increment,
    name varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key(id)
);
insert into users(name,email,country) values('Phuc','phuc@codegym.vn','Quang Nam');
insert into users(name, email, country) values('Hi','hi@codegym.vn','Da Nang');
select*from users;
insert into users(name, email, country) values('Hoi Anh','hihi@codegym.vn','Quang Binh');

delimiter $$
create procedure get_user_by_id(in user_id int)
begin
	select users.name, users.email, users.country from users
    where users.id = user_id;
end $$
delimiter $$

delimiter $$
create procedure insert_user(
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
	insert into users(name,email,country) values (user_name,user_email,user_country);
end $$
delimiter $$

delimiter $$
create procedure find_all_users()
begin
	 select*from users;
end $$
delimiter ;

delimiter $$
create procedure update_users(
	in id_user int,
    in name_user varchar(120),
    in email_user varchar(220),
    in country_user varchar(120)
)
begin
	 update users set name = name_user, email = email_user,country = country_user where id = id_user;
end $$
delimiter ;


call update_users(8,"B","phuc@gmail.com","Quang Nam");
select*from users;

delimiter $$
create procedure delete_users(
	IN user_id int
)
	begin
		delete from users 
        where id = user_id;
	end $$
delimiter ;
call delete_users(8);
