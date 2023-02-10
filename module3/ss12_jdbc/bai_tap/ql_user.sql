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
