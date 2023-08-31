package com.ncstudy.config.interfaceConfig;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Documented
public @interface ServiceLock {
    String description() default "";
}
