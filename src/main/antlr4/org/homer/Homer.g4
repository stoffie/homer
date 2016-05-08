
grammar Homer;

@header {
    import org.homer.ast.*;
}

program returns [Ast ast]
    : stmnt_seq { $ast = $stmnt_seq.ast; }
    ;

stmnt_seq returns [Ast ast]
    : stmnt { $ast = $stmnt.ast; }
    | stmnt seq=stmnt_seq { $ast = new StmntSeqPair($stmnt.ast, $seq.ast); }
    ;

stmnt returns [Ast ast]
    : decl ';' { $ast = $decl.ast; }
    | expr ';' { $ast = $expr.ast; }
    | ';' { $ast = new AstHNil(); }
    ;

expr returns [Ast ast]
    : hnative { $ast = $hnative.ast; }
    | ID { $ast = new AstID($ID.text); }
    ;

decl returns [Ast ast]
    : VAL ID '=' expr { $ast = new Decl($ID.text, $expr.ast); }
    ;

params returns [Params val]
    : expr { $val = new Params($expr.ast); }
    | expr ',' p=params { $val = new Params($expr.ast, $p.val); }
    ;

form returns [Form val]
    : ID { $val = new Form($ID.text); }
    | ID ',' f=form { $val = new Form($ID.text, $f.val); }
    ;

hlambda returns [Ast ast]
    : '{' '|' form '|' stmnt_seq '}' { $ast = new AstHLambda($form.val, $stmnt_seq.ast); }
    | '{' stmnt_seq '}' { $ast = new AstHLambda($stmnt_seq.ast); }
    ;

hnative returns [Ast ast]
    : NIL { $ast = new AstHNil(); }
    | INT { $ast = new AstHInt($INT.text); }
    | TRUE { $ast = new AstHBool(true); }
    | FALSE { $ast = new AstHBool(false); }
    | hlambda { $ast = $hlambda.ast; }
    ;

WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines

INT: [0-9]+;
NIL: 'nil';
TRUE: 'true';
FALSE: 'false';
VAL: 'val';
ID: [a-zA-Z][a-zA-Z0-9]*;