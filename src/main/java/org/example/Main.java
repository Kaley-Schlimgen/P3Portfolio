package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Counting Up:");

        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

        System.out.println("Counting Down:");

        for (int i = 20; i >= 1; --i) {
            System.out.println(i);
        }
    }
}