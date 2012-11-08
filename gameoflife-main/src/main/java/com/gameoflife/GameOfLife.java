package com.gameoflife;

import com.gameoflife.Engine;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLife {

    Engine engine;
    char printChar;

    public GameOfLife(final Engine engine, final char printChar) {
       this.engine = engine;
       this.printChar = printChar;
    }

    public void step(final int count) {
       for (int i=0;i<count;i++) {
           engine.step();
       }
    }

    public void printBoard() {
       for (int row=0;row<engine.getBoardHeight();row++) {
          String printRow = "";
          for (int col=0;col<engine.getBoardWidth();col++) {
             if (engine.getPiece(col,row)>0) {
                printRow += printChar;
             } else {
                printRow += " ";
             }
          }
          System.out.println(printRow);
       }
    }
}
