create table User_table(
    id int not null,
    name varchar(20) not null,
    user_type numeric(1, 0),
    created_date date,
    user_pass varchar(32)
);
create unique index pk_user_table on User_table (id, user_pass);
alter table User_table
add constraint pk_user_table primary key using index pk_user_table;