package Example;

//import com.zll.main.Parser;

import com.zll.parser.Parser;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.util.List;

public class SimpleCalculatorParserTest extends TestCase {

    public SimpleCalculatorParserTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCanAddTwoNumbers() throws Exception {
        List<Integer> results = Parser.getResults(new ByteArrayInputStream("int n=4+4;".getBytes()));
        assertEquals("Should parse the expression and return 8", (Integer) 8, results.get(0));
        System.out.println("n=" + results.get(0));
    }

    public void testCanMultiplyTwoNumbers() throws Exception {
        List<Integer> results = Parser.getResults(new ByteArrayInputStream("int n=4*4;".getBytes()));
        assertEquals("Should parse the expression and return 16", (Integer) 16, results.get(0));
        System.out.println("n=" + results.get(0));
    }

    public void testParenthesis() throws Exception {
        List<Integer> results = Parser.getResults(new ByteArrayInputStream("int n=4*(1+4)%6+7;".getBytes()));
        assertEquals("Should parse the expression and return 20", (Integer) 9, results.get(0));
        System.out.println("n=" + results.get(0));
    }

}
