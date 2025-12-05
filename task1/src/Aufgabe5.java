/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe5 {

    public static void main(String[] args) {

        int n = 11;
        if(4 < n && n < 20 && n%2 == 0) {

            System.out.println("n is supposed to be less than 20, but greater than 4 and even!");

        } else {

            int width = 300;
            int nHalf = n/2;
            CodeDraw myDrawObj = new CodeDraw(width, width);
            double circleDiameter = (double) width/n;
            double circleRadius = circleDiameter/2;

            myDrawObj.setLineWidth(6);
            myDrawObj.setColor(Palette.RED);

            //red
            for(int xPos = 0; xPos < nHalf; xPos++) {
                myDrawObj.drawCircle(circleRadius + circleDiameter * xPos, circleRadius, circleRadius);
                myDrawObj.drawCircle(width - (circleRadius + circleDiameter * xPos), circleRadius + circleDiameter * (n - 1), circleRadius);
            }

            for(int yPos = 0; yPos < n; yPos++) {
                myDrawObj.drawCircle(circleRadius + circleDiameter * nHalf, circleRadius + circleDiameter * yPos, circleRadius);
            }

            //blue
            myDrawObj.setLineWidth(2);
            myDrawObj.setColor(Palette.BLUE);

            for(int yPos = 1; yPos < nHalf; yPos++) {
                myDrawObj.drawCircle(circleRadius, circleRadius + circleDiameter * yPos, circleRadius);
            }

            for(int xPos = 0; xPos < n; xPos++) {
                if(xPos == nHalf) {
                    continue;
                }
                myDrawObj.drawCircle(circleRadius + circleDiameter * xPos, circleRadius + circleDiameter * nHalf, circleRadius);
            }

            //orange
            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.drawCircle((n+1)/2 * circleRadius, (n+1)/2 * circleRadius, (n-2)/2 * circleRadius);
            myDrawObj.show();
        }
    }
}