-- package specification
create or replace package employeepack is
procedure employeeinsert(id in number,code in varchar2);
function calculatedays(code varchar2) return number;
procedure outparamexample(code in varchar2,days out number);

end ;


-- package body
create or replace package body employeepack is

procedure employeeinsert(id number,code in varchar2) is
  v_count number;
  v_name employee.empname%type;   -- using type data type
  v_code employee.empcode%type;
  v_dept dept.deptname%type;
  v_exp number;
  v_case varchar2(50);
begin
  select count(*) into v_count from employee where empcode = code;

  if v_count < 1 then
     insert into employee values (id,code,'Karuppasamy',to_date('10-Mar-2013','dd-mon-yyyy'),
                             UTL_RAW.CAST_TO_RAW('This is to be convert into 0s and 1s'),
                             'char large object',2700,987654);
                             
     dbms_output.put_line('Employee record Inserted');
     commit;
     dbms_output.put_line('Employee Details ');
     
-- calling function 
     select empname,empcode,deptname,calculatedays(empcode) into v_name,v_code,v_dept,v_exp from employee join dept on dept.deptid = employee.deptid where empid=id; 
     dbms_output.put_line('Name - '||v_name||' Code - '||v_code||' Dept - '||v_dept||' Experance - '||v_exp);
     
-- using case when expression
     v_case := case  when v_exp > 15 then '15 days Exp'
     when  v_exp > 12 then '12 Days Exp'
     when v_exp > 10 then '10 Days Exp'
     else 'No Exp' end ;
          
     dbms_output.put_line('Experiance'||v_case);   
     
  else
     dbms_output.put_line('Already Exist Employee');
  end if ;
end employeeinsert;


function calculatedays(code varchar2) return number is
days number ;
begin
-- calculate days between 2 dates
     select round(to_number(sysdate - e.doj),0) into days  from employee e where empcode =code ; 
     dbms_output.put_line(' Calling Function');
     dbms_output.put_line('Days '||days);
     
     
-- calling procetures using OUT  Param
     dbms_output.put_line(' Calling Proceture');
     outparamexample(code,days);
     dbms_output.put_line('Days '||days);    
     
 return days;
end calculatedays;


procedure outparamexample(code in varchar2,days out number) is 

begin
-- using OUT param
     select round(to_number(sysdate - e.doj),0) into days  from employee e where empcode =code ;      
end outparamexample;


-- overload procedures
procedure outparamexample(days out number,code in varchar2) is 

begin
     select round(to_number(sysdate - e.doj),0) into days  from employee e where empcode =code ; 
     
end outparamexample;

end employeepack ;


select * from employee

-- calling procedure
call employeepack.employeeinsert(12369,'gbs03574');

-- calling function
select employeepack.calculatedays('gbs03530')||' Days' as exp ,empcode,empname  from employee where empcode  = 'gbs03530'

-- calling function within query
select a.*,
employeepack.calculatedays(a.empcode)||' Days' as exp 
from
(select empname,empcode from employee )a

-- calling proceture with interchange parameters

call employeepack.employeeinsert(code => 'gbs03575',id => 12370);



-- annoynms block with loop
declare 
a number :=0;
begin 
loop 
a:= a+1;
dbms_output.put_line('A--> '||a);
exit when a>10; 
end loop;
end;


-- annoynms block with loop and insert
create table temp (no1 number);


declare 
a number :=0;
begin 
loop 
a:= a+1;
exit when a>10; 
insert into temp values (a);
end loop;
commit;
end;

select * from temp 

delete from temp

-- annoynms block with while loop

declare 
a number :=0;
begin 
while a<10
loop 
a:= a+1; 
insert into temp values (a);
end loop;
commit;
end;


select * from temp 
delete from temp

-- annoynms block with for loop

declare 
begin 
for a in 1..10 
loop 
insert into temp values (a);
end loop;
commit;
end;

select * from temp 
delete from temp


-- annoynms block with for loop reverse

declare 
begin 
for a in reverse 1..10 
loop 
insert into temp values (a);
end loop;
commit;
end;

select * from temp 
delete from temp



