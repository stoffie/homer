
package org.homer.ast;

import org.homer.Ast;
import org.homer.HNative;
import org.homer.StackFrame;

public class StmntSeqPair extends Ast {
    Ast stmnt;
    Ast seq;

    public StmntSeqPair(Ast stmnt, Ast seq) {
        this.stmnt = stmnt;
        this.seq = seq;
    }

    public HNative eval(StackFrame frame) {
        this.stmnt.eval(frame);
        return this.seq.eval(frame);
    }
}
