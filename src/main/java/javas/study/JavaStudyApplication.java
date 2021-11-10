package javas.study;

import javas.study.inflearn.the.javastudy.code.manipulation.Group;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

@SpringBootApplication
public class JavaStudyApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JavaStudyApplication.class, args);

//		ClassLoader classLoader = JavaStudyApplication.class.getClassLoader();
//		TypePool typePool = TypePool.Default.of(classLoader);
//
//		new ByteBuddy().redefine(typePool.describe("javas.study.inflearn.the.javastudy.code.manipulation.Group").resolve(), ClassFileLocator.ForClassLoader.of(classLoader))
//				.method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
//				.make().saveIn(new File("/Users/ansehyeong/Project/private-project/java-study/build/classes/java/main"));

		System.out.println(new Group().pullOut());
	}

}
