package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.console.commandprompt.Command;
import org.csystem.util.console.commandprompt.CommandPrompt;
import org.csystem.util.console.commandprompt.ErrorCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandsInfo {
    private final CommandPrompt m_commandPrompt;

    @Command("cp")
    @Command
    private void copy(String srcPath, String destPath)
    {
        try {
            Files.copy(Path.of(srcPath), Path.of(destPath));
        }
        catch (IOException ignore) {
            Console.Error.writeLine("IO Problem");
        }
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list()
    {
        list(".");
    }

    @Command("ls")
    @Command("dir")
    @Command
    private void list(String path)
    {
        var dir = new File(path);
        if (!dir.isDirectory()) {
            Console.Error.writeLine("path must be adirectory");
            return;
        }

        for (var file : dir.listFiles())
            Console.writeLine("%s%s", file.getName(), file.isDirectory() ? " <DIR>" : "");
    }

    @Command("chgp")
    private void changePrompt(String prompt)
    {
        m_commandPrompt.setPrompt(prompt);
    }


    @Command("exit")
    @Command
    private void quit()
    {
        Console.writeLine("C and System Programmers Association");
        Console.writeLine("Thank you");
        System.exit(1);
    }

    @ErrorCommand
    private void error()
    {
        Console.writeLine("error");
    }

    public CommandsInfo(CommandPrompt commandPrompt)
    {
        m_commandPrompt = commandPrompt;
    }
}
