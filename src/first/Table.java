package first;

import java.math.BigInteger;

public class Table {
    public static void main(String[] args) {
        Table table = new Table(4, 1);
        int[] arr = {0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1};
        int[] arr2 = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        Table taple = new Table(4, arr, arr2);
        System.out.println(taple.toString());
    }

    //Instanzvariablen
    private final int eingaenge, ausgaenge;
    private int zeilen, spalten;
    private boolean[][] feld;

    //Konstruktor
    Table(int eingaenge, int ausgaenge) {
        this.eingaenge = eingaenge;
        this.ausgaenge = ausgaenge;
        zeilen = 1 << eingaenge;
        spalten = eingaenge + ausgaenge;
        feld = new boolean[zeilen][spalten];
        //Schleife für Spalten
        for(int i = 0; i <= eingaenge -1; i++) {
            //Schleife für Zeilen
        for (int l = 0; l < zeilen; l += (1<<i)){
            if (l % (1<<i+1) == (1<<i)) {
                //Schleife für die jeweilige Anzahl an 1en
                for (int m = 0; m < (1 << i); m++) {
                    feld[m + l][eingaenge-1-i] = true;
                    }
                }
            }
        }
    }
    Table(int eingaenge, int[] ... ausgaenge) {
        this.eingaenge = eingaenge;
        this.ausgaenge = 1;
        zeilen = 1 << eingaenge;
        spalten = eingaenge + ausgaenge.length;
        feld = new boolean[zeilen][spalten];
        //Schleife für Spalten
        for(int i = 0; i <= eingaenge -1; i++) {
            //Schleife für Zeilen
            for (int l = 0; l < zeilen; l += (1<<i)){
                if (l % (1<<i+1) == (1<<i)) {
                    //Schleife für die jeweilige Anzahl an 1en
                    for (int m = 0; m < (1 << i); m++) {
                        feld[m + l][eingaenge-1-i] = true;
                    }
                }
            }
        }
        for(int i = 0; i < ausgaenge.length; i++){
            for (int l = 0; l < zeilen; l++){
                if (ausgaenge[i][l] >= 1){
                    feld[l][eingaenge+i] = true;
                } else{
                    feld[l][eingaenge+i] = false;
                }
            }
        }
    }

    public void print(String s) {
        System.out.println(s);
        System.out.println(this);
    }
/*
    public String toString() {
        //Buffervariable b wird mit Wert 0 initialisiert
        boolean buffer = false;
        //Schleife zum finden des größten Elementes für den Buffer
        for (boolean[] b : this.feld) {
            for (boolean bb : b) {
                //Variable a wird der länge des String der die Doublezahl repräsentiert zugewie
                //Wenn aktuelles Element größer als Buffer entspricht der Buffer dem aktuellen Element
                if (bb) {
                    buffer = bb;
                    break;
                }
            }
        }
        //Initialisierung des resultierenden Strings
        String res = "";
        //Schleife für durchlauf durch das äußere Array
        for (boolean[] b : this.feld) {
            //An resultierenden String wird "[" angefügt
            res = res.concat("[");
            //Schleife für Durchlauf durch das innere Array
            for (boolean bb : b)  {
                if (buffer && Boolean.toString(bb).length()<=4) res = res.concat(" ");
                //Hinzufügen des aktuellen Array-Elemntes zum resultierenden String
                res = res.concat(Boolean.toString(bb));
                res = res.concat(" ");
            }
            res = res.concat("]\n");
        }
        return res;
    }

 */
    public String toString(){
        String res = "";
        //Schleife für durchlauf durch das äußere Array
        for (boolean[] b : this.feld) {
            //An resultierenden String wird "[" angefügt
            res = res.concat("[ ");
            //Schleife für Durchlauf durch das innere Array
            for (int i = 0; i <= b.length -1; i++)  {
                if (b[i]) {
                    res = res.concat("1");
                } else {
                    res = res.concat("0");
                }
                if (i == eingaenge-1 ) res = res.concat(" |");

                res = res.concat(" ");
            }
            res = res.concat("]\n");
        }
        return res;
    }

    public void setValue(int i, int j, boolean x) {
        this.feld[i-1][j-1] = x;
    }

    public boolean getValue(int i, int j) {
        return this.feld[i-1][j-1];
    }
}

