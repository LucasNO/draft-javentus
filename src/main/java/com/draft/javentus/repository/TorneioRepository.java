package com.draft.javentus.repository;

import com.draft.javentus.model.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Integer>{
    
}
