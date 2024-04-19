package br.com.erd.banklineapi.repositories;

import br.com.erd.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {

    @Query("SELECT c FROM Correntista c WHERE c.conta.numero = :id")
    Optional<Correntista> findByConta(long id);
}
