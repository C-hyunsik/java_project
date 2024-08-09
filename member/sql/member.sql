--ORACLE
create table member(
name varchar2(15) not null,      --중복가능
id varchar2(30) primary key,     --중복불가능(무결성 제약조건), not null
pw varchar2(50) not null,
phone varchar2(20) unique        --중복불가능
);