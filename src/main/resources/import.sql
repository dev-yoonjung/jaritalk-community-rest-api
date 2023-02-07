INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit) VALUES (NOW(), NOW(), 'lessorA', 'LESSOR', '임차인A', false);
INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit, quit_date) VALUES (NOW(), NOW(), 'lessorB', 'LESSOR', '임차인B', true, NOW());
INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit) VALUES (NOW(), NOW(), 'realtorA', 'REALTOR', '공인중개사A',false);
INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit, quit_date) VALUES (NOW(), NOW(), 'realtorB', 'REALTOR', '공인중개사B', true, NOW());
INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit) VALUES (NOW(), NOW(), 'lesseeA', 'LESSEE', '임대인A', false);
INSERT INTO user (create_time, update_time, account_id, account_type, nickname, quit, quit_date) VALUES (NOW(), NOW(), 'lesseeB', 'LESSEE', '임대인B', true, NOW());