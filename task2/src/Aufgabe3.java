/*
    Aufgabe 3) Schleifen und Methoden - Quersummen und Teilbarkeit
*/
public class Aufgabe3 {

    private static int calcCrossSum(int number) {
        int sum = 0;

        while(number > 0) {
            sum += number % 10; //hinterste Ziffer addieren
            number /= 10;       //hinterste Ziffer "entfernen"
        }

        return sum;
    }

    private static boolean isCrossSumDividable(int number, int crossSum) {
        return number % crossSum == 0;
    }

    private static int countCrossSumDividable(int start, int end) {
        int count = 0;

        while(start <= end) {
            if(isCrossSumDividable(start, calcCrossSum(start))) {
                count++;
            }
            start++;
        }

        return count;
    }

    private static void printCrossSumDividable(int start, int end) {

        while(start <= end) {
            if(isCrossSumDividable(start, calcCrossSum(start))) {
                System.out.println("Die Zahl " + start + " ist durch die Quersumme " + calcCrossSum(start) + " teilbar.");
            }
            start++;
        }
    }

    public static void main(String[] args) {

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //**********************************************************************
        assert (calcCrossSum(1) == 1);
        assert (calcCrossSum(102) == 3);
        assert (calcCrossSum(1234) == 10);
        assert (calcCrossSum(10000) == 1);
        assert (calcCrossSum(935943789) == 57);
        assert (calcCrossSum(1234567890) == 45);
        assert (isCrossSumDividable(1,1));
        assert (isCrossSumDividable(24,6));
        assert (isCrossSumDividable(364,13));
        assert (!isCrossSumDividable(123,6));
        //**********************************************************************

        int startInterval = 999994000;
        int endInterval = 999996000;

        System.out.println("*************");
        int count = countCrossSumDividable(startInterval, endInterval);
        System.out.println("Im Intervall von " + startInterval + " und " + endInterval + " gibt es " + count + " Zahlen die durch ihre Quersumme teilbar sind.");

        System.out.println("*************");
        System.out.println("Im Intervall von " + startInterval + " und " + endInterval + " gibt es folgende Zahlen die durch ihre Quersumme teilbar sind:");
        printCrossSumDividable(startInterval, endInterval);


        System.out.println();
        startInterval = 21;
        endInterval = 41;

        System.out.println("*************");
        count = countCrossSumDividable(startInterval, endInterval);
        System.out.println("Im Intervall von " + startInterval + " und " + endInterval + " gibt es " + count + " Zahlen die durch ihre Quersumme teilbar sind.");

        System.out.println("*************");
        System.out.println("Im Intervall von " + startInterval + " und " + endInterval + " gibt es folgende Zahlen die durch ihre Quersumme teilbar sind:");
        printCrossSumDividable(startInterval, endInterval);
    }
}
