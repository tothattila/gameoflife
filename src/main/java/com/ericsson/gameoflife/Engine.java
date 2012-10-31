package com.ericsson.gameoflife;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/31/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Engine {

    private int[][] board;
    public Engine(final int[][] seed) {
        board = seed;
    }

    private int getNeighborCount(final int x, final int y) {


       return 0;
    }

    public int getBoardHeight() { return board.length; }
    public int getBoardWidth() { return board[0].length; }

    public int getPiece(final int column, final int row) {
        return -1;
    }

    public void step() {

    }
}
