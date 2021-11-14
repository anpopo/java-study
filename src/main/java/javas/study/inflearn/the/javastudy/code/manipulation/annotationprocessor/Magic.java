package javas.study.inflearn.the.javastudy.code.manipulation.annotationprocessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)  // Class, Interface , Enum
@Retention(RetentionPolicy.SOURCE) // source 레벨에서만 필요한 어노테이션
public @interface Magic {
}
