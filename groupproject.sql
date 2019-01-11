

create database if not exists user_info; 

use user_info; 

drop table if exists user_info; 

create table user_info(
    id int(11) not null auto_increment PRIMARY KEY,
    username varchar(25) not null UNIQUE, 
    password varchar(25) not null

); 

