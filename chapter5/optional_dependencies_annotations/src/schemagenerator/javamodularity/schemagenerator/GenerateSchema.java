package javamodularity.schemagenerator;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
public @interface GenerateSchema {

}
