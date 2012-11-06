import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/6/12
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameOfLifeIntegrationTest {

    /**
     *  .O.
     *  O.O
     *  .OO
     */
    @Test(groups="integration")
    public void stillBoard1() {

    }

    /**
     * .OO.
     * O..O
     * .O.O
     * ..O.
     */
    @Test(groups="integration")
    public void stillBoard2() {

    }

    /**
     * .O.       ...
     * .O.   =>  OOO  => ...
     * .O.       ...
     */
    @Test(groups="integration")
    public void oscillatingBoard1() {

    }

    /**
     * ....    ..O.
     * .OOO    O..O
     * OOO. => O..O  => ...
     * ....    .O..
     */
    @Test(groups="integration")
    public void oscillatingBoard2() {

    }

    /**
     * R-pentomino
     *
     * .....
     * ..OO.
     * .OO..
     * ..O..
     * .....
     */

    @Test(groups="integration")
    public void changingBoard1() {

    }

    @Test(groups="integration")
    public void changingBoard2() {

    }

}
