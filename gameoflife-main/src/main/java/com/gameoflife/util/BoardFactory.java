package com.gameoflife.util;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardFactory {
    public int[][] parse(final String inputString) {
        final String[] rows = inputString.split(";");
        final String firstRow = rows[0];
        final int width = firstRow.split(",").length;
        final int height = rows.length;

        final int[][] result = new int[height][width];

        for (int rowCount = 0;rowCount<rows.length;rowCount++) {
            String[] col = rows[rowCount].split(",");
            for (int colCount=0;colCount<col.length;colCount++) {
                if (col[colCount].equals("1")) {
                    result[rowCount][colCount] = 1;
                } else {
                    result[rowCount][colCount] = 0;
                }
            }
        }
        return result;
    }

}
