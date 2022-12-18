package ua.goit.hw8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.hw8.model.dto.UserDto;
import ua.goit.hw8.service.UserService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @GetMapping("/findById")
    private ModelAndView findById(@RequestParam(name="userId", required = false,
            defaultValue = "123e4567-e89b-12d3-a456-426614174000") String id) {
        ModelAndView result = new ModelAndView("users/findById");
        result.addObject("user", service.findById(UUID.fromString(id)));
        return result;
    }

    @GetMapping("/findAll")
    private ModelAndView findAll(){
        ModelAndView result = new ModelAndView("/users/findAll");
        List<UserDto> users = service.findAll();
        result.addObject("users", users);
        return result;
    }

    @GetMapping("/create")
    private ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("/users/createForm");
        UserDto userDto = new UserDto();
        result.addObject("userDto", userDto);
        return result;
    }

    @GetMapping("/update")
    private ModelAndView getUpdateForm() {
        ModelAndView result = new ModelAndView("/users/updateForm");
        UserDto userDto = new UserDto();
        result.addObject("userDto", userDto);
        return result;
    }

    @PostMapping("/save")
    private ModelAndView save(@Validated @ModelAttribute("user") UserDto user){
        service.save(user);
        return findAll();
    }

    @GetMapping("/delete")
    private RedirectView delete(@RequestParam("id") String id) {
        service.deleteById(UUID.fromString(id));
        return new RedirectView("/user/findAll");
    }
}
