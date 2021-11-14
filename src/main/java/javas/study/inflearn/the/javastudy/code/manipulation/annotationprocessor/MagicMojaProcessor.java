package javas.study.inflearn.the.javastudy.code.manipulation.annotationprocessor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

public class MagicMojaProcessor extends AbstractProcessor {

    // 어떤 타입의 어노테이션을 처리할지 정의하는 메서드 오버라이드
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_11;
    }

    // annotation processor 는 round 로 처리한다.
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // true return 시 annotation process 가 처리된 것이기 때문에 다른 process 에서 처리하지 않는다.

        //Magic annotation 이 존재하는 element 들을 가지고 온다.
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);

        // processingEnv 는 AbstractProcessor 를 상속받으면 사용할 수 있다.
        for (Element element : elements) {
            Name elementName = element.getSimpleName();

            // annotation 에서 Target option 을 통해 설정할 수 있지만, Interface, Class Enum 등의 세세한 설정을 하지 못하기 때문에 한번더 valid
            if (element.getKind() != ElementKind.INTERFACE) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation can not be used on " + elementName);
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing " + elementName);
            }

            TypeElement typeElement = (TypeElement) element;
            ClassName className = ClassName.get(typeElement);

            // 코드상으로 메서드와 클래스를 생성해준다.
            MethodSpec pullOut = MethodSpec.methodBuilder("pullOut")
                    .addModifiers(Modifier.PUBLIC)
                    .returns(String.class)
                    .addStatement("return $S", "Rabbit!")
                    .build();

            TypeSpec magicMoja = TypeSpec.classBuilder("MagicMoja")
                    .addModifiers(Modifier.PUBLIC)
                    .addSuperinterface(className)
                    .addMethod(pullOut)
                    .build();
            /*
             * AutoService api 를 이용
             * - 원래는 resources 디렉토리 하위 META-INF.services 에 javax.annotation.processing.Processor 파일을 생성 후
             *   커스텀 Processor 의 FQCN 을 넣어주어야한다.
             * - clean build 후 다시 build 하여 컴파일 된 클래스 파일을 생성하고 참조한다
             *  - 번거로움이 있기 때문에 외부 라이브러리인 AutoService 를 이용할 수 있다.
             *
             * - intellij 에서 annotation processor 설정을 enable 하고
             * - resources 를 프로젝트 프로젝트 구조의 모듈의 리소스 기본경로로 설정한 후
             * - google 에서 진행하는 auto service 를 적용시켜주면
             * - 컴파일 시점에서 이미 참조할 수 있는 클래스 파일을 생성해 준다.
             */

            // 생성한 TpyeSpec 등록해 주어야 한다. - 외부 라이브러리 javapoet 사용
            Filer filer = processingEnv.getFiler();
            try {
                JavaFile.builder(className.packageName(), magicMoja)
                        .build()
                        .writeTo(filer);
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR " + e);
            }

        }
        return true;
    }
}
