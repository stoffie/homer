
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class ExprLval extends Expr {
    Lval lval;

    public ExprLval(Lval lval) {
        this.lval = lval;
    }

    public HNative eval(StackFrame frame) {
        return this.lval.eval(frame);
    }
}
