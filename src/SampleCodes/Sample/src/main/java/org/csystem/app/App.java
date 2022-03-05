/*----------------------------------------------------------------------------------------------------------------------
    StreamSupport sınıfının stream metoduna Itreable arayüzünün spliterator metodunun geri dönüş değeri verilerek
    Stream referansı elde edilebilir Metodun ikinci parametresi true geçilirse "parallel stream" biçiminde çalışacak
    bir stream referansı elde edilir
    Aşağıdaki örnekte tedarik edilmemiş ürünlerin her bir için isim ve stok miktarı  ProducNameStockDTO nesneleri
    olarak elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.ProductFactory;
import org.csystem.app.data.product.ProductMapper;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

import java.util.stream.StreamSupport;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);

            if (factoryOpt.isEmpty())
                return;

            var products = factoryOpt.get().getProductsAsIterable();
            var mapper = new ProductMapper();

            StreamSupport.stream(products.spliterator(), false)
                    .filter(p -> p.getStock() < 0)
                    .map(mapper::toProductStockDTO)
                    .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
