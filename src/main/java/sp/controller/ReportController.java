package sp.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import sp.service.ReportService;

/**
 *
 * @author the-ramones
 */
@Controller
public class ReportController {
    
    @Inject
    private ReportService reportService;
    
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }
}
