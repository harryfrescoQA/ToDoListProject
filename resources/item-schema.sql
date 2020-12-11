drop table if exists full_list CASCADE;
drop table if exists item CASCADE;
 

create table item (id bigint generated by default as identity, done boolean not null, message varchar(255) not null, title varchar(255) not null, full_list_id bigint, primary key (id));