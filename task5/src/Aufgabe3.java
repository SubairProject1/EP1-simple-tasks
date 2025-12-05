/*
    Aufgabe 3) Zweidimensionale Arrays und Rekursion - Sudoku
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe3 {

    private static final int sSize = 9; //sudoku field size ==> 9x9
    private static final int subSize = 3; //sudoku subfield size ==> 3x3

    private static boolean isNumUsedInBox(int[][] array, int num, int row, int col) {
        
        for(int x = 0; x < subSize; x++) {
            for (int y = 0; y < subSize; y++) {
                if (array[row + y][col + x] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isNumUsedInRow(int[][] array, int num, int row) {

        for(int i = 0; i < sSize; i++) {
            if (array[row][i] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean isNumUsedInCol(int[][] array, int num, int col) {

        for(int i = 0; i < sSize; i++) {
            if (array[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidSudokuSolution(int[][] array) {

        for(int num = 1; num <= 9; num++) {

            for(int row = 0; row < 9; row++) {
               if(!isNumUsedInRow(array, num, row)) {
                   return false;
               }
            }

            for(int col = 0; col < 9; col++) {
                if(!isNumUsedInCol(array, num, col)) {
                    return false;
                }
            }

            for (int y = 0; y <= 6; y += 3) {
                for (int x = 0; x <= 6; x += 3) {
                    if(!isNumUsedInBox(array, num, y, x)) {
                        return false;
                    }
                }
            }
        }
        
        return true; 
    }

    // *********************************** BEREITS IMPLEMENTIERTE METHODEN **************************************
    private static int[][] readArrayFromFile(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int[][] array = new int[sSize][sSize];
        int lineCount = 0;
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String[] values = temp.split(";");
            for (int i = 0; i < values.length; i++) {
                array[lineCount][i] = Integer.parseInt(values[i]);
            }
            lineCount++;
        }
        return array;
    }

    private static boolean solveSudoku(int[][] array, int idx) {
        if (idx > (sSize * sSize - 1)) {
            return true;
        } else {
            int row = idx / sSize;
            int col = idx % sSize;
            if (array[row][col] == 0) {
                for (int num = 1; num <= sSize; num++) {
                    if (!isNumUsedInRow(array, num, row) &&
                            !isNumUsedInCol(array, num, col) &&
                            !isNumUsedInBox(array, num, row - (row % subSize), col - (col % subSize))) {

                        array[row][col] = num;
                        if (solveSudoku(array, idx + 1)) {
                            return true;
                        } else {
                            array[row][col] = 0;
                        }
                    }
                }
            } else {
                return solveSudoku(array, idx + 1);
            }
        }
        return false;
    }

    private static void printArray(int[][] inputArray) {
        for (int y = 0; y < inputArray.length; y++) {
            for (int x = 0; x < inputArray[y].length; x++) {
                System.out.print(inputArray[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    //***********************************************************************************************************

    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "sudoku1.csv"; //sudoku0.csv - sudoku7.csv available!

        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+fileName;
        System.out.println("Reading " + filePath + " ...");
        int[][] sudokuField = readArrayFromFile(filePath);
        printArray(sudokuField);
        
        System.out.println("Sudoku solved: " + solveSudoku(sudokuField, 0));

        System.out.println("Valid solution: " + isValidSudokuSolution(sudokuField));
        printArray(sudokuField);
    }
}

