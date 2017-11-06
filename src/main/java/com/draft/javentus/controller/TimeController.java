package com.draft.javentus.controller;

import com.draft.javentus.model.Jogador;
import com.draft.javentus.model.Time;
import com.draft.javentus.model.Usuario;
import com.draft.javentus.service.JogadorService;
import com.draft.javentus.service.TimeService;
import com.draft.javentus.service.UserService;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas
 */
@Controller
public class TimeController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private UserService userService;

    @Autowired
    JogadorService jogadorService;

    @Getter
    @Setter
    private List<Time> timesList;

    @Getter
    @Setter
    private HashMap<String, List<Jogador>> jogadoresList;

    public void init() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        Time t = timeService.carregarTimeUsuario(user);
        timesList = timeService.findAll();
        timesList.remove(t);
    }

    public HashMap<String, List<Jogador>> popularTimes(List<Time> timesList) {
        HashMap<String, List<Jogador>> mapa = new HashMap<>();
        for (Time t : timesList) {
            mapa.put(t.getNome(), t.getJogadorList());
        }
        return mapa;
    }

    @GetMapping("/admin/meuTime")
    public ModelAndView findJogadores() {
        ModelAndView mv = new ModelAndView("/admin/meuTime");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        Time t = timeService.carregarTimeUsuario(user);
        mv.addObject("jogadores", t.getJogadorList());
        return mv;
    }

    @GetMapping("/admin/outrosTimes")
    public ModelAndView findOutrosTimes() {
        ModelAndView mv = new ModelAndView("/admin/outrosTimes");
        init();
        jogadoresList = popularTimes(timesList);
        mv.addObject("jogadores",  jogadoresList);
        return mv;
    }

    @GetMapping("/admin/meuTime/dispensarJogador/{id}")
    public ModelAndView dispensarJogador(@PathVariable("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        Time t = timeService.carregarTimeUsuario(user);
        jogadorService.dispensarJogador(id);
        return findJogadores();
    }

    @GetMapping("/admin/meuTime/proproTransferencia/{id}")
    public ModelAndView outrosTimes(@PathVariable("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario user = userService.findUserByEmail(auth.getName());
        Time t = timeService.carregarTimeUsuario(user);
        jogadorService.dispensarJogador(id);
        return findJogadores();
    }
}
