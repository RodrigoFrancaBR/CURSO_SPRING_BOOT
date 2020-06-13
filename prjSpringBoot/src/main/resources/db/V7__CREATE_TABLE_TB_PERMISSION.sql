USE db_curso;

CREATE TABLE IF NOT EXISTS `tb_permission` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `tb_permission` (`DESCRIPTION`) VALUES
	('ADMIN'),
	('MANAGER'),
	('COMMON_USER');
