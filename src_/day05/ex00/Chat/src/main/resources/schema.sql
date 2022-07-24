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
  creator_id bigint not null,
  constraint uk_chatrooms unique (name),
  constraint fk_chatrooms_creator_id foreign key (creator_id) references users(id)
);

create table messages
(
  id bigserial primary key,
  autor_id bigint not null,
  chatroom_id bigint not null,
  content varchar not null,
  constraint fk_messages_autor_id foreign key (autor_id) references users(id),
  constraint fk_messages_chatroom_id foreign key (chatroom_id) references chatrooms(id)
);