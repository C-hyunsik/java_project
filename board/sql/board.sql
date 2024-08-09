create table board_java(
seq number,                             --글번호
id varchar2(30) not null,   --아이디 중복x
name varchar2(15) not null,             --이름 빈 문자열x
subject varchar2(100) not null,         --글 제목 빈 문자열x
content varchar2(500),                  --내용
logtime date                            --작성날짜
);

create SEQUENCE board_java_seq NOCACHE;