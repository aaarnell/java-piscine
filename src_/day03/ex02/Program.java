//package day03.ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

    public static void main(String[] args) throws Exception {
        if (args.length != 2)
            throw new Exception("Number of arguments greater than 1");

        int arraySize = 0;
        arraySize = Integer.parseInt(args[0].substring(12));

        int threadsCount = 0;
        threadsCount = Integer.parseInt(args[1].substring(15));

        List<Integer> randomInts = new ArrayList<>(arraySize);
        Set < Thread > threadhashmap = ConcurrentHashMap.newKeySet(threadsCount);

        for (int i = 0; i < arraySize; i++) {
            Thread t = new Thread(() -> {
                int randomNum;
                randomNum = ThreadLocalRandom.current().nextInt(0, 1000) ;
                randomInts.add(randomNum);
                System.out.println("A new random int generated : " + randomNum);
            });
            threadhashmap.add(t);
            t.start();
        }
        Iterator<Thread> iterator = threadhashmap.iterator();

        while (iterator.hasNext())
            iterator.next().join();

        int range = arraySize/threadsCount - 1;
        List<Thread> threads = new ArrayList<>(threadsCount);
        int rangeBeginIndex = 0;
        int rangeEndIndex = 0;

        for (int i = 0; i < threadsCount - 1; i++) {
            rangeBeginIndex = i * range;
            rangeEndIndex = (i + 1) * range;

            List<Integer> arrayForThread = randomInts.subList(rangeBeginIndex, rangeEndIndex);
            Thread tmp = new ThreadsController(arrayForThread, rangeBeginIndex, rangeEndIndex);
            tmp.setName("Thread " + (1 + i));
            threads.add(tmp);
        }

        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + ThreadsController.getTotal());
    }
}

class ThreadsController extends Thread {

    private static int total = 0;
    private final int rangeBeginIndex;
    private final int rangeEndIndex;
    private int sumOfThread = 0;

    public ThreadsController(List<Integer> data, int rangeBeginIndex, int rangeEndIndex) {
        this.rangeBeginIndex = rangeBeginIndex;
        this.rangeEndIndex = rangeEndIndex;
        for (int value : data) {
            sumOfThread += value;
        }
    }

    private static synchronized void sumOfThreads(int sumOfThread, int rangeBeginIndex, int rangeEndIndex) {
        System.out.println(
                Thread.currentThread().getName() + ": from " + rangeBeginIndex + " to " + (rangeEndIndex - 1) + " sum is " + sumOfThread);
        total += sumOfThread;
    }

    public static int getTotal() {
        return total;
    }

    public void run() {
        sumOfThreads(sumOfThread, rangeBeginIndex, rangeEndIndex);
    }
}