package ru.novichikhin.repositories;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.novichikhin.model.ClientModel;
import ru.novichikhin.model.FilmModel;


import java.util.List;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    ClientModel findByName(String name);
    Page<ClientModel> findClientsByNameContaining(String searchTerm, PageRequest pageRequest);
}
