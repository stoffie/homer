
package org.homer;

public class HLambda extends HNative {
    StackFrame frame;
    Ast body;

    public HLambda(Ast body) {
        this.body = body;
    }

    public HNative call() {
        return this.body.eval(new StackFrame(this.frame));
    }

    public HNative eval(StackFrame frame) {
        if (this.frame == null) {
            this.frame = frame;
        }
        return this;
    }

    public String type() {
        return "lambda";
    }
}
