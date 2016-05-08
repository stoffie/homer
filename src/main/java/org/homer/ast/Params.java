
package org.homer.ast;

import org.homer.Ast;

public class Params {
    Ast expr;
    Params next;

    public Params(Ast expr) {
        this.expr = expr;
    }

    public Params(Ast expr, Params next) {
        this.expr = expr;
        this.next = next;
    }
}
