package sudoku_bot_game;

import  java.util.ArrayList;

public class SudokuTile {
    private int number;
    private String state;
    private ArrayList<Integer> suggest;

    public SudokuTile(int number){
        this.number = number;
        if(number != 0){
            state = "in";
            suggest = null;
        }
        else {
            state = "unknown";
            suggest = new ArrayList<Integer>();
            for(int i = 1; i < 10; ++i){
                suggest.add(i);
            }
        }
    }

    public int GetNumber(){
        return number;
    }

    public  String GetState(){
        return  state;
    }
    public ArrayList<Integer> GetSuggest(){
        return suggest;
    }
    public void SetSuggest(ArrayList<Integer> arr){
        suggest = arr;
    }
    public void SetState(String str){
        state = str;
    }
    public void SetNumber(Integer num){
        number = num;
    }
}
