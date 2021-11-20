package javas.study.inflearn.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone());  // false
        System.out.println("Started!!");

        submit.get();  // blocking call

        System.out.println(submit.isDone());  // true
        System.out.println("End!!");


        System.out.println("=======================================================");

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };



        Callable<String> name = () -> {
            Thread.sleep(4000L);
            return "name";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, name));

        for (Future<String> f :futures) {
            System.out.println(f.get());
        }


        executorService.shutdown();
    }
}
