package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.UserRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.UserResponseDto;
import tech.reliab.course.zaiko.bank.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/users")
public class UserController {

    private static final String REDIRECT_USER_LIST = "redirect:/banklab/users";
    private static final String REDIRECT_USER_ITEM = "redirect:/banklab/users/{id}";
    private final UserService userService;

    @PostMapping({"", "/"})
    public String postUser(@ModelAttribute("userRequestDto") UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
        return REDIRECT_USER_LIST;
    }

    @GetMapping({"", "/"})
    public String getUsers(Model model, @ModelAttribute("userRequestDto") UserRequestDto userRequestDto) {
        model.addAttribute("userResponseDtos", userService.getAll());
        return "user/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("userResponseDto", userService.getById(id));
        return "user/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putUser(@PathVariable("id") Long id,
                          @ModelAttribute("userResponseDto") UserResponseDto userResponseDto) {
        userService.update(userResponseDto);
        return REDIRECT_USER_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return REDIRECT_USER_LIST;
    }
}
