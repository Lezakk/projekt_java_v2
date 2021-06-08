alter table list add column user_id integer;
alter table list add constraint list_fk0 foreign key (user_id) references user(id);