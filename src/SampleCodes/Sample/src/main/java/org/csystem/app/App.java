/*----------------------------------------------------------------------------------------------------------------------
    Java 8 ile birlikte java.util.function paketine bir grup fonksiyonel arayüz eklenmiştir. Bu arayüzler özellike yine
    Java 8 ile eklenen "Stream API" tarafından kullanılmaktadır. Stream API Java'da programlama modelini geliştirmiştir ve
    kullanılması uygun olan durumda kesinlikle kullanılmalıdır. Bu konu ileride detaylı biçimde ele alınacaktır. Şüphesiz
    bu arayüzler yalnızca Stream API ile kullanılmaz. Programcı kendi tasarladığı sınıflarda ve metotlarda da kullanabilir.
    Ayrıca Java 8 ile eklenen bu arayüzler başka sınıflar tarafından da kullanılmaktadır.

    java.util.function paketi içerisinde bulunan bu arayüzler basitçe şu şekilde gruplanabilir:
    1. Function arayüzleri: Bu arayüzler bir ya da iki tane giriş alan ve bir sonuç üretilmesi işleminde kullanılır. Bu
    arayüzlerin en geneli Function ve BiFunction arayüzleridir. Function<T, R> arayüzü T türünden bir değer alan ve R
    türünden bir geri dönüş değerine sahip apply isimli bir metoda sahiptir. BiFunction<T, U, R> arayüzünde ise T ve U türünden
    iki tane parametresi olan ve R türünden  geri dönüş değerine sahip apply isimli abstract metot vardır.

    2. Operatör arayüzleri: Bu arayüzler bşr ya da iki girişe göre bir işlem yapan ve sonuç üreten durumlarda kullanılır.
    Bunların birçoğu Function veya BiFunction arayüzünden türetilmiştir. Bu arayüzler de BinaryOperator ve UnaryOperator
    olarak iki gruba ayrılır.Bu arayüzler bir ya da iki operandlı işlemler için kullanılır. Bu arayüzlerinde temel bazı
    türler için ayrı karşılıkları da bulunur.

    3. Supplier arayüzleri: Bu arayüzler bir giriş almadan bir değer üretmez için kullanılır
    4. Consumer arayüzleri:
    5. Predicate arayüzleri:
    6. Geri kalanlar:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class App {
    public static void main(String[] args)
    {
        Random r = new Random();

        IntStream.generate(r::nextInt).limit(10).filter(val -> val % 2 == 0).forEach(Console::writeLine);

        Console.writeLine("-------------------------------------");
        Stream.generate(() -> StringUtil.getRandomTextTR(r, 10)).limit(10).forEach(Console::writeLine);
    }
}

