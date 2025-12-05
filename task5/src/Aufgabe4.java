/*
    Aufgabe 4) Rekursion - Flood Fill Algorithmus
*/

import codedraw.*;
import codedraw.Image;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Aufgabe4 {

    private static int readIntValue(Scanner sc) {

        while(true) {
            if(sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                sc.next();
            }
        }
    }

    private static void floodFill(CodeDraw myDrawObj, int[][] imgArr, int sx, int sy, int gVal, int gThresh) {

        if(!(sx > 0 && sy > 0 && sx < 255 && sy < 255) || imgArr[sy][sx] == -1) {
            return;
        }

        imgArr[sy][sx] = -1;
        myDrawObj.setPixel(sx, sy, Palette.LIME);

        //die Abstände zu Nachbarn
        byte[][] nPixels = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        //mit der foreach-Schleife die Nachbar durchgehen
        for(byte[] nPixel : nPixels) {
            int gValNeighbour = imgArr[sy + nPixel[1]][sx + nPixel[0]];

            if (Math.abs(gVal - gValNeighbour) < gThresh * 2.55d) {
                floodFill(myDrawObj, imgArr, sx + nPixel[0], sy + nPixel[1], gValNeighbour, gThresh);
            }
        }
    }

    // ************************************ BEREITS IMPLEMENTIERTE METHODE **************************************
    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //***********************************************************************************************************

    public static void main(String[] args) {

        String pathImage = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"world.png";

        // open image file
        Image img = Image.fromFile(pathImage);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();
        Scanner myScannerObj = new Scanner(System.in);

        //draw image
        myDrawObj.drawImage(0, 0, img);
        myDrawObj.show();

        // convert rgb image into grayscale array
        int[][] myImage = convertImg2Array(img);

        System.out.println("Please click on an area within the image!");

        while (!myDrawObj.isClosed()) {
            if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();

                //System.out.println("mouseX: " + mouseX + " mouseY: " + mouseY);
                //printArray(myImage,mouseX-10,mouseY-10,mouseX+10,mouseY+10);
                //myDrawObj.drawRectangle(mouseX-10,mouseY-10,20,20);

                // read grayscale value of clicked point and read user info for the grayscale threshold
                System.out.println("Grayvalue of the clicked position x:" + mouseX + " y:" + mouseY + " is:" + myImage[mouseY][mouseX]);

                int grayThreshold = -1;
                do {
                    System.out.println("Please type value between 1-50% for the grayscale threshold: ");
                    grayThreshold = readIntValue(myScannerObj);
                }while(grayThreshold < 1 || grayThreshold > 50);

                floodFill(myDrawObj, myImage, mouseX, mouseY, myImage[mouseY][mouseX], grayThreshold);
                System.out.println("FloodFill finished!");
                myDrawObj.show();
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
        myScannerObj.close();
    }
}


