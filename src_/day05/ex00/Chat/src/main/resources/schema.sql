create table users
(
  id serial primary key,
  login varchar not null,
  password varchar not null,
  constraint uk_users unique (login)
);
  
create table chatrooms
(
  id serial primary key,
  name varchar not null,
  owner_id int not null,
  constraint uk_chatrooms unique (name),
  constraint fk_chatrooms_creator_id foreign key (owner_id) references users(id)
);

create table messages
(
  id serial primary key,
  sender_id int not null,
  chatroom_id int not null,
  content varchar not null,
  constraint fk_messages_autor_id foreign key (sender_id) references users(id),
  constraint fk_messages_chatroom_id foreign key (chatroom_id) references chatrooms(id)
);