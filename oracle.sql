create table testorder(
mname varchar2(10),
item varchar2(10) not null,
qty number(3),
price number(7),
indate timestamp default sysdate
);
select * from testorder;
create table testcom(
no number(2),
name varchar2(10),
price number(6),
qty number(4) check(qty>=0));
drop sequence testcom_no;
create sequence testcom_no;

insert into testcom values(1,'채끝',60000,200);
insert into testcom values(2,'등심',50000,200);
insert into testcom values(3,'안심',80000,200);
insert into testcom values(4,'토마호크',120000,200);
insert into testcom values(5,'포터하우스',150000,200);
select * from testcom;
truncate table testcom;

create table testnow(
no number(2),
name varchar2(10),
price number(6),
qty number(4)default 0, check(qty>=0));
drop table testnow;
select * from testnow;
insert into testnow values(1,'채끝',60000,default);
insert into testnow values(2,'등심',50000,default);
insert into testnow values(3,'안심',80000,default);
insert into testnow values(4,'토마호크',120000,default);
insert into testnow values(5,'포터하우스',150000,default);

--create or replace trigger testorder
--after update
--on testnow
--for each row
--begin
--    update testcom set qty=(select qty from :new);
--end testorder;





