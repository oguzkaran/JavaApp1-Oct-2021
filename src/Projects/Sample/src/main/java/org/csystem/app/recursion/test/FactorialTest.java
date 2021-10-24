/*----------------------------------------------------------------------------------------------------------------------
    Faktoriayel hesaplayan metodun iteratif versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class FactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d!= %d", n, Util.factorial(n));
    }
}
