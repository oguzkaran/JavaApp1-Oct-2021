/*----------------------------------------------------------------------------------------------------------------------
   Override annotation'ı SOURCE ve yalnızca metot bildirimlerinde kullanılabilen bir annotation'dır. Bu anntation bir
   elemanı yoktur. Bu annotation metodun override edilip edilemeyeceğinin derleme zamanında kontrol edilmesi için
   kullanılır. Eğer metot override edilemeyecek şekilde yazılmışsa error oluşur. Override işleminde kullanılması
   zorunlu değildir. Ancak her zaman kullanılmalıdır. Ayrıca bu annotation okunabilirliği de artırır.
   Aşağıdaki örnekte A sınıfının foo metodunun yapısının değiştirilmesi durumunda B'de Override annotation'ından
   dolayı error oluşacak ve programcı da B'yi ve A'dan türetilen tüm diğer sınıflardaki override edilen bu metodu
   değiştirmek zorunda kalacaktır. Böylelikle olası bir hatanın da önüne geçilebilecektir. Üstelik bu annotation'ın
   okunabilirliği artırması da gözardı edilmemelidir. Örnek tamamen durumu anlatmak için yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.tuple.Pair;

class App {
    public static void main(String[] args)
    {
        var pair = Pair.of(34, "İstanbul");

        Console.writeLine(pair);
    }
}

class B extends A {
    @Override
    public void foo(double a, int b)
    {
        Console.writeLine("B.foo(double, long)");
    }
}

class A {
    public void foo(double a, int b)
    {
        Console.writeLine("A.foo(double, int)");
    }
}

