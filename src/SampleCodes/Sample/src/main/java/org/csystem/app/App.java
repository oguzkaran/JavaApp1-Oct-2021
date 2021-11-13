/*----------------------------------------------------------------------------------------------------------------------
    DateTimeFormatter sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class App {
    public static void main(String[] args)
    {
        var now = LocalDateTime.now();
        var time = LocalTime.now();

        Console.writeLine(DateTimeFormatter.ofPattern("dd-MM-yyyy kk:mm:ss E").format(now));
        Console.writeLine(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss E").format(now));
        Console.writeLine(DateTimeFormatter.ofPattern("dd-MM-yyyy KK:mm:ss a E").format(now));
        Console.writeLine(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a E").format(now));
        Console.writeLine(DateTimeFormatter.ISO_TIME.format(now));
    }
}
