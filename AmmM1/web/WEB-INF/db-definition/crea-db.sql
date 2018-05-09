/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Marty
 * Created: 9-mag-2018
 */

drop table if exists users;
create table users(
	id serial primary key,
	name varchar(100),
	surname varchar(100),
	username varchar(16) not null,
	unique(username),
	password varchar(16),
	category enum('AUTHOR','READER','GUEST'),
	birthDate datetime,
	introDesc varchar(200),
	imageUrl varchar(100)
);

drop table if exists news;
create table news(
	id serial primary key,
	title varchar(100),
	`desc` varchar(200),
	imageUrl varchar(100),
	imageDesc varchar(200),
	`date` datetime,
	category set('POLITICA','CRONACA','ESTERI','ECONOMIA','SPORT','CULTURA'),
	authorId bigint unsigned,
	foreign key(authorId) references users(id)
		on update cascade
		on delete cascade
);

drop table if exists comments;
create table comments(
	id serial primary key,
	newsId bigint unsigned,
	foreign key(newsId) references news(id)
		on update cascade
		on delete cascade,
	`desc` varchar(200),
	`date` datetime,
	authorId bigint unsigned,
	foreign key(authorId) references users(id)
		on update cascade
		on delete cascade
);
