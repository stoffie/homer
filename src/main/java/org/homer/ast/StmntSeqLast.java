
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class StmntSeqLast extends StmntSeq {
    Stmnt stmnt;

    public StmntSeqLast(Stmnt stmnt) {
        this.stmnt = stmnt;
    }

    public HNative eval(StackFrame frame) {
        return this.stmnt.eval(frame);
    }
}
