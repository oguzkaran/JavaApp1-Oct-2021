package org.csystem.application.commandprompt;

import org.csystem.util.Console;
import org.csystem.util.commandprompt.Command;
import org.csystem.util.commandprompt.CommandPrompt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandsInfo {
    private final CommandPrompt m_commandPrompt;

    public CommandsInfo(CommandPrompt commandPrompt)
    {
        m_commandPrompt = commandPrompt;
    }

    @Command("cp")
    @Command
    private void copy(String srcPath, String destPath)
    {
        try {
            Files.copy(Path.of(srcPath), Path.of(destPath));
        }
        catch (IOException ex) {
            Console.writeLine("Problem occurred");
        }
    }

    @Command("ls")
    @Command("dir")
    private void list()
    {
        list(".");
    }

    @Command("ls")
    @Command("dir")
    private void list(String path)
    {
        var dir = new File(path);

        if (!dir.isDirectory()) {
            Console.writeLine("path must be directory");
            return;
        }
        for (var file : dir.listFiles())
            Console.writeLine("%s%s", file.getName(), file.isDirectory() ? "<DIR>" : "");
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
        System.exit(0);
    }
}
