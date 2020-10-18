package main.lex;

import main.lex.workfile.InterFile;

import java.io.File;

public class Application {

    private final static String RES_PATH = "src/main/resources/";

    public static void main(String[] args) {
        File inputFile = InterFile.openFile(RES_PATH + "main.cpp");
        File outputFile = InterFile.createFile(RES_PATH + "index.txt");
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        lexicalAnalyzer.analyze(inputFile);
        lexicalAnalyzer.save(outputFile);
    }

}
