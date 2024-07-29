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
        String x="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Email Template</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Hello, sagar_varade!</h1>\n" +
                "\t<p>Sneha Patel</p>\n" +
                "\t<p>sneha.patel@example.com</p>\n" +
                "\t<p>9876543213</p>\n" +
                "\t<p>1993-04-04 05:30:00.0</p>\n" +
                "\t<p>Female</p>\n" +
                "</body>\n" +
                "</html>\n";
        System.out.println(x.getBytes());

    }
}
