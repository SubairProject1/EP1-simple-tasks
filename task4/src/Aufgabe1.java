/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] filledArray) {
        int number = 8;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 8;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 6 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[8];
        int number = 8;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 8;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 999;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************

    //Antwort zu Punkt a:
    // Gib den Fehler java.lang.ArrayIndexOutOfBoundsException aus.
    // Es wird auf ein Element zugegriffen, welches nicht existiert.
    // Auch wenn die Größe von Array n ist, ist der letzte index n - 1.
    // statt "<=" nur "<" schreiben

    //Antwort zu Punkt b:
    // weil es nicht nötig ist, die Änderungen am Array finden statt
    // auch wenn es nicht rückgegeben wird. Liegt an der Eigenschaft,
    // dass nicht der Array, sondern die Referenz kopiert wird. Damit
    // wird jeder Array, der eine Referenz auf dieselbe Adresse hat, ebenfalls verändert


    //Antwort zu Punkt c:
    // Ähnlich wie bei b) ist coppiedArray keine echte Kopie.
    // Stattdessen ist es eine Referenz auf dem Speicher vom workArray
    // damit findet jede Änderung immer auf beiden Arrays statt

    //Antwort zu Punkt d:
    // neuer Arrayinhalt, weil der workArray anfangs eine Referenzkopie von
    // filledArray war, später zeigt er stattdessen auf den selben Speicher wie helpArray
    // der Inhalt von filledArray bzw. der Speicher wurde gar nicht geändert
    // deshalb wird bei printArray(filledArray) auch der alte Inhalt geprintet

    //Zusatzfragen
    //1.) int
    //2.) nach dem Initialisieren, geht es nicht
    //3.) entweder mit einer for-Schleife jedes Element
    //    aus einem Array Index für Index dem neuen Array
    //    (ebenfalls Index für Index) zugewiesen oder mit System.arraycopy
    //4.) die Adressen der jeweiligen Arrays werden verglichen, also nein. Es ist nicht sinvoll.
}
