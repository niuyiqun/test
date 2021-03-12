# DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `age` int(11) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `perms` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;