/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdıran writeReverse metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class WriteReverseTest {
    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            Util.writeReverse(s);
            Console.writeLine();

            if ("quit".equals(s))
                break;
        }
    }
}
