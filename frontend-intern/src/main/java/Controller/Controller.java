package Controller;


import org.springframework.web.bind.annotation.GetMapping;

public class Controller {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}