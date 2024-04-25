package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("banklab")
public class MainPageController {


    @GetMapping({"", "/"})
    public String getMainPage() {
        return "main_page";
    }
}
