package br.com.franca.repository;

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
}
