package org.csystem.app.service.rest.competiton.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
@Documented
public @interface DataHelper {
}
