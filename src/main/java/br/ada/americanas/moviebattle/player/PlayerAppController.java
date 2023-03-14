package br.ada.americanas.moviebattle.player;

import br.ada.americanas.moviebattle.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/players")
public class PlayerAppController {

    private PlayerService service;

    @Autowired
    public PlayerAppController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("player", service.list());
        return "player/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        return "player/form";
    }

    @PostMapping
    public String save(@ModelAttribute Player player) {
        player.setScore(0.0f);
        service.add(player);
        return "redirect:/app/players";
    }

}