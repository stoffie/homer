
package org.homer.ast;

import org.homer.Ast;
import org.homer.HNative;
import org.homer.StackFrame;

public class Decl extends Ast {
    String id;
    Expr e;

    public Decl(String id, Expr e) {
        this.id = id;
        this.e = e;
    }

    public HNative eval(StackFrame frame) {
        return frame.decl(this.id, this.e.eval(frame));
    }
}
