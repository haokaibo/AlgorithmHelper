/**
 * Demo for "35 Prefer annotations to naming patterns".
 */
package com.effectivejava.enumAnnotations;

import java.lang.annotation.*;

/**
 * @author Kaibo 
 * Indicates that the annotated method is a test method. Use only on parameterless static methods.
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}