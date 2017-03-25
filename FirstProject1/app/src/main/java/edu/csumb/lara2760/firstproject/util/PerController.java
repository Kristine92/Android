package edu.csumb.lara2760.firstproject.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by andrade on 3/25/17.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerController {
}
