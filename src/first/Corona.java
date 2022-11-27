package first;

public class Corona {
    public static void main(String[] args) {
        int n = MyIO.readInt("Gib mir eine Zahl");
        for (int i = 0; i < n; i++){
            if (!(i%3==0) && !(i%5==0) && !(i%7==0)) {
                System.out.print(i);
            }

            if (i%3==0 && !(i%5==0) && !(i%7==0)) {
                System.out.print("Tra");
            }
            if (!(i%3==0) && i%5==0 && !(i%7==0)) {
                System.out.print("Tri");
            }
            if (!(i%3==0) && !(i%5==0) && i%7==0) {
                System.out.print("Lala");
            }
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0){
                System.out.print("Covid");}
            else if ((i % 3 == 0 && i % 5 == 0) ^ (i%3 == 0 && i % 7 == 0) ^ (i % 5 == 0 && i % 7 == 0)){
                System.out.print("Corona");
            }
            }
        }
    }

