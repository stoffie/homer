
package org.homer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.homer.ast.StmntSeq;

public class App
{
    public static void main( String[] args )
    {
        HomerLexer lexer = new HomerLexer(new ANTLRInputStream("var t = true; t = 10; t = 666;"));
        HomerParser parser = new HomerParser(new CommonTokenStream(lexer));

        StackFrame frame = new StackFrame();
        StmntSeq stmntSeq = parser.program().val;
        stmntSeq.eval(frame);
        System.out.println(frame.map);
    }
}
