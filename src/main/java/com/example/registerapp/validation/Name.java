package com.example.registerapp.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

@javax.validation.constraints.Pattern.List({ @Pattern(
    regexp = "(\"^[A-Z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$\")"
) })
@ReportAsSingleViolation
@Documented
@Constraint(
    validatedBy = {}
)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER,
    ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Name.List.class)
public @interface Name {

    String message() default "El apellido es invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        Name[] value();
    }
}
