package sp.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;
import sp.model.Report;
import sp.repository.ReportRepository;

/**
 *
 * @author the-ramones
 */
public class ReportServiceImpl implements ReportService {

    @Inject
    private ReportRepository reportRepository;

    @Override
    @Transactional(readOnly = true)
    public Report addReport(Report report) {
        return reportRepository.saveReport(report);
    }

    @Override
    @Transactional
    public List<Report> getReports(String performer) {        
        return reportRepository.getReportsByPerformer(performer);
        
    }
}
