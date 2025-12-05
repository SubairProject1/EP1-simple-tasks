/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedLetters(String text, int index) {

        // ein oder kein Zeichen
        if(text.length() < 2) {
            return 0;
        }

        //der Teil, der nicht überprüft wird, gleich zu Beginn loswerden
        if(index > 0) {
            return countNOrderedLetters(text.substring(index), 0);
        }

        //es sollen nur Buchstaben überprüft werden
        if(!(("0123456789".contains(text.charAt(0) + "")) || "0123456789".contains(text.charAt(1) + ""))) {
            if(text.toLowerCase().charAt(0) <= text.toLowerCase().charAt(1)) {
                return 1 + countNOrderedLetters(text.substring(1), 0);
            }
        }

        return countNOrderedLetters(text.substring(1), 0);
    }

    private static String duplicateSelectedChar(String text, char character) {

        if(text.isEmpty()) {
            return "";
        }

        if(text.charAt(0) == '0') {
            return "" + text.length();
        }

        //keine andere Lösung gefunden außer Zahlen mitzugeben
        if(text.toLowerCase().charAt(0) == Character.toLowerCase(character)) {
            return "" + text.charAt(0) + text.charAt(0) + duplicateSelectedChar(text.substring(1) + "0", character);
        }

        return text.charAt(0) + duplicateSelectedChar(text.substring(1), character);
    }

    public static void main(String[] args) {

        String text = "bCaa12fgHIdE32zYxYz";
        System.out.println(countNOrderedLetters(text, 0));
        System.out.println(countNOrderedLetters(text, 1));
        System.out.println(countNOrderedLetters(text, 6));
        System.out.println(countNOrderedLetters(text, 13));
        System.out.println(countNOrderedLetters(text, 17));
        System.out.println();

        System.out.println(duplicateSelectedChar("", 'o'));
        System.out.println(duplicateSelectedChar("K", 'k'));
        System.out.println(duplicateSelectedChar("abcAijk", 'a'));
        System.out.println(duplicateSelectedChar("abcAijk", 'A'));
        System.out.println(duplicateSelectedChar("AbNcdnNopqnUvWN", 'n'));
        System.out.println(duplicateSelectedChar("AbNcdnNopqnUvWN", 'm'));
        System.out.println(duplicateSelectedChar("nothing", 'Z'));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countNOrderedLetters(text, 0) == 8);
        assert (countNOrderedLetters(text, 1) == 7);
        assert (countNOrderedLetters(text, 6) == 6);
        assert (countNOrderedLetters(text, 13) == 2);
        assert (countNOrderedLetters(text, 17) == 1);

        assert (duplicateSelectedChar("", 'o').equals(""));
        assert (duplicateSelectedChar("K", 'k').equals("KK1"));
        assert (duplicateSelectedChar("abcAijk", 'a').equals("aabcAAijk2"));
        assert (duplicateSelectedChar("abcAijk", 'A').equals("aabcAAijk2"));
        assert (duplicateSelectedChar("AbNcdnNopqnUvWN", 'n').equals("AbNNcdnnNNopqnnUvWNN5"));
        assert (duplicateSelectedChar("AbNcdnNopqnUvWN", 'm').equals("AbNcdnNopqnUvWN"));
        assert (duplicateSelectedChar("nothing", 'Z').equals("nothing"));
        //**********************************************************************
    }
}
