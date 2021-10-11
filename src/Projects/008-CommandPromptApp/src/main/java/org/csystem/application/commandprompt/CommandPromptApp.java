package org.csystem.application.commandprompt;

import org.csystem.util.commandprompt.CommandPrompt;

public final class CommandPromptApp {
    private CommandPromptApp()
    {
    }

    public static void run()
    {
        var cp = new CommandPrompt();

        cp.register(new CommandsInfo(cp))
                .setPrompt("csd")
                .setPromptSuffix("$")
                .run();
    }
}
