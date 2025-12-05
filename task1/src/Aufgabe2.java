import java.io.Console;

/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {

        String text = "Eine nennenswerte und geeignete Sprache.";

        //Aufgabe a
        int index = 0;

        while (index < text.length()) {

            if (index % 2 == 1 && text.charAt(index) != 'n') {
                System.out.print(text.charAt(index));
            }

            index++;
        }

        System.out.print('\n');

        //Aufgabe b
        index = text.length() - 1;
        int nCount = 0;
        String newString = text;

        while(index >= 0) {

            if(text.charAt(index) == 'n') {
                nCount++;
            }

            if(nCount == 5) {
                newString = text.substring(index, text.length());
                break;
            }

            index--;
        }

        System.out.println(newString);

        //Aufgabe c
        index = 0;
        int count = 0;

        while(index < text.length()) {

            //kleine Abhilfe, sonst langer Text
            int currentChar = text.toUpperCase().charAt(index);

            if(currentChar >= 'A' && currentChar <= 'M') {
                count++;
            }

            index++;
        }

        System.out.println(count);

        //Aufgabe d
        index = 20;

        while(index < 304) {
            if(index % 2 == 0 && index % 19 == 0) {
                System.out.print(index + " ");
            }
            index++;
        }
    }
}