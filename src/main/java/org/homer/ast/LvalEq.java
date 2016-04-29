
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class LvalEq extends Lval {
    String id;
    Expr expr;

    public LvalEq(String id, Expr expr) {
        this.id = id;
        this.expr = expr;
    }

    public HNative eval(StackFrame frame) {
        return frame.set(this.id, this.expr.eval(frame));
    }
}
