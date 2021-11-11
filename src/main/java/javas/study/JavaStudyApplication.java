package javas.study;

import javas.study.inflearn.the.javastudy.code.manipulation.Group;
import javas.study.inflearn.the.javastudy.code.manipulation.reflection.Book;
import javas.study.inflearn.the.javastudy.code.manipulation.reflection.Car;
import javas.study.inflearn.the.javastudy.code.manipulation.reflection.MyBook;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;

import static net.bytebuddy.matcher.ElementMatchers.named;

@SpringBootApplication
public class JavaStudyApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		SpringApplication.run(JavaStudyApplication.class, args);

//		ClassLoader classLoader = JavaStudyApplication.class.getClassLoader();
//		TypePool typePool = TypePool.Default.of(classLoader);
//
//		new ByteBuddy().redefine(typePool.describe("javas.study.inflearn.the.javastudy.code.manipulation.Group").resolve(), ClassFileLocator.ForClassLoader.of(classLoader))
//				.method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
//				.make().saveIn(new File("/Users/ansehyeong/Project/private-project/java-study/build/classes/java/main"));

		System.out.println(new Group().pullOut());

		// 리플렉션을 위한 클래스 api에 접근하는 방법 3가지
		// 타입 기반 클래스 접근 - 클래스 이름.class
		Class<Book> bookClass = Book.class;

		// 인스턴스 기반 접근 - getClass();
		Book book = new Book();
		Class<? extends Book> aClass = book.getClass();

		// Full Qualified Class 으로 접근
		Class<?> aClass1 = Class.forName("javas.study.inflearn.the.javastudy.code.manipulation.reflection.Book");


		System.out.println("==========================================");

		// public 으로 선언된 필드값만 가지고 온다
		Arrays.stream(bookClass.getFields()).forEach(System.out::println);

		// 모든 필드 값을 가져온다
		Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

		System.out.println("==================필드값=======================");

		Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);
				System.out.printf("%s %s\n", f, f.get(book));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		System.out.println("=====================인터페이스====================");

		// 인터페이스 가져오기
		Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

		System.out.println("=====================슈퍼클래스 가져오기====================");

		System.out.println(MyBook.class.getSuperclass());

		System.out.println("=====================modifier 를 이용한 접근제한자 확====================");

		Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
			int modifiers = f.getModifiers();

			System.out.println(f);
			System.out.println(Modifier.isPublic(modifiers));
			System.out.println(Modifier.isStatic(modifiers));

		});

		System.out.println("===================== 어노테이션 조회 ====================");
		// @Inherited 속성때문에 상위 어노테이션까지 가지고 올 수 있다. 없으면 상위 어노테이션 조회 할 수 없음
		Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
		System.out.println();
		System.out.println("=================================================================================================================");
		System.out.println();
		System.out.println(">>> 리플렉션을 이용한 클래스 정보 수정");
		System.out.println();


		Class<Car> carClass = Car.class;
		// 새로운 인스턴스 생성하기 파라미터가 없는 생성자
		Constructor<Car> constructor = carClass.getConstructor(null);
		Car car = constructor.newInstance();
		System.out.println(car);

		// 파라미터가 있는 생성자
		Constructor<Car> constructor1 = carClass.getConstructor(String.class);
		Car car1 = constructor1.newInstance("myBook");
		System.out.println(car1);

		System.out.println("===========================================================");
		System.out.println();

		// 필드값 가져오기
		Field a = Car.class.getDeclaredField("A");
		System.out.println(a.get(null));
		a.set(null, "aaAAaaAA");
		System.out.println(a.get(null));

		System.out.println("===========================================================");

		// 특정 인스턴스 필드값 가져오기 / 수정하기
		Field b = Car.class.getDeclaredField("b");
		b.setAccessible(true);
		System.out.println(b.get(car));
		b.set(car, "BBBBBBB");
		System.out.println(b.get(car));


		System.out.println("===========================================================");
		// 파라미터가 없는 프라이빗 메소드 호출
		Method c = Car.class.getDeclaredMethod("c");
		c.setAccessible(true);
		c.invoke(car);
		System.out.println("===========================================================");
		// 파라미터가 있는 메소드 호출
		Method d = Car.class.getMethod("d", int.class, int.class);
		int invoke = (int) d.invoke(car, 1, 2);
		System.out.println(invoke);
	}

}
