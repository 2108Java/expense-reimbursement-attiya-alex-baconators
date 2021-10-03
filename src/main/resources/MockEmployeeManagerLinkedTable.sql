create table employee_table (
	employee_id serial primary key,
	firstname varchar (20), 
	lastname varchar(30), 
	department varchar(20), 
	outstanding_expenses float,
	manager_id int, 
	foreign key (manager_id) references finance_mgr(manager_id));--finance manager will be a foreign key

alter table employee_table add foreign_key_mgr int references Finance_mgr(assigned_emp);

select * from employee_table;

create table finance_mgr(manager_id serial primary key, firstname varchar (20), lastname varchar(30));--one to many(one manager can manage multiple employee accounts)

select * from finance_mgr;

insert into employee_project1(firstname,lastname,department,outstanding_expenses,manager_id) values ('Rick','Sanchez','IT',null,1);
insert into employee_project1(firstname,lastname,department,outstanding_expenses,manager_id) values('Morty','Smith','HR',null,2);
insert into employee_project1(firstname,lastname,department,outstanding_expenses,manager_id) values('Attiya','Kovenburg','IT',null,2);
insert into employee_project1(firstname,lastname,department,outstanding_expenses,manager_id) values('John','Taft','HR',null,3);
insert into employee_project1(firstname,lastname,department,outstanding_expenses,manager_id) values('Belinda','Flowers','HR',null,4);

insert into finance_mgr(firstname,lastname) values ('Tim','Smith');
insert into finance_mgr(firstname,lastname) values('Sue','Anne');
insert into finance_mgr(firstname,lastname) values('Stephen','Parker');
insert into finance_mgr(firstname,lastname) values('Ricky','Ticky');

drop table employee_project1 ;
drop table finance_mgr ;