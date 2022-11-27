package first;
/**
 * @version 1, 08.11.2022
 * @author Jan Obernberger
 **/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class EsreverLister {

    public static void main(String[] args) throws IOException {
        //Initialisierung einer Liste mit Elementen des Typs String
        List<String> list = new ArrayList<String>();
        MyIO.writeln("Ich werde einen Text einlesen und diesen gespiegelt" +
                "in umgekehrter Reihenfolge ausgeben...");
        while (true){
            String s = MyIO.promptAndRead("->");
            if (s == null ||s.equalsIgnoreCase("potS") || s.equalsIgnoreCase("^Z")) break;
            list.add(invertieren(s));
        }
     /*
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;

        do {
            System.out.print("->");
            inputLine = input.readLine().lines();

            list.add(invertieren(inputLine));
            if(inputLine  != null || inputLine.equalsIgnoreCase("potS") || inputLine.equalsIgnoreCase("^Z")) break;
        } while (true);
        /*


        //Endlosschleife für die Eingabe
        while (true) {
            boolean a;
            String s = promptAndReadBars("asd");
            //String für die Eingabe
            System.out.println("->");

            if (s  == null || s.equalsIgnoreCase("potS") || s.equalsIgnoreCase("^Z")) break;
            //Abbruchbedingungen werden festgelegt
            //Hinzufügen des invertierten Eingabestrings zur Liste
            list.add(invertieren(s));

        }
        */

        /*
        //Umgekehrte Ausgabe nach Abbruch der Endlosschleife
        for (int i = list.size(); i > 0; i--){
            MyIO.writeln(list.get(i - 1));
        }



         */


        //Alternative Ausgabe mit ListIterator Objekt
        ListIterator<String> it = list.listIterator(list.size());
        while (it.hasPrevious()){
            MyIO.writeln(it.previous());
        }




    }

    public static String invertieren(String a) {
        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.charAt(0);

    }

    public static String promptAndReadBars(String a) throws IOException {
        System.out.print(a);
        boolean b = false;
        Scanner sc = new Scanner(System.in);
       if (sc.hasNext()) b = true;


        //Promptet nach jeder Linie, ggf buffered reader benutzen oder while
        //File IO anschauen
        return sc.nextLine();
    }


}