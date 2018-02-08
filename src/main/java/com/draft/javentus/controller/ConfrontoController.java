package com.draft.javentus.controller;

import com.draft.javentus.model.Confronto;
import com.draft.javentus.service.ConfrontoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
public class ConfrontoController {

    @Autowired
    private ConfrontoService confrontoService;

    @GetMapping("/admin/confronto")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("admin/confronto");
        mv.addObject("confrontos", confrontoService.findAll());
        return mv;
    }

    @PostMapping("/admin/confronto/save")
    public ModelAndView save(@Valid Confronto confronto, BindingResult result) {

        if (result.hasErrors()) {
            return findAll();
        }
        
        return findAll();
    }
}
