/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersyüz eden reversed metodunun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveReversedTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            var rev = RecursionUtil.reversed(s);
            Console.writeLine(rev);

            if ("quit".equals(s))
                break;
        }
    }
}
