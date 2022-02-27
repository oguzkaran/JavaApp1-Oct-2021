/*----------------------------------------------------------------------------------------------------------------------
    Stream arayüzlerinin reduce metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.data.factory.NumberFactory;
import org.csystem.util.console.Console;
import org.csystem.util.console.command.CommandLineUtil;
import org.csystem.util.numeric.NumberUtil;

import java.nio.file.Path;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineUtil.checkForLengthEqual(args, 1, "Wrong number of arguments", 1);
            var factory = NumberFactory.loadFromTextFile(Path.of(args[0]));
            var numbers = factory.getNumbers();

            var value = Console.readInt("Input a number:");

            IntStream.of(numbers)
                    .filter(a -> a > value)
                    .filter(NumberUtil::isPrime)
                    .forEach(a -> Console.write("%d ", a));
            Console.writeLine();

            var result = IntStream.of(numbers)
                    .filter(a -> a > value)
                    .filter(NumberUtil::isPrime)
                    .reduce(1, (r, a) -> r * a);

            Console.writeLine("Total:%d", result);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
