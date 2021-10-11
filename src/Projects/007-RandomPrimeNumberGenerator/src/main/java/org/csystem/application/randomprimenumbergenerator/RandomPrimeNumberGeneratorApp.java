package org.csystem.application.randomprimenumbergenerator;

import org.csystem.util.Console;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class RandomPrimeNumberGeneratorApp {
    private RandomPrimeNumberGeneratorApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }

        try {
            var count = Integer.parseInt(args[0]);
            var period = Long.parseLong(args[1]);
            var path = args[2];


            var randomPrimeNumberGenerator = new RandomPrimeNumberGenerator(count, period, TimeUnit.MILLISECONDS, path);

            randomPrimeNumberGenerator.run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid value for count");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IOException:%s", ex.getMessage());
        }
    }
}
