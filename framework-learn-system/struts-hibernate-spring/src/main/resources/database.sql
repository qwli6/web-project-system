create database ssh;

use ssh;

create table user
(
  uid varchar(48) not null
    primary key,
  username varchar(16) null,
  nickname varchar(16) null
);