
package org.homer.ast;

public class StmnHNil extends StmntExpr {
    public StmnHNil() {
        super(new ExprHNative(new AstHNil()));
    }
}
