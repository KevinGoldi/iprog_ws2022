/**
 * @version 3, 08.11.2022
 * @author Jan Obernberger
 **/

package first;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class MyIO {

    private MyIO() {

    }
    static Scanner sc = new Scanner(System.in);

    public static String readString(){
        return sc.nextLine();
    }
    public static String promptAndRead(String prompt){
        System.out.print(prompt);
        return sc.nextLine();
    }
    public static Fraction readFct(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                String frc = sc.nextLine().trim();
                String[] arr = frc.split("/");
                return new Fraction(BigInteger.valueOf(Long.parseLong(arr[0])), BigInteger.valueOf(Long.parseLong(arr[1])));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Error, bitte nochmal versuchen");
            }

        }
    }
    public static int readInt(String prompt){
        System.out.print(prompt);
        while (true) try {
         return Integer.parseInt(sc.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Error, bitte nochmal versuchen");

        }
    }
    public static long readLng(String prompt){
        System.out.print(prompt);
        while (true) try {
            return Long.parseLong(sc.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Error, bitte nochmal versuchen");

        }
    }
    public static BigInteger readBigInt(String prompt){
        System.out.print(prompt);
        while (true) try {
            return new BigInteger(sc.nextLine().trim());
        }
        catch (Exception e) {
            System.out.println("Error, bitte nochmal versuchen");
        }
    }
    public static float readFlt(String prompt){
        System.out.print(prompt);
        while (true) try {
            return Float.parseFloat(sc.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Error, bitte nochmal versuchen");

        }
    }
    public static double readDbl(String prompt){
        System.out.print(prompt);
        while (true) try {
            return Double.parseDouble(sc.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Error, bitte nochmal versuchen");

        }
    }
    public static BigDecimal readBigDec(String prompt){
        System.out.print(prompt);
        while (true) try {
            BigDecimal number = new BigDecimal(sc.nextLine().trim());
            return number;
        }
        catch (Exception e) {
            System.out.println("Error, bitte nochmal versuchen");
        }
    }

    public static void write(String s){
        System.out.print(s);
        return;
    }
    public static void write(int a){
        System.out.println(a);
        return;
    }
    public static void write(long a){
        System.out.println(a);
        return;
    }
    public static void write(float a){
        System.out.println(a);
        return;
    }
    public static void write(double a){
        System.out.println(a);
        return;
    }

    public static void writeln(String s){
        System.out.println(s);
        return;
    }
    public static void writeln(int a){
        System.out.println(a);
        return;
    }
    public static void writeln(long a){
        System.out.println(a);
        return;
    }
    public static void writeln(float a){
        System.out.println(a);
        return;
    }
    public static void writeln(double a){
        System.out.println(a);
        return;
    }
}
