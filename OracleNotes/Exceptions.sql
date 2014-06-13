
select myexceptiontest from dual

create or replace function practiceexception(num number) return number as
v_name employee.empname%type;

myexception exception;
pragma exception_init(myexception,-20002);

begin

if num=1  then 
select empname into v_name from employee where empcode ='novalue';  -- NO_DATA_FOUND
elsif num=2 then 
      select empname into v_name from employee; -- TOO_MANY_ROWS
elsif num=3 then 
        raise myexception;  -- myexception
else          
        raise_application_error(-20001,'My Own error'); 
end if ;

return 0;
exception

 when NO_DATA_FOUND then 
      dbms_output.put_line('No Record Found');
      return 0;
 when TOO_MANY_ROWS then 
      dbms_output.put_line('Too Many Rows');       
      return 0;    
 when myexception then
      dbms_output.put_line('User Defined Exception'||SQLERRM||SQLCODE);  
      raise; -- propogate to parent
      return 0;         
end;



create or replace function myexceptiontest return number
as
a number :=0;
temp number;
myexception exception;
begin
while a<5
loop
a := a+1;
if(a=1) then
  select practiceexception(1) into temp from dual;
elsif (a=2) then
  select practiceexception(2)into temp  from dual;
 elsif(a=3) then
 select practiceexception(3) into temp  from dual;
 elsif(a=4) then
 select practiceexception(4) into temp  from dual;
 end if;
end loop;
 return 0;
exception
when myexception then 
  dbms_output.put_line('Coming to Parent Myexception');
   return 0; 
when others then 
 dbms_output.put_line('Coming to Parent'||SQLERRM||sqlcode);
 return 0; 
end;
