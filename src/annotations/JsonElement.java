package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation declares one String parameter with the name “key” and an empty string as the default value.
 *
 * When creating custom annotations with methods, we should be aware that these methods must have no parameters,
 * and cannot throw an exception. Also, the return types are restricted to primitives, String, Class, enums, annotations,
 * and arrays of these types, and the default value cannot be null.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonElement {
    public String key() default "";
}
