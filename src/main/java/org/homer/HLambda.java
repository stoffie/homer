
package org.homer;

import org.homer.ast.Form;

public class HLambda extends HNative {
    StackFrame frame;
    Form form;
    Ast stmntSeq;

    public HLambda(StackFrame frame, Form form, Ast stmntSeq) {
        this.frame = frame;
        this.form = form;
        this.stmntSeq = stmntSeq;
    }

    public HNative call() {
        throw new UnsupportedOperationException("not implemented");
        //return this.body.eval(new StackFrame(this.frame));
    }

    public String type() {
        return "lambda";
    }
}
