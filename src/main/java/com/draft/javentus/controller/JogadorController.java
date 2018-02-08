package com.draft.javentus.controller;

import com.draft.javentus.model.Jogador;
import com.draft.javentus.model.Posicao;
import com.draft.javentus.model.Time;
import com.draft.javentus.model.Usuario;
import com.draft.javentus.service.JogadorService;
import com.draft.javentus.service.PosicaoService;
import com.draft.javentus.service.TimeService;
import com.draft.javentus.service.UserService;
import java.util.List;
import javax.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;
    @Autowired
    private PosicaoService posicaoService;
    @Autowired
    private UserService userService;
    @Autowired
    private TimeService timeService;

    @Getter
    @Setter
    List<Posicao> posList;

    @GetMapping("/admin/jogador")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("admin/jogador");
        mv.addObject("jogadores", jogadorService.findAll());
        return mv;
    }

    @GetMapping("/admin/freeAgents")
    public ModelAndView findAllFreeAgents() {
        ModelAndView mv = new ModelAndView("admin/freeAgents");
        mv.addObject("jogadores", jogadorService.carregarFreeAgents());
        return mv;
    }

    @GetMapping("/admin/jogador/add")
    public ModelAndView add(Jogador jogador) {

        posList = posicaoService.findAll();
        ModelAndView mv = new ModelAndView("admin/jogadorAdd");
        mv.addObject("jogador", jogador);
        mv.addObject("posicoes", posList);
        return mv;
    }

    @GetMapping("/admin/jogador/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {

        return add(jogadorService.findOne(id));
    }

    @GetMapping("/admin/jogador/contratarJogador/{id}")
    public ModelAndView contratarJogador(@PathVariable("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        Time t = timeService.carregarTimeUsuario(user);
        jogadorService.contratarJogador(t, id);
        return findAllFreeAgents();
    }

    @GetMapping("/admin/jogador/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        jogadorService.delete(id);

        return findAll();
    }

    @PostMapping("/admin/jogador/save")
    public ModelAndView save(@Valid Jogador jogador, BindingResult result) {

        if (result.hasErrors()) {
            return add(jogador);
        }

        jogadorService.save(jogador);

        return findAll();
    }
}
