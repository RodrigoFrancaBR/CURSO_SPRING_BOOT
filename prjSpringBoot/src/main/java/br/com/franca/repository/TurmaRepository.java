package br.com.franca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
