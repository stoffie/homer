
package org.homer.ast;

import org.homer.HNative;
import org.homer.HNil;
import org.homer.StackFrame;

public class StmntDecl extends Stmnt {
    Decl decl;

    public StmntDecl(Decl decl) {
        this.decl = decl;
    }

    public HNative eval(StackFrame frame) {
        this.decl.eval(frame);
        return new HNil();
    }
}
