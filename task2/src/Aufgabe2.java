/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    private static void printAsciiNeighbors(char character) {
        System.out.print("" + (char) (character - 1) + character + (char) (character + 1));
    }

    private static void printAlphabet() {
        for(int i = 0; i <= 25; i++) {
            System.out.print((char) ('a' + i) + " ");
        }
    }

    private static int calcSum(int start, int end) {
        int sum = 0;
        while(start <= end) {
            sum += start;
            start++;
        }
        return sum;
    }

    private static boolean isCharOnceInString(String text, char character) {

        int count = 0;

        //wäre auch mit for-each loop lösbar
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == character) {
                count++;

                if(count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }

    private static String removeNumbersInString(String text) {

        String newString = "";

        for(int i = 0; i < text.length(); i++) {
            if(!('0' <= text.charAt(i) && text.charAt(i) <= '9'))  {
                newString += text.charAt(i);
            }
        }

        return newString;
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.

        assert (calcSum(-1,1) == 0);
        assert (calcSum(0,0) == 0);
        assert (calcSum(256,331) == 22306);
        assert (calcSum(0,22) == 253);
        assert (calcSum(-31,14) == -391);

        assert (!isCharOnceInString("", 'a'));
        assert (isCharOnceInString("a", 'a'));
        assert (isCharOnceInString("abc", 'b'));
        assert (!isCharOnceInString("nennenswerte Worte", 'n'));
        assert (isCharOnceInString("nennenswerte Worte", 'o'));
        assert (!isCharOnceInString("nennenswerte Worte", 'z'));

        assert (removeNumbersInString("").equals(""));
        assert (removeNumbersInString("123").equals(""));
        assert (removeNumbersInString("1A2B3C").equals("ABC"));
        assert (removeNumbersInString("Das ist die Nummer 1").equals("Das ist die Nummer "));
        assert (removeNumbersInString("Es gibt keine Ziffer").equals("Es gibt keine Ziffer"));
        assert (removeNumbersInString("3 mal die 5 ist gleich 15").equals(" mal die  ist gleich "));

        //**********************************************************************

        //meine Tests
        //printAlphabet();
        //System.out.println(calcSum(10, 12));
        //System.out.println(isCharOnceInString("Hndu", 'u'));
        //System.out.println(removeNumbersInString("eins1zwölf12dreizig30"));
    }
}
