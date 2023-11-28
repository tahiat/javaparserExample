package com.examples.input;

import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;

public class ExceptionVisitor extends ModifierVisitor<Void> {
    @Override
    public Visitable visit(Parameter n, Void arg) {
       // n.resolve();
        return super.visit(n, arg);
    }
}
