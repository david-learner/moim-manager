INSERT INTO moim_member(email, name, grade, nick_name, password) VALUES('learner@hard.com', '황러너', 'NORMAL','하드러너', '$2a$10$FziYi91Kc8cTGE8PlbLqOuexUC6sBEn.8PCgITs7ScRkToBCeJpl.');
INSERT INTO moim_member(email, name, grade, nick_name, password) VALUES('sysmuch@hard.com', '서마용', 'NORMAL','모닥불', '$2a$10$FziYi91Kc8cTGE8PlbLqOuexUC6sBEn.8PCgITs7ScRkToBCeJpl.');
INSERT INTO moim_member(email, name, grade, nick_name, password) VALUES('learner2@hard.com', '김다윗', 'NORMAL','소프트러너', '$2a$10$FziYi91Kc8cTGE8PlbLqOuexUC6sBEn.8PCgITs7ScRkToBCeJpl.');
INSERT INTO moim_member(email, name, grade, nick_name, password) VALUES('learner3@hard.com', '황요셉', 'NORMAL','믹스러너', '$2a$10$FziYi91Kc8cTGE8PlbLqOuexUC6sBEn.8PCgITs7ScRkToBCeJpl.');

INSERT INTO moim_group(category, connect_type, name, region, leader_id) VALUE('독서','offline','부경나비','부산광역시',1);
INSERT INTO moim_group(category, connect_type, name, region, leader_id) VALUE('독서','onoffline','바스락','서울특별시',2);
INSERT INTO moim_group(category, connect_type, name, region, leader_id) VALUE('신앙','offline','비저니어스','서울특별시',1);

INSERT INTO miom_member_opened_groups(user_id, groups_id) VALUES (1, 1);
INSERT INTO miom_member_opened_groups(user_id, groups_id) VALUES (2, 2);
INSERT INTO miom_member_opened_groups(user_id, groups_id) VALUES (3, 1);

-- INSERT INTO moim_group_joined_members(group_id, members_id) VALUE(1, 3);
-- INSERT INTO moim_group_joined_members(group_id, members_id) VALUE(1, 2);
-- INSERT INTO moim_group_join_waiting_members(group_id, members_id) VALUE(1, 4);

-- INSERT INTO assignment(writer_id, title, content, startdate, enddate) VALUES (1, '과제1 - WAS 조사', 'WAS의 종류를 조사하세요', '2019-02-27 10:01:00', '2019-02-28 11:11:00');