create table role (
    id integer not null auto_increment,
    created datetime,
    modified datetime,
    name varchar(255),
    deleted datetime,
    primary key (id)
) engine=InnoDB;

create table user (
    id integer not null auto_increment,
    created datetime,
    modified datetime,
    email varchar(255),
    password varchar(255),
    deleted datetime,
    primary key (id)
) engine=InnoDB;

create table user_role (
    user_id integer,
    role_id integer,
    primary key (user_id, role_id)
) engine=InnoDB;

alter table user_role add constraint user_role_fk0 foreign key (user_id) references user (id);
alter table user_role add constraint user_role_fk1 foreign key (role_id) references role (id);

insert into role (created, modified, name)
values (now(), now(), "ROLE_USER");
insert into role (created, modified, name)
values (now(), now(), "ROLE_MODERATOR");
insert into role (created, modified, name)
values (now(), now(), "ROLE_ADMIN");