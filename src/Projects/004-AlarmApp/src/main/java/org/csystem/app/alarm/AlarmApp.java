package org.csystem.app.alarm;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Alarm;

public final class AlarmApp {
    public static void run(String [] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Geçersiz komut satırı argüman sayısı");
            System.exit(1);
        }

        try {
            var alarm = new Alarm(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));

            alarm.start(() -> Console.write("\nArtık uyan"), () -> Console.write('.'));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Geçersiz argümanlar");
        }
    }
}
