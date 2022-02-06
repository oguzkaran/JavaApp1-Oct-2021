/*----------------------------------------------------------------------------------------------------------------------
     IntGenerator sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.range.IntGenerator;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var r = new Random();
        var ig = IntGenerator.of(r, 10, 0, 99);

        for (var val : ig)
            Console.write("%02d ", val);

        Console.writeLine();
    }
}


