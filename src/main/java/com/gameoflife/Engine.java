package com.gameoflife;

import com.gameoflife.util.Mark;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/31/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Engine {

    private static final int FIRST_ROW = 0;
    private int[][] board;
    private final ArrayList<Mark> markList;
    private int width;
    private int height;
    private static final int DEAD = 0;
    private static final int LIVE = 1;

    public Engine(final int[][] seed) {
        board = seed;
        width = board[FIRST_ROW].length;
        height = board.length;
        markList = new ArrayList<Mark>();
    }

    private int getNeighborCount(final int column, final int row) {
        return getPiece(column-1,row-1) + getPiece(column,row-1) + getPiece(column+1,row-1) + getPiece(column-1,
                row) + getPiece(column+1,row) + getPiece(column-1,row+1) + getPiece(column,row+1) + getPiece(column+1,row+1);
    }

    private void setPiece(final int column, final int row, final int value) {
       board[row][column] = value;
    }

    public int getBoardHeight() { return height; }
    public int getBoardWidth() { return width; }

    public int getPiece(final int column, final int row) {
        if ((row>=0) && (row<height) && (column>=0) && (column<width)) {
            return board[row][column];
        }
        else
        {
            return 0;
        }
    }

    public void step() {
        for (int colIndex = 0 ; colIndex<width ; colIndex++) {
           for (int rowIndex = 0 ; rowIndex<height ; rowIndex++) {
              setNewState(colIndex, rowIndex, getNeighborCount(colIndex,rowIndex));
           }
       }
       setMarks(markList);
       markList.clear();
    }

    private void setMarks(ArrayList<Mark> marks) {
        for(Mark m:marks) {
           setPiece(m.getX(),m.getY(),m.getValue());
       }
    }

    private void setNewState(int column, int row, int neighborCount) {
        switch (getPiece(column, row)) {
            case DEAD: if (neighborCount > 2) {
                          markList.add(new Mark(column, row, LIVE));
                      }
                break;
            case LIVE: if ((neighborCount ==1) || (neighborCount > 3)) {
                          markList.add(new Mark(column, row, DEAD));
                      }
                break;
        }
    }

}
