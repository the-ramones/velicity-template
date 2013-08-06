package sp.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sp.model.Report;

/**
 *
 * @author the-ramones
 */
public class ReportRepositoryImpl implements ReportRepository {

    /*
     * Spring JPA injection, thread-safe? : yes
     * Although EntityManagerFactory instances are thread-safe, EntityManager 
     * instances are not. The injected JPA EntityManager behaves like an
     * EntityManager fetched from an application server's JNDI environment,
     * as defined by the JPA specification. It delegates all calls to the 
     * current transactional EntityManager, if any; otherwise, it falls back to
     * a newly created EntityManager per operation, in effect making its usage 
     * thread-safe. -- From Spring Reference
     * 
     * http://stackoverflow.com/questions/1310087/injecting-entitymanager-vs-entitymanagerfactory
     * 
     * "I think part of my problem is I am using
     * 
     * @PersistenceContext(unitName = "unit",
     * type = PersistenceContextType.EXTENDED)
     * 
     * If you use PersistenceContextType.EXTENDED, keep in mind you have to, if I 
     * understand correctly, manually close the transaction. See this thread for 
     * more information."
     * 
     * "I found that setting the @Repository Spring annotation on our DAOs and 
     * having EntityManager managed by Spring and injected by @PersistenceContext 
     * annotation is the most convenient way to get everything working fluently.
     * You benefit from the thread safety of the shared EntityManager and 
     * exception translation. By default, the shared EntityManager will manage 
     * transactions if you combine several DAOs from a manager for instance. 
     * In the end you'll find that your DAOs will become anemic."
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Report getReportById(Long id) {
        return entityManager.find(Report.class, id);
    }

    @Override
    public Report saveReport(Report report) {
        entityManager.persist(report);
        return report;
    }

    @Override
    public List<Report> getReportsByPerformer(String performer) {
        //TODO: insert implementation here
        return null;
    }
}
