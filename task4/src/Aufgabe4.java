/*
    Aufgabe 4) Eindimensionale Arrays und rekursive Methoden
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static char[] compareTemperatures(int[] lastYear, int[] currentYear, int index) {

        char[] compareTemperatures = new char[currentYear.length];

        //Rekursiven Aufruf bis zum letzten Element
        //Nach dem Ändern, diesen Speicher dem Array vom vorherigen Stack zuweisen und das vorherige Element ändern usw.
        if(index != lastYear.length - 1) {
            compareTemperatures = compareTemperatures(lastYear,currentYear,index + 1);
        }

        if(currentYear[index] > lastYear[index]) {
            compareTemperatures[index] = '>';
        } else if (currentYear[index] < lastYear[index]) {
            compareTemperatures[index] = '<';
        } else {
            compareTemperatures[index] = '=';
        }

        return compareTemperatures;
    }

    private static void shiftLowestHighestValue(int[] workArray, int index) {
        int min = workArray[0];
        int max = workArray[workArray.length - 1];
        int temp;

        if(max < workArray[index]) {
            temp = workArray[workArray.length - 1];
            workArray[workArray.length - 1] = workArray[index];
            workArray[index] = temp;
        }

        if(min > workArray[index]) {
            temp = workArray[0];
            workArray[0] = workArray[index];
            workArray[index] = temp;
        }

        if(index != workArray.length - 1) {
            shiftLowestHighestValue(workArray, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] year22 = {-3, 5, 6, 11, 10, 20, 26, 29, 23, 14, 11, -5};
        int[] year23 = {-3, 3, 7, 11, 10, 19, 27, 33, 21, 16, 16, -6};
        int[] year24 = {-2, 4, 6, 15, 10, 17, 29, 34, 21, 16, 8, 2};

        char[] results1 = compareTemperatures(year22, year23, 0);
        System.out.println(Arrays.toString(results1));
        assert (Arrays.equals(results1, new char[]{'=', '<', '>', '=', '=', '<', '>', '>', '<', '>', '>', '<'}));

        char[] results2 = compareTemperatures(year23, year24, 0);
        System.out.println(Arrays.toString(results2));
        assert (Arrays.equals(results2, new char[]{'>', '>', '<', '>', '=', '<', '>', '>', '=', '=', '<', '>'}));
        System.out.println();

        int[] array1 = {32, 46, 22, 38, 41, 24, 12, 28, 33};
        shiftLowestHighestValue(array1, 0);
        System.out.println(Arrays.toString(array1));
        assert (array1[0] == 12);
        assert (array1[array1.length - 1] == 46);

        array1 = new int[]{32, 46, 22, 38, 41, 24, 12, 28, 33};
        shiftLowestHighestValue(array1, 4);
        System.out.println(Arrays.toString(array1));
        assert (array1[0] == 12);
        assert (array1[array1.length - 1] == 41);

        array1 = new int[]{32, 46, 22, 38, 41, 24, 12, 28, 33};
        shiftLowestHighestValue(array1, 5);
        System.out.println(Arrays.toString(array1));
        assert (array1[0] == 12);
        assert (array1[array1.length - 1] == 33);

        array1 = new int[]{32, 46, 22, 38, 41, 24, 12, 28, 33};
        shiftLowestHighestValue(array1, 7);
        System.out.println(Arrays.toString(array1));
        assert (array1[0] == 28);
        assert (array1[array1.length - 1] == 33);

        int[] array2 = {5, 4, 3, 2, 1};
        shiftLowestHighestValue(array2, 0);
        System.out.println(Arrays.toString(array2));
        assert (array2[0] == 1);
        assert (array2[array2.length - 1] == 5);

        int[] array3 = {7, 2, 10, 5, 3};
        shiftLowestHighestValue(array3, 0);
        System.out.println(Arrays.toString(array3));
        assert (array3[0] == 2);
        assert (array3[array3.length - 1] == 10);

        int[] array4 = {2, 1, 3, 9, 6};
        shiftLowestHighestValue(array4, 0);
        System.out.println(Arrays.toString(array4));
        assert (array4[0] == 1);
        assert (array4[array4.length - 1] == 9);

    }
}
