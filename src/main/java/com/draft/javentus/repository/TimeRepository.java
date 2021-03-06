package com.draft.javentus.repository;

import com.draft.javentus.model.Time;
import com.draft.javentus.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeRepository extends JpaRepository<Time, Integer>{
    
    @Query("select tim from Time tim where tim.usr = :usuario")
    public Time carregarTimeUsuario(@Param("usuario") Usuario u);
    
    
}
