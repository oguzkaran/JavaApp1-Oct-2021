/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte 128 bit'lik rasgele sayı üretilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        Random random = new Random();

        for (int i = 0; i < 10; ++i) {
            var n = new BigInteger(128, random); //[0, pow(2, 128) - 1]

            if (random.nextBoolean())
                n = n.negate();

            Console.writeLine(n);
        }
    }
}

