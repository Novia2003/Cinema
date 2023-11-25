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
import ru.novichikhin.model.TicketModel;
import ru.novichikhin.repositories.*;

@Controller
@RequiredArgsConstructor
public class TicketController {
    private final FilmSessionRepository filmSessionRepository;
    private final TicketRepository ticketRepository;
    private final ClientRepository clientRepository;

    @GetMapping("/ticket")
    public String getAllTickets(ModelMap model) {
        model.addAttribute("ticket", new TicketModel());
        model.addAttribute("tickets", ticketRepository.findAll());
        model.addAttribute("filmsSessions", filmSessionRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        return "ticket";
    }

    @GetMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable("id") long idTicket) {
        ticketRepository.deleteById(idTicket);
        return "redirect:/ticket";
    }

    @PostMapping("/ticket/save")
    public String saveTicket(@ModelAttribute("ticket") TicketModel ticket) {
        ticketRepository.save(ticket);
        return "redirect:/ticket";
    }

    @GetMapping("/ticket/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        TicketModel ticket = ticketRepository.findById(id).orElse(new TicketModel());
        model.addAttribute("ticket", ticket);
        model.addAttribute("filmsSessions", filmSessionRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        return "update_ticket";
    }

    @PostMapping("/ticket")
    public ModelAndView addNewTicket(@ModelAttribute("ticket") TicketModel ticket) {
        ticketRepository.save(ticket);

        return new ModelAndView("redirect:/ticket");
    }
}
