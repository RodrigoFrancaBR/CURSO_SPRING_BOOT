USE db_curso;

CREATE TABLE IF NOT EXISTS `tb_unidade` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`NOME` VARCHAR(80) NOT NULL,
	`ENDERECO` VARCHAR(100) NOT NULL COMMENT 'Endereço não pode ser repetido.',
	`STATUS` VARCHAR(20) NOT NULL COMMENT 'DESATIVADA(0, "Desativada"), ATIVA(1, "Ativa"), INVALIDA(100, "Status inválido")',
	PRIMARY KEY (`ID`),
	UNIQUE INDEX `NOME_ENDERECO_UK` (`NOME` ASC, `ENDERECO` ASC) COMMENT 'O nome da unidade pode se repetir, desde que seja para endereços diferentes ex.\nNome Cascadura end quintão\nNome Cascadura end ana quintão'
	);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;


INSERT INTO `tb_unidade` (ID, NOME, ENDERECO, STATUS) VALUES 
	(1,'CASCADURA','RUA C 1','ATIVA'),
	(2,'MADUREIRA','RUA M 1','ATIVA'),
	(3,'OSWALDO CRUZ','RUA O 1','ATIVA'),
	(5,'MARECHAL HERMES','RUA M 2','ATIVA'),
	(6,'OLARIA','RUA O 2','ATIVA');
