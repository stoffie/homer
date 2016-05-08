
package org.homer.ast;

public class Params {
    Expr expr;
    Params next;

    public Params(Expr expr) {
        this.expr = expr;
    }

    public Params(Expr expr, Params next) {
        this.expr = expr;
        this.next = next;
    }
}
