package com.draft.javentus.repository;

import com.draft.javentus.model.Titulos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface TitulosRepository extends JpaRepository<Titulos, Integer>{
    
    public List<Titulos> findByOrderByPrimeiroDescSegundoDescTerceiroDesc();
    
    
}
