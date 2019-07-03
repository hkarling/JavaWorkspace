select *from member; -- alt+x

drop table member;
--회원가입 테이블 생성

create table member(
   id varchar2(20) primary key ,
   pwd varchar2(20) not null,
   name varchar2(20) not null,
   age int,
   phone varchar2(15),
   addr varchar2(50),
   join_date date not null
);

select * from member;
--레코드 추가
insert into member(id,pwd,name,age,phone,addr, join_date)
values('jang','1234','장희정',20,'010-8875-8253','서울시 광진구', sysdate);

insert into member values('user1','1234','user1',40,'000-0000-0000','성남시 분당구', sysdate);
insert into member values('user2','2345','user2',30,'111-1111-1111','성남시 분당구', sysdate);
insert into member values('user3','3456','user3',20,'222-2222-2222','성남시 분당구', sysdate);
commit
