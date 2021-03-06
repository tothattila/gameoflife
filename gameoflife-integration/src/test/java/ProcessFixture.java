import java.io.*;

import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 11/8/12
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessFixture {

    public String lineSep = System.getProperty("line.separator");

    protected String executeGameOfLifeAndCollectResults(final int stepCount, final String initialBoard, String Output) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        String installDir = System.getenv("GAMEOFLIFE_INSTALL_DIR");
        String command = "java -jar " + installDir + File.separator + "gameoflife.jar -step " + stepCount + " -board " +
                "" +
                initialBoard +
                " -active " + Output;
        Process testProcess = runtime.exec(command);
        testProcess.waitFor();
        return convertInputStreamToString(testProcess.getErrorStream()) + convertInputStreamToString(testProcess.getInputStream());
    }

    protected String convertInputStreamToString(final InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String nextLine;
        String result="";
        while((nextLine = reader.readLine()) != null) {
            result += nextLine + lineSep;
        }
        return result;
    }

}
