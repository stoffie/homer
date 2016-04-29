
package org.homer.ast;

import org.homer.HNative;
import org.homer.HNil;
import org.homer.StackFrame;

public class AstHNil extends AstHNative {
    public HNative eval(StackFrame frame) {
        return new HNil();
    }
}
