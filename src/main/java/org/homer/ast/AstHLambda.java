package org.homer.ast;

import org.homer.Ast;
import org.homer.HLambda;
import org.homer.HNative;
import org.homer.StackFrame;

public class AstHLambda extends AstHNative {
    Form form;
    Ast seq;

    public AstHLambda(Ast seq) {
        this.seq = seq;
    }

    public AstHLambda(Form form, Ast seq) {
        this.form = form;
        this.seq = seq;
    }

    public HNative eval(StackFrame frame) {
        return new HLambda(frame, form, seq);
    }
}
