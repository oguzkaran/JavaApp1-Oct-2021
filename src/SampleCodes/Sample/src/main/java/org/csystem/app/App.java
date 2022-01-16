/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırı argümanı olarak aldığı bir önek (prefix), n ve periyot bilgisi için n tane dosyaya
    ayrı ayrı rasgele üretilmiş şifreleri verilen periyotta yazan programı yazınız. Dosyaların isimleri <önek>-<numara>
    biçiminde olacaktır
    005-PeriodicAsyncPasswordGeneratorSimulation
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

