
package org.homer;

import org.homer.ast.Form;
import org.homer.ast.StmntSeq;

public class HLambda extends HNative {
    StackFrame frame;
    Form form;
    StmntSeq seq;

    public HLambda(StackFrame frame, Form form, StmntSeq seq) {
        this.frame = frame;
        this.form = form;
        this.seq = seq;
    }

    public HNative call() {
        throw new UnsupportedOperationException("not implemented");
        //return this.body.eval(new StackFrame(this.frame));
    }

    public String type() {
        return "lambda";
    }
}
