package com.learn.corejava.multiThread;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //extracted();
    	method2();
    }

	private static void method2() throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 42;
        });

        // Chain another task
        CompletableFuture<Integer> resultFuture = future.thenApply(result -> result * 2);

        // Do some other work while the task is running
        System.out.println("Doing other work...");

        // Get the result of the computation
        Integer result = resultFuture.get();
        System.out.println("Result: " + result);
	}

	private static void extracted() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            // Simulate long-running task
            Thread.sleep(1000);
            return 42;
        });
        
        
        Future<Integer> future2 = executor.submit(() -> {
            // Simulate long-running task
            Thread.sleep(5000);
            return 99;
        });
     // Do some other work while the task is running
        System.out.println("Doing other work...");
        
        
        Integer result = future.get(3,TimeUnit.SECONDS);
        System.out.println("Result: 11 " + result+"  ");
        
        
        
        // Get the result of the computation
        Integer result2 = future2.get(3,TimeUnit.SECONDS);
        System.out.println("Result:12 " + result2);

        executor.shutdown();
	}
}

