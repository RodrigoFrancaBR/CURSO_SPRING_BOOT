package br.com.franca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
