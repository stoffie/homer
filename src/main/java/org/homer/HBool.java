
package org.homer;

public class HBool extends HNative {
    boolean b;

    public HBool(boolean b) {
        this.b = b;
    }

    public String type() {
        return "bool";
    }

    public String toString() {
        return super.toString() + "[" + b + "]";
    }
}
