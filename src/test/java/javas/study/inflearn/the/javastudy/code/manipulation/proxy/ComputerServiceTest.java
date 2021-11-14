package javas.study.inflearn.the.javastudy.code.manipulation.proxy;

import javas.study.inflearn.the.javastudy.code.manipulation.reflection.di.BookService;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.junit.jupiter.api.Assertions.*;

class ComputerServiceTest {
    ComputerService computerService = (ComputerService) Proxy.newProxyInstance(ComputerService.class.getClassLoader(), new Class[]{ComputerService.class},
            new InvocationHandler() {
                /**
                 *
                 * @param proxy -> 생성된 프록시 객체
                 * @param method -> 실행할 메소드
                 * @param args -> 인자값
                 *
                 *             리플렉션 기반 다이나믹 프록시 생성
                 *             프록시에서 참조하는 실제 객체가 반드시 있어야 한다.
                 * @return
                 * @throws Throwable
                 */

                ComputerService computerService = new DefaultComputerService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("code")) {
                        System.out.println("aaa");
                        Object invoke = method.invoke(computerService, args);
                        System.out.println("bbbb");
                        return invoke;
                    }

                    return method.invoke(computerService, args);
                }
            });

    @Test
    @DisplayName("다이나믹 프록시 - 자바 다이나믹 프록시 기술 사용")
    public void test() {
        computerService.code();
    }


    /**
     * 자바의 프록시 생성은 인터페이스만 가능하다.
     * 그렇기 때문에 외부 라이브러리를 사용해 클래스 기반 프록시 객체를 생성 할 수 있다.
     */


    @Test
    @DisplayName("다이나믹 프록시 - 외부 라이브러리 cglib 사용")
    public void dynamicProxy() {

        MethodInterceptor handler = new MethodInterceptor() {

            ComputerServiceClass computerServiceClass = new ComputerServiceClass();
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("this is");
                Object invoke = method.invoke(computerServiceClass, args);
                System.out.println("library");
                return invoke;
            }
        };

        ComputerServiceClass computerServiceClass = (ComputerServiceClass) Enhancer.create(ComputerServiceClass.class, handler);
        computerServiceClass.code();
    }


    @Test
    @DisplayName("다이나믹 프록시 - 외부 라이브러리 bytebuddy 사용")
    public void dynamicProxy2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<? extends ComputerServiceClass> proxyClass = new ByteBuddy().subclass(ComputerServiceClass.class)
                .method(named("code")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    ComputerServiceClass computerServiceClass = new ComputerServiceClass();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("asdfasdfasdfasdf");
                        Object invoke = method.invoke(computerServiceClass, args);
                        System.out.println("asdfadgggwdgasdg");
                        return invoke;
                    }
                }))
                .make().load(ComputerServiceClass.class.getClassLoader())
                .getLoaded();


        ComputerServiceClass computerServiceClass = proxyClass.getConstructor(null).newInstance();


        proxyClass.getConstructor(null).newInstance().code();
    }

}