/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıda açıklanan Alarm isimli sınıfı yazınız
    Açıklamalar:
        - Sınıfın saat, dakika, saniye alan ve LocalTime parametreli iki adet ctoru olacaktır
        - Sınıfın run metodu Runnable arayüzü ile alarm süresi dolduğunda yapılacak işlemi alacaktır.
        - Sınıfın ayrıca her saniye yapacağı işe de alabilen bir start metodu da olacaktır
        - Sınıfı yazarken Timer veya Scheduler kullanılabilir
        - Alarm sınıfını şu senryo için kullanılan programı yazınız:
            Komut satırı argümanı ile verilen saat, dakika ve saniye bigilerine göre zaman dolduğunda "Artık uyan",
            şeklinde bir mesaj veren ve alarm süresi dolana kadar ise sürekli ekrana nokta bastıran programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.scheduler.Alarm;

class App {
    public static void main(String[] args)
    {
        var alarm = new Alarm(18, 36);

        alarm.start(() -> Console.writeLine("\nArtık uyan"));
    }
}

