package com.examples.input;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestExecutorClass {
    private static final String FILE_PATH = "src/main/java/com/examples/input/Test1.java";
    public static void main(String[] args) throws Exception {
        TypeSolver typeSolver = new CombinedTypeSolver(
                new ReflectionTypeSolver(),
                new JavaParserTypeSolver(new File("src/main/java"))
        );
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);

        StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);

        CompilationUnit cu = StaticJavaParser.parse(Files.newInputStream(Paths.get(FILE_PATH)));

        ExceptionVisitor visitor = new ExceptionVisitor();

        visitor.visit(cu, null);


    }
}
