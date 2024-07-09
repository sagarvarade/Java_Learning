package com.learn.corejava;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExecutionTime {
}

class ExecutionTimeHandler implements InvocationHandler {
	private final Object target;

	public ExecutionTimeHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(ExecutionTime.class)) {
			long startTime = System.currentTimeMillis();
			Object result = method.invoke(target, args);
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.println("Method '" + method.getName() + "' executed in " + duration + " milliseconds");
			return result;
		} else {
			return method.invoke(target, args);
		}
	}

	public static <T> T wrapWithExecutionTime(T target) {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new ExecutionTimeHandler(target));
	}
}

class MyClass {
	@ExecutionTime
	public void myMethod() {
		try {
			Thread.sleep(1000); // Simulating some task taking time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void anotherMethod() {
		// This method will not print execution time
	}
}

public class TimeExec {
	public static void main(String[] args) {
		MyClass obj = ExecutionTimeHandler.wrapWithExecutionTime(new MyClass());
		obj.myMethod(); // Execution time will be printed
		obj.anotherMethod(); // Execution time will not be printed
	}
}
