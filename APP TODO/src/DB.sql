create database  todoApp;

create  table  todo(
    title varchar(100) primary key ,
    description text not null ,
    priority int check ( priority >= 0 )
);