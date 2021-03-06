USE db_curso;

CREATE TABLE IF NOT EXISTS `db_curso`.`tb_aluno` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(40) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL COMMENT '11111111111',
  `RG` VARCHAR(9) NOT NULL COMMENT '999999999',
  `ORG_EXP` VARCHAR(20) ,
  `UF_RG` VARCHAR(2) ,
  `DT_NASCI` DATE ,
  `SEXO` VARCHAR(20) NOT NULL,
  `CELULAR` VARCHAR(11) NOT NULL COMMENT '21988887777',
  `RESIDENCIAL` VARCHAR(10) NOT NULL COMMENT '2133332222',
  `EMAIL` VARCHAR(60) ,
  `CEP` VARCHAR(8) COMMENT '99999888',
  `ENDERECO` VARCHAR(60) NOT NULL,
  `BAIRRO` VARCHAR(30) NOT NULL,
  `CIDADE` VARCHAR(30) ,
  `ESTADO` VARCHAR(2) ,
  `PAI` VARCHAR(40) ,
  `MAE` VARCHAR(40) ,
  `SIT_ALUNO` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC),
  UNIQUE INDEX `RG_UNIQUE` (`RG` ASC));

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `db_curso`.`tb_aluno`(`ID`, `NOME`, `CPF`, `RG`, `ORG_EXP`, `UF_RG`, `DT_NASCI`, `SEXO`, `CELULAR`, `RESIDENCIAL`, `EMAIL`, `CEP`, `ENDERECO`, `BAIRRO`, `CIDADE`, `ESTADO`, `PAI`, `MAE`, `SIT_ALUNO`) VALUES ('1', 'ALUNO 1', '99988877761', '998887776', 'DETRAN', 'RJ', '1985-09-03', 'MASCULINO', '99877665544', '9988776655', 'ALUNO@GMAIL.COM', '99888777', 'RUA C1', 'CASCADURA', 'RIO DE JANEIRO', 'RJ', 'PAI DE ALUNO 2', 'MAE DE ALUNO 2', 'ATIVO');