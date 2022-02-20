/*----------------------------------------------------------------------------------------------------------------------
    Question: Design a stack that computes the minimum int value in constant time. The push, pop and min methods
    should operate int O(1) time. Amortized constant time allowed for push method
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.ProductFactory;
import org.csystem.app.data.product.ProductInfo;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineUtil.checkForLengthEqual(args, 2, "Wrong number of arguments", 1);
            var factory = ProductFactory.loadFromTextFile(args[0]).get();
            var products = new ArrayList<ProductInfo>();
            var random = new Random();

            var count = Integer.parseInt(args[1]);
            for (int i = 0; i < count; ++i)
                products.add(factory.getRandomProduct(random).get());

            products.forEach(Console::writeLine);
            Console.writeLine(Util.areAllDistinct(products));
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

class Util {
    public static <T> boolean areAllDistinct(Collection<? extends T> collection)
    {
        return collection.size() == new HashSet<>(collection).size();
    }
}