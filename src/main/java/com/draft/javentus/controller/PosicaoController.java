package com.draft.javentus.controller;

import com.draft.javentus.model.Posicao;
import com.draft.javentus.service.PosicaoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
public class PosicaoController {

    @Autowired
    private PosicaoService posicaoService;

    @GetMapping("/admin/posicao")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("admin/posicao");
        mv.addObject("posicoes", posicaoService.findAll());
        return mv;
    }

    @GetMapping("/admin/posicao/add")
    public ModelAndView add(Posicao posicao) {

        ModelAndView mv = new ModelAndView("admin/posicaoAdd");
        mv.addObject("posicao", posicao);

        return mv;
    }

    @GetMapping("/admin/posicao/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

        return add(posicaoService.findOne(id));
    }

    @GetMapping("/admin/posicao/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        posicaoService.delete(id);

        return findAll();
    }

    @PostMapping("/admin/posicao/save")
    public ModelAndView save(@Valid Posicao posicao, BindingResult result) {

        if (result.hasErrors()) {
            return add(posicao);
        }
        if (posicao.getId() == null) {
            posicaoService.save(posicao);
        } else {
            posicaoService.update(posicao);
        }

        return findAll();
    }
}
