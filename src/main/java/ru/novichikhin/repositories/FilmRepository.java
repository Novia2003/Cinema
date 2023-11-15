package ru.novichikhin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novichikhin.model.FilmModel;

public interface FilmRepository extends JpaRepository<FilmModel, Long> {
    FilmModel findByFilmName(String filmName);
}
