
package org.homer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class App
{
    public static void main( String[] args )
    {
        String fragment = "val x = 0; val f = { x; 1; };";

        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));

        StackFrame frame = new StackFrame();
        Ast program = parser.program().ast;
        program.eval(frame);
        System.out.println(frame.map);
    }
}
