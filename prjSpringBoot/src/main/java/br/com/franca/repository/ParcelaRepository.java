package br.com.franca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.Parcela;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

}
