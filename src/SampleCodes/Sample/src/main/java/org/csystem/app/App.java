/*----------------------------------------------------------------------------------------------------------------------
    Optional sınıflarının ifPresentOrElse metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.function.FunctionalUtil;
import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        Random random = new Random();

        var numbers = ArrayUtil.getRandomArray(random, 0, 0, 99);

        Console.writeLine("-------------------------------------");
        FunctionalUtil.forEach(numbers, numbers.length, val -> Console.write("%d ", val));
        Console.writeLine();

        var resultIntOpt = FunctionalUtil.reduce(numbers, Integer::sum);


    }
}

