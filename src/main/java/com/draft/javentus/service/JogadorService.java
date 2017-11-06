package com.draft.javentus.service;

import com.draft.javentus.model.Jogador;
import com.draft.javentus.model.Time;
import com.draft.javentus.repository.JogadorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class JogadorService {
    
    @Autowired
    private JogadorRepository jogadorRepository;
    
    public List<Jogador> findAll(){
        return jogadorRepository.findAll();
    }
    
    public Jogador findOne(Integer id){
        return jogadorRepository.findOne(id);
    }
    
    public Jogador save(Jogador jogador){
        return jogadorRepository.saveAndFlush(jogador);
    }
    
    public void delete(Integer id) {
        jogadorRepository.delete(id);
    }
    
    public List<Jogador> carregarFreeAgents(){
        return jogadorRepository.carregarFreeAgents();
    }
    
    public void contratarJogador(Time t, Integer idJogador){
        Jogador j = findOne(idJogador);
        j.setTim(t);
        save(j);
    }
    
    public void dispensarJogador(Integer idJogador){
        Jogador j = findOne(idJogador);
        j.setTim(null);
        save(j);
    }
}
