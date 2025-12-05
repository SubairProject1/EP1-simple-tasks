/*
    Aufgabe 5) Quadrate => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe5 {

    private static void drawPatternRecursively(CodeDraw myDrawObj, int x, int y, int s, boolean c) {
        if(s < 4) {
            return;
        }

        drawPatternRecursively(myDrawObj, x - s/2, y - s/2, s/2, !c);
        drawPatternRecursively(myDrawObj, x + s/2, y - s/2, s/2, !c);
        drawPatternRecursively(myDrawObj, x - s/2, y + s/2, s/2, !c);
        drawPatternRecursively(myDrawObj, x + s/2, y + s/2, s/2, !c);

        myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
        myDrawObj.fillSquare(x - s/2, y - s/2, s);
    }

    // Iterative Version => ChatGPT 3.5 generiert (nur Aufrufe für Zeichenmethoden und Farben setzen wurden angepasst)
    public static void drawPatternIteratively(CodeDraw myDrawObj, int width) {
        int s = width;
        boolean c = true;

        while (s >= 4) {
            myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
            myDrawObj.fillSquare(width / 2, width / 2, s);

            int halfSize = s / 2;

            // Zeichne Quadrate in den vier Diagonalrichtungen
            myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
            myDrawObj.fillSquare(width / 2 - halfSize, width / 2 - halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 + halfSize, width / 2 - halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 - halfSize, width / 2 + halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 + halfSize, width / 2 + halfSize, halfSize);

            s /= 2;
            c = !c;
        }
    }

    public static void myDrawPatternIteratively(CodeDraw myDrawObj, int width) {
        //decadic logarithm
        boolean c = (Math.log(width)/Math.log(2)) % 2 == 1;

        //s starts with the size of the smallest squares, so the bigger ones will be placed in front afterwards
        for(int s = 8; s <= width; s *= 2) {
            myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);

            for(int y = s/2; y < width; y += s) {
                for(int x = s/2; x < width; x += s) {
                    myDrawObj.fillSquare(x - s/4, y - s/4, s/2);
                }
            }

            c = !c;
        }
    }

    public static void main(String[] args) {

        int pixelWidth = 512;
        int pixelHeight = 512;

        CodeDraw myDrawObjR = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjR.setTitle("Output Recursive Method");
        myDrawObjR.setCanvasPositionX(100);
        myDrawObjR.setCanvasPositionY(100);
        CodeDraw myDrawObjI = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjI.setTitle("Output Iterative Method");
        myDrawObjI.setCanvasPositionX(650);
        myDrawObjI.setCanvasPositionY(100);


        drawPatternRecursively(myDrawObjR, pixelWidth / 2, pixelHeight / 2, pixelWidth / 2, true);
        myDrawObjR.show();
        //drawPatternIteratively(myDrawObjI, pixelWidth);
        myDrawPatternIteratively(myDrawObjI, pixelWidth);
        myDrawObjI.show();
    }
}