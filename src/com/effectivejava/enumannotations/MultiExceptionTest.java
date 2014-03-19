/**
 * Demo for "35 Prefer annotations to naming patterns".
 */
package com.effectivejava.enumannotations;

import java.lang.annotation.*;

/**
 * @author Kaibo Annotation type with an array parameter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultiExceptionTest {
	Class<? extends Exception>[] value();
}
