
package org.homer;

import java.util.HashMap;

public class StackFrame {
    // this is some old crap
    StackFrame parent;
    HashMap<String, Pointer> map;

    public StackFrame() {
        this(null);
    }

    public StackFrame(StackFrame parent) {
        this.parent = parent;
        this.map = new HashMap<String, Pointer>();
    }

    public HNative decl(String id, HNative n) {
        if (this.map.get(id) != null) {
            // variable already declared in this context
            throw new UnsupportedOperationException();
        }

        map.put(id, new Pointer(n));
        return n;
    }

    public HNative set(String id, HNative n) {
        return this.getPointer(id).set(n);
    }

    public HNative get(String id) {
        return this.getPointer(id).get();
    }

    public Pointer getPointer(String id) {
        Pointer p = map.get(id);

        if (p != null) {
            return p;
        }

        if (this.parent != null) {
            return this.parent.getPointer(id);
        }

        // variable not found
        throw new UnsupportedOperationException();
    }
}
