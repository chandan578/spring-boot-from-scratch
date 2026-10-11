package com.example.aop.annotation;

import java.lang.annotation.*;

// Metadata of any annotations
@Target(ElementType.METHOD)   // this fix where u can use this TrackExectuionTime annotation, by default it uses everywhere
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 1500;
    String operation() default "";
}
