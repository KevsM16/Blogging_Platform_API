create table posts(

id bigint not null auto_increment,
title varchar(100) not null unique,
content varchar(200) not null unique,
category varchar(100) not null,
primary key(id)
);

create table posts_tags(
    post_id bigint not null,
    tag varchar(255) not null,
    primary key (post_id, tag),
    foreign key (post_id) references posts(id)
);
