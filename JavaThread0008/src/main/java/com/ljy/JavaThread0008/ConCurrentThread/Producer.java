package com.ljy.JavaThread0008.ConCurrentThread;

public class Producer extends Thread {
    private final ItemQueue queue;
    public Producer(ItemQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        String[] numbers={"1","2","3","4","5","6","7","8","9","10","11","12"};
        try {
            for (String number:numbers){
                queue.add(number);
                System.out.println("[Producer]:"+number);
            }
            queue.add(null);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
