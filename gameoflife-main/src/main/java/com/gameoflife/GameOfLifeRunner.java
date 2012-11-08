package com.gameoflife;

import com.gameoflife.util.BoardFactory;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/30/12
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLifeRunner {

    public static void main(final String params[]) {
        int stepCount;
        String board;
        try {
           stepCount = Integer.valueOf(params[0]);
           board = params[1];
           BoardFactory factory = new BoardFactory();
           GameOfLife gameOfLife = new GameOfLife(new Engine(factory.parse(board)),'O');
           gameOfLife.step(stepCount);
           gameOfLife.printBoard();
        } catch(NumberFormatException exc)  {
           usage();
        } catch (ArrayIndexOutOfBoundsException exc) {
           usage();
        }
    }

    private static void usage() {
        System.out.println("Usage: command <stepcount> <board>");
        System.out.println("  For example command 15 1,1,0;1,1,0;0,0,0 will do 15 steps on still board");
        System.out.println("        1 1 0");
        System.out.println("        1 1 0");
        System.out.println("        0 0 0");
    }

}
