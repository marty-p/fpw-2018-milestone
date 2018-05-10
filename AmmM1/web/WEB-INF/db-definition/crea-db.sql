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
	`id` serial primary key,
	`name` varchar(100),
	`surname` varchar(100),
	`username` varchar(16) not null,
	unique(`username`),
	`password` varchar(16),
	`category` enum('AUTHOR','READER','GUEST'),
	`birthDate` date,
	`introDesc` varchar(200),
	`imageUrl` varchar(100)
);

drop table if exists news;
create table news(
	`id` serial primary key,
	`title` varchar(100),
	`desc` varchar(600),
	`imageUrl` varchar(100),
	`imageDesc` varchar(200),
	`date` date,
	`category` set('POLITICA','CRONACA','ESTERI','ECONOMIA','SPORT','CULTURA'),
	`authorId` bigint unsigned/*,
	foreign key(`authorId`) references `users`(`id`)
		on update cascade
		on delete cascade*/
);

drop table if exists comments;
create table comments(
	`id` serial primary key,
	`newsId` bigint unsigned/*,
	foreign key(`newsId`) references `news`(`id`)
		on update cascade
		on delete cascade*/,
	`desc` varchar(200),
	`date` date,
	`authorId` bigint unsigned/*,
	foreign key(`authorId`) references `users`(`id`)
		on update cascade
		on delete cascade*/
);

INSERT INTO `users`(`id`, `name`, `surname`, `username`, `password`, `category`, `birthDate`, `introDesc`, `imageUrl`) VALUES (1, 'Pinco', 'Pallino', 'pp1', '111', 'AUTHOR', '2018/1/1', 'introducting myself 1', 'pics/icon1.png');
INSERT INTO `users`(`id`, `name`, `surname`, `username`, `password`, `category`, `birthDate`, `introDesc`, `imageUrl`) VALUES (2, 'Pinco', 'Pallone', 'pp2', '222', 'READER', '2018/2/2', 'introducting myself 2', 'pics/icon2.png');
INSERT INTO `users`(`id`, `name`, `surname`, `username`, `password`, `category`, `birthDate`, `introDesc`, `imageUrl`) VALUES (3, 'Pinco', 'Palloncino', 'pp3', '333', 'GUEST', '2018/3/3', 'introducting myself 3', 'pics/icon3.png');


INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (1, 'Autostrada A1 chiusa per neve', 'Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'pics/snowman.png', 'Pupazzi in autostrada', '2018/3/2', 'POLITICA,CRONACA', 1);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (2, 'title2', 'desc2', 'pics/snowman.png', 'imagedesc2', '2018/3/22', 'ESTERI', 1);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (3, 'title3', 'desc3', 'pics/snowman.png', 'imagedesc3', '2018/4/22', 'ESTERI', 1);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (4, 'I fantastici astici', '! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !', 'pics/snowman.png', 'imagedesc4', '2018/1/23', 'CRONACA', 1);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (5, 'I castori rosicanti', 'ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK ROSIK', 'pics/snowman.png', 'imagedesc5', '2018/2/25', 'CRONACA', 1);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (6, 'Holy moly', 'H O L Y M O L Y', 'pics/snowman.png', 'imagedesc6', '2018/3/27', 'CRONACA', 1);

INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (7, 'Tangenziale CC chiusa per palle', 'LE PALLE CI STANNO INVADENDO', 'pics/palleintangenziale.png', 'Palle in tangenziale', '2018/4/3', 'SPORT', 2);
INSERT INTO `news`(`id`, `title`, `desc`, `imageUrl`, `imageDesc`, `date`, `category`, `authorId`) VALUES (8, 'Festa delle feste annunciata', 'GONNA PARTY HARD', 'pics/partyhard.png', 'Party Hard', '2018/5/4', 'CULTURA', 3);


