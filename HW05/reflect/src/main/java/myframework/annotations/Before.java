package myframework.annotations;

import java.lang.annotation.*;

/**
 * Created by anton on 22.11.17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface Before {

}