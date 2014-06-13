-- implicit cursor in anonyms block
declare 
v_count number;
begin
select count(empid) into v_count  from employee where empcode='12';
if(sql%found and v_count>0) then 
dbms_output.put_line ('Count'||v_count);
elsif (sql%notfound) then
dbms_output.put_line ('Not Found');
else
dbms_output.put_line ('Count>0');
end if ;
end;

-- explicite cursor in anonyms block

declare 
cursor  empcursor is select * from employee;
emprow employee%rowtype;
begin 
open empcursor;
loop
fetch empcursor into emprow;
exit when empcursor%notfound ;
dbms_output.put_line('Values'|| 'empName - '||emprow.empname||'Code - '||emprow.empcode);
end loop;
close empcursor;
end ;


-- explicite cursor with cursor parameter

declare 
cursor  empcursor(code varchar2) is select * from employee where empcode = code;
emprow employee%rowtype;
begin 
open empcursor ('gbs03530');
loop
fetch empcursor into emprow;
exit when empcursor%notfound ;
dbms_output.put_line('Values'|| 'empName - '||emprow.empname||'Code - '||emprow.empcode);
end loop;
close empcursor;
end ;

-- cursor using for 

declare 
cursor  empcursor is select * from employee;
--emprow employee%rowtype;
begin 
for emprow in empcursor 
loop
dbms_output.put_line('Values'|| 'empName - '||emprow.empname||'Code - '||emprow.empcode);
end loop;
end ;


--1. cursor with ref cursor 

declare 
type refcursor is ref cursor;
mycur refcursor;
myrow employee%rowtype;
begin 
open mycur for select * from employee;
loop
fetch mycur into myrow;
exit when mycur%notfound;
dbms_output.put_line('Values'|| 'empName - '||myrow.empname||'Code - '||myrow.empcode||' RowCount '||mycur%rowcount);
end loop;
close mycur;
end;


--2. cursor with ref cursor and multiple select statements

declare 
type refcursor is ref cursor;
mycur refcursor;
myrow employee%rowtype;
myrow1 dept%rowtype;
a number :=0;
begin 
while a<3
loop
a := a+1;

case when a = 1 then 
open mycur for select * from employee;
loop
fetch mycur into myrow;
exit when mycur%notfound;
dbms_output.put_line('Values'|| 'empName - '||myrow.empname||'Code - '||myrow.empcode);
end loop;
close mycur;

when a=2 then
open mycur for select * from dept;
loop
fetch mycur into myrow1;
exit when mycur%notfound;
dbms_output.put_line('Values'|| 'depName - '||myrow1.deptname||'id - '||myrow1.deptid);
end loop;
close mycur;

else
dbms_output.put_line('Empty');
end case;

end loop;
end;


--- bulk collect with cursor

declare 
type employeetype is table of employee%rowtype;
cursor mycur is select * from employee ;
mytype employeetype;
begin 
open mycur;
fetch mycur bulk collect into mytype;
close mycur;
for i in mytype.FIRST..mytype.LAST
loop
dbms_output.put_line('Values '||mytype(i).empname||' Code -'||mytype(i).empcode);    
end loop;
end;

-- nested cursors 

declare 
type curtype is ref cursor;
mycur curtype;
cursor mycur1 is select deptname,cursor(select * from employee) as emp from dept;
deprow dept%rowtype;
emprow employee%rowtype;
deptname dept.deptname%type;
begin
open mycur1;
loop
fetch mycur1 into deptname,mycur;
exit when mycur1%notfound;
dbms_output.put_line('Dept Name '||deptname);
loop
   fetch mycur into emprow;
   exit when mycur%notfound;
   dbms_output.put_line('EmpName '||emprow.empname||' Empcode '||emprow.empcode);     
end loop;
end loop;
end;


