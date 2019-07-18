package com.ljy.JavaThread0008;

import com.ljy.JavaThread0008.ConCurrentThread.*;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Reader;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ljy
 * @create 2019-07-08
 * @desc 线程
 */
public class ThreadMain {
    private static Object object1=new Object();
    private static Object object2=new Object();
    private static final ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock(true);
    private static String message="a";
    private static AtomicReference<String> atomicReference;

    public static void main(String[] args) {
        // region 多线程
//        Multi multi=new Multi();
//        multi.start();
//
//        MultiRunnable multiRunnable=new MultiRunnable();
//        Thread thread=new Thread(multiRunnable);
//        thread.start();
//        thread.start();
//
//        TestSleepThread testSleepThread1=new TestSleepThread();
//        TestSleepThread testSleepThread2=new TestSleepThread();
//        testSleepThread1.start();
//        testSleepThread2.start();

//        每个线程在一个单独的调用堆栈中启动。
//        从主线程调用run()方法，run()方法进入当前调用堆栈而不是新调用堆栈的开头
//        TestSleepThread testSleepThread1=new TestSleepThread();
//        TestSleepThread testSleepThread2=new TestSleepThread();
//        testSleepThread1.run();
//        testSleepThread2.run();

//        join()方法等待线程死亡。 换句话说，它会导致当前运行的线程停止执行，直到它加入的线程完成其任务

//        System.out.println(Thread.currentThread().isDaemon());
//        TestJoinThread joinThread1 = new TestJoinThread();
//        TestJoinThread joinThread2 = new TestJoinThread();
//        TestJoinThread joinThread3 = new TestJoinThread();
//        joinThread1.setPriority(Thread.MIN_PRIORITY);
//        joinThread2.setPriority(Thread.MAX_PRIORITY);
//        joinThread3.setPriority(Thread.NORM_PRIORITY);
//
//        joinThread1.setDaemon(true);
//        joinThread1.start();
////        joinThread1.setDaemon(true); //启动线程 用户线程再设置守护线程时报错，主线程停止，用户线程继续执行完
//        try {
//            joinThread1.join(500);
//            joinThread1.setName("joinThread");
//            System.out.println(joinThread1.isDaemon());
//        } catch (Exception ex) {
//            System.out.print(ex);
//        }
//        joinThread2.start();
//        joinThread3.start();

        // 线程池
//        ExecutorService executorService=Executors.newFixedThreadPool(5);
//        for(int i=0;i<=10;i++){
//            Runnable work=new WorkerThread(String.valueOf(i));
//            executorService.execute(work);
//        }
//        executorService.shutdown();
//        while (!executorService.isTerminated()){}
//        System.out.println("Finished all threads");


        //线程组
//        TestThreadGroup testThreadGroup=new TestThreadGroup();
//        ThreadGroup group=new ThreadGroup("Parent ThreadGroup");
//        Thread t1=new Thread(group,testThreadGroup,"one");
//        t1.start();
//        Thread t2=new Thread(group,testThreadGroup,"two");
//        t2.start();
//        Thread t3=new Thread(group,testThreadGroup,"three");
//        t3.start();
//        System.out.println("Thread Group Name:"+group.getName());
//        group.list();

        //线程挂钩
//        Runtime r=Runtime.getRuntime();
////        r.addShutdownHook(new TestSleepThread());
//        // 匿名类
//        r.addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                System.out.println("Shut Down hoot task completed");
//            }
//        });
//        System.out.println("Now main sleeping ...press ctrl c to exit");
//        try{
//            Thread.sleep(3000);
//
//        }catch (Exception ex){}

        // 垃圾收集器
//        TestGarbage t1=new TestGarbage();
//        TestGarbage t2=new TestGarbage();
//        t1=null;
//        t2=null;
//        System.gc();

        //runtime
//        try {
//            Runtime.getRuntime().exec("notepad");
//
//        }catch (Exception ex){
//
//        }
        //endregion

        // region 并发
        //实现runnable
//        RunnableDemo R1 = new RunnableDemo("thread1");
//        R1.start();
//
//        RunnableDemo R2 = new RunnableDemo("thread2");
//        R2.start();
//
//        try {
//            R1.suspend();
//            System.out.println("Suspending First Thread");
//            Thread.sleep(500);
//            R1.resume();
//            System.out.println("Resuming First Thread");
//
//            R2.suspend();
//            System.out.println("Suspending thread Two");
//            Thread.sleep(500);
//            R2.resume();
//            System.out.println("Resuming thread Two");
//        } catch (InterruptedException e) {
//            System.out.println("Main thread Interrupted");
//        }
//        try {
//            System.out.println("Waiting for threads to finish.");
//            R1.t.join();
//            R2.t.join();
//        } catch (InterruptedException e) {
//            System.out.println("Main thread Interrupted");
//        }
//        System.out.println("Main thread exiting.");

        //继承extends
//        ThreadDemo R1=new ThreadDemo("thread1");
//        R1.start();
//
//        ThreadDemo R2=new ThreadDemo("thread2");
//        R2.start();

        //线程间通信
//        Chat m=new Chat();
//        new QuestionRunnable(m);
//        new AnswerRunnable(m);


        //线程同步
//        PrintDemo printDemo=new PrintDemo();
//        ThreadPrint threadPrint=new ThreadPrint("thread-1",printDemo);
//        ThreadPrint threadPrint1=new ThreadPrint("thread-2",printDemo);
//
//        threadPrint.start();
//        threadPrint1.start();

        //同步死锁
//        ThreadDemo1 demo1=new ThreadDemo1();
//        ThreadDemo2 demo2=new ThreadDemo2();
//
//        demo1.start();
//        demo2.start();

        //ThreadLocal
//        ThreadLocalRunnable runnable=new ThreadLocalRunnable();
//
//        Thread t1=new Thread(runnable);
//        Thread t2=new Thread(runnable);
//        Thread t3=new Thread(runnable);
//        Thread t4=new Thread(runnable);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        //Lock 加锁 解锁
//        LockPrintDemo printDemo=new LockPrintDemo();
//        LockThread thread1=new LockThread("Thread-1",printDemo);
//        LockThread thread2=new LockThread("Thread-2",printDemo);
//        LockThread thread3=new LockThread("Thread-3",printDemo);
//        LockThread thread4=new LockThread("Thread-4",printDemo);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();

        //ThreadLocalRandom
//        System.out.println("Random Integer: " + new Random().nextInt());
//        System.out.println("Seeded Random Integer: " + new Random(15).nextInt());
//        System.out.println("Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());
//        final ThreadLocalRandom random = ThreadLocalRandom.current();
//        random.setSeed(15);  //exception will come as seeding is not allowed in ThreadLocalRandom.
//        System.out.println( "Seeded Thread Local Random Integer: " + random.nextInt());

        // ReadWriteLock
//        try{
//            Thread t1 = new Thread(new WriterDemoA());
//            t1.setName("Writer A");
//            Thread t2 = new Thread(new WriterDemoB());
//            t2.setName("Writer B");
//            Thread t3 = new Thread(new ReaderDemo());
//            t3.setName("Reader");
//            t1.start();
//            t2.start();
//            t3.start();
//            t1.join();
//            t2.join();
//            t3.join();
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        //Condition
//        try {
//            ItemQueue itemQueue = new ItemQueue(10);
//            Thread producer = new Producer(itemQueue);
//            Thread consumer = new Consumer(itemQueue);
//
//            producer.start();
//            consumer.start();
//
//            producer.join();
//            consumer.join();
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        //AtomicLong
//        try {
//            final AtomicLongCounter counter = new AtomicLongCounter();
//            for (int i = 0; i < 1000; i++) {
//                new Thread(new Runnable() {
//                    public void run() {
//                        counter.increament();
//                    }
//                }).start();
//            }
//            Thread.sleep(6000);
//            System.out.println("Final number (should be 1000): " + counter.value());
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        //AtomicLong compare Long
//        long start=System.currentTimeMillis();
//        AtomicIntegerCompareTest test=new AtomicIntegerCompareTest(0);
//        for(int i=0;i<10000000;i++){
//            test.increase();
//        }
//        long end=System.currentTimeMillis();
//        System.out.println("time elapse:"+(end-start));
//
//        long start2=System.currentTimeMillis();
//        AtomicInteger atomicInteger=new AtomicInteger(0);
//        for(int i=0;i<10000000;i++){
//            atomicInteger.incrementAndGet();
//        }
//        long end2=System.currentTimeMillis();
//        System.out.println("time elapse:"+(end2-start2));

        //AtomicBoolean
//        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
//        new Thread("Thread 1") {
//            public void run() {
//                while(true){
//                    System.out.println(Thread.currentThread().getName()
//                            +" Waiting for Thread 2 to set Atomic variable to true. Current value is "
//                            + atomicBoolean.get());
//                    if(atomicBoolean.compareAndSet(true, false)) {
//                        System.out.println("Done!");
//                        break;
//                    }
//                }};
//        }.start();
//
//        new Thread("Thread 2") {
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ", Atomic Variable: " +atomicBoolean.get());
//                System.out.println(Thread.currentThread().getName() +" is setting the variable to true ");
//                atomicBoolean.set(true);
//                System.out.println(Thread.currentThread().getName() + ", Atomic Variable: " +atomicBoolean.get());
//            };
//        }.start();

        //AtomicReference
//        try {
//            atomicReference = new AtomicReference<String>(message);
//            new Thread("Thread-1") {
//                @Override
//                public void run() {
//                    atomicReference.compareAndSet(message, "Thread 1");
//                    message = message.concat(" - Thread 1 ");
//                }
//            }.start();
//            Thread.sleep(50);
//            System.out.println("Message is :" + message);
//            System.out.println("Atomic Reference of Message is:" + atomicReference.get());
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        //AtomicIntegerArray
//        try {
//            for (int i = 0; i < atomicIntegerArray.length(); i++) {
//                atomicIntegerArray.set(i, 1);
//            }
//
//            Thread t1 = new Thread(new Increment());
//            Thread t2 = new Thread(new compare());
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
//
//            System.out.println("Values: ");
//            for (int i=0; i<atomicIntegerArray.length(); i++) {
//                System.out.print(atomicIntegerArray.get(i) + " ");
//            }
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

        //Executor
//        Executor executor=Executors.newCachedThreadPool();
//        executor.execute(new Task());
//        ThreadPoolExecutor poolExecutor=(ThreadPoolExecutor)executor;
//        poolExecutor.shutdown();

        //ExecutorService
//        ExecutorService service=Executors.newSingleThreadExecutor();
//        try{
//            service.submit(new Task());
//            System.out.println("Shut down executor service");
//            service.shutdown();
//            service.awaitTermination(5,TimeUnit.SECONDS);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }finally {
//            if(!service.isTerminated()){
//                System.err.println("cancel non-finished taskes");
//            }
//            service.shutdownNow();
//            System.out.println("shutdown  finished");
//        }

        // https://www.yiibai.com/java_concurrency/concurrency_scheduledexecutorservice.html
        //endregion


    }

    private static class Task implements Runnable{
        public void run() {
            try{
                long duration=(long)(Math.random()*20);
                System.out.println("Running task!");
                TimeUnit.SECONDS.sleep(duration);
//                System.out.println("Task completed");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }


    private static AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(10);
    private static class Increment implements Runnable{
        public void run() {
            for(int i=0;i<atomicIntegerArray.length();i++){
                int add=atomicIntegerArray.incrementAndGet(i);
                System.out.println("Thread "+Thread.currentThread().getId()+",index "+i+",value:"+add);
            }
        }
    }
    private static class compare implements Runnable{
        public void run() {
            for(int i=0;i<atomicIntegerArray.length();i++){
                boolean swapped=atomicIntegerArray.compareAndSet(i,2,3);
                if(swapped){
                    System.out.println("Thread "+Thread.currentThread().getId()+",index "+i+",value:3");
                }
            }
        }
    }

    private static class AtomicIntegerCompareTest{
        private int value;

        public AtomicIntegerCompareTest(int value){
            this.value=value;
        }

        public synchronized int increase(){
            return value++;
        }
    }
    private static class AtomicLongCounter{
        private AtomicLong atomicLong=new AtomicLong(0);

        public void increament(){
            atomicLong.getAndIncrement();
        }

        public long value(){
            return atomicLong.get();
        }
    }

    private static class ReaderDemo implements Runnable{
        public void run() {
            if(readWriteLock.isWriteLocked()){
                System.out.println(" Write lock present");
            }

            readWriteLock.readLock().lock();

            try{
                Long duration=(long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()
                        +" Time Taken "+(duration/1000)+" seconds.");
                Thread.sleep(duration);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+": "+message);
                readWriteLock.readLock().unlock();
            }
        }
    }
    private static class WriterDemoA implements Runnable{
        public void run() {
            readWriteLock.writeLock().lock();
            try{
                Long duration=(long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()
                        +" Time Taken "+(duration/1000)+" seconds.");
                Thread.sleep(duration);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                message=message.concat("a");
                readWriteLock.writeLock().unlock();
            }
        }
    }
    private static class WriterDemoB implements Runnable{
        public void run() {
            readWriteLock.writeLock().lock();
            try{
                Long duration=(long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()
                        +" Time Taken "+(duration/1000)+" seconds.");
                Thread.sleep(duration);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                message=message.concat("b");
                readWriteLock.writeLock().unlock();
            }
        }
    }


    private static class ThreadDemo1 extends Thread{

        @Override
        public void run() {
            synchronized (object1){
                System.out.println("Thread 1 :holding lock 1...");

                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                }
                System.out.println("Thread 1 Waiting for lock 2...");

                synchronized (object2){
                    System.out.println("Thread 1 holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread{
        @Override
        public void run() {
            synchronized (object2){
                System.out.println("Thread 2:holding lock 2 ...");

                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                }
                System.out.println("Thread 2 wating for loca 1...");

                synchronized (object1){
                    System.out.println("Thread 2 holding lock  2 &1 ...");
                }
            }
        }
    }
}