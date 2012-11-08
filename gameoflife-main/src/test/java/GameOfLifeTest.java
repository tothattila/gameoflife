import com.gameoflife.GameOfLife;
import com.gameoflife.Engine;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLifeTest {

    @Mock
    Engine mockEngine;

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final String LINESEP = System.getProperty("line.separator");

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shallStepEngineProperly() {
       GameOfLife testGame = new GameOfLife(mockEngine,'O');
       testGame.step(2);
       verify(mockEngine,times(2)).step();
    }

    @Test
    public void fetchBoardValuesProperlyFromEngine() {
       System.setOut(new PrintStream(output));
       when(mockEngine.getBoardHeight()).thenReturn(2);
       when(mockEngine.getBoardWidth()).thenReturn(3);
       when(mockEngine.getPiece(0,0)).thenReturn(1);
       when(mockEngine.getPiece(1,0)).thenReturn(0);
       when(mockEngine.getPiece(2,0)).thenReturn(1);
       when(mockEngine.getPiece(0,1)).thenReturn(0);
       when(mockEngine.getPiece(1,1)).thenReturn(1);
       when(mockEngine.getPiece(2,1)).thenReturn(0);
       GameOfLife testGame = new GameOfLife(mockEngine,'O');
       testGame.printBoard();
       assertEquals("O O" + LINESEP + " O " + LINESEP, output.toString());
       System.setOut(null);
    }

}
