/*
    Aufgabe 4) Simpler Taschenrechner mit Scanner und Methoden
*/

import java.util.Scanner;

public class Aufgabe4 {

    private static int enteredNumber() {
        Scanner scn = new Scanner(System.in);

        while(true) {
            if(scn.hasNextInt()) { //ab hier wirst du nach dem input gefragt und der soll ein Interger sein
                return scn.nextInt();
            } else {
                System.out.println("The input is invalid. Please only enter a number.");
                scn.next(); //ganzen angegeben String abfangen und für den nächsten input freiräumen, sonst Endlosschleife
            }
        }
    }

    private static char enteredOperation() {
        Scanner scn = new Scanner(System.in);

        while(true) {
            String currentNext = scn.next(); //Eingabe wiederholen, falls falsch war

            //erst wenn die Eingabe ein einziges Zeichen ist, soll man überprüfen auf Korrektheit überprüfen
            if(currentNext.length() == 1 && "+-*/%".contains(currentNext)) {
                return currentNext.charAt(0);
            } else {
                System.out.println("The input is invalid. Please only enter the operation (+,-,*,/ or %).");
            }
        }
    }

    private static boolean continueCalc() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter symbol q/Q for quitting or c/C for another calculation:");

        while(true) {
            String currentNext = scn.next();

            if(currentNext.length() == 1 && "cCqQ".contains(currentNext)) {
                if(currentNext.toUpperCase().charAt(0) == 'C') {
                    return true;
                }

                return false;

            } else {
                System.out.println("The input is invalid. Please only symbol q/Q for quitting or c/C for another calculation:");
            }
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("Enter the first operand:");
            int operand1 = enteredNumber();

            System.out.println("Enter the second operand:");
            int operand2 = enteredNumber();

            System.out.println("Enter operation (+,-,*,/ or %)");
            char operation = enteredOperation();

            switch(operation) {
                case '+':
                    System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
                    break;
                case '-':
                    System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
                    break;
                case '*':
                    System.out.println(operand1 + " * " + operand2 + " = " + (operand1 * operand2));
                    break;
                case '/':
                    System.out.println(operand1 + " / " + operand2 + " = " + ((double)operand1 / operand2));
                    break;
                case '%':
                    System.out.println(operand1 + " % " + operand2 + " = " + (operand1 % operand2));
                    break;
                default:
                    System.out.println("Etwas ist schiefgelaufen!");
                    break;
            }

        } while(continueCalc());
    }
}
