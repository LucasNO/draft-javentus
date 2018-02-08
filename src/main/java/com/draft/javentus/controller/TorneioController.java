package com.draft.javentus.controller;

import com.draft.javentus.model.Torneio;
import com.draft.javentus.service.TimeService;
import com.draft.javentus.service.TipoTorneioService;
import com.draft.javentus.service.TorneioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
public class TorneioController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private TipoTorneioService tipoTorneioService;

    @Autowired
    private TorneioService torneioService;

    @RequestMapping(value = "/admin/torneio", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/torneio");
        modelAndView.addObject("tipoTorneio", tipoTorneioService.findAll());
        if (torneioService.verificarTorneioAtivo()) {
            modelAndView.addObject("torneio", torneioService.carregarTorneioAtivo());
        } else {
            modelAndView.addObject("torneio", new Torneio());
        }
        torneioService.gerarConfrontosTorneio(tipoTorneioService.findOne(2));
        return modelAndView;
    }

    @PostMapping("/admin/torneio/save")
    public ModelAndView save(@Valid Torneio torneio, BindingResult result) {
        if (result.hasErrors()) {
            return home();
        }
        if (torneio.getId() != null) {
            torneioService.update(torneio);
        } else {
            torneioService.gerarConfrontosTorneio(torneio.getTto());
            torneio.setAtivo(Boolean.TRUE);
            torneioService.save(torneio);
        }
        return home();
    }
}
