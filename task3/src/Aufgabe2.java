/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addChar(String text, char character) {

        if(text.isEmpty()) {
            System.out.println();
            return;
        }

        System.out.print(text.charAt(0));

        for(int i = 1; i < text.length(); i++) {
            if(i % 2 == 1) {
                System.out.print("" + character + character);
            } else {
                System.out.print(character);
            }
            System.out.print(text.charAt(i));
        }

        System.out.println();
    }

    private static void addChar(int number, char character) {
        String text = Integer.toString(number);
        addChar(text, character);
    }

    private static void addChar(String text, String characters) {
        for(int i = 0; i < characters.length(); i++) {
            addChar(text, characters.charAt(i));
        }
    }

    private static void addChar(String text) {
        addChar(text, '=');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "A";
        String text2 = "CW";
        String text3 = "EP1";
        String text4 = "Index";

        addChar(text0, '&');
        addChar(text1, '+');
        addChar(text2, '*');
        addChar(text3, '-');
        addChar(text4, '#');
        System.out.println();

        addChar(1, '.');
        addChar(42, ':');
        addChar(148, '$');
        addChar(2048, ')');
        addChar(131719, '%');
        System.out.println();

        addChar(text2, "!O(");
        addChar(text4, "T1#+");
        System.out.println();

        addChar(text1);
        addChar(text2);
        addChar(text3);
    }
}
