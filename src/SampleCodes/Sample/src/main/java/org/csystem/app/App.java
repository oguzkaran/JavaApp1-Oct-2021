/*----------------------------------------------------------------------------------------------------------------------
    Apache commons StopWatch sınıfı
    https://commons.apache.org/
    Anahtar Notlar: Bu kütüphanedeki hemen hemen her sınıf Apache Lisansına göre kullanılmaktadır. Bu lisansı inceleyeniz:
    link: http://www.apache.org/licenses/LICENSE-2.0 (28.11.2021)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.apache.commons.lang3.time.StopWatch;
import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        long n = 5697859706174583067L;

        var stopWatch = new StopWatch();

        stopWatch.start();
        var result = NumberUtil.isPrime(n);
        stopWatch.stop();
        var elapsed = stopWatch.getTime(TimeUnit.MILLISECONDS);

        Console.writeLine(result ? "Asal" : "Asal değil");
        Console.writeLine("Elapsed (sec):%f", elapsed / 1000.);

        stopWatch.reset();
        stopWatch.start();
        result = NumberUtil.isPrime(BigInteger.valueOf(n));
        stopWatch.stop();
        elapsed = stopWatch.getTime(TimeUnit.MILLISECONDS);
        Console.writeLine(result ? "Asal" : "Asal değil");
        Console.writeLine("Elapsed (sec):%f", elapsed / 1000.);
    }
}
