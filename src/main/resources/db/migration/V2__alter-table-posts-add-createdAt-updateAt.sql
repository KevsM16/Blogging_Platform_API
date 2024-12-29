alter table posts
 add column created_at timestamp default current_timestamp,
 add column updated_at timestamp default current_timestamp on update current_timestamp;