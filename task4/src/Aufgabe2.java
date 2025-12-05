/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    private static void printArray(final int[] copyArray) {
        for(int num : copyArray) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    private static void printArray(final char[] copyArray) {
        for(char character : copyArray) {
            System.out.print(character + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        //a
        int[] arr1 = new int[15];

        for (int i = 0; i < arr1.length; i++) {
            int cubicNum = (int) Math.pow(i + 2, 3);

            if(cubicNum % 9 == 0) {
                arr1[i] = 0;
            } else {
                arr1[i] = cubicNum;
            }
        }

        printArray(arr1);

        //b
        char[] arr2 = {'a', '8', 'U', '3', ':', '9', 'd', 'F', '-', 'T'};

        //die Ziffer zählen
        int sum = 0;
        for(int character : arr2) {
            if('0' <= character && character <= '9') {
                sum++;
            }
        }

        char[] arr2new = new char[arr2.length + sum];
        int shift = 0;

        for(int i = 0; i < arr2new.length; i++) {
            arr2new[i] = arr2[i - shift]; //shifte um 1 wenn arr2new Z bekommt

            if(i != arr2new.length - 1) {
                // wenn das nächste Elemnt eine Zahl ist, weise dem nächsten Index Z zu
                if('0' <= arr2[i + 1 - shift] && arr2[i + 1 - shift] <= '9') {
                    arr2new[++i] = 'Z';
                    shift++;
                }
            }
        }

        printArray(arr2new);

        //c
        int[] arr3 = new int[20];

        for (int i = 0; i < 20; i++) {
            arr3[i] = i + 1;
        }

        System.out.print("for-Schleife: ");

        for (int i = 0; i < arr3.length; i++) {
            if(i % 2 == 1) {

                if(i > 2) {
                    System.out.print(':');
                }

                System.out.print(arr3[arr3.length - i]);
            }
        }

        System.out.println();

        System.out.print("while-Schleife: ");

        int i = 0;
        while (i < arr3.length) {
            if(i % 2 == 1) {

                if(i > 2) {
                    System.out.print(':');
                }

                System.out.print(arr3[arr3.length - i]);
            }

            i++;
        }
    }
}

