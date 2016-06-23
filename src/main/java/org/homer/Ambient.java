package org.homer;

public interface Ambient {
    Value get(String id);

    static Value get(Ambient ambient, String id) {
        return ambient.get(id);
    }

    static Ambient empty = new Ambient() {
        public Value get(String id) {
            return Value.NIL_VAL;
        }
    };

    static Ambient set(Ambient parent, String id, Value value) {
        return new Ambient() {
            public Value get(String this_id) {
                if (this_id.equals(id)) {
                    return value;
                } else {
                    return parent.get(id);
                }
            }
        };
    }
}