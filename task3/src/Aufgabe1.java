/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Es kreiert 2 Karos, die untereinander liegen und innerhalb eines Quadrats liegt, dessen Seiten durch + und * dargestellt sind, Ecken mit *
    // Man fängt damit an, dass man zuerst die obere Seite erstellt, daraufhin folgt der obere Teil des Karos (dass mit + gefüllt wird), sieht wie eine Pyramide aus
    // dann wird der untere Teil des Karos wieder mit einer for-Schleife kreiert
    // in jeder Zeil wird am Anfang und am Ende ein * platziert
    // die beiden Vorgänge werden 1:1 nochmal für das untere Karo verwendet
    // und zum Schluss die untere Linie aus "+"

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // auf die Einrückung wurde oft nicht geachtet, nach jeder offenen runden Klammer (weist auf einen neuen Codeblock hin) wird
    // der darauffolgende Code um eins nach vor gerückt bis die geschlossene Klammer kommt (bei for, if usw.)
    // Man lässt außerdem zwischen wichtigen Abläufen eine Zeile frei für die Lesbarkeit (z.b. große for-Schleifen)
    // Zudem würde ich die Bedingung für ein if-statment oder for-Schleife und Anweisungen in unterschiedlichen Zeilen schreiben


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung
    private static void drawKaroLine(int width) {
        System.out.print("#");

        for (int i = 1; i <= width; i++) {
            System.out.print("+");
        }

        System.out.println("#");
    }
    private static void drawKaro(int width) {

        //upper Part of Karo
        for (int i = 1; i <= width/2; i++) {

            //left side
            System.out.print("*");

            //middle part
            for (int j = 2; j <= width/2 - i + 1; j++) {
                System.out.print(" ");
            }

            System.out.print("/");

            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }

            System.out.print("\\");

            for (int j = 2; j <= width/2 - i + 1; j++) {
                System.out.print(" ");
            }

            //right side
            System.out.print("*");
            System.out.println();
        }

        //lower Part of Karo
        for (int i = 1; i <= width/2; i++) {

            //left side
            System.out.print("*");

            //middle part
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.print("\\");

            for (int j = 1; j <= 2 * (width/2 - i); j++) {
                System.out.print("+");
            }

            System.out.print("/");

            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            //right side
            System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        drawKaroLine(4);
        drawKaro(4);
        drawKaro(4);
        drawKaroLine(4);
        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 8; i++) {
        System.out.print("+");
        }
        System.out.println("#");

        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= (8/2-i+1); j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 2; j <= (8/2-i+1); j++) {System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }            System.out.print("\\");
            for (int j = 1; j <= (8 - 2 * i); j++) {System.out.print("+");
            }
            System.out.print("/");
            for (int j = 2; j <= i; j++) {System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= (8/2-i+1); j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 2; j <= (8/2-i+1); j++) {System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");            }
            System.out.print("\\");
            for (int j = 1; j <= (8-2*i); j++) {System.out.print("+");     }
            System.out.print("/");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.print("#");        for (int i = 1; i <= 8; i++) {
            System.out.print("+");
        }
        System.out.println("#");
    }
}


