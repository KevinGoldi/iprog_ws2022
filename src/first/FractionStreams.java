package first;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
        Gibt Float-Werte aller Brüche der sortierten Liste eindeutig aus
        */
        liste.stream().sorted().distinct().map(n -> n.multiply(n)).forEach(n ->{
            System.out.println(n.floatValue());
        });
    }



}
