CREATE TABLE `permissions` (
  `permissionId` int(11) NOT NULL,
  `permission` varchar(50) NOT NULL,
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles_permissions` (
  `roleId` int(11) NOT NULL,
  `permissionId` int(11) NOT NULL,
  CONSTRAINT `roles_permissions_roles_fk` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`),
  CONSTRAINT `roles_permissions_permissions_fk` FOREIGN KEY (`permissionId`) REFERENCES `permissions` (`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users_roles` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  CONSTRAINT `users_roles_roles_fk` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`),
  CONSTRAINT `users_roles_users_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` (`userId`, `userName`, `password`) VALUES (1, 'scott', 'scott');
INSERT INTO `users` (`userId`, `userName`, `password`) VALUES (2, 'test', 'test');

INSERT INTO `roles` (`roleId`, `role`) VALUES (1, 'admin');
INSERT INTO `roles` (`roleId`, `role`) VALUES (2, 'normal_user');

INSERT INTO `permissions` (`permissionId`, `permission`) VALUES (1, 'check');
INSERT INTO `permissions` (`permissionId`, `permission`) VALUES (2, 'modify');

INSERT INTO `users_roles` (`userId`, `roleId`) VALUES (1, 1);
INSERT INTO `users_roles` (`userId`, `roleId`) VALUES (2, 2);

INSERT INTO `roles_permissions` (`roleId`, `permissionId`) VALUES (1, 1);
INSERT INTO `roles_permissions` (`roleId`, `permissionId`) VALUES (1, 2);
INSERT INTO `roles_permissions` (`roleId`, `permissionId`) VALUES (2, 1);
