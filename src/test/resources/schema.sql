DROP TABLE IF EXISTS dummy;
CREATE TABLE dummy (
    id int(11) primary key auto_increment,
    value varchar(48),
    deleted int(1) default 0,
    deleted_at datetime
);