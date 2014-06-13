-- test usign nested table in sql
create type testtype as table of varchar2(50);

create table tes (
name varchar2(20) primary key,
testtype testtype
)
nested table testtype store as test;

select * from tes

insert into tes values('karthik',testtype('hai','karthi','how','are','you'));

update tes set testtype = testtype('hai','kumar','how','are','you') where name = 'karthik';

declare 
temp testtype;
vname varchar2(50);
begin
select testtype,name into temp,vname from tes ;
for i in temp.FIRST..temp.LAST 
loop
    dbms_output.put_line(temp(i));    
    if(temp(i)='kumar') then
      temp(i) := 'karthikeyan';       
     end if;
end loop;
update tes set testtype = temp where name = vname;  -- update some portion in collection 
end;

select t.name,nest.column_value as value from tes t 
left join 
table(t.testtype) nest
on 1=1
where nest.column_value ='hai'

-- test usign nested table in plsql

declare 
type testnest is table of varchar2(50);
temp testnest := testnest() ;  

begin
for i in 1..3
loop
temp.extend;
temp(i) := 'karthik'||i;
end loop;

for i in temp.FIRST.. temp.LAST
loop
dbms_output.put_line(temp(i));
end loop;
end;


-- test using varray in sql
create or replace type varraytest as varray(3) of varchar2(50);

create table varraytab
(
name varchar2(50),
varrayt varraytest
);

select * from varraytab

insert into varraytab values('Karthik',varraytest('Working','in','Bancasella'))

declare 
temp varraytest;
begin
select varrayt into temp from varraytab;
 
for i in temp.FIRST..temp.LAST
loop
    dbms_output.put_line('Values'||temp(i));
end loop;
end;


select * from varraytab v
left join table(v.varrayt)a on 1=1 where a.column_value  ='Bancasella'

-- test using varray in plsql

declare 
type varraytest is varray(3) of varchar(50);
temp varraytest := varraytest();
begin
for i in 1..3
loop
temp.extend;
temp(i) := 'Karthik'||i;
end loop;

for i in temp.FIRST .. temp.LAST
loop
dbms_output.put_line(temp(i));
end loop;
end;


-- test using associate array in sql

--its not poosible in sql.. associate array not support in sql onlu\y support in plsql
