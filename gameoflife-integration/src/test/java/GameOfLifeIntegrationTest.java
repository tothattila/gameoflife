
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLifeIntegrationTest extends ProcessFixture {


    @Test(groups="integration")
    public void stillBoard0() throws Exception {
        final String board =    "0,0,0;" + //
                                "0,1,0;" + //
                                "0,0,0";
        final String expected = "   " + lineSep + //
                "   " + lineSep + //
                "   " + lineSep;

        assertEquals(expected, executeGameOfLifeAndCollectResults(1, board, "O"));
    }

    /**
     *  OO.
     *  OO.
     *  ...
     */
    @Test(groups="integration")
    public void stillBoard1() throws Exception {
        final String board = "1,1,0;" + //
                             "1,1,0;" + //
                             "0,0,0";
        final String expected = "OO " + lineSep + //
                                "OO " + lineSep + //
                                "   " + lineSep;

        assertEquals(expected, executeGameOfLifeAndCollectResults(1, board, "O"));
        assertEquals(expected, executeGameOfLifeAndCollectResults(2, board, "O"));
        assertEquals(expected, executeGameOfLifeAndCollectResults(3, board, "O"));
    }

    /**
     * .OO.
     * O..O
     * .OO.
     */
    @Test(groups="integration")
    public void stillBoard2() throws Exception  {
       final String board = "0,1,1,0;" + //
                            "1,0,0,1;" + //
                            "0,1,1,0";
       final String expected = " OO " + lineSep + //
                               "O  O" + lineSep + //
                               " OO " + lineSep;

       assertEquals(expected, executeGameOfLifeAndCollectResults(1, board, "O"));
       assertEquals(expected, executeGameOfLifeAndCollectResults(2, board, "O"));
       assertEquals(expected, executeGameOfLifeAndCollectResults(3, board, "O"));
    }


    @Test(groups="integration")
    public void stillBoard3() throws Exception {
        final String board = "1,1,0;" + //
                "1,1,0;" + //
                "0,0,0";
        final String expected = "FF " + lineSep + //
                "FF " + lineSep + //
                "   " + lineSep;

        assertEquals(expected, executeGameOfLifeAndCollectResults(1, board, "F"));
        assertEquals(expected, executeGameOfLifeAndCollectResults(2, board, "F"));
        assertEquals(expected, executeGameOfLifeAndCollectResults(3, board, "F"));
    }

    /**
     * .O.       ...
     * .O.   =>  OOO  => ...
     * .O.       ...
     */
    @Test(groups="integration")
    public void oscillatingBoard1() throws Exception  {
       final String initialBoard = "0,1,0;"+ //
                                   "0,1,0;"+ //
                                   "0,1,0";
       final String step1 = "   " + lineSep + //
                                "OOO" + lineSep + //
                                "   " + lineSep;
       final String step2 = " O " + lineSep + //
                                " O " + lineSep + //
                                " O " + lineSep;

       assertEquals(step1, executeGameOfLifeAndCollectResults(1, initialBoard, "O"));
       assertEquals(step2, executeGameOfLifeAndCollectResults(2, initialBoard, "O"));
       assertEquals(step1, executeGameOfLifeAndCollectResults(3, initialBoard, "O"));
       assertEquals(step2, executeGameOfLifeAndCollectResults(4, initialBoard, "O"));
       assertEquals(step1, executeGameOfLifeAndCollectResults(5, initialBoard, "O"));
       assertEquals(step2, executeGameOfLifeAndCollectResults(6, initialBoard, "O"));
    }

    /**
     * ....    ..O.
     * .OOO    O..O
     * OOO. => O..O  => ...
     * ....    .O..
     */
    @Test(groups="integration")
    public void oscillatingBoard2() throws Exception  {
       final String initialBoard = "0,0,0,0;"+ //
                                   "0,1,1,1;"+ //
                                   "1,1,1,0;"+ //
                                   "0,0,0,0";
       final String expectedStep1 = "  O "+lineSep + //
                                    "O  O"+lineSep + //
                                    "O  O"+lineSep + //
                                    " O  "+lineSep;
       final String expectedStep2 = "    "+lineSep + //
                                    " OOO"+lineSep + //
                                    "OOO "+lineSep + //
                                    "    "+lineSep;

       assertEquals(expectedStep1, executeGameOfLifeAndCollectResults(1, initialBoard, "O"));
       assertEquals(expectedStep2, executeGameOfLifeAndCollectResults(2, initialBoard, "O"));
       assertEquals(expectedStep1, executeGameOfLifeAndCollectResults(3, initialBoard, "O"));
       assertEquals(expectedStep2, executeGameOfLifeAndCollectResults(4, initialBoard, "O"));
       assertEquals(expectedStep1, executeGameOfLifeAndCollectResults(5, initialBoard, "O"));
       assertEquals(expectedStep2, executeGameOfLifeAndCollectResults(6, initialBoard, "O"));
    }

    /**
     * R-pentomino
     *
     * http://conwaylife.com/wiki/index.php?title=R-pentomino
     *
     *
     */

    @Test(groups="integration")
    public void changingBoard1() throws Exception  {
        final String initialBoard = "0,0,0,0,0;"+ //
                                    "0,0,1,1,0;"+ //
                                    "0,1,1,0,0;"+ //
                                    "0,0,1,0,0;"+ //
                                    "0,0,0,0,0";
        final String expectedStep1 = "     " + lineSep + //
                                     " OOO " + lineSep + //
                                     " O   " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep;
        final String expectedStep2 = "  O  " + lineSep + //
                                     " OO  " + lineSep + //
                                     "O  O " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep;
        final String expectedStep3 = " OO  " + lineSep + //
                                     " OOO " + lineSep + //
                                     "O  O " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep;
        final String expectedStep4 = " O O " + lineSep + //
                                     "O  O " + lineSep + //
                                     "O  O " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep;
        final String expectedStep5 = "  O  " + lineSep + //
                                     "OO OO" + lineSep + //
                                     "O  O " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep;

        assertEquals(expectedStep1, executeGameOfLifeAndCollectResults(1, initialBoard, "O"));
        assertEquals(expectedStep2, executeGameOfLifeAndCollectResults(2, initialBoard, "O"));
        assertEquals(expectedStep3, executeGameOfLifeAndCollectResults(3, initialBoard, "O"));
        assertEquals(expectedStep4, executeGameOfLifeAndCollectResults(4, initialBoard, "O"));
        assertEquals(expectedStep5, executeGameOfLifeAndCollectResults(5, initialBoard, "O"));
    }

    /**
     *  Glider
     *
     *  see http://en.wikipedia.org/wiki/Glider_(Conway's_Life)
     */
    @Test(groups="integration")
    public void changingBoard2() throws Exception  {
        final String initialBoard = "1,0,1,0,0;"+ //
                                    "0,1,1,0,0;"+ //
                                    "0,1,0,0,0;"+ //
                                    "0,0,0,0,0;"+
                                    "0,0,0,0,0";
        final String expectedStep1 = "  O  " + lineSep + //
                                     "O O  " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep + //
                                     "     " + lineSep;

        final String expectedStep2 = " O   " + lineSep + //
                                     "  OO " + lineSep + //
                                     " OO  " + lineSep + //
                                     "     " + lineSep + //
                                     "     " + lineSep;

        final String expectedStep3 = "  O  " + lineSep + //
                                     "   O " + lineSep + //
                                     " OOO " + lineSep + //
                                     "     " + lineSep + //
                                     "     " + lineSep;

        final String expectedStep4 = "     " + lineSep + //
                                     " O O " + lineSep + //
                                     "  OO " + lineSep + //
                                     "  O  " + lineSep + //
                                     "     " + lineSep;
        final String expectedStep5 = "     " + lineSep + //
                                     "   O " + lineSep + //
                                     " O O " + lineSep + //
                                     "  OO " + lineSep + //
                                     "     " + lineSep;

        assertEquals(expectedStep1, executeGameOfLifeAndCollectResults(1, initialBoard, "O"));
        assertEquals(expectedStep2, executeGameOfLifeAndCollectResults(2, initialBoard, "O"));
        assertEquals(expectedStep3, executeGameOfLifeAndCollectResults(3, initialBoard, "O"));
        assertEquals(expectedStep4, executeGameOfLifeAndCollectResults(4, initialBoard, "O"));
        assertEquals(expectedStep5, executeGameOfLifeAndCollectResults(5, initialBoard, "O"));
    }

}
