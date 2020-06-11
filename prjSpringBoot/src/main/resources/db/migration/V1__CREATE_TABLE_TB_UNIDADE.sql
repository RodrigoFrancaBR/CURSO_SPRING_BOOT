CREATE TABLE IF NOT EXISTS `tb_unidade` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`NOME` VARCHAR(80) NOT NULL,
	`ENDERECO` VARCHAR(100) NOT NULL COMMENT 'Endereço não pode ser repetido.',
	`STATUS` VARCHAR(20) NOT NULL COMMENT 'DESATIVADA(0, "Desativada"), ATIVA(1, "Ativa"), INVALIDA(100, "Status inválido")',
	PRIMARY KEY (`ID`),
	UNIQUE INDEX `NOME_ENDERECO_UK` (`NOME` ASC, `ENDERECO` ASC) COMMENT 'O nome da unidade pode se repetir, desde que seja para endereços diferentes ex.\nNome Cascadura end quintão\nNome Cascadura end ana quintão'
	);