
package org.homer.ast;

import org.homer.Ast;
import org.homer.HNative;
import org.homer.StackFrame;

public class Decl extends Ast {
    String id;
    Ast e;

    public Decl(String id, Ast e) {
        this.id = id;
        this.e = e;
    }

    public HNative eval(StackFrame frame) {
        return frame.decl(this.id, this.e.eval(frame));
    }
}
