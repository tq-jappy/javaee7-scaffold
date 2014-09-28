create sequence todo_id_seq start with 1;

create table todo (
  id serial,
  title varchar(64),
  finished boolean,
  created_at timestamp
);
