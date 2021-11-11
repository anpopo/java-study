package javas.study.inflearn.the.javastudy.code.manipulation.reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface MyAnnotation {
    // value 를 사용하면 네임드 파라미터를 사용하지 않아도 된다.
    String value() default "sehyeong";

    int number() default 100;
}
