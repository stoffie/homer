
package org.homer;

public class HInt extends HNative {
    int i;

    public HInt(int i) {
        this.i = i;
    }

    public String type() {
        return "int";
    }

    public String toString() {
        return super.toString() + "[" + this.i + "]";
    }
}
