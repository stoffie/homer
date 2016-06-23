package org.homer;

import junit.framework.TestCase;

public class AmbientTest extends TestCase {
    public void testInterface() {
        Ambient a = Ambient.empty;
        Ambient a1 = Ambient.set(a, "x", Value.TRUE_VAL);
        assertEquals(a1.get("x"), Value.TRUE_VAL);
    }
}
