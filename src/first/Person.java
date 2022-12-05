package first;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Person implements Comparable<Person>, Cloneable, SimpleTreeNode{
    public static void main(String[] args) {
        MyIO.writeln("Lass uns die Klasse Testen.");
        MyIO.writeln("Hierzu werde ich ein Objekt mit meinen Daten erzuegen.");
        Person[] personen = {
                new Person("Alex", "Lustig", "Instandhalter", "Heilbronn", 2000, 1.80),
                new Person("Sven", "Lustig", "Verkäufer", "Köln", 1992, 1.81),
                new Person("Dagmar", "Lustig", "Goldschmied", "Heilbronn", 1960, 1.65),
                new Person("Susanne", "Böse", "Consultant", "Heilbronn", 1976, 1.54),
                new Person("Friedrich", "Böse", "Influencer", "Heilbronn", 2002, 1.83),
                new Person("Vitali", "Böse", "Profiboxer", "Moskau", 1984, 1.85),
                new Person("Yusuf", "Böse", "Kamelzüchter", "Istanbul", 1999, 1.73)};

        personen[2].addChild(personen[1]);
        personen[2].addChild(personen[3]);
        personen[3].addChild(personen[0]);
        personen[5].addChild(personen[0]);
        personen[5].addChild(personen[6]);
        Person p = personen[2].clone();
        System.out.println(p.getChild(0));
    }

    private final String vorname;
    private final String name;
    private final String beruf;
    private final String geburtsort;
    private final int geburtsjahr;
    private final double hoehe;
    //Hier wird über DefaultTreeNode delegiert, womit die Methoden hieraus nutzbar sind
    private DefaultTreeNode node;

    public Person(String vorname, String name, String beruf, String geburtsort, int geburtsjahr, double hoehe) {
        this.vorname = vorname;
        this.name = name;
        this.beruf = beruf;
        this.geburtsort = geburtsort;
        this.geburtsjahr = geburtsjahr;
        this.hoehe = hoehe;
        this.node = new DefaultTreeNode(name);
    }

    public Person() {
        MyIO.writeln("Trage in den folgenden Zelen die Daten der Person ein");
        this.vorname = MyIO.promptAndRead("Gib mir den Vornamen der Person: ");
        this.name = MyIO.promptAndRead("Gib mir den Nachnahmen der Person: ");
        this.beruf = MyIO.promptAndRead("Gib mir den Beruf der Person: ");
        this.geburtsort = MyIO.promptAndRead("Gib mir den Geburtsort der Person: ");
        this.geburtsjahr = MyIO.readInt("Gib mir das Geburtsjahr der Person: ");
        this.hoehe = MyIO.readFlt("Gib mir die Körpergröße der Person:");
    }

    public String toString() {

        int age = new GregorianCalendar().get(Calendar.YEAR) - geburtsjahr;
        String s;
        if (hoehe <= 1.48) {
            s = "klein";
        } else if (hoehe <= 1.82) {
            s = "mittel";
        } else {
            s = "groß";
        }
        return "[" + vorname + ", " + name + ", " + beruf + ", " + geburtsort + ", " + geburtsjahr + "(" + age + "j), "
                + hoehe + "m(" + s + ")]";

    }

    public void compareWith(Person a) {
        if (this.hoehe == a.hoehe) {
            MyIO.writeln("Beide sind gleich groß: " + this.hoehe);
        } else if (this.hoehe <= a.hoehe) {
            MyIO.writeln(a.name + " ist " + (a.hoehe - this.hoehe) + " größer als " + this.name);
        } else {
            MyIO.writeln(this.name + " ist " + (this.hoehe - a.hoehe) + " größer als " + a.name);
        }
        if (this.geburtsjahr == a.geburtsjahr) {
            MyIO.writeln("Beide sind gleich alt: " + (new GregorianCalendar().get(Calendar.YEAR) - geburtsjahr));
        } else if (this.geburtsjahr <= a.geburtsjahr) {
            MyIO.writeln(this.name + " ist " + (a.geburtsjahr - this.geburtsjahr) + " älter als " + a.name);
        } else {
            MyIO.writeln(a.name + " ist " + (this.geburtsjahr - a.geburtsjahr) + " älter als " + this.name);
        }
    }

    @Override
    public void addChild(SimpleTreeNode child) {
        node.addChild(child);
    }

    @Override
    public int getChildCnt() {
        return this.node.getChildCnt();
    }

    @Override
    public SimpleTreeNode getChild(int pos) {
        return this.node.getChild(pos);
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public Person clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            //Erzeugt ein geklontes Objekt, welches als Person gecastet wird
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
