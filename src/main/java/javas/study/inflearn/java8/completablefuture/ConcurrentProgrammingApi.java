package javas.study.inflearn.java8.completablefuture;

public class ConcurrentProgrammingApi {

    public static void main(String[] args) throws Exception{


        Thread thread = new Thread(() -> {
                System.out.println("Thread " + Thread.currentThread().getName());

                try {
                    Thread.sleep(7000L);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
        });

        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());

        thread.join();
        System.out.println(thread + " is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello " + Thread.currentThread().getName());
        }
    }
}
