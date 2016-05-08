
package org.homer.ast;

import org.homer.Ast;
import org.homer.HInt;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstHInt extends Ast {
    HInt i;

    public AstHInt(String s) {
        this.i = new HInt(Integer.parseInt(s));
    }

    public HNative eval(StackFrame frame) {
        return i;
    }
}
