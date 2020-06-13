USE db_curso;

CREATE TABLE IF NOT EXISTS `db_curso`.`tb_contrato` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `TURMA_ID` BIGINT NOT NULL,
  `ALUNO_ID` BIGINT NOT NULL,
  `TX_MATRI` DECIMAL(7,2) NOT NULL COMMENT 'taxa de matrícula',
  `VLR_CURSO` DECIMAL(7,2) NOT NULL COMMENT 'valor do curso',
  `DESC_CURSO` DECIMAL(7,2) NOT NULL COMMENT 'desconto obtIDo no valor do curso',
  `VLR_MATE` DECIMAL(7,2) NOT NULL,
  `FORMA_PG` VARCHAR(20) NOT NULL,
  `DIA_VENC` TINYINT NOT NULL,
  `DT_MATRI` DATE NOT NULL,
  `SIT_MATRIC` VARCHAR(20) NOT NULL,
  `MATRICULA` VARCHAR(11) NOT NULL,
  INDEX `FK_tb_turma_ALUNO_tb_aluno_IDX` (`ALUNO_ID` ASC) ,
  INDEX `FK_tb_turma_ALUNO_tb_turma_IDX` (`TURMA_ID` ASC) ,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `TURMA_ID_ALUNO_ID_UK` (`ALUNO_ID` ASC, `TURMA_ID` ASC) COMMENT 'O ALUNO pode se repetir desde que seja em TURMAs diferentes',
  UNIQUE INDEX `MATRICULA_UK` (`MATRICULA` ASC) ,
  CONSTRAINT `FK_TB_TURMA_ALUNO_TB_TURMA`
    FOREIGN KEY (`TURMA_ID`)
    REFERENCES `db_curso`.`tb_turma` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TB_TURMA_TB_ALUNO_TB_ALUNO`
    FOREIGN KEY (`ALUNO_ID`)
    REFERENCES `db_curso`.`tb_aluno` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;