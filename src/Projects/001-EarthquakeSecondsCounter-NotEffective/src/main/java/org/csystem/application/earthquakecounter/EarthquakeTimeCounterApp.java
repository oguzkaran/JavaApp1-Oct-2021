/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: 17.08.1999 tarihinde 03:02:00 zamanında gerçekleşmiş olan büyük Gölcük depreminden
    bu zamana kadar geçen saniye sayısını artarak devam edecek şekilde ekrana basam programı yazınız.
    Açıklamalar:
    - Programı bir döngü içerisinde yapınız. Aslında bu teknik iyi bir teknik değildir. İleride timer kullanarak
    daha efektif bir biçimde yazılacaktır)
    - Programı .jar haline getirerek işletim sisteminizin terminalinde (command prompt) çalıştırınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.earthquakecounter;

import org.csystem.util.Console;
import org.csystem.util.datetime.DateTimeInfo;

import java.time.Month;

public class EarthquakeTimeCounterApp {
    private static DateTimeInfo getDateTimeInfo()
    {
        var day = Console.readInt("Gün?");
        var month = Console.readInt("Ay?");
        var year = Console.readInt("Yıl?");
        var hour = Console.readInt("Saat?");
        var minute = Console.readInt("Dakika?");
        var second = Console.readInt("Saniye?");

        return new DateTimeInfo(day, Month.values()[month - 1], year, hour, minute, second);
    }

    private EarthquakeTimeCounterApp()
    {
    }

    public static void run()
    {
        var dateTimeInfo = getDateTimeInfo();

        for (;;)
            System.out.printf("Depremden bu zamana kadar geçen saniye sayıs:%d\r", dateTimeInfo.getSeconds());

    }
}
