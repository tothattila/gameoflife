import com.ericsson.gameoflife.Engine;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/31/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class EngineTest {

    private static final int testBoard[][] = new int[][] { {0,0,0}, {0,1,0}, {1,1,1}};

    @Test
    public void createProperlySizedBoard() {
        Engine testEngine = new Engine(testBoard);
        assertEquals(3,testEngine.getBoardWidth());
        assertEquals(3,testEngine.getBoardHeight());
    }

}
