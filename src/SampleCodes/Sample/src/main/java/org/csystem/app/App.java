/*----------------------------------------------------------------------------------------------------------------------
     Set<E>
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.ProductFactory;
import org.csystem.app.data.product.ProductInfo;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

class App {
    public static void main(String[] args)
    {
        CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);

        try {
            var factoryOpt = ProductFactory.loadFromTextFile(args[0]);
            if (factoryOpt.isEmpty())
                return;

            var factory = factoryOpt.get();

            //factory.PRODUCTS.forEach(Console::writeLine);

            Console.writeLine("-----------------------------------------------------");
            var products = factory.PRODUCTS.toArray(new ProductInfo[0]);

            for (var pi : products)
                Console.writeLine(pi);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

