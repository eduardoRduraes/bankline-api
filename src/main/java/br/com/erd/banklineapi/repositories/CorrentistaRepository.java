package br.com.erd.banklineapi.repositories;

import br.com.erd.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {
}
