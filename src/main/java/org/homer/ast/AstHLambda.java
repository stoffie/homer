package org.homer.ast;

import org.homer.HLambda;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstHLambda extends AstHNative {
    Form form;
    StmntSeq seq;

    public AstHLambda(StmntSeq seq) {
        this.seq = seq;
    }

    public AstHLambda(Form form, StmntSeq seq) {
        this.form = form;
        this.seq = seq;
    }

    public HNative eval(StackFrame frame) {
        return new HLambda(frame, form, seq);
    }
}
