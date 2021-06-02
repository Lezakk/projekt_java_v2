alter table position_list add column to_do_list_id integer;
alter table position_list add constraint position_fk0 foreign key (to_do_list_id) references list(id);