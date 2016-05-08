
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class ExprCall extends Expr {
    Expr expr;

    public ExprCall(Expr expr) {
        this.expr = expr;
    }

    public HNative eval(StackFrame frame) {
        return null;
    }
}
