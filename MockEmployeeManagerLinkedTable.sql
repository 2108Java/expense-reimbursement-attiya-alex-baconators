create table Employee_project1 (employeeId serial primary key,firstname varchar (20), lastname varchar(30), department varchar(20), outstanding_expenses float,managerId int, foreign key (managerId) references Finance_mgr(managerId));--finance manager will be a foreign key

alter table employee_project1 add foreign_key_mgr int references Finance_mgr(assigned_emp);

select *from Employee_project1;

create table Finance_mgr(managerId serial primary key, firstname varchar (20), lastname varchar(30));--one to many(one manager can manage multiple employee accounts)

select *from Finance_mgr;

insert into Employee_project1(firstname,lastname,department,outstanding_expenses,managerId) values ('Rick','Sanchez','IT',null,1);
insert into Employee_project1(firstname,lastname,department,outstanding_expenses,managerId) values('Morty','Smith','HR',null,2);
insert into Employee_project1(firstname,lastname,department,outstanding_expenses,managerId) values('Attiya','Kovenburg','IT',null,2);
insert into Employee_project1(firstname,lastname,department,outstanding_expenses,managerId) values('John','Taft','HR',null,3);
insert into Employee_project1(firstname,lastname,department,outstanding_expenses,managerId) values('Belinda','Flowers','HR',null,4);

insert into Finance_mgr(firstname,lastname) values ('Tim','Smith');
insert into Finance_mgr(firstname,lastname) values('Sue','Anne');
insert into Finance_mgr(firstname,lastname) values('Stephen','Parker');
insert into Finance_mgr(firstname,lastname) values('Ricky','Ticky');

select *from planets;


drop table employee_project1 ;
drop table finance_mgr ;