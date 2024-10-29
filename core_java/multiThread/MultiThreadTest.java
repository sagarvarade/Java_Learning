package com.learn.corejava.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThreadTest {

	public class ThreadOne extends Thread {
		public void run() {
			System.out.println("Extend Running thread  : " + Thread.currentThread().getName());
		}
	}

	public class ThreadTwo implements Runnable {
		public void run() {
			System.out.println("Runnable Running thread  : " + Thread.currentThread().getName());
		}
	}

	public class ThreadCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			return "Thread Callabe run";
		}

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MultiThreadTest ml = new MultiThreadTest();
		ThreadOne tr = ml.new ThreadOne();
		Thread th = new Thread(tr);
		th.start();

		ThreadTwo tr2 = ml.new ThreadTwo();
		Thread th2 = new Thread(tr2);
		th2.start();

		Runnable rt = () -> {
			System.out.println("Lambda running !");
		};
		Thread th3 = new Thread(rt);
		th3.run();
		
		ThreadCallable tr4 = ml.new ThreadCallable();
		FutureTask<String> fl=new FutureTask<String>(tr4);
		
		Thread th4=new Thread(fl);
		th4.start();
		System.out.println(fl.get());
		
		
	}
}
