/*
    Aufgabe 1) for-Schleifen
*/

public class Aufgabe1 {

    public static void main(String[] args) {

        //a)
        int sum = 0;

        for(int i = 12; i <= 110; i++) {
            if(i % 11 == 0) {
                sum += i;
            }
        }
        System.out.println(sum + "\n");

        //b)
        for(int i = 7; i < 49; i += 7) {
            System.out.print(i + " ");
        }
        System.out.println('\n');

        //c)
        System.out.print('*');

        for (int i = 222; i <= 1105; i++) {

            if(i % 13 == 0 && i % 17 == 0) {
                System.out.print(i + "*");
            }
        }
        System.out.println('\n');

        //d)
        for(int i = 79; i > 70; i--) {
            System.out.print((char) i);

            if(i > 71) {
                System.out.print(',');
            }
        }
        System.out.println('\n');

        //e)
        int count = 0;
        String string = "Zehn zahme Ziegen zogen zehn Zentner zerbr¨oselten Zucker zum Zoo!";

        for(int i = 0; i < string.length(); i++) {
            if(string.toUpperCase().charAt(i) == 'Z') {
                count++;
            }
        }
        System.out.print(count);
    }
}
