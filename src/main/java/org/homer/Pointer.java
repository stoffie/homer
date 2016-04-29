
package org.homer;

public class Pointer {
    HNative p;

    public Pointer(HNative p) {
        this.p = p;
    }

    public HNative set(HNative p) {
        return (this.p = p);
    }

    public HNative get() {
        return this.p;
    }

    public String toString() {
        return super.toString() + "[" + this.p.toString() + "]";
    }
}
