
grammar Homer;

@header {
    import org.homer.ast.*;
}

program returns [StmntSeq val]
    : stmnt_seq { $val = $stmnt_seq.val; }
    ;

stmnt_seq returns [StmntSeq val]
    : stmnt { $val = new StmntSeqLast($stmnt.val); }
    | stmnt seq=stmnt_seq { $val = new StmntSeqPair($stmnt.val, $seq.val); }
    ;

stmnt returns [Stmnt val]
    : decl ';' { $val = new StmntDecl($decl.val); }
    | expr ';' { $val = new StmntExpr($expr.val); }
    | ';' { $val = new StmnHNil(); }
    ;

expr returns [Expr val]
    : hnative { $val = new ExprHNative($hnative.val); }
    | lval { $val = new ExprLval($lval.val); }
    ;

lval returns [Lval val]
    : ID { $val = new LvalID($ID.text); }
    | ID '=' expr { $val = new LvalEq($ID.text, $expr.val); }
    ;

decl returns [Decl val]
    : VAR ID '=' expr { $val = new Decl($ID.text, $expr.val); }
    ;

params returns [Params val]
    : expr { $val = new Params($expr.val); }
    | expr ',' p=params { $val = new Params($expr.val, $p.val); }
    ;

form returns [Form val]
    : ID { $val = new Form($ID.text); }
    | ID ',' f=form { $val = new Form($ID.text, $f.val); }
    ;

hlambda returns [AstHLambda val]
    : '{' '|' form '|' stmnt_seq '}' { $val = new AstHLambda($form.val, $stmnt_seq.val); }
    | '{' stmnt_seq '}' { $val = new AstHLambda($stmnt_seq.val); }
    ;

hnative returns [AstHNative val]
    : NIL { $val = new AstHNil(); }
    | INT { $val = new AstHInt($INT.text); }
    | TRUE { $val = new AstHBool(true); }
    | FALSE { $val = new AstHBool(false); }
    | hlambda { $val = $hlambda.val; }
    ;

WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines

INT: [0-9]+;
NIL: 'nil';
TRUE: 'true';
FALSE: 'false';
VAR: 'var';
ID: [a-zA-Z][a-zA-Z0-9]*;