package ru.novichikhin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.novichikhin.model.FilmModel;
import ru.novichikhin.repositories.FilmRepository;

@Controller
@RequiredArgsConstructor
public class FilmController {
    private final FilmRepository filmRepository;

    @GetMapping("/film")
    public String getAllFilms(ModelMap model) {
        model.addAttribute("films", filmRepository.findAll());
        return "film";
    }

    @GetMapping("/film/delete/{id}")
    public String deleteFilm(@PathVariable("id") long filmId) {
        filmRepository.deleteById(filmId);
        return "redirect:/film";
    }

    @PostMapping("/film/save")
    public String saveFilm(@ModelAttribute("film") FilmModel filmModel) {
        filmRepository.save(filmModel);
        return "redirect:/film";
    }

    @GetMapping("/film/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        FilmModel filmModel = filmRepository.findById(id).orElse(new FilmModel());
        model.addAttribute("film", filmModel);
        return "update_film";
    }

    @PostMapping("/film")
    public ModelAndView addNewFilm(@RequestParam String name, @RequestParam int ageRestriction,
                                   @RequestParam int duration, @RequestParam String genre) {
        FilmModel filmModel = new FilmModel();
        filmModel.setFilmName(name);
        filmModel.setAgeRestriction(ageRestriction);
        filmModel.setDuration(duration);
        filmModel.setGenre(genre);

        if(filmRepository.findByFilmName(name) == null)
            filmRepository.save(filmModel);

        return new ModelAndView("redirect:/film");
    }
}
