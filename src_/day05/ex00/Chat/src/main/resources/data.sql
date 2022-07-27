insert into users (login, password) values
	('user_1', 'easy_pas_1'),
	('user_2', 'easy_pas_2'),
	('user_3', 'easy_pas_3'),
	('user_4', 'easy_pas_4'),
	('user_5', 'easy_pas_5');

insert into chatrooms (name, owner_id) values
	('room_1', 1),
	('room_2', 5),
	('room_3', 5),
	('room_4', 4),
	('room_5', 3);

insert into messages (sender_id, chatroom_id, content, date) values
	(1, 1, 'Text_1_1', '2022-07-08 04:00:00'),
	(5, 2, 'Text_2_1', '2022-07-09 14:00:00'),
	(5, 3, 'Text_3_1', '2022-07-10 05:00:00'),
	(4, 4, 'Text_4_1', '2022-07-11 04:50:00'),
	(3, 5, 'Text_5_1', '2022-07-12 14:00:00'),
	(2, 1, 'Text_1_2', '2022-07-13 09:00:00'),
	(1, 2, 'Text_2_2', '2022-07-14 10:00:00'),
	(2, 3, 'Text_3_2', '2022-07-15 12:00:00'),
	(3, 4, 'Text_4_2', '2022-07-16 22:00:00'),
	(5, 5, 'Text_5_2', '2022-07-17 13:00:00');
