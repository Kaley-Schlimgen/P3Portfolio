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
        secondThread.start();

        System.out.println("Counting Up:");

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Main thread error", e);
        }

        System.out.println("Counting Up Successful");
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
                logger.log(Level.WARNING, "Counting up thread error", e);
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
                logger.log(Level.WARNING, "Counting down thread error", e);
            }
        }
    }
}
/*
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

        System.out.println("Counting Down:");

        for (int i = 20; i >= 1; --i) {
            System.out.println(i);
        }
    } */
