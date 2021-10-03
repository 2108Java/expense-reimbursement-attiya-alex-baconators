create table requests_table (
	foreign key (employee_id) references employee_table(employee_id),
	request_approval boolean default (false),
	request_type varchar(15) not null,
	description varchar(200),
	amount bigint not null,
	time_log timestamp default (current_timestamp)
);