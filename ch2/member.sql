-- member 테이블 생성
create table member(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender nvarchar2(2) not null,
	email varchar2(50) not null
);

insert into member values('hongq123', 'hong123@','홍길동','남','hong123@gmail.com');

select * from member where userid='hong' and password='hong';

drop table member;

select * from member;

-- 비밀번호 변경
update MEMBER set password='' where userid='' and password='';













