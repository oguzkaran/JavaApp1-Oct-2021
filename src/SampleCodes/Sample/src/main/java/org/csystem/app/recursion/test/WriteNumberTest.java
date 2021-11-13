/*----------------------------------------------------------------------------------------------------------------------
    Yalnızca bir tane karakteri ekrana yazan metot (System.out.write) ve dizi kullanarak int türden bir sayıyı
    ekrana (stdout) yazdıran metodun recursive olmayan versiyonu. Metotta ikiye tümleme işlemine yönelik negatif
    sayıların gözterilişi yapılmamamıştır. Bu durum bitsel operatörler konusu içerisinde ayrıca ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.recursion.test;

import org.csystem.app.recursion.Util;
import org.csystem.util.console.Console;

public class WriteNumberTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");
            var radix = Console.readUInt("Sayı sistemini giriniz:");

            Util.writeNumber(val, radix);
            Console.writeLine();

            if (val == 0)
                break;
        }
    }
}
