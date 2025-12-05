/*
    Aufgabe 1) Zweidimensionale Arrays und Gameplay - Sokoban
*/

import codedraw.*;
import codedraw.Image;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe1 {
    private static final int SQUARE_SIZE = 40;

    // reads levels from file / first line is number of levels
    private static String[] readLevels(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int numberOfLevels = sc.nextInt();
        int counter = -1; // starts at -1 because first line is empty after reading int
        String[] levels = new String[numberOfLevels];
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                levels[++counter] = "";
            } else {
                levels[counter] += line + "\n";
            }
        }
        return levels;
    }

    // returns level as char array and fills goal positions into goals array
    private static char[][] newLevel(int[][] goals, String levelString) {
        // calculate array size
        int xSize = 0;
        int ySize = 0;
        int counter = 0;

        for (int i = 0; i < levelString.length(); i++) {
            if (levelString.charAt(i) == '\n') {
                ySize++;
                if (counter > xSize) {
                    xSize = counter;
                }
                counter = 0;
            } else {
                counter++;
            }
        }

        // fill array and goals
        char[][] levelArr = new char[ySize][xSize];
        int goalCounter = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < levelString.length(); i++) {
            char item = levelString.charAt(i);
            switch (item) {
                case '.':
                    levelArr[y][x] = ' ';
                    goals[goalCounter++] = new int[]{x, y};
                    x++;
                    break;
                case '\n':
                    y++;
                    x = 0;
                    break;
                case '#':
                case '$':
                case '@':
                case ' ':
                    levelArr[y][x] = item;
                    x++;
                    break;
                default:
                    break;
            }
        }
        return levelArr;
    }

    // calculates based on the current position and the direction the new position coordinates
    private static int[] adjacentPosition(int[] position, int direction) {
        return switch (direction) {
            case 1 -> new int[]{position[0], position[1] - 1};
            case 2 -> new int[]{position[0], position[1] + 1};
            case 3 -> new int[]{position[0] - 1, position[1]};
            case 4 -> new int[]{position[0] + 1, position[1]};
            default -> new int[]{-1, -1};
        };
    }

    // helping method for writing text in the CodeDraw window
    private static void showText(CodeDraw myDrawObj, double x, double y, String text) {
        myDrawObj.clear(Color.white);
        myDrawObj.setColor(Color.black);
        myDrawObj.drawText(x, y, text);
        myDrawObj.show();
    }

    // returns the total number of goals in the level
    private static int numberOfGoals(String levelString) {
        int count = 0;

        for(int i = 0; i < levelString.length(); i++) {
            if(levelString.charAt(i) == '.') {
                count++;
            }
        }

        return count;
    }

    // returns position of the figure. [0] = x, [1] = y
    private static int[] figurePosition(char[][] level) {

        for(int i = 0; i < level.length; i++) {
            for(int j = 0; j < level[i].length; j++) {
                if(level[i][j] == '@') {
                    return new int[]{j, i};
                }
            }
        }

        //to satisfy the compiler, but it will never reach this
        throw new IllegalStateException("The '@' character was not found in the provided level");
    }

    // moves figure and box if they don't hit an obstacle
    // returns true if figure was moved
    private static boolean move(char[][] level, int direction) {
        int[] playerPos = figurePosition(level);
        int[] nextField = adjacentPosition(playerPos, direction);

        if(level[nextField[1]][nextField[0]] == '$') {
            int[] behindBox = adjacentPosition(nextField, direction);

            if(level[behindBox[1]][behindBox[0]] == ' ') {
                level[behindBox[1]][behindBox[0]] = '$';
                level[playerPos[1]][playerPos[0]] = ' ';
                level[nextField[1]][nextField[0]] = '@';
                return true;
            }

        } else if(level[nextField[1]][nextField[0]] == ' ') {
            level[playerPos[1]][playerPos[0]] = ' ';
            level[nextField[1]][nextField[0]] = '@';
            return true;
        }

        return false;
    }

    // returns current position of all boxes
    private static int[][] boxPositions(char[][] level, int numberOfBoxes) {

        //with only numberOfBoxes also possible but it's better to start counting up (from 0) than counting down (from numberOfBoxes)
        //because the coordinates of the very first box will be compared to those of the very first endPoint, so counting down would
        //mess up the comparison

        int counter = 0;
        int[][] boxPositions = new int[numberOfBoxes][2];

        for(int i = 0; i < level.length; i++) {
            for(int j = 0; j < level[i].length; j++) {
                if(level[i][j] == '$') {
                    boxPositions[counter] = new int[]{j, i};
                    counter++;
                }
            }
        }

        return boxPositions;
    }

    // returns true if all boxes are on a goal
    private static boolean won(char[][] level, int[][] goals) {
        int boxCounter = 0;

        for(int i = 0; i < level.length; i++) {
            for(int j = 0; j < level[i].length; j++) {
                if(level[i][j] == '$') {
                    boxCounter++;
                }
            }
        }

        int[][] boxPositions = boxPositions(level, boxCounter);

        for(int i = 0; i < boxCounter; i++) {
            //once a box is found that isn't on endPoint, the level isn't finished yet
            if(!(boxPositions[i][0] == goals[i][0] && boxPositions[i][1] == goals[i][1])) {
                return false;
            }
        }

        return true;
    }

    // draws the current level with all elements
    private static void drawGame(CodeDraw myDrawObj, char[][] level, int[][] goals, int direction) {
        Image imgPlayer;
        Image imgWall = Image.fromFile("src/wall.png");
        Image imgBox = Image.fromFile("src/box.png");
        Image imgBoxGoal = Image.fromFile("src/box_goal.png");
        Image imgEndPoint = Image.fromFile("src/endpoint.png");

        switch(direction) {
            case 1:
                imgPlayer = Image.fromFile("src/figure_up.png");
                break;
            case 3:
                imgPlayer = Image.fromFile("src/figure_left.png");
                break;
            case 4:
                imgPlayer = Image.fromFile("src/figure_right.png");
                break;
            default:
                imgPlayer = Image.fromFile("src/figure_down.png");
                break;
        }

        for(int i = 0; i < level.length; i++) {
            for(int j = 0; j < level[i].length; j++) {
                switch(level[i][j]) {
                    case ' ':
                        myDrawObj.setColor(Color.WHITE);
                        myDrawObj.fillSquare(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE);

                        //endPoints
                        for (int k = 0; k < goals.length; k++) {
                            if(goals[k][1] == i &&  goals[k][0] == j) {
                                myDrawObj.drawImage(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, imgEndPoint);
                            }
                        }

                        break;
                    case '#':
                        myDrawObj.drawImage(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, imgWall);
                        break;
                    case '$':
                        myDrawObj.drawImage(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, imgBox);

                        //if true, overwrite normal box image with goalbox image
                        for (int k = 0; k < goals.length; k++) {
                            if(goals[k][1] == i &&  goals[k][0] == j) {
                                myDrawObj.drawImage(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, imgBoxGoal);
                            }
                        }

                        break;
                    case '@':
                        myDrawObj.drawImage(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, imgPlayer);
                        break;
                    default:
                        return;
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "sokoban_levels.csv";  // all levels for sokoban
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName;
        String[] allLevels = readLevels(filePath); //read all levels

        int levelId = 0;
        int[][] goals = new int[numberOfGoals(allLevels[levelId])][];//extract all goals of the first level
        char[][] level = newLevel(goals, allLevels[levelId]);//generate the first level as char array
        boolean gameRunning = true;
        int moveDirection = 0;
        int stepsLevel = 0;
        int stepsTotal = 0;

        CodeDraw myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
        myDrawObj.setTitle("Sokoban");
        TextFormat format = myDrawObj.getTextFormat();
        format.setTextOrigin(TextOrigin.CENTER);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        drawGame(myDrawObj, level, goals, moveDirection);
        myDrawObj.show();

        while (gameRunning) {
            // direction -> key: up, down, left and right
            // restart -> key r
            // to next level -> key t
            // quit -> key q
            if (myEventSC.hasKeyDownEvent()) {
                Key currentKey = myEventSC.nextKeyDownEvent().getKey();
                System.out.println("Last KEY pressed: " + currentKey);
                if (currentKey == Key.UP) {
                    moveDirection = 1;
                } else if (currentKey == Key.DOWN) {
                    moveDirection = 2;
                } else if (currentKey == Key.LEFT) {
                    moveDirection = 3;
                } else if (currentKey == Key.RIGHT) {
                    moveDirection = 4;
                } else if (currentKey == Key.R) { // reset current level
                    stepsLevel = 0;
                    goals = new int[numberOfGoals(allLevels[levelId])][];
                    level = newLevel(goals, allLevels[levelId]);
                    drawGame(myDrawObj, level, goals, moveDirection);
                } else if (currentKey == Key.T) { // skip to next level
                    if (levelId < allLevels.length - 1) {
                        stepsLevel = 0;
                        levelId++;
                        goals = new int[numberOfGoals(allLevels[levelId])][];
                        level = newLevel(goals, allLevels[levelId]);
                        myDrawObj.close();
                        myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
                        myDrawObj.setTitle("Sokoban");
                        myEventSC = myDrawObj.getEventScanner();
                        drawGame(myDrawObj, level, goals, moveDirection);
                    } else { // end game
                        gameRunning = false;
                        showText(myDrawObj, level.length * SQUARE_SIZE / 2.0, level[0].length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                    }
                } else if (currentKey == Key.Q) { // quit game
                    gameRunning = false;
                }
            } else {
                myEventSC.nextEvent();
            }

            if (moveDirection != 0) {
                if (move(level, moveDirection)) {
                    stepsLevel++;
                    stepsTotal++;
                }
                drawGame(myDrawObj, level, goals, moveDirection);
                moveDirection = 0;
                if (won(level, goals)) {
                    showText(myDrawObj, level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "Steps: " + stepsLevel);
                    myDrawObj.show(2000);
                    stepsLevel = 0;
                    if (levelId < allLevels.length - 1) { // load next level
                        levelId++;
                        goals = new int[numberOfGoals(allLevels[levelId])][];
                        level = newLevel(goals, allLevels[levelId]);
                        myDrawObj.close();
                        myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
                        myDrawObj.setTitle("Sokoban");
                        myEventSC = myDrawObj.getEventScanner();
                        drawGame(myDrawObj, level, goals, moveDirection);
                        myDrawObj.show();
                    } else { // end game
                        gameRunning = false;
                        showText(myDrawObj, level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                        myDrawObj.show(2000);
                    }
                }
                System.out.println("Steps Level: " + stepsLevel + " Steps Total: " + stepsTotal);
            }
            myDrawObj.show();
        }
        myDrawObj.close();
    }
}
