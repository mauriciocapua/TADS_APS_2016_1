drop database csv_template; 
create database csv_template; 
\c csv_template;
create table if not exists csv(cpf varchar(15) primary key, nome varchar(200), idade integer); 

insert into csv values('111.111.111-11', 'igor pereira', 29);
insert into csv values('222.222.222-22', 'betito', 90);
insert into csv values('333.333.333-33', 'mifael', 50);
select * from csv;
