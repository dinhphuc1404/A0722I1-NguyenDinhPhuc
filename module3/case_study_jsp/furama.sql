create database furama;
use furama;
create table positionn(
	position_id int primary key not null,
    position_name varchar(45)
);

create table education_degree(
	education_degree_id int primary key not null,
    education_degree_name varchar(45)
);

create table division(
	division_id int primary key not null,
    division_name varchar(45)
);

create table user(
	username varchar(255) primary key not null,
    password varchar(255)
);

create table employee(
	employee_id int primary key not null,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255),
    foreign key(position_id) references positionn(position_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(division_id) references division(division_id),
    foreign key(username) references user(username)
);
 create table role(
	role_id int primary key not null,
    role_name varchar(255)
 );
 
 create table user_role(
	role_id int ,
    username varchar(255),
    foreign key(role_id) references role(role_id),
    foreign key(username) references user(username)
 );
 
 create table customer_type(
	customer_type_id int primary key not null,
    customer_type_name varchar(45)
 );
 
 create table customer(
	customer_id int primary key not null,
    customer_type_id int not null,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45),
    customer_address varchar(45),
    foreign key(customer_type_id) references customer_type(customer_type_id)
 );
 
 create table service_type(
	service_type_id int primary key not null,
    service_type_name varchar(45)
 );
 
 create table rent_type(
	rent_type_id int primary key not null,
    rent_type_name varchar(45),
    rent_type_cost double
 );

create table service(
	service_id int primary key not null,
    service_name varchar(45) not null,
    service_area int ,
    service_cost double not null,
    service_max_people int,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45),
    discription_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,	
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);

create table attach_service(
	attach_service_id int primary key not null,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45)
);

create table contract(
	contract_id int primary key not null,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_deposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id) references service(service_id)
);

create table contract_detail(
	contract_detail_id int primary key not null,
    contract_id int not null,
    attach_service_id int not null,
    quantity int not null,
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);
select employee.employee_id,employee.employee_name,employee.employee_birthday,employee.employee_id_card,employee.employee_salary,
employee.employee_phone,employee.employee_email,employee.employee_address,positionn.position_name,education_degree.education_degree_name,
division.division_name,user.username,user.password from employee inner join positionn on positionn.position_id = employee.position_id
            inner join education_degree on education_degree.education_degree_id = employee.education_degree_id 
            inner join division on division.division_id = employee.division_id
            inner join user on user.username = employee.username;
            
select customer.customer_id, customer.customer_code, customer_type.customer_type_name,customer.customer_name,customer.customer_birthday,customer.customer_gender,
customer.customer_id_card,customer.customer_phone,customer.customer_email,customer.customer_address 
from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id;
 
 