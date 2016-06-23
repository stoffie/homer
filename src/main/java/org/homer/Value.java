package org.homer;

public interface Value {
    String toString();

    static Value NIL_VAL = new Value() {
        public String toString() {
            throw new UnsupportedOperationException("Illegal state reached");
        }
    };

    static Value TRUE_VAL = new Value() {
        public String toString() {
            return "true";
        }
    };

    static Value FALSE_VAL = new Value() {
        public String toString() {
            return "false";
        }
    };

    static Value intVal(String text) {
        return new Value() {
            public String toString() {
                return text;
            }
        };
    }
}
