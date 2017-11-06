package com.draft.javentus.service;

import com.draft.javentus.model.Posicao;
import com.draft.javentus.repository.PosicaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class PosicaoService {
    
    @Autowired
    private PosicaoRepository posicaoRepository;
    
    public List<Posicao> findAll(){
        return posicaoRepository.findAll();
    }
    
    public Posicao findOne(Integer id){
        return posicaoRepository.findOne(id);
    }
    
    public Posicao save(Posicao posicao){
        return posicaoRepository.save(posicao);
    }
    
    public Posicao update(Posicao posicao){
        return posicaoRepository.saveAndFlush(posicao);
    }
    
    public void delete(Integer id) {
        posicaoRepository.delete(id);
    }
}
