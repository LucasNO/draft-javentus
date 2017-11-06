package com.draft.javentus.service;

import com.draft.javentus.model.Time;
import com.draft.javentus.model.Usuario;
import com.draft.javentus.repository.TimeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time carregarTimeUsuario(Usuario u){
        return timeRepository.carregarTimeUsuario(u);
    }
    
    public List<Time> findAll(){
        return timeRepository.findAll();
    }
    
    public Time findOne(Integer id){
        return timeRepository.findOne(id);
    }
}
