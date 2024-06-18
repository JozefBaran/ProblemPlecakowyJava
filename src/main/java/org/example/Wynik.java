package org.example;
import java.util.List;

public class Wynik {
    public List<Integer> numeryPrzedmiotow;
    public int sumWartosc;
    public int sumWaga;

    public Wynik(List<Integer> numeryPrzedmiotow, int sumWartosc, int sumWaga) {
        this.numeryPrzedmiotow = numeryPrzedmiotow;
        this.sumWartosc = sumWartosc;
        this.sumWaga = sumWaga;
    }

    @Override
    public String toString() {
        return "Kolejność przedmiotów: " + numeryPrzedmiotow +
                ", Całkowita wartość: " + sumWartosc +
                ", Całkowita waga: " + sumWaga;
    }
}

