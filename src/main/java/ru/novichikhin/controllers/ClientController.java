package ru.novichikhin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.novichikhin.model.ClientModel;
import ru.novichikhin.repositories.ClientRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping("/client")
    public String getClients(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(name = "search", required = false) String search,
                               ModelMap model) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<ClientModel> clients;
        if (search != null) {
            clients = clientRepository.findClientsByNameContaining(search, pageRequest);
        } else {
            clients = clientRepository.findAll(pageRequest);
        }
        model.addAttribute("clients", clients.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("search", search);
        model.addAttribute("totalPages", clients.getTotalPages());
        return "client";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") long idClient) {
        clientRepository.deleteById(idClient);
        return "redirect:/client";
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute("client") ClientModel clientModel) {
        clientRepository.save(clientModel);
        return "redirect:/client";
    }

    @GetMapping("/client/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        ClientModel clientModel = clientRepository.findById(id).orElse(new ClientModel());
        model.addAttribute("client", clientModel);
        return "update_client";
    }

    @PostMapping("/client")
    public ModelAndView addNewClient(@RequestParam String name, @RequestParam Date birthdate) {
        ClientModel clientModel = new ClientModel();
        clientModel.setName(name);
        clientModel.setBirthdate(birthdate);

        if(clientRepository.findByName(name) == null)
            clientRepository.save(clientModel);

        return new ModelAndView("redirect:/client");
    }
}
