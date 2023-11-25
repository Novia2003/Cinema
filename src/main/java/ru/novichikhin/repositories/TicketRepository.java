package ru.novichikhin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novichikhin.model.FilmSessionModel;
import ru.novichikhin.model.TicketModel;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketModel, Long> {
    int countBySessionById(FilmSessionModel sessionById);
}
