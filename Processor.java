package MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private List<Integer> list = new ArrayList<>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private int value = 0;
    private final Object lock = new Object();
    public void add(){
        synchronized (lock){
            while(true){
                if(list.size()==LIMIT){
                    System.out.println("waiting for remove");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    value++;
                    list.add(value);
                    System.out.println("added :"+ value);
                    lock.notify();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        }

    public void sub(){
        synchronized(lock){
            while(true){
                if(list.size()==BOTTOM){
                    System.out.println("waiting for adding");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    value--;
                    System.out.println("Removed :"+ list.remove(value));
                    lock.notify();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }

        }

    }


    }

