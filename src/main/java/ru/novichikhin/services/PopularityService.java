package ru.novichikhin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.novichikhin.model.FilmModel;
import ru.novichikhin.model.FilmSessionModel;
import ru.novichikhin.repositories.FilmRepository;
import ru.novichikhin.repositories.FilmSessionRepository;
import ru.novichikhin.repositories.TicketRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PopularityService {
    private final FilmSessionRepository filmSessionRepository;
    private final FilmRepository filmRepository;
    private final TicketRepository ticketRepository;

    public List<String[]> getPopularityFilms() {
        List<String[]> popularityFilms = new ArrayList<>();

        List<FilmModel> films = filmRepository.findAll();

        for (FilmModel film : films) {
            List<FilmSessionModel> filmSessions = filmSessionRepository.findAllByFilmById(film);
            int result = 0;

            for (FilmSessionModel filmSession : filmSessions) {
                result += ticketRepository.countBySessionById(filmSession);
            }
            popularityFilms.add(new String[]{film.getFilmName(), Integer.toString(result)});
        }

        popularityFilms.sort((a, b) -> b[1].compareTo(a[1]));

        return popularityFilms;
    }

}
