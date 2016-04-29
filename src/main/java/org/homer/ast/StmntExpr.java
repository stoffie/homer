
package org.homer.ast;

import org.homer.HNative;
import org.homer.HNil;
import org.homer.StackFrame;

public class StmntExpr extends Stmnt {
    Expr expr;

    public StmntExpr(Expr expr) {
        this.expr = expr;
    }

    public HNative eval(StackFrame frame) {
        this.expr.eval(frame);
        return new HNil();
    }
}
