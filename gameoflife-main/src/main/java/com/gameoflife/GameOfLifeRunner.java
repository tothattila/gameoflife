package com.gameoflife;

import com.gameoflife.util.BoardFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/30/12
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLifeRunner {

    private static final String BOARD ="-board";
    private static final String STEPCOUNT ="-step";


    public static void main(final String params[]) {
        try {
           Map<String,String> paramMap=readParams(params);
           BoardFactory factory = new BoardFactory();
            String board=paramMap.get(BOARD);
            if(board==null){
                usage();
            }
            Integer stepCount=Integer.parseInt(paramMap.get(STEPCOUNT));

           GameOfLife gameOfLife = new GameOfLife(new Engine(factory.parse(board)),'O');
           gameOfLife.step(stepCount);
           gameOfLife.printBoard();
        } catch(NumberFormatException exc)  {
           usage();
        } catch (ArrayIndexOutOfBoundsException exc) {
           usage();
        }
    }

    private static Map<String,String> readParams(String[] params) {
        Map result = new HashMap<String,String>();
        for(int i=0; (i+1) < params.length;i +=2){
            String name=params[i];
            String val=params[i+1];
            result.put(name,val);
        }
        if(params.length % 2 == 1){
           System.out.println("WARNING: the number of parameters is odd:"+params.length);
        }
        return result;
    }

    private static void usage() {
        System.out.println("Usage: command <stepcount> <board>");
        System.out.println("  For example command -step 15 -board 1,1,0;1,1,0;0,0,0 will do 15 steps on still board");
        System.out.println("        1 1 0");
        System.out.println("        1 1 0");
        System.out.println("        0 0 0");
    }

}
