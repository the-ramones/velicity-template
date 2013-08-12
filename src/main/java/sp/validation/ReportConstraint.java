package sp.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;

/**
 *
 * @author Paul Kulitski
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportConstraint {

    String message() default "{sp.validation.ReportConstraint}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}