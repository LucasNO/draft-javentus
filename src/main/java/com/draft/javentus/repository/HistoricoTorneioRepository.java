package com.draft.javentus.repository;

import com.draft.javentus.model.HistoricoTorneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface HistoricoTorneioRepository extends JpaRepository<HistoricoTorneio, Integer>{
    
}
