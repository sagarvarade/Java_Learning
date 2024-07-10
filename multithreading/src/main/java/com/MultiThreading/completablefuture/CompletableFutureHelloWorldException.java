package com.MultiThreading.completablefuture;

import com.MultiThreading.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

import static com.MultiThreading.util.CommonUtil.*;
import static com.MultiThreading.util.LoggerUtil.log;

public class CompletableFutureHelloWorldException {

    private HelloWorldService hws;

    public CompletableFutureHelloWorldException(HelloWorldService hws) {
        this.hws = hws;
    }


    public String helloworld_3_async_calls_handle(){
        startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->hws.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->hws.world());
        CompletableFuture<String> hiCompletableFuture =  CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });

        String hw= hello // hello
                .handle((res, e) -> {
                    log("res is :" + res);
                    if(e!=null){
                        log("Exception is :" + e.getMessage());
                        return "";
                    }else{
                        return res;
                    }

                })
                .thenCombine(world, (h, w) -> h+w) // "hello world!"
                .handle((res, e) -> {
                    log("res is :" + res);
                    if(e!=null){
                        log("Exception after world is :" + e.getMessage());
                        return "";
                    }else{
                        return res;
                    }
                })
                .thenCombine(hiCompletableFuture, (previous,current)->previous+current)
                //   "hello world! Hi CompletableFuture!"
                .thenApply(String::toUpperCase) // "HELLO WORLD! HI COMPLETABLEFUTURE!"
                .join(); // "HELLO WORLD! HI COMPLETABLEFUTURE!"

        timeTaken();
        return hw;
    }

    public String helloworld_3_async_calls_exceptionally(){
        startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->hws.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->hws.world());
        CompletableFuture<String> hiCompletableFuture =  CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });

        String hw= hello // hello
                .exceptionally((e) -> {
                        log("Exception is :" + e.getMessage());
                        return "";
                })
                .thenCombine(world, (h, w) -> h+w) // "h-> ""
                .exceptionally((e) -> {
                    log("Exception after world is :" + e.getMessage());
                    return "";
                })
                .thenCombine(hiCompletableFuture, (previous,current)->previous+current)
                //   " Hi CompletableFuture!"
                .thenApply(String::toUpperCase) // " HI COMPLETABLEFUTURE!"
                .join(); // " HI COMPLETABLEFUTURE!"

        timeTaken();
        return hw;
    }

    public String helloworld_3_async_calls_whenhandle(){
        startTimer();

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->hws.hello());
        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->hws.world());
        CompletableFuture<String> hiCompletableFuture =  CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });

        String hw= hello // hello
                .whenComplete((res, e) -> {
                    log("res is :" + res);
                    if(e!=null){
                        log("Exception is :" + e.getMessage());
                    }
                })
                .thenCombine(world, (h, w) -> h+w) // "hello world!"
                .whenComplete((res, e) -> {
                    log("res is :" + res);
                    if(e!=null){
                        log("Exception after world is :" + e.getMessage());
                    }
                })
                .exceptionally((e) -> {
                    log("Exception after thenCombine is :" + e.getMessage());
                    return "";
                })
                .thenCombine(hiCompletableFuture, (previous,current)->previous+current)
                //   " Hi CompletableFuture!"
                .thenApply(String::toUpperCase) // " HI COMPLETABLEFUTURE!"
                .join(); // " HI COMPLETABLEFUTURE!"

        timeTaken();
        return hw;
    }
}
