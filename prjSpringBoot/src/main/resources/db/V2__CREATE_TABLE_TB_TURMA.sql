USE db_curso;

CREATE TABLE IF NOT EXISTS `tb_turma` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `UNIDADE_ID`BIGINT NOT NULL,
  `NOME` VARCHAR(80) NOT NULL,  
  `STATUS` VARCHAR(20) NOT NULL COMMENT 'DESATIVADA(0, "Desativada"), ATIVA(1, "Ativa"), INVALIDA(100, "Status inválido")', 
  PRIMARY KEY (`ID`),
  INDEX `FK_TB_TURMA_TB_UNIDADE_IDX` (`UNIDADE_ID` ASC),
    UNIQUE INDEX `NOME_UNIDADE_ID_UK`
        (`NOME` ASC, `UNIDADE_ID` ASC) COMMENT 'O nome da turma pode se repetir desde que seja para unidades diferentes\nex nome 1001 unidade_id 1\nnome 1001 unidade_id 2',
    CONSTRAINT `FK_TB_TURMA_TB_UNIDADE`
    FOREIGN KEY (`UNIDADE_ID`)
    REFERENCES `db_curso`.`tb_unidade` (`ID`)
    -- REFERENCES `DB_CURSO`.`tb_unidade` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `tb_turma` (ID, UNIDADE_ID, NOME, STATUS) VALUES 
(1,1,'1000','ATIVA'),
(2,1,'1001','ATIVA'),
(3,1,'1002','ATIVA'),
(4,1,'1003','ATIVA'),
(5,1,'1004','ATIVA'),
(6,1,'1005','ATIVA');