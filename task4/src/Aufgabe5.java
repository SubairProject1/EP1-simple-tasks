/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] generateFilledArray(int n) {
        int[][]generateFilledArray = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {

                int num = (x + 1) + y * n;

                if(num <= (n*n+1)/2) {
                    generateFilledArray[y][x] = num;
                } else {
                    //belegte Werte spiegeln
                    generateFilledArray[y][x] = generateFilledArray[n - y - 1][n - x - 1];
                }
            }
        }

        return generateFilledArray;
    }

    private static int[][] generateExtendedArray(int[] inputArray) {

        //inputArray[0]... Wiederholunge von inputArray[1]
        //inputArray[1]... Elemente beginnend bei 1 bis n
        //inputArray[2]... Wiederholunge von inputArray[3]
        //inputArray[3]... Elemente beginnend bei 1 bis n

        int[][] generateExtendedArray = new int[inputArray[0] + inputArray[2]][];

        for(int y = 0; y < inputArray[0]; y++) {

            generateExtendedArray[y] = new int[inputArray[1]];

            for (int x = 0; x < inputArray[1]; x++) {
                generateExtendedArray[y][x] = x + 1;
            }
        }

        for (int y = 0; y < inputArray[2]; y++) {

            generateExtendedArray[inputArray[0] + y] = new int[inputArray[3]];

            for (int x = 0; x < inputArray[3]; x++) {
                generateExtendedArray[inputArray[0] + y][x] = x + 1;
            }
        }
        
        return generateExtendedArray;
    }

    private static int[][] generateReformattedArray(int[][] inputArray) {

        int[][] generateReformattedArray = new int[inputArray.length][];

        for (int row = 0; row < inputArray.length; row++) {
            int count0 = 0;

            //0er zählen
            for(int element : inputArray[row]) {
                if(element == 0) {
                    count0++;
                }
            }

            //die Größe in jeder Reihe festlegen
            generateReformattedArray[row] = new int[inputArray[row].length];

            for(int i = 0; i < inputArray[row].length; i++) {
                if(i < count0) {
                    generateReformattedArray[row][i] = 0;
                } else {
                    generateReformattedArray[row][i] = 1;
                }
            }
        }

        return generateReformattedArray;
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int[] arr : inputArray) {
                for (int val : arr) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Test: generateFilledArray");
        System.out.println("-----");
        int[][] array = generateFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2}, {2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {8, 7, 6, 5}, {4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(5);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 12, 11},
                                                     {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(7);
        printArray(array);
        System.out.println("-----");
        System.out.println();

        System.out.println("Test: generateExtendedArray");
        System.out.println("-----");
        int[] array1 = new int[]{4, 3, 2, 6};
        int[][] array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3},
                                                        {1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}}));
        System.out.println("-----");

        array1 = new int[]{2, 4, 1, 5};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}}));
        System.out.println("-----");

        array1 = new int[]{1, 1, 1, 1};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1}, {1}}));
        System.out.println("-----");

        array1 = new int[]{4, 4, 1, 4};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4},
                                                         {1, 2, 3, 4}, {1, 2, 3, 4}}));
        System.out.println("-----");
        System.out.println();

        System.out.println("Test: generateReformattedArray");
        System.out.println("-----");
        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        System.out.println("Before:");
        printArray(array2);
        int[][] array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0, 1, 1, 1}, {0, 1, 1}, {0, 0, 1, 1, 1},
                                                         {0, 0, 0, 0, 1}, {0, 1}, {1, 1, 1, 1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0},
                             {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                             {0, 0, 0, 0, 0, 0, 0, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0, 0, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 1, 1},
                                                         {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
                                                         {0, 0, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                                                         {0, 0, 0, 0, 0, 0, 0, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");

        array2 = new int[][]{{0}, {1}, {0, 0}, {0, 1}, {1, 0}, {1, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0}, {1}, {0, 0}, {0, 1}, {0, 1}, {1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");
    }
}
