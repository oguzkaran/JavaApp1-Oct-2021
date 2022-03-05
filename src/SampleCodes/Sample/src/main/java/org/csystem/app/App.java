/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte en pahalı nb-tane ürün listelenmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.ProductFactory;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

import java.util.Comparator;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);

            if (factoryOpt.isEmpty())
                return;

            var n = Console.readInt("Bir sayı giriniz:");
            var products = factoryOpt.get().PRODUCTS;


            products.stream().sorted().forEach(Console::writeLine);

            Console.writeLine("---------------------------------------------------");

            products.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(n)
                    .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
