package com.corejava.thread;

/**
 *
 * @author Ashutosh
 */
public class PrintNumbers implements Runnable{
    Object obj = new Object();
    static volatile int i = 1;

    @Override
    public void run() {
        while(i<=10){
            if(i%2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("Even")){
                synchronized(obj){
                    System.out.println(i);
                    i++;
                    try {
                        obj.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(i%2 == 1 && Thread.currentThread().getName().equalsIgnoreCase("Odd")){
                synchronized(obj){
                    System.out.println(i);
                    i++;
                    obj.notify();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();
        Thread odd = new Thread(pn);
        Thread even = new Thread(pn);
        odd.setName("Odd");
        even.setName("Even");
        
        odd.start();
        even.start();
    }
}
