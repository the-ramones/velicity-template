package sp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sp.service.ReportService;

/**
 * Report CRUD operations controller
 *
 * @author the-ramones
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Inject    
    private ReportService reportService;
    
    @PostConstruct
    public void postConstruct() {
    }

    @PreDestroy
    public void preDestroy() {
    }

    @RequestMapping(value = {"","search"}, method = RequestMethod.GET)
    public String setupForm(Model model) {        
        model.addAttribute("performers", reportService.getPerformers());
        return "form";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String doSearch(Model model, 
            @ModelAttribute(value = "performer") 
            @RequestParam(value = "performer", defaultValue = "") String performer) {
        model.addAttribute("reports", reportService.getReports(performer));
        return "list";
    }

    @RequestMapping(value="detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("report", reportService.getReportById(id));
        return "detail";
    }
    
    @RequestMapping(value = "clear", method = RequestMethod.GET)
    public String clear(Model model) {
        //TODO: redirect to setupForm @requestMapping
        return "form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model) {
        return "add";
    }
}
