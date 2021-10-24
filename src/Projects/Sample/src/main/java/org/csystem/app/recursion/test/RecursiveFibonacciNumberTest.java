/*----------------------------------------------------------------------------------------------------------------------
    n-inci Fibonacci sayısını döndüren fibonacciNumber metodunun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveFibonacciNumberTest {
    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Bir sayı giriniz:");

            if (n <= 0)
                break;

            Console.writeLine("%d. Fibonacci sayısı:%d", n, RecursionUtil.fibonacciNumber(n));
        }
    }
}
