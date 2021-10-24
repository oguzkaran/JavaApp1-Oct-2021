/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveFactorialTest {
    public static void run()
    {
        for (var n = 0; n < 13; ++n)
            Console.writeLine("%d!= %d", n, RecursionUtil.factorial(n));
    }
}
