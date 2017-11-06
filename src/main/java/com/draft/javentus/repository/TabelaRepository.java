package com.draft.javentus.repository;

import com.draft.javentus.model.Tabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface TabelaRepository extends JpaRepository<Tabela, Integer>{
    
}
