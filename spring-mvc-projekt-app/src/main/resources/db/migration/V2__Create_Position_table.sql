create table position_list (
    id INTEGER NOT NULL auto_increment,
    title VARCHAR(255),
    description VARCHAR(255),
    created DATE,
    modified DATE,
    PRIMARY KEY (id)

) engine=InnoDB;