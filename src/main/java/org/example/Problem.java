package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Problem {
    public int liczbaPrzedmiotow;
    public int lowerBound;
    public int upperBound;
    public List<Przedmioty> przedmioty;

    public Problem(int n, int seed) {
        liczbaPrzedmiotow = n;
        przedmioty = new ArrayList<>();
        lowerBound = 1;
        upperBound = 10;
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            int wartosc = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int waga = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            przedmioty.add(new Przedmioty(wartosc, waga));
        }
    }

    @Override
    public String toString() {
        StringBuilder wynik = new StringBuilder();
        for (Przedmioty przedmiot : przedmioty) {
            wynik.append("Wartość: ").append(przedmiot.wartosc).append(", Waga: ").append(przedmiot.waga).append("\n");
        }
        return wynik.toString();
    }

    public Wynik solve(int pojemnosc) {
        List<Przedmioty> posortowanePrzedmioty = new ArrayList<>(przedmioty);
        Collections.sort(posortowanePrzedmioty, (p1, p2) -> Double.compare((double) p2.wartosc / p2.waga, (double) p1.wartosc / p1.waga));

        List<Integer> numeryPrzedmiotow = new ArrayList<>();
        int sumWartosc = 0;
        int sumWaga = 0;

        while (pojemnosc > 0) {
            Przedmioty najlepszyPrzedmiot = null;
            double najlepszyWspolczynnik = 0.0;

            for (Przedmioty przedmiot : posortowanePrzedmioty) {
                if (przedmiot.waga <= pojemnosc) {
                    double wspolczynnik = (double) przedmiot.wartosc / przedmiot.waga;
                    if (wspolczynnik > najlepszyWspolczynnik) {
                        najlepszyWspolczynnik = wspolczynnik;
                        najlepszyPrzedmiot = przedmiot;
                    }
                }
            }

            if (najlepszyPrzedmiot != null) {
                numeryPrzedmiotow.add(przedmioty.indexOf(najlepszyPrzedmiot) + 1);
                sumWartosc += najlepszyPrzedmiot.wartosc;
                sumWaga += najlepszyPrzedmiot.waga;
                pojemnosc -= najlepszyPrzedmiot.waga;
            } else {
                break; // Nie ma już przedmiotów, które można by było umieścić w plecaku
            }
        }

        return new Wynik(numeryPrzedmiotow, sumWartosc, sumWaga);
    }
}