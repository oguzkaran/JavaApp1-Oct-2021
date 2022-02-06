package org.csystem.app;

import org.csystem.util.console.commandprompt.CommandPrompt;

public class CommandPromptApp {
    private CommandPromptApp()
    {}

    public static void run()
    {
        var cp = new CommandPrompt();

        cp.register(new CommandsInfo(cp))
                .setPrompt("CSD")
                .setPromptSuffix(">")
                .run();
    }
}
