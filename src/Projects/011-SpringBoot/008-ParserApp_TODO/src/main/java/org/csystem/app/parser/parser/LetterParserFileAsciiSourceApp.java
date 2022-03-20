package org.csystem.app.parser.parser;

import org.csystem.util.console.command.CommandLineUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class LetterParserFileAsciiSourceApp {
    private LetterParserFileAsciiSourceApp()
    {
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);

        ParseFactory factory = new ParseFactory();

        try (FileAsciiSource fs = new FileAsciiSource(args[0])) {
            Parser parser = factory.getParser(ParserType.LETTER, fs);

            System.out.printf("Number of Letters:%d%n", parser.doParse());
        }
        catch (FileNotFoundException ignore) {
            System.err.println("File Not found");
        }
        catch (IOException ignore) {
            System.err.println();
        }

    }
}
