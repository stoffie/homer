package org.homer;

public interface Evaluable {
    //Value eval(StackFrame stackFrame);
    EvaluationPair eval(Ambient env);

    static Evaluable trueAst = (env) -> EvaluationPair.init(env, Value.TRUE_VAL);
    static Evaluable falseAst = (env) -> EvaluationPair.init(env, Value.FALSE_VAL);

    static Evaluable intAst(String text) {
        return (env) -> EvaluationPair.init(env, Value.intVal(text));
    }

    static Evaluable bodyAst(Evaluable body, Evaluable last) {
        return (env) -> {
            EvaluationPair evaluateBody = body.eval(env);
            return last.eval(evaluateBody.getEnviroment());
        };
    }
}
