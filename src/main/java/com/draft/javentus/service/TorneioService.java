package com.draft.javentus.service;

import com.draft.javentus.model.Torneio;
import com.draft.javentus.repository.TorneioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class TorneioService {
    
    @Autowired
    private TorneioRepository torneioRepository;
    
    public List<Torneio> findAll(){
        return torneioRepository.findAll();
    }
    
    public Torneio findOne(Integer id){
        return torneioRepository.findOne(id);
    }
    
    public Torneio save(Torneio torneio){
        return torneioRepository.save(torneio);
    }
    
    public Torneio update(Torneio torneio){
        return torneioRepository.saveAndFlush(torneio);
    }
    
    public void delete(Integer id) {
        torneioRepository.delete(id);
    }
}
