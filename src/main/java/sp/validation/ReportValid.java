package sp.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Paul Kulitski
 */
@Documented
@Constraint(validatedBy = ReportValidValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportValid {

    String message() default "{sp.validation.ReportValid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}