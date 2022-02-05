package org.csystem.app.reflection;

import org.csystem.util.console.command.CommandLineUtil;

public final class PublicMembersInfoApp {
    private PublicMembersInfoApp()
    {
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkForLengthLess(args, 1, "Wrong number of arguments", 1);

        var sp = new PublicMembersInfo(args);

        sp.run();
    }
}
