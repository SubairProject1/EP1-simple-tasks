/*
    Aufgabe 5) Designaufgabe
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import java.awt.*;

public class Aufgabe5 {

    private static void drawCloud(CodeDraw myDrawObj, double size, double xOffset, double yOffset) {
        //leider hard-coded, aber stellt sicher, dass die Wolken wieder links auftauchen
        xOffset = (xOffset % 900) - 200;
        myDrawObj.fillCircle(9     * size + xOffset, 14    * size + yOffset, 2    * size);
        myDrawObj.fillCircle(11.5d * size + xOffset, 15    * size + yOffset, 2    * size);
        myDrawObj.fillCircle(13    * size + xOffset, 15    * size + yOffset, 1.5d * size);
        myDrawObj.fillCircle(7.5d  * size + xOffset, 14.5d * size + yOffset, 1.5d * size);
        myDrawObj.fillCircle(7.5d  * size + xOffset, 14.5d * size + yOffset, 1.5d * size);
    }

    private static void drawStar(CodeDraw myDrawObj, int x, int y) {
        myDrawObj.drawLine(x, y - 5, x, y);
        myDrawObj.drawLine(x - 4, y - 2, x, y);
        myDrawObj.drawLine(x + 4, y - 2, x, y);
        myDrawObj.drawLine(x - 3, y + 3, x, y);
        myDrawObj.drawLine(x + 3, y + 3, x, y);
    }

    private static int mathClamp(int minVal, int maxVal, int val) {
        if(val > maxVal) {
            return maxVal;
        } else if(val < minVal) {
            return minVal;
        } else {
            return val;
        }
    }

    public static void main(String[] args) {
        int width = 700;
        int height = 500;
        CodeDraw myDrawObj = new CodeDraw(width, height);
        int offsetMovement = 0;
        int sunPosY = 210;
        boolean sunRise = false;
        int colorR = 0;

        while(true) {
            myDrawObj.clear();

            //sky
            myDrawObj.setColor(new Color(55, mathClamp(70, 255,  416 - sunPosY), mathClamp(100, 255, 465 - sunPosY)));
            myDrawObj.fillRectangle(0, 0, width, height);

            //Sun
            myDrawObj.setColor(Palette.YELLOW);

            if(sunPosY <= 210) {
                sunRise = false;
            } else if (sunPosY >= 500) {
                sunRise = true;
            }

            sunPosY = sunRise ? sunPosY - 2 : sunPosY + 2;
            myDrawObj.fillCircle(width/2, sunPosY, 60);


            //stars
            myDrawObj.setColor(new Color(255, 255, 0, mathClamp(0, 255, -180 + sunPosY)));
            for(int y = 10; y <= height - 10; y += 40) {
                for(int x = 10; x <= width - 10; x += 40) {
                    if((x + y) % 100 == 0) {
                        drawStar(myDrawObj, x, y);
                    }
                }
            }

            //grass ground
            myDrawObj.setColor(Palette.LAWN_GREEN);
            myDrawObj.fillEllipse(width/2, height, width/2, width/6);

            //clouds
            myDrawObj.setColor(Palette.WHITE);

            drawCloud(myDrawObj, 5, 0  + offsetMovement, 60);
            drawCloud(myDrawObj, 8, 10 + offsetMovement, 15);
            drawCloud(myDrawObj, 4, 50 + offsetMovement, 110);

            drawCloud(myDrawObj, 11, 210 + offsetMovement, 80);
            drawCloud(myDrawObj, 7, 310  + offsetMovement, 90);

            drawCloud(myDrawObj, 3, 580 + offsetMovement, 170);
            drawCloud(myDrawObj, 4, 580 + offsetMovement, 150);
            drawCloud(myDrawObj, 6, 500 + offsetMovement, 105);

            offsetMovement++;
            myDrawObj.show();
        }
    }
}