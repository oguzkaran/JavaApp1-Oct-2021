/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Stream API kullanılarak stdin'den girilen stok miktarından daha çok olan ürünlerin isimleri
    büyük harfe dönüştürülerek stout'a yazdırılmıştır. Örnek sadece genel Stream API kullanımını göstermek için yazılmıştır.
    Detaylar konu içerisinde ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Random;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        var n = Console.readInt("Bir sayı giriniz:");
        var random = new Random();

        IntStream.generate(() -> random.nextInt(100)).limit(n).forEach(val -> Console.write("%d ", val));
        Console.writeLine();
    }
}

