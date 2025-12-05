/*
    Aufgabe 1) Verschachtelte Schleifen - Optische Täuschung
*/
import codedraw.CodeDraw;
import codedraw.Palette;
import java.awt.*;

public class Aufgabe1 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(40 * 10, 40 * 11);
        Color color;

        //quads
        for(int row = 0; row < 11; row++) {
            for(int column = 0; column < 10; column++) {
                color = (row + column) % 2 == 0 ? new Color(166, 166, 76) : new Color(90, 90, 0);
                myDrawObj.setColor(color);
                myDrawObj.fillRectangle(40 * column, 40 * row, 40, 40);
            }
        }

        int OFFSET_X;
        int OFFSET_Y;
        int WIDTH;
        int HEIGHT;
        boolean isEvenSum;

        //rects
        for(int row = 0; row < 10; row++) {
            for(int column = 0; column < 9; column++) {

                isEvenSum = (row + column) % 2 == 0;

                OFFSET_X = isEvenSum ? 30 : 38;
                OFFSET_Y = isEvenSum ? 38 : 30;
                WIDTH    = isEvenSum ? 20 : 4;
                HEIGHT   = isEvenSum ? 4 : 20;

                //schwarze Rechtecke müssen vor den weißen abgebildet werden
                myDrawObj.setColor(Palette.WHITE);
                myDrawObj.fillRectangle(OFFSET_X + 40 * column, OFFSET_Y + 40 * row, WIDTH, HEIGHT);
                myDrawObj.setColor(Palette.BLACK);
                myDrawObj.fillRectangle(OFFSET_Y + 40 * column, OFFSET_X + 40 * row, HEIGHT, WIDTH);
            }
        }

        myDrawObj.show();
    }
}
