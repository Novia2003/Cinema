package ru.novichikhin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novichikhin.model.FilmModel;
import ru.novichikhin.model.FilmSessionModel;

import java.util.List;

public interface FilmSessionRepository extends JpaRepository<FilmSessionModel, Long> {
    List<FilmSessionModel> findAllByFilmById(FilmModel filmModel);
}
