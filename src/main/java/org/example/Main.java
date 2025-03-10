package org.example;

/*
 *
 * @author kaleyschlimgen
 * Programming 3: Portfolio Project
 *
 * Program:
 * Create a Java program that will exhibit concurrency concepts.
 * Create two threads that will act as counters.
 * The first thread counts up to 20.
 * After the first thread reaches 20, the second thread counts down to 0.
 *
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    //logger for thread safe synchronization
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //create threads for counting up and down
        Thread incrementThread = new Thread(new CountUp());
        Thread decrementThread = new Thread(new CountDown());
        //set severity level
        logger.setLevel(Level.INFO);

        //start increment thread
        incrementThread.start();

        System.out.println("Increment Thread Counting Up to 20:");

        try {
            incrementThread.join();
            System.out.println("Counting Up Thread Successful");
            System.out.println();
            System.out.println("Decrement Thread Counting Down to 0:");
            //start decrement thread
            decrementThread.start();
        } catch (InterruptedException e) {
                //catch errors
                logger.log(Level.SEVERE, "Main Thread Error", e);
        }

        try {
            decrementThread.join();
            System.out.println("Counting Down Thread Successful");
        }
        catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Main Thread Error", e);
        }

        System.out.println("Both Successful");
    }
}

//Runnable allows for concurrent execution of the counter
//class for increment counter
class CountUp implements Runnable {
    private static final Logger logger = Logger.getLogger(CountUp.class.getName());

    //first thread will count up to 20 and print each number
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
            try {
                //pause for 100 milliseconds between counts so they maintain order
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Counting Up Thread Error", e);
            }
        }
    }
}

class CountDown implements Runnable {
    private static final Logger logger = Logger.getLogger(CountDown.class.getName());

    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Counting Down Thread Error", e);
            }
        }
    }
}
