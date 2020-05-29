package br.com.franca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
