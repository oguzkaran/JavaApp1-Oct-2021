/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte ilgili tarihe ilişkin ayın son günü olan tarih elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.datetime.DateTime;

class App {
    public static void main(String[] args)
    {
        var month = Console.readInt("Son kullanma tarihi ay bilgisini giriniz:");
        var year =  Console.readInt("Son kullanma tarihi yıl bilgisini giriniz:");
        var expiryDate = DateTime.of(1, month, year);

        expiryDate = expiryDate.withDay(expiryDate.getEndOfMonth());

        if (DateTime.today().isAfter(expiryDate))
            Console.writeLine("Kartın son kullanma tarihi geçmiştir");
        else
            Console.writeLine("Kartın son kullanma tarihi henüz geçmemiştir");
    }
}
