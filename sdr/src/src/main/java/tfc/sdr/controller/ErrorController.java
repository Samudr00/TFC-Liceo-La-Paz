package tfc.sdr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "error/access-denied";
    }
}
