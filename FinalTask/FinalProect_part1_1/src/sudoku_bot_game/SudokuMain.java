package sudoku_bot_game;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

import static java.awt.event.KeyEvent.*;
import static sudoku_bot_game.SudokuImage.*;

import java.util.*;


public class SudokuMain {


    static Robot robot;
    static int[][] gamePlace = new int[9][9];
    static Point startPoint = null;
    static SudokuTile[][] tiles = new SudokuTile[9][9];



   static Map<Integer, BufferedImage> map = new HashMap<Integer, BufferedImage>();


    public static void main(String[] args) throws IOException {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.out.println("Error" + e);

        }

        map.put(0, key0);
        map.put(1, key1);
        map.put(2, key2);
        map.put(3, key3);
        map.put(4, key4);
        map.put(5, key5);
        map.put(6, key6);
        map.put(7, key7);
        map.put(8, key8);
        map.put(9, key9);



        SudokuMethods.doScreenshot();
        startPoint = SudokuMethods.searchPoint(start, im);


        int cellsWidth = 0;
        int cellsHeight;
        for(int i = 0; i < 9; ++i){
            cellsHeight = 0;
            for(int j = 0; j < 9; ++j){
                gamePlace[j][i] =  SudokuMethods.match(im, startPoint.x + cellsWidth, startPoint.y + cellsHeight);
                cellsHeight += 43;
            }
            cellsWidth += 43;
        }

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
              tiles[i][j] = new SudokuTile(gamePlace[i][j]);
            }
        }

        SudokuMethods.Solve();
        SudokuMethods.ShowResult();

        cellsWidth = startPoint.x + 21;
        cellsHeight = startPoint.y + 21;
        for(int i = 0; i < 9; ++i){
            cellsHeight = startPoint.y + 21;
            for(int j = 0; j < 9; ++j){

            robot.mouseMove(cellsWidth, cellsHeight);
            robot.mousePress(BUTTON1_DOWN_MASK);
            robot.delay(150);

                int key = tiles[j][i].GetNumber();
                switch (key) {
                    case 1:
                        robot.keyPress(VK_1);
                        break;
                    case 2:
                        robot.keyPress(VK_2);
                        break;
                    case 3:
                        robot.keyPress(VK_3);
                        break;
                    case 4:
                        robot.keyPress(VK_4);
                        break;
                    case 5:
                        robot.keyPress(VK_5);
                        break;
                    case 6:
                        robot.keyPress(VK_6);
                        break;
                    case 7:
                        robot.keyPress(VK_7);
                        break;
                    case 8:
                        robot.keyPress(VK_8);
                        break;
                    case 9:
                        robot.keyPress(VK_9);
                        break;
                }
                robot.mouseRelease(BUTTON1_DOWN_MASK);

                cellsHeight += 43;
            }
            cellsWidth += 43;
        }

    }
}









