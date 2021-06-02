alter table position_list add column toDoList_id integer;
alter table position_list add constraint position_fk0 foreign key (toDoList_id) references list(id);