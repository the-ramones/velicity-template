package sp.service;

import java.util.List;
import sp.model.Report;

/**
 *
 * @author the-ramones
 */
public interface ReportService {

    public Report addReport(Report report);

    public List<Report> getReports(String performer);

    public Report getReportById(Long id);
}
