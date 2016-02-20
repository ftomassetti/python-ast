package me.tomassetti.pythonast;

import me.tomassetti.pythonast.parser.Python3BaseListener;
import me.tomassetti.pythonast.parser.Python3Lexer;
import me.tomassetti.pythonast.parser.Python3Listener;
import me.tomassetti.pythonast.parser.Python3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AstPrinter {

    private static void explore(RuleContext ctx) {
        String ruleName = Python3Parser.ruleNames[ctx.getRuleIndex()];
        System.out.println(ruleName);
        for (int i=0;i<ctx.getChildCount();i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof RuleContext) {
                explore((RuleContext)element);
            }
        }
    }

    public static void main(String[] args) {
        // Get our lexer
        String code = "import foo\n";
        Python3Lexer lexer = new Python3Lexer(new ANTLRInputStream(code));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        Python3Parser parser = new Python3Parser(tokens);

        // Specify our entry point
        //Python3Parser.File_inputContext drinkSentenceContext = parser.file_input();

        explore(parser.file_input());

        // Walk it and attach our listener
        //ParseTreeWalker walker = new ParseTreeWalker();
        //Python3Listener listener = new Python3BaseListener();
        //walker.walk(listener, drinkSentenceContext);
    }

}
