package ua.goit.hw8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.hw8.model.dto.ProducerDto;
import ua.goit.hw8.service.ProducerService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService service;

    @GetMapping("/findById")
    private ModelAndView findById(@RequestParam(name="producerId", required = false,
            defaultValue = "123e4567-e89b-12d3-a456-426614174000") String id) {
        ModelAndView result = new ModelAndView("producers/findById");
        result.addObject("producer", service.findById(UUID.fromString(id)));
        return result;
    }

    @GetMapping("/findAll")
    private ModelAndView findAll(){
        ModelAndView result = new ModelAndView("/producers/findAll");
        List<ProducerDto> producers = service.findAll();
        result.addObject("producers", producers);
        return result;
    }


    @GetMapping("/create")
    private ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("/producers/createForm");
        ProducerDto producerDto = new ProducerDto();
        result.addObject("producerDto", producerDto);
        return result;
    }


    @GetMapping("/update")
    private ModelAndView getUpdateForm() {
        ModelAndView result = new ModelAndView("/producers/updateForm");
        ProducerDto producerDto = new ProducerDto();
        result.addObject("producerDto", producerDto);
        return result;

    }


    @PostMapping("/save")
    private ModelAndView save(@Validated @ModelAttribute("producer") ProducerDto producer){
        service.save(producer);
        return findAll();
    }


    @GetMapping("/delete")
    private RedirectView delete(@RequestParam("id") String id) {
        service.deleteById(UUID.fromString(id));
        return new RedirectView("/producer/findAll");
    }

}
