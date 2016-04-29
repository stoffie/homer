
package org.homer.ast;

import org.homer.HNative;
import org.homer.StackFrame;

public class StmntSeqPair extends StmntSeq {
    Stmnt stmnt;
    StmntSeq seq;

    public StmntSeqPair(Stmnt stmnt, StmntSeq seq) {
        this.stmnt = stmnt;
        this.seq = seq;
    }

    public HNative eval(StackFrame frame) {
        this.stmnt.eval(frame);
        return this.seq.eval(frame);
    }
}
