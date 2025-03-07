package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Thread firstThread = new Thread(new IncrementThread());
        Thread secondThread = new Thread(new DecrementThread());
        logger.setLevel(Level.INFO);

        firstThread.start();

        System.out.println("First Thread Counting Up to 20:");

        try {
            firstThread.join();
            System.out.println("Counting Up Thread Successful");
            System.out.println();
            System.out.println("Second Thread Counting Down to 0:");
            secondThread.start();
        } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Main Thread Error", e);
        }

        try {
            secondThread.join();
            System.out.println("Counting Down Thread Successful");
        }
        catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Main Thread Error", e);
        }

        System.out.println("Both Successful");
    }
}

class IncrementThread implements Runnable {
    private static final Logger logger = Logger.getLogger(IncrementThread.class.getName());

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Counting Up Thread Error", e);
            }
        }
    }
}

class DecrementThread implements Runnable {
    private static final Logger logger = Logger.getLogger(DecrementThread.class.getName());

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
