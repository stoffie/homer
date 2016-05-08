
package org.homer.ast;

public class Form {
    String id;
    Form next;

    public Form(String id) {
        this.id = id;
    }

    public Form(String id, Form next) {
        this.id = id;
        this.next = next;
    }
}
