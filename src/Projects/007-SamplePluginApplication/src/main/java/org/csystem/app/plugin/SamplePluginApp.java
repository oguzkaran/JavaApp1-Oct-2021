package org.csystem.app.plugin;

import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

import java.util.concurrent.ConcurrentSkipListMap;

public final class SamplePluginApp {
    private SamplePluginApp()
    {
    }

    public static void run(String [] args)
    {
        CommandLineUtil.checkForLengthLess(args, 1, "Wrong number of arguments", 1);

        var sp = new SamplePlugin(args);

        sp.run();
    }
}
