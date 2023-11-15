package ru.novichikhin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.novichikhin.model.HallModel;
import ru.novichikhin.repositories.HallRepository;

@Controller
@RequiredArgsConstructor
public class HallController {
    private final HallRepository hallRepository;

    @GetMapping("/hall")
    public String getAllHalls(ModelMap model) {
        model.addAttribute("halls", hallRepository.findAll());
        return "hall";
    }

    @GetMapping("/hall/delete/{id}")
    public String deleteHall(@PathVariable("id") long hallNumber) {
        hallRepository.deleteById(hallNumber);
        return "redirect:/hall";
    }

    @PostMapping("/hall/save")
    public String saveHall(@ModelAttribute("hall") HallModel hallModel) {
        hallRepository.save(hallModel);
        return "redirect:/hall";
    }

    @GetMapping("/hall/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        HallModel hallModel = hallRepository.findById(id).orElse(new HallModel());
        model.addAttribute("hall", hallModel);
        return "update_hall";
    }

    @PostMapping("/hall")
    public ModelAndView addNewHall(@RequestParam int numberRows, @RequestParam int numberSeatsInRow) {
        HallModel hallModel = new HallModel();
        hallModel.setNumberRows(numberRows);
        hallModel.setNumberSeatsInRow(numberSeatsInRow);

        hallRepository.save(hallModel);

        return new ModelAndView("redirect:/hall");
    }
}
