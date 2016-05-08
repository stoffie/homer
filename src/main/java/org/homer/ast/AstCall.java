
package org.homer.ast;

import org.homer.Ast;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstCall extends Ast {
    Ast expr;

    public AstCall(Ast expr) {
        this.expr = expr;
    }

    public HNative eval(StackFrame frame) {
        return null;
    }
}
