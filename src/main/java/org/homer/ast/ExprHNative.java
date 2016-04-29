
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class ExprHNative extends Expr {
    AstHNative h;

    public ExprHNative(AstHNative h) {
        this.h = h;
    }

    public HNative eval(StackFrame frame) {
        return this.h.eval(frame);
    }
}
