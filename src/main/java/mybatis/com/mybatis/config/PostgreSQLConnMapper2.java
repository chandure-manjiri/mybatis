package mybatis.com.mybatis.config;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PostgreSQLConnMapper2 {
    String value() default "";
}
