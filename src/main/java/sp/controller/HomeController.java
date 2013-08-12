package sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHome(Model model) {
        return "home";
    }
}
