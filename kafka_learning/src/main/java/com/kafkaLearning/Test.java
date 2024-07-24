package com.kafkaLearning;

public class Test implements  Runnable{


    @Override
    public void run() {
        System.out.println("Hhhhh");
        synchronized (Test.class){
            for(int i=0;i<5;i++){
                System.out.println("I > "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static void main(String[] args)throws Exception {
        Test t=new Test();
        Thread thrd=new Thread(t);
        System.out.println(thrd.getName());
        thrd.setPriority(1);
        thrd.start();

        Thread thrd2=new Thread(t);
        thrd2.setPriority(5);
        System.out.println(thrd2.getName());
        thrd2.start();

    }
}
