package org.example;

public class DeadlockRunner {
    static final Object pen = new Object();
    static final Object notebook = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (pen){
                System.out.println("Holding a pen...");
                try {
                    Thread.sleep(500);
                }catch (Exception e){

                }
                synchronized (notebook){
                    System.out.println("Got a notebook!");
                }
            }
        });
        Thread t2 = new Thread(
                ()->{
                    synchronized (notebook){
                        System.out.println("Holding a notebook...");
                        try {
                            Thread.sleep(500);
                        }catch (Exception ignored){}
                        synchronized (pen){
                            System.out.println("Got a pen!");
                        }
                    }

                }
        );
        t1.start();
        t2.start();
    }
}
