package com.draft.javentus.repository;

import com.draft.javentus.model.TipoTorneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface TipoTorneioRepository extends JpaRepository<TipoTorneio, Integer>{
    
}
