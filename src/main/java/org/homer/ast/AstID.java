
package org.homer.ast;

import org.homer.Ast;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstID extends Ast {
    String id;

    public AstID(String id) {
        this.id = id;
    }

    public HNative eval(StackFrame frame) {
        return frame.get(this.id);
    }
}
