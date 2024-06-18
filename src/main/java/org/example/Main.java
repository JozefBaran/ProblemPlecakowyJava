package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę przedmiotów: ");
        int n = scanner.nextInt();

        System.out.println("Podaj pojemność plecaka: ");
        int p = scanner.nextInt();

        System.out.println("Podaj wartość seedu: ");
        int seed = scanner.nextInt();

        Problem problem = new Problem(n, seed);
        System.out.println(problem.toString());

        Wynik wynik = problem.solve(p);
        System.out.println(wynik.toString());
    }
}
