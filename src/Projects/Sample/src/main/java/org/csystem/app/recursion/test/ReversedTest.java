/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersyüz eden reversed metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class ReversedTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            var rev = Util.reversed(s);
            Console.writeLine(rev);

            if ("quit".equals(s))
                break;
        }
    }
}
