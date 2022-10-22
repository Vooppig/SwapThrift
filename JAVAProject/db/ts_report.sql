create table Report(
    id int not null,
    r_date date not null,
    r_text text,
    user_id int not null,
    prod_id int,
    user_reported_id int,
    report_datetime timestamp
);
create unique index pk_report on report (id, r_date);
alter table Report
add constraint pk_report primary key using index pk_report;
alter table Report
add constraint fk_report foreign key (user_id) references user_table (id);