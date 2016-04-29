
package org.homer.ast;

import org.homer.HBool;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstHBool extends AstHNative {
    HBool b;

    public AstHBool(boolean b) {
        this.b = new HBool(b);
    }

    public HNative eval(StackFrame frame) {
        return b;
    }
}
