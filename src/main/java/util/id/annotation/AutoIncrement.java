package util.id.annotation;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Gerardo Cortés <gerardo.cortes.o@gmail.com>
 * @version 1.0
 * @since 4/15/2014.
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface AutoIncrement
{
}
