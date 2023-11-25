package ru.novichikhin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.novichikhin.model.FilmSessionModel;
import ru.novichikhin.repositories.FilmRepository;
import ru.novichikhin.repositories.FilmSessionRepository;
import ru.novichikhin.repositories.HallRepository;
import ru.novichikhin.repositories.TicketRepository;
import ru.novichikhin.services.PopularityService;

@Controller
@RequiredArgsConstructor
public class PopularityController {
    private final PopularityService popularityService;

    @GetMapping("/popularity")
    public String getPopularity(ModelMap model) {
        model.addAttribute("films", popularityService.getPopularityFilms());

        return "popularity";
    }
}
