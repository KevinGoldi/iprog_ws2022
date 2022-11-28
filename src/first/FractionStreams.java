package first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class FractionStreams {
    public static void main(String[] args) {

        ArrayList<Fraction> liste = new ArrayList<Fraction>();
        for (int i = -14; i <= 14; i++)
            for (int j = 14; j >= -14;j--){
                liste.add(new Fraction(i, j));
            }


        /*
        Gibt Float-Werte aller Brüche der sortierten Liste eindeutig aus
        */
        liste.stream().sorted().distinct().forEach(n ->{
            System.out.println(n.floatValue());
        });
                /*
        Gibt alle Brüche der sortierten Liste eindeutig und quadriert aus
        */
        liste.stream().sorted().distinct().map(n -> n.multiply(n)).forEach(System.out::println);
                /*
        Gibt Float-Werte aller Brüche der sortierten Liste eindeutig aus
        */
        liste.stream().
                sorted(new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                return new Random().nextInt();
            }
        }).filter(n -> n.zaehler.isProbablePrime(10) && n.nenner.isProbablePrime(10))
                .forEach(n ->{
            System.out.println(n);
        });
                /*
        Gibt alle Brüche aus, die Integer sind
        */
        liste.stream().sorted().filter(Fraction::isInteger)
                .forEach(System.out::println);
                        /*
        Gibt alle Brüche als Double aus, wobei vorher der Sinus des Elementes berechnet wird
        */
        liste.stream().sorted().map(n -> Math.sin(n.doubleValue()))
                .forEach(System.out::println);
    }



}
