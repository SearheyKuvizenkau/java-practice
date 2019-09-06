package sudoku_bot_game;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

import static sudoku_bot_game.SudokuMain.robot;



class SudokuMethods {
    
    static void doScreenshot() throws IOException {
        SudokuImage.im = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(SudokuImage.im, "png", new File("screenshot.png"));
    }

    public static Point searchPoint( BufferedImage subimage, BufferedImage screenshot) {

            for (int i = 0; i < screenshot.getWidth()  - subimage.getWidth(); i++) {

                check_subimage:

                for (int j = 0; j < screenshot.getHeight() - subimage.getHeight(); j++) {
                    for (int ii = 0; ii < subimage.getWidth(); ii++) {
                        for (int jj = 0; jj < subimage.getHeight(); jj++) {
                            if (subimage.getRGB(ii, jj) != screenshot.getRGB(i + ii, j + jj)) {
                                continue check_subimage;
                            }
                        }
                    }
                    return new Point(i,j);
                }
            }
     return new Point(-1, -1);
    }

    static int steps = 0;
   

    public static int match( BufferedImage image, int startX, int startY) {
        int num = -1;

        outer_for:

        for (Map.Entry<Integer, BufferedImage> pair : SudokuMain.map.entrySet()) {

            for (int i = startX; i <= startX + 42 - pair.getValue().getWidth(); i++) {

                check_subimage:

                for (int j = startY; j <= startY + 42 - pair.getValue().getHeight(); j++) {
                    for (int ii = 0; ii < pair.getValue().getWidth(); ii++) {
                        for (int jj = 0; jj < pair.getValue().getHeight(); jj++) {
                            if (pair.getValue().getRGB(ii, jj) != image.getRGB(i + ii, j + jj)) {
                                continue check_subimage;
                            }
                        }
                    }

                //robot.mouseMove(i, j);
                    num = pair.getKey();
                    break outer_for;
                }
            }
        }
        return num;
    }

    static  void Solve(){
        int changed = 0;
        do {
            changed = UpdateSuggests();
            steps++;
            if ( 81 < steps ) {
                break;
            }
        } while (changed != 0);

    }

    static int UpdateSuggests(){

        int changed = 0;
        ArrayList<Integer> buf = ArrayDiff(SudokuMain.tiles[1][3].GetSuggest(), RowContent(1));
        buf = ArrayDiff(buf, ColContent(3));
        buf = ArrayDiff(buf, SectionContent(1,3));
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(SudokuMain.tiles[i][j].GetState() != "unknown"){
                    continue;
                }
                changed += SolveSingle(i,j);
                changed += SolveHiddenSingle(i,j);
            }
        }
        return  changed;
    }

    static ArrayList<Integer> RowContent(int i){
        ArrayList<Integer> rowContent = new ArrayList<Integer>();
        for(int j = 0; j < 9; ++j){
            if(SudokuMain.tiles[i][j].GetState() != "unknown"){
                rowContent.add(SudokuMain.tiles[i][j].GetNumber());
            }
        }
        return rowContent;
    }

    static ArrayList<Integer> ColContent(int j){
        ArrayList<Integer> colContent = new ArrayList<Integer>();
        for(int i = 0; i < 9; ++i){
            if(SudokuMain.tiles[i][j].GetState() != "unknown"){
                colContent.add(SudokuMain.tiles[i][j].GetNumber());
            }
        }
        return colContent;
    }

    static ArrayList<Integer> SectionContent(int i, int j){
        Point offset = SectionOffset(i, j);
        ArrayList<Integer> sectContent = new ArrayList<Integer>();
        for(int k = 0; k < 3; ++k){
            for(int l = 0; l < 3; ++l){
                if(SudokuMain.tiles[offset.x + k][offset.y + l].GetState() != "unknown"){
                    sectContent.add(SudokuMain.tiles[offset.x + k][offset.y + l].GetNumber());
                }
            }
        }
        return sectContent;
    }

    static ArrayList<Integer> ArrayDiff(ArrayList<Integer> arr1, ArrayList<Integer> arr2){

        ArrayList<Integer> arrayDifference = new ArrayList<Integer>();
       // System.out.println("size= " + arr2.size());
        for(int i = 0; i < arr1.size(); ++i){
            boolean isFound = false;

            for(int j = 0; j < arr2.size(); ++j){
                if(arr1.get(i) == arr2.get(j)){
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                arrayDifference.add(arr1.get(i));
            }
        }
        return arrayDifference;
    }

    static Point SectionOffset(int i, int j){

        Point offset = new Point((int)Math.floor(i/3)*3, (int) Math.floor(j/3)*3);
        return offset;
    }

    static int SolveSingle(int i, int j){
        SudokuMain.tiles[i][j].SetSuggest(ArrayDiff(SudokuMain.tiles[i][j].GetSuggest(), RowContent(i)));
        SudokuMain.tiles[i][j].SetSuggest(ArrayDiff(SudokuMain.tiles[i][j].GetSuggest(), ColContent(j)));
        SudokuMain.tiles[i][j].SetSuggest(ArrayDiff(SudokuMain.tiles[i][j].GetSuggest(), SectionContent(i,j)));
        if(SudokuMain.tiles[i][j].GetSuggest().size() == 1){
            MarkSolved(i, j, SudokuMain.tiles[i][j].GetSuggest().get(0));
            return 1;
        }
        else  return  0;
    }

    static int SolveHiddenSingle(int i, int j){
        ArrayList<Integer> lessSuggest = LessRowSuggest(i,j);
        int changed = 0;
        if(lessSuggest.size() == 1){
            MarkSolved(i,j, lessSuggest.get(0));
            changed++;
        }
        lessSuggest = LessColSuggest(i,j);
        if(lessSuggest.size() == 1){
            MarkSolved(i,j, lessSuggest.get(0));
            changed++;
        }
        lessSuggest = LessSectSuggest(i,j);
        if(lessSuggest.size() == 1){
            MarkSolved(i,j, lessSuggest.get(0));
            changed++;
        }
        return  changed;
    }

    static void MarkSolved(int i, int j, int solve){
        SudokuMain.tiles[i][j].SetNumber(solve);
        SudokuMain.tiles[i][j].SetState("solved");
    }

    static  ArrayList<Integer> LessRowSuggest(int i, int j){
        ArrayList<Integer> lessSuggest = SudokuMain.tiles[i][j].GetSuggest();
        for(int k = 0; k < 9; ++k){
            if(k == j || SudokuMain.tiles[i][k].GetState() != "unknown"){
                continue;
            }
           // System.out.println("LessRow");
           // System.out.println("array " + SudokuMain.tiles[i][k].GetSuggest().size());
            lessSuggest = ArrayDiff(lessSuggest, SudokuMain.tiles[i][k].GetSuggest());
        }
        return lessSuggest;
    }

    static  ArrayList<Integer> LessColSuggest(int i, int j){
        ArrayList<Integer> lessSuggest = SudokuMain.tiles[i][j].GetSuggest();
        for(int k = 0; k < 9; ++k){
            if(k == i || SudokuMain.tiles[k][j].GetState() != "unknown"){
                continue;
            }
           // System.out.println("LessCol");
            lessSuggest = ArrayDiff(lessSuggest, SudokuMain.tiles[k][j].GetSuggest());
        }
        return lessSuggest;
    }
    static  ArrayList<Integer> LessSectSuggest(int i, int j){
        ArrayList<Integer> lessSuggest = SudokuMain.tiles[i][j].GetSuggest();
        Point offset = SectionOffset(i, j);
        for(int k = 0; k < 3; ++k){
            for(int l = 0; l < 3; ++l){
                if( ((offset.x+k) == i  && (offset.y+l) == j)|| "unknown" != SudokuMain.tiles[offset.x+k][offset.y+l].GetState()){
                    continue;
                }
             //   System.out.println("LessSect");
            lessSuggest = ArrayDiff(lessSuggest, SudokuMain.tiles[offset.x +k][offset.y + l].GetSuggest());
        }
        }
        return lessSuggest;
    }

    static void ShowResult(){
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                System.out.print (SudokuMain.tiles[i][j].GetNumber());
            }
            System.out.println();
        }
    }
}










