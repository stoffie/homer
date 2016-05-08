
package org.homer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.homer.ast.StmntSeq;

public class App
{
    public static void main( String[] args )
    {
        String fragment = "var x = 0; var f = { x = 1; };";

        HomerLexer lexer = new HomerLexer(new ANTLRInputStream(fragment));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));

        StackFrame frame = new StackFrame();
        StmntSeq stmntSeq = parser.program().val;
        stmntSeq.eval(frame);
        System.out.println(frame.map);
    }
}
