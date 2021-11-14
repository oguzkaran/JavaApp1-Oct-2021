/*----------------------------------------------------------------------------------------------------------------------
    BigDecimal sınıfının bir kullanımı. Diğer sınıflar proje içerisindedir. Çok değiştirileceği için buraya
    yapıştırılmamıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.application.shopping.Product;
import org.csystem.application.shopping.ProductFactory;
import org.csystem.util.console.Console;

import java.math.BigDecimal;

class App {
    public static void main(String[] args)
    {
        ShoppingApp.run();
    }
}

final class ShoppingApp {
    private static BigDecimal getTotal(Product [] products)
    {
        //İleride döngü kullanmayacağız
        var total = BigDecimal.ZERO;

        for (var p : products)
            total = total.add(p.getTotal());

        return total;
    }

    private ShoppingApp()
    {
    }

    public static void run()
    {
        var factory = new ProductFactory();

        Console.writeLine("Total:%s", getTotal(factory.getProducts()));
    }
}
