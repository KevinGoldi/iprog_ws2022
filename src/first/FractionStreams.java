package first;

import java.util.ArrayList;
import java.util.*;
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
        liste.stream().sorted().forEach(n ->{
            System.out.println(n.floatValue());
        });
    }



}
