package com.draft.javentus.controller;

import com.draft.javentus.model.Jogador;
import com.draft.javentus.service.JogadorService;
import com.draft.javentus.service.TransferenciaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author lucas
 */
@Controller
public class TransferenciaController {
    
    @Autowired
    private TransferenciaService transferenciaService;
    
    @Autowired
    private JogadorService jogadorService;
    
    @Getter
    @Setter
    private Jogador jogador;
    
    
    @GetMapping("/admin/tranferencia/jogador/{id}")
    public void edit(@PathVariable("id") Integer id) {

        jogador = jogadorService.findOne(id);
        
    }
}
