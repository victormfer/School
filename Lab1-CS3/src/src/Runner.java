/*
* Author: Victor Fernandez
* Prof: Diego Aguirre
* Last Edit: 9/8/17
* Lab 1*/

import java.util.Scanner;

public class Runner {
    public static void main(String[] Args) {

        System.out.println("Select an operation");

        while (true) {
        System.out.println("\n1. Recursion Fibonacci");
        System.out.println("2. Loop Fibonacci");
        System.out.println("3. Linear Fibonacci");
        System.out.println("4. Create Sudoku Table");
        System.out.println("Select how to solve the sudoku");
        System.out.println("5. Naive Algorithm");
        System.out.println("6. Not-so-Naive Algorithm");
        System.out.println("7. Not-Naive Algorithm");

        int n = 0;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Fibo fibo = new Fibo();
        Sudo sudo = new Sudo();

        switch (choice) {
            case 1:
                System.out.println("\nChoose an index number:  ");
                n = scanner.nextInt();
                System.out.println("Result is: " + fibo.recursion(n) + " ");
                break;

            case 2:
                System.out.println("\nChoose an index number:  ");
                n = scanner.nextInt();
                System.out.println("Result is:  " + fibo.loop(n) + " ");
                break;

            case 3:
                System.out.println("\nChoose an index number:  ");
                n = scanner.nextInt();
                System.out.println("Result is: " + fibo.linear(n) + " ");
                break;

            case 4:
                System.out.println("\nPlease set a size for the table: ");
                n = scanner.nextInt();
                System.out.println("Sudoku Table: ");
                sudo.create(n);
                sudo.print();
                //System.out.println();
                break;

            case 5:
                /*sudo.create(n);
                sudo.print();
                System.out.println("Solving");
                sudo.naive(sudo.table);
                break;*/


            case 6:
               /* sudo.create(n);
                sudo.print();
                System.out.println("Solving");
                sudo.notSoNaive(sudo.table);
                break;*/

            case 7:
                n = scanner.nextInt();
                sudo.create(n);
                sudo.print();
                System.out.println("Solving");
                sudo.notNaive(sudo.table);
                break;

            default:
                System.out.println("\nError: Unvalid Option.");
                break;
        }

        }
    }
}
