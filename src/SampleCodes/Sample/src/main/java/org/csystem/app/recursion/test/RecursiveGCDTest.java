/*----------------------------------------------------------------------------------------------------------------------
    Parametresi ile aldığı iki sayının ortak bölenlerinin en büyüğünü bulan metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.RecursionUtil;
import org.csystem.util.console.Console;

public class RecursiveGCDTest {
    public static void run()
    {
        for (;;) {
            var a = Console.readInt("Birinci sayıyı giriniz:");

            if (a == 0)
                break;

            var b = Console.readInt("İkinci sayıyı giriniz:");

            Console.writeLine("O.B.E.B.:%d", RecursionUtil.gcd(a, b));
        }
    }
}
