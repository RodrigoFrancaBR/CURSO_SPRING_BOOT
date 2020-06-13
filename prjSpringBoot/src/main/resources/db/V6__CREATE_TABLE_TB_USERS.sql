USE db_curso;

CREATE TABLE  IF NOT EXISTS `tb_users` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` VARCHAR(255) DEFAULT NULL,
  `FULL_NAME` VARCHAR(255) DEFAULT NULL,
  `PASSWORD` VARCHAR(255) DEFAULT NULL,
  `ACCOUNT_NON_EXPIRED` BIT(1) DEFAULT NULL,
  `ACCOUNT_NON_LOCKED` BIT(1) DEFAULT NULL,
  `CREDENTIALS_NON_EXPIRED` BIT(1) DEFAULT NULL,
  `ENABLED` BIT(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_USER_NAME` (`USER_NAME`)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `tb_users` (`USER_NAME`, `FULL_NAME`, `PASSWORD`, `ACCOUNT_NON_EXPIRED`,
  `ACCOUNT_NON_LOCKED`, `CREDENTIALS_NON_EXPIRED`, `ENABLED`) VALUES
  ('leandro', 'Leandro Costa', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', b'1',
    b'1', b'1', b'1'),
  ('flavio', 'Flavio Costa', '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', b'1',
    b'1', b'1', b'1');
