package org.csystem.app.simulation.passwdgenerator.simulation;

import org.csystem.app.simulation.passwdgenerator.PeriodicAsyncPasswordGenerator;
import org.csystem.util.console.Console;

import java.io.IOException;

public class PeriodicAsyncPasswordGeneratorSimulation {
    public static void run(String [] args)
    {
        if (args.length != 4) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }
        try  {
            var pg = new PeriodicAsyncPasswordGenerator(args[0], Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]), Long.parseLong(args[3]));

            pg.run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }

    }
}
