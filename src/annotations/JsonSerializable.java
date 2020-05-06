package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * this annotation has runtime visibility, and it will be apply to types (classes, enums, interfaces, etc).
 * In addition, it has no methods, and thus serves as a simple marker to mark classes that can be serialized into JSON.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonSerializable {

}
