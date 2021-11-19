package javas.study.inflearn.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureApiStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 기본적인 completable future 인스턴스 생성
        CompletableFuture<String> future = new CompletableFuture<>();

        future.complete("sehyeong");

        System.out.println(future.get());

        // Factory Method 를 이용해서 생성할 수 있음.
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("sehyeong");
        System.out.println(future1.get());

        // return 이 없는 경우 runAsync 를 통해 설정 가능
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 2 run async " + Thread.currentThread().getName());
        });

        System.out.println("////////////////////");
        System.out.println("//////10초 딜레이/////");
        System.out.println("////////////////////");
        future2.get();


        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> {
            System.out.println("future 5 run async " + Thread.currentThread().getName());
        });

        // 리턴 타입이 있는 경우 supplyAsync 를 사용한다.
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is future with supply async - " + Thread.currentThread().getName());
            return "supply async";
        });

        System.out.println("good");
//        System.out.println(future3.get());

        System.out.println("------------------------------------------------------");

        // thenApply() 등의 call back method 를 통해서 async
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("here is supply async - " + Thread.currentThread().getName());
            return "supply async call back value";
        }).thenApply((String s) -> {
            System.out.println("here is call back method - " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println("before get the value, it ain't happen anything!! - " + Thread.currentThread().getName());

        System.out.println(future4.get());


        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////////////////////");


        // 비동기 작업 2개 연결하기

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            String s = "this is cf1 ";
            System.out.println(s + Thread.currentThread().getName());
            return s;
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()-> {
            String s = "this is cf2 ";
            System.out.println(s + Thread.currentThread().getName());
            return s;
        });

        CompletableFuture<String> future6 = cf1.thenCombine(cf2, (s1, s2) -> s1 + " " + s2);
        System.out.println(future6.get());


        System.out.println("************************************");
        System.out.println("************************************");

        // allOf() / anyOf()
        CompletableFuture<String> future7 = CompletableFuture.allOf(cf1, cf2)
                .thenApply((v) -> {
                    return "end";
                });

        System.out.println(future7.get());


    }
}
