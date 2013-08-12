package sp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Paul Kulitski
 */
public class ReportValidValidator implements ConstraintValidator<ReportValid, sp.model.Report> {
    
    @Override
    public void initialize(ReportValid constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isValid(sp.model.Report value, ConstraintValidatorContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}