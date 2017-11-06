package com.draft.javentus.repository;

import com.draft.javentus.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>{
    
}
