USE staffgym;

CREATE TABLE `foro`
(
`id` int(10) NOT NULL auto_increment,
`autor` varchar(50) NOT NULL default '',
`titulo` varchar(100) NOT NULL default '',
`mensaje` text NOT NULL,
primary key (`id`)
);