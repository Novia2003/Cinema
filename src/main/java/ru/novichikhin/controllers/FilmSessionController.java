package ru.novichikhin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.novichikhin.model.FilmSessionModel;
import ru.novichikhin.repositories.FilmRepository;
import ru.novichikhin.repositories.FilmSessionRepository;
import ru.novichikhin.repositories.HallRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FilmSessionController {
    private final FilmSessionRepository filmSessionRepository;
    private final FilmRepository filmRepository;
    private final HallRepository hallRepository;

    @GetMapping("/film_session")
    public String getAllFilmSessions(ModelMap model) {
        model.addAttribute("filmSession", new FilmSessionModel());
        model.addAttribute("filmSessions", filmSessionRepository.findAll());
        model.addAttribute("films", filmRepository.findAll());
        model.addAttribute("halls", hallRepository.findAll());
        return "film_session";
    }

    @GetMapping("/film_session/delete/{id}")
    public String deleteFilmSession(@PathVariable("id") long idSession) {
        filmSessionRepository.deleteById(idSession);
        return "redirect:/film_session";
    }

    @PostMapping("/film_session/save")
    public String saveFilmSession(@ModelAttribute("filmSession") FilmSessionModel filmSession) {
        filmSessionRepository.save(filmSession);
        return "redirect:/film_session";
    }

    @GetMapping("/film_session/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        FilmSessionModel filmSession = filmSessionRepository.findById(id).orElse(new FilmSessionModel());
        model.addAttribute("filmSession", filmSession);
        model.addAttribute("films", filmRepository.findAll());
        model.addAttribute("halls", hallRepository.findAll());
        return "update_film_session";
    }

    @PostMapping("/film_session")
    public ModelAndView addNewFilmSession(@ModelAttribute("filmSession") FilmSessionModel filmSession) {
        System.out.println(filmSession.getFilmById());

        filmSessionRepository.save(filmSession);

        return new ModelAndView("redirect:/film_session");
    }
}
