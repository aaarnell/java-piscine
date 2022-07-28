create table users
(
  id bigserial primary key,
  login varchar not null,
  password varchar not null,
  constraint uk_users unique (login)
);
  
create table chatrooms
(
  id bigserial primary key,
  name varchar not null,
  owner_id int not null,
  constraint uk_chatrooms unique (name),
  constraint fk_chatrooms_owner_id foreign key (owner_id) references users(id)
);

create table messages
(
  id bigserial primary key,
  sender_id int not null,
  chatroom_id int not null,
  content varchar not null,
  date timestamp not null,
  constraint fk_messages_sender_id foreign key (sender_id) references users(id),
  constraint fk_messages_chatroom_id foreign key (chatroom_id) references chatrooms(id)
);