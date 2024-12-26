create database webstore;

create table products(
    id INT primary key,
    pname VARCHAR(20),
    brand VARCHAR(20),
    price FLOAT(7,2),
    stock SMALLINT
);

insert into products values(103,'笔记本电脑','Lenovo',4900.00,8);
insert into products values(104,'苹果7s Plus手机','苹果', 5300.00,5);
insert into products values(101,'数码相机','奥林巴斯',1330.00,3);
insert into products values(102,'平板电脑','苹果',1990.00,5);
insert into products values(105,'台式计算机','戴尔',4500.00,10);
