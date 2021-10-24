/*----------------------------------------------------------------------------------------------------------------------
    n-inci Fibonacci sayısını döndüren fibonacciNumber metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class FibonacciNumberTest {
    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Bir sayı giriniz:");

            if (n <= 0)
                break;

            Console.writeLine("%d. Fibonacci sayısı:%d", n, Util.fibonacciNumber(n));
        }
    }
}
