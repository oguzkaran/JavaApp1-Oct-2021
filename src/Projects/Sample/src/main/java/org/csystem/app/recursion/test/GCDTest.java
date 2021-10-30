/*----------------------------------------------------------------------------------------------------------------------
    Parametresi ile aldığı iki sayının ortak bölenlerinin en büyüğünü bulan metodun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class GCDTest {
    public static void run()
    {
        for (;;) {
            var a = Console.readInt("Birinci sayıyı giriniz:");

            if (a == 0)
                break;

            var b = Console.readInt("İkinci sayıyı giriniz:");

            Console.writeLine("O.B.E.B.:%d%n", Util.gcd(a, b));
        }
    }
}
