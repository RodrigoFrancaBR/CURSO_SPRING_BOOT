package br.com.franca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.franca.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
	@Modifying
	@Query("UPDATE Unidade u SET u.status = 'DESATIVADA' WHERE u.id =:id")
	void delete(@Param("id") Long id);
	
	@Query("SELECT u FROM Unidade u WHERE u.nome LIKE LOWER(CONCAT ('%', :nome, '%'))")
	Page<Unidade> findAllPageablePorNome(@Param("nome")String nome, Pageable pageable);
}