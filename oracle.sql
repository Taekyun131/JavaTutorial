create table staff(
    id varchar2(10) primary key,
  pwd varchar2(20),
  name varchar2(10),
  rank varchar2(6) check(rank in('사원','매니저','점주')),
  wtime number(2) default 0);
  drop table staff;
  
  create table comitem(
no number(2),
name varchar2(10),
price number(6),
qty number(4) check(qty>=0));
select * from comitem;
create sequence comitem_no;
insert into comItem values(comitem_no.nextval,'채끝',60000,200);
insert into comItem values(comitem_no.nextval,'등심',50000,200);
insert into comItem values(comitem_no.nextval,'안심',80000,200);
insert into comItem values(comitem_no.nextval,'토마호크',120000,200);
insert into comItem values(comitem_no.nextval,'포터하우스',150000,200);

create table nowitem(
no number(2),
name varchar2(10),
price number(6),
qty number(4) default 0, check(qty>=0));
select * from nowitem;
create sequence nowitem_no;

insert into nowitem values(nowitem_no.nextval,'채끝',60000,default);
insert into nowitem values(nowitem_no.nextval,'등심',50000,default);
insert into nowitem values(nowitem_no.nextval,'안심',80000,default);
insert into nowitem values(nowitem_no.nextval,'토마호크',120000,default);
insert into nowitem values(nowitem_no.nextval,'포터하우스',150000,default);


create table revenue(
mname varchar2(10),
item varchar2(10) not null,
qty number(3),
price number(7),
indate timestamp default sysdate
);


create table return(
mname varchar2(10),
item varchar2(10) not null,
qty number(3),
price number(7),
indate timestamp default sysdate
);

create table orderitem(
mname varchar2(10),
item varchar2(10) not null,
qty number(3),
price number(7),
indate timestamp default sysdate
);

create table review(
no number(3),
name varchar2(10),
content varchar2(50),
star number(1) check(star in(1,2,3,4,5)));
alter table review add indate timestamp default sysdate;
alter table review add vdate date default sysdate;


create sequence review_no;


insert into staff values('333','333','333','점주',default);
select * from staff;
commit;


create or replace trigger ordertrg
after update 
on comitem
for each row
begin 
    update nowitem set qty=qty+(:old.qty-:new.qty) where no=:new.no;
end;
commit;
drop trigger modcom;
drop trigger ordertrg;
