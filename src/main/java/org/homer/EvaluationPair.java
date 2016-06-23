package org.homer;


public interface EvaluationPair {
    Ambient getEnviroment();
    Value getValue();

    static EvaluationPair init(Ambient ambient, Value value) {
        return new EvaluationPair() {
            @Override
            public Ambient getEnviroment() {
                return ambient;
            }

            @Override
            public Value getValue() {
                return value;
            }
        };
    }
}
