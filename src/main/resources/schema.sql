alter table administrator
    drop
        foreign key FKki6r2xv31hq1v9vj2m4ptbucd;

drop table if exists administrator;
drop table if exists article;
drop table if exists hibernate_sequence;
drop table if exists member;
drop table if exists professor;
drop table if exists project;
drop table if exists publication;
drop table if exists research_area;
drop table if exists research_equipment;
drop table if exists salt;

create table administrator (
                               administrator_id bigint not null auto_increment,
                               password varchar(255) not null,
                               role varchar(255),
                               username varchar(255) not null,
                               salt_id integer,
                               primary key (administrator_id)
);

create table article (
                         article_id bigint not null auto_increment,
                         author varchar(255),
                         board_type varchar(255),
                         content varchar(1000),
                         create_date datetime(6),
                         topic varchar(255),
                         primary key (article_id)
);

create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );

create table member (
                        member_id bigint not null auto_increment,
                        degree varchar(255),
                        email varchar(255),
                        eng_name varchar(255),
                        graduate bit,
                        name varchar(255) not null,
                        photo varchar(255),
                        research_area varchar(255),
                        primary key (member_id)
);

create table professor (
                           member_id bigint not null auto_increment,
                           bold_detail varchar(255),
                           detail varchar(255),
                           email varchar(255),
                           eng_name varchar(255),
                           name varchar(255) not null,
                           photo varchar(255),
                           primary key (member_id)
);

create table project (
                         project_id bigint not null auto_increment,
                         detail1 varchar(255),
                         detail2 varchar(255),
                         detail3 varchar(255),
                         detail4 varchar(255),
                         detail5 varchar(255),
                         eng_detail1 varchar(255),
                         eng_detail2 varchar(255),
                         eng_detail3 varchar(255),
                         eng_detail4 varchar(255),
                         eng_detail5 varchar(255),
                         eng_sub_topic varchar(255),
                         eng_topic varchar(255),
                         photo varchar(255),
                         sub_topic varchar(255),
                         topic varchar(255),
                         primary key (project_id)
);

create table publication (
                             pubilcation_id bigint not null auto_increment,
                             detail varchar(255),
                             filling_date date,
                             filling_no varchar(255),
                             granted_date date,
                             granted_no varchar(255),
                             inventor varchar(255),
                             link varchar(255),
                             progress varchar(255),
                             publication_type varchar(255),
                             topic varchar(255) not null,
                             primary key (pubilcation_id)
);

create table research_area (
                               research_area_id bigint not null auto_increment,
                               detail varchar(255),
                               eng_detail varchar(255),
                               eng_name varchar(255),
                               name varchar(255) not null,
                               photo varchar(255),
                               primary key (research_area_id)
);

create table research_equipment (
                                    research_equipment_id bigint not null auto_increment,
                                    eng_name varchar(255),
                                    name varchar(255) not null,
                                    photo varchar(255),
                                    primary key (research_equipment_id)
);

create table salt (
                      id integer not null,
                      salt varchar(255),
                      primary key (id)
);

alter table administrator
    add constraint UK_esogmqxeek1uwdyhxvubme3qf unique (username);

alter table administrator
    add constraint FKki6r2xv31hq1v9vj2m4ptbucd
        foreign key (salt_id)
            references salt (id);

select
    next_val as id_val
from
    hibernate_sequence for update;

update
    hibernate_sequence
set
    next_val=1;