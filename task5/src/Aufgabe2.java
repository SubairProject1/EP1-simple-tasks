/*
    Aufgabe 2) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static char[][] makeOver(char[][] inputArray) {
        char[][] makeOver = new char[inputArray.length + 2][];

        //erste und letzte Reihe nur mit * befüllen
        makeOver[0] = new char[inputArray[0].length + 2];
        makeOver[makeOver.length - 1] = new char[inputArray[inputArray.length - 1].length + 2];

        for (int i = 0; i < makeOver[0].length; i++) {
            makeOver[0][i] = '*';
        }

        for (int i = 0; i < makeOver[makeOver.length - 1].length; i++) {
            makeOver[makeOver.length - 1][i] = '*';
        }

        //restliche Reihen
        for(int row = 1; row < makeOver.length - 1; row++) {

            //jede Reihe ist um 2 größer als inputArray Reihe
            makeOver[row] = new char[inputArray[row - 1].length + 2];

            //erste und letzte Stelle *
            makeOver[row][0] = '*';
            makeOver[row][makeOver[row].length - 1] = '*';

            //und dann die vorkommenden Buchstaben einfügen
            for(int letterIdx = 1; letterIdx < makeOver[row].length - 1; letterIdx++) {
                makeOver[row][letterIdx] = inputArray[row - 1][letterIdx - 1];
            }
        }

        return makeOver;
    }

    private static void change(int[][] workArray) {
        int[][] temp = new int[workArray.length][];

        for(int i = 0; i < workArray.length; i++) {

            int removeNum;

            if(workArray[i].length > 0 && workArray[i][0] < 0) {
                removeNum = Math.abs(workArray[i][0]);
            } else {
                removeNum = 0;
            }

            //copy
            temp[i] = new int[workArray[i].length];
            for(int j = 0; j < workArray[i].length; j++) {
                temp[i][j] = workArray[i][j];
            }

            //assign
            int newSize = Math.max(0, temp[i].length - removeNum);
            workArray[i] = new int[newSize];

            for(int j = 0; j < workArray[i].length; j++) {
                workArray[i][j] = temp[i][j + removeNum];
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(char[][] inputArray) {
        if (inputArray != null) {
            for (char[] arr : inputArray) {
                for (char val : arr) {
                    System.out.print(val);
                }
                System.out.println();
            }
            System.out.println();
        }
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

        System.out.println("Test: makeOver");
        System.out.println();

        char[][] array1 = {{'H', 'i', '!'}, {'E', 'P'}, {'1'}};
        char[][] result1 = makeOver(array1);
        printArray(result1);
        assert (Arrays.deepEquals(result1, new char[][]{{'*', '*', '*', '*', '*'},
                                                        {'*', 'H', 'i', '!', '*'},
                                                        {'*', 'E', 'P', '*'},
                                                        {'*', '1', '*'},
                                                        {'*', '*', '*'}}));

        char[][] array2 = {{'O'}};
        char[][] result2 = makeOver(array2);
        printArray(result2);
        assert (Arrays.deepEquals(result2, new char[][]{{'*', '*', '*'},
                                                        {'*', 'O', '*'},
                                                        {'*', '*', '*'}}));

        char[][] array3 = {{'H'}, {'H', 'H', 'H'}, {'H'}};
        char[][] result3 = makeOver(array3);
        printArray(result3);
        assert (Arrays.deepEquals(result3, new char[][]{{'*', '*', '*'},
                                                        {'*', 'H', '*'},
                                                        {'*', 'H', 'H','H', '*'},
                                                        {'*', 'H', '*'},
                                                        {'*', '*', '*'}}));


        System.out.println("Test: change");
        System.out.println();

        int[][] array4 = {{1, 4, -2, 0}, {2}, {-3, -1}, {-2, 6, -5, 8, 3}};
        System.out.println("Before:");
        printArray(array4);
        change(array4);
        System.out.println("After:");
        printArray(array4);
        assert (Arrays.deepEquals(array4, new int[][]{{1, 4, -2, 0}, {2}, {}, {-5, 8, 3}}));


        int[][] array5 = {{0, 2}, {}, {-1, 5}};
        System.out.println("Before:");
        printArray(array5);
        change(array5);
        System.out.println("After:");
        printArray(array5);
        assert (Arrays.deepEquals(array5, new int[][]{{0, 2}, {}, {5}}));


        int[][] array6 = {{-2, -2, 0}, {-1}, {2, -1, -3}, {-3, 4, -2, 6, 8, -5}};
        System.out.println("Before:");
        printArray(array6);
        change(array6);
        System.out.println("After:");
        printArray(array6);
        assert (Arrays.deepEquals(array6, new int[][]{{0}, {}, {2, -1, -3}, {6, 8, -5}}));
    }


}
