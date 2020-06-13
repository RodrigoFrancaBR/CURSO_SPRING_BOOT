USE db_curso;

CREATE TABLE IF NOT EXISTS `tb_user_permission` (
  `ID_USER` BIGINT(20) NOT NULL,
  `ID_PERMISSION` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID_USER`,`ID_PERMISSION`),
  KEY `FK_USER_PERMISSION_PERMISSION` (`ID_PERMISSION`),
  CONSTRAINT `FK_USER_PERMISSION` FOREIGN KEY (`ID_USER`) REFERENCES `tb_users` (`ID`),
  CONSTRAINT `FK_USER_PERMISSION_PERMISSION` FOREIGN KEY (`ID_PERMISSION`) REFERENCES `tb_permission` (`ID`)
)

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `tb_user_permission` (`ID_USER`, `ID_PERMISSION`) VALUES
	(1, 1),
	(2, 1),
	(1, 2);	