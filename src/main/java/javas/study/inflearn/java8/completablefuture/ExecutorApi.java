package javas.study.inflearn.java8.completablefuture;

import java.util.concurrent.*;

public class ExecutorApi {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(getTask("this is good"));

        executorService.shutdown();  // graceful shutdown - 처리중인 작업 기다렸다가 종료
        executorService.shutdownNow();  // 당장 종료

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();


        scheduledExecutorService.scheduleAtFixedRate(getTask("scheduled"), 1, 2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

    }

    private static Runnable getTask(String message) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(message + " " + Thread.currentThread().getName());
            }
        };
    }
}
