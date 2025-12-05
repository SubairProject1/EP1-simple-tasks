/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printOddNumbersAscending(int start, int end) {
        if(start > end) {
            return;
        }

        //falls der Startwert nicht gerade sein sollte
        if(start % 2 != 1) {
            start++;
        }

        System.out.print(start + " ");
        printOddNumbersAscending(start + 2, end);
    }

    private static void printEvenNumbersDescending(int end) {
        if(end < 0) {
            return;
        }

        //falls der Startwert nicht gerade sein sollte
        if(end % 2 != 0) {
            end--;
        }

        System.out.print(end + " ");
        printEvenNumbersDescending(end - 2);
    }

    private static int countDigitsAboveFive(int number) {
        //Abbruchbedingung
        if(number == 0) {
            return 0;
        }

        //wenn die letzte Ziffer größer ist als 5
        if (number % 10 > 5) {
            return 1 + countDigitsAboveFive(number/10);
        }

        //ansonsten für letzte Ziffer kleiner gleich als 5
        return countDigitsAboveFive(number/10);
    }

    private static boolean checkIfStopAvailable(String text) {

        if(text.length() < 4) {
            return false;
        }

        //es würde schneller mit einem Stringvergleich gehen, aber equals() ist nicht erlaubt
        if(text.toLowerCase().charAt(0) == 's' && text.toLowerCase().charAt(1) == 't' &&
           text.toLowerCase().charAt(2) == 'o' && text.toLowerCase().charAt(3) == 'p') {
            return true;
        }

        return checkIfStopAvailable(text.substring(1));
    }

    public static void main(String[] args) {
        printOddNumbersAscending(3, 15);
        System.out.println();
        printEvenNumbersDescending(14);
        System.out.println();

        System.out.println(countDigitsAboveFive(6));
        System.out.println(countDigitsAboveFive(4));
        System.out.println(countDigitsAboveFive(456));
        System.out.println(countDigitsAboveFive(1234));
        System.out.println(countDigitsAboveFive(61238));
        System.out.println(countDigitsAboveFive(93862));
        System.out.println(countDigitsAboveFive(518279463));
        System.out.println();

        System.out.println(checkIfStopAvailable(""));
        System.out.println(checkIfStopAvailable("sto"));
        System.out.println(checkIfStopAvailable("STOP"));
        System.out.println(checkIfStopAvailable("stOkP3tOp"));
        System.out.println(checkIfStopAvailable("dasStOpistda"));
        System.out.println(checkIfStopAvailable("ASTOP"));
        System.out.println(checkIfStopAvailable("asTsTopstoPb"));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countDigitsAboveFive(6) == 1);
        assert (countDigitsAboveFive(4) == 0);
        assert (countDigitsAboveFive(456) == 1);
        assert (countDigitsAboveFive(1234) == 0);
        assert (countDigitsAboveFive(61238) == 2);
        assert (countDigitsAboveFive(93862) == 3);
        assert (countDigitsAboveFive(518279463) == 4);

        assert(!checkIfStopAvailable(""));
        assert(!checkIfStopAvailable("sto"));
        assert(checkIfStopAvailable("STOP"));
        assert(!checkIfStopAvailable("stOkP3tOp"));
        assert(checkIfStopAvailable("dasStOpistda"));
        assert(checkIfStopAvailable("ASTOP"));
        assert(checkIfStopAvailable("asTsTopstoPb"));
        //**********************************************************************
    }
}

