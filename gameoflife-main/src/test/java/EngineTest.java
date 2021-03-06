import com.gameoflife.Engine;
import org.testng.annotations.Test;

import java.io.Serializable;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/31/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class EngineTest {

    private Engine testEngine;

    @Test
    public void createProperlySizedBoard() {
        testEngine = new Engine(new int[][] { {0,0,0,0,0},
                                              {0,1,0,0,0},
                                              {1,1,1,0,0}});
        assertEquals(5,testEngine.getBoardWidth());
        assertEquals(3,testEngine.getBoardHeight());
    }

    @Test
    public void testUnderPopulationRule() {
        testEngine = new Engine(new int[][] { {1,0,0},
                                              {0,1,0},
                                              {0,0,0}});
        testEngine.step();
        assertEquals(0,testEngine.getPiece(1, 1));

    }

    @Test
    public void testStayAliveRule() {
       testEngine = new Engine(new int[][] { {1,0,0},
                                             {0,1,0},
                                             {0,0,1}});
        testEngine.step();
        assertEquals(1,testEngine.getPiece(1,1));
    }

    @Test
    public void testOverCrowdingRule() {
        testEngine = new Engine(new int[][] { {0,0,1},
                                              {1,1,1},
                                              {1,0,0}});
        System.out.println(testEngine.toString());
        testEngine.step();
        System.out.println(testEngine.toString());
        assertEquals(0, testEngine.getPiece(1, 1));

    }

    @Test
    public void testBirthRule() {
        testEngine = new Engine(new int[][] { {1,0,0},
                                              {1,0,0},
                                              {1,0,0}});
        testEngine.step();
        assertEquals(1, testEngine.getPiece(1, 1));
    }

    @Test
    public void concurrentRuleExecution() {
        testEngine = new Engine(new int[][] { {1,0,0},
                                              {1,1,0},
                                              {1,1,1}});
        testEngine.step();
        assertEquals(0, testEngine.getPiece(1, 1));
        assertEquals(1,testEngine.getPiece(2,2));
    }

    @Test
    public void getSingleElement() {
        testEngine = new Engine(new int[][] { {0,1,1},
                                              {0,1,1},
                                              {0,0,0}});
        testEngine.step();
        assertEquals(1,testEngine.getPiece(2,0));
        assertEquals(1,testEngine.getPiece(2,1));
        assertEquals(1,testEngine.getPiece(1,0));
        assertEquals(1,testEngine.getPiece(1,1));
    }

    @Test
    public void shouldKillOneStandingAlone() {
        testEngine = new Engine(new int[][] { {0,0,0},
                {0,1,0},
                {0,0,0}});
        testEngine.step();
        for (int i=0; i< 2;i++){
            for (int j=0; j< 2;j++){
                assertEquals(0,testEngine.getPiece(i,j));
            }
        }
    }

    @Test
    public void getElementOverRange() {
        testEngine = new Engine(new int[][] { {1,1,1,1,1},
                                              {1,1,1,1,1},
                                              {1,1,1,1,1}});
        assertEquals(0, testEngine.getPiece(-1, 0));
        assertEquals(0,testEngine.getPiece(5,6));

    }

    @Test
    public void doNotCreateElementWhenNeighborCountIsMoreThanThree() {
       testEngine = new Engine(new int[][] { {1,1,0,1,1},
                                             {1,1,0,1,1},
                                             {0,0,0,0,0}});

       assertEquals(0,testEngine.getPiece(3,2));
    }



}
