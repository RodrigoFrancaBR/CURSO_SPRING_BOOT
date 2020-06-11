CREATE TABLE IF NOT EXISTS `tb_turma` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`UNIDADE_ID`BIGINT NOT NULL,
	`NOME` VARCHAR(80) NOT NULL,	
	`STATUS` VARCHAR(20) NOT NULL COMMENT 'DESATIVADA(0, "Desativada"), ATIVA(1, "Ativa"), INVALIDA(100, "Status inválido")',	
	PRIMARY KEY (`ID`),
	INDEX `FK_tb_turma_tb_unidade_IDX` (`UNIDADE_ID` ASC),
  	UNIQUE INDEX `NOME_UNIDADE_ID_UK`
  			(`NOME` ASC, `UNIDADE_ID` ASC) COMMENT 'O nome da turma pode se repetir desde que seja para unidades diferentes\nex nome 1001 unidade_id 1\nnome 1001 unidade_id 2',
  	CONSTRAINT `FK_tb_turma_tb_unidade`
    FOREIGN KEY (`UNIDADE_ID`)
    REFERENCES `db_curso`.`tb_unidade` (`ID`)
    -- REFERENCES `DB_CURSO`.`tb_unidade` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);