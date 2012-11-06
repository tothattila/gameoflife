import com.gameoflife.util.BoardFactory;
import org.junit.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardFactoryTest {

    @Test
    public void processSimpleBoard() {
       int[][]result = new BoardFactory().parse("1,0,0;0,1,0;0,0,1;0,0,0;1,0,0");
       assertEquals(5,result.length);
       assertEquals(3,result[0].length);

       assertArrayEquals(new int[]{1, 0, 0}, result[0]);
       assertArrayEquals(new int[]{0, 1, 0}, result[1]);
       assertArrayEquals(new int[]{0, 0, 1}, result[2]);
       assertArrayEquals(new int[]{0, 0, 0}, result[3]);
       assertArrayEquals(new int[]{1, 0, 0}, result[4]);
    }

    @Ignore
    @Test
    public void processIrregularBoard() {
        int[][]result = new BoardFactory().parse("1,0,0;0,1,0;1;0;1,0,0,0,1");
        assertEquals(5,result.length);
        assertEquals(3, result[0].length);

        assertArrayEquals(new int[]{1, 0, 0}, result[0]);
        assertArrayEquals(new int[]{0, 1, 0}, result[1]);
        assertArrayEquals(new int[]{1, 0, 0}, result[2]);
        assertArrayEquals(new int[]{0, 0, 0}, result[3]);
        assertArrayEquals(new int[]{1, 0, 0}, result[4]);
    }

}
