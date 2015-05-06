import java.io.*;
import java.util.*;

public class comboMoves{
	private int move1;
	private int move2;
 	private int move3;

    //constructor takes value of node
    public comboMoves(int m1, int m2, int m3){
        
        move1 = m1;
        move2 = m2;
        move3 = m3;
    }

    public int getMove1(){
    	return move1;
    }

    public int getMove2(){
    	return move2;
    }

    public int getMove3(){
    	return move3;
    }

    public void setMove1(int m){
    	move1 = m;
    }

    public void setMove2(int m){
    	move2 = m;
    }

    public void setMove3(int m){
    	move3 = m;
    }


}
