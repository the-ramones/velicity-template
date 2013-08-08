package sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller
 *
 * @author the-ramones
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String home(Model model) {
        return "home";
    }
}
