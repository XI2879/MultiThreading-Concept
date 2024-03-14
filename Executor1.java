package MultiThreading;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Executor1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Processor process = new Processor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->
                process.add());
        executorService.submit(()->
                process.sub());
        executorService.shutdown();

//       CompletableFuture<?> future = CompletableFuture.runAsync(() -> System.out.println(),executorService);
//       CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->  10,executorService).thenApply((i) -> i*i);
//       CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->  11,executorService)
//                .thenCombine(future1,(result1,result2)-> result1+result2);
//        System.out.println("hello");
//        System.out.println("hello");
//        System.out.println("hello");
//        System.out.println(future.get());
//        System.out.println(future1.get());
//        System.out.println(future2.get());
//        System.out.println("hello");



//        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
