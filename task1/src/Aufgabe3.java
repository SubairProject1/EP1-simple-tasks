import java.awt.*;

/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {

        int width = 7;
        boolean isTrapezoid = true;
        boolean isParallelogram = true;

        // width muss größer als 1 sein
        if(width < 2) {
            isTrapezoid = false;
            isParallelogram = false;
        }

        if (isTrapezoid) {

            int height = width/2;

            for (int row = 1; row <= height; row++) {

                for(int i = 0; i < height - row; i++) {
                    System.out.print(' ');
                }

                int hashAmount = (width % 2) == 0 ? (2 * row) : (2 * row + 1);

                for(int j = 0; j < hashAmount; j++) {
                    System.out.print('#');
                }

                System.out.print('\n');
            }

            System.out.print('\n');
        }

        if (isParallelogram) {

            for(int row = 0; row < width; row++) {

                for(int i = 0; i < row; i++) {
                    System.out.print(' ');
                }

                for(int j = 0; j < width; j++) {

                    if(row == 0 || row == width - 1) {

                        System.out.print('#');

                    } else {

                        if(j == 0 || j == width - 1) {
                            System.out.print('#');
                        } else {
                            System.out.print(' ');
                        }

                    }
                }

                System.out.print('\n');
            }
        }
    }
}
