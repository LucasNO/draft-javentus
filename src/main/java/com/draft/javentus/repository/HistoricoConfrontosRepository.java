package com.draft.javentus.repository;

import com.draft.javentus.model.HistoricoConfrontos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface HistoricoConfrontosRepository extends JpaRepository<HistoricoConfrontos, Integer>{
    
}
