
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class LvalID extends Lval {
    String id;

    public LvalID(String id) {
        this.id = id;
    }

    public HNative eval(StackFrame frame) {
        return frame.get(this.id);
    }
}
