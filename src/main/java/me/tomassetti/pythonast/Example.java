package me.tomassetti.pythonast;

import java.io.File;
import java.io.IOException;

public class Example {

    public static void main(String[] args) throws IOException {
        ParserFacade parserFacade = new ParserFacade();
        AstPrinter astPrinter = new AstPrinter();
        astPrinter.print(parserFacade.parse(new File("examples/simple.py")));
    }
}
