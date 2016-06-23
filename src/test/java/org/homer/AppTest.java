package org.homer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testMutableFragment() {
        // this tests the outdated grammar
        String fragment = "val x = 0; val f = { x; 1; };";

        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));

        StackFrame frame = new StackFrame();
        //Ast program = parser.program().ast;
        //program.eval(frame);
        //System.out.println(frame.map);
        assertTrue( true );
    }

    public void testValueFragment() {
        String fragment = "true";
        String out = "true";
        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));

        Ambient frame = Ambient.empty;
        Evaluable program = parser.value().ast;
        assertEquals(program.eval(frame).getValue().toString(), out);
    }

    public void testValueFalseFragment() {
        String fragment = "false";
        String out = "false";
        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));
        Ambient frame = Ambient.empty;
        Evaluable program = parser.value().ast;
        assertEquals(program.eval(frame).getValue().toString(), out);
    }

    public void testProgramFragment() {
        String fragment = "false";
        String out = "false";
        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));
        Ambient frame = Ambient.empty;
        Evaluable program = parser.body().ast;
        assertEquals(program.eval(frame).getValue().toString(), out);
    }
}
