package ru.novichikhin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novichikhin.model.HallModel;

public interface HallRepository extends JpaRepository<HallModel, Long> {
}
