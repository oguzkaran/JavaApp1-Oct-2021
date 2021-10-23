/*----------------------------------------------------------------------------------------------------------------------
    var değişkenler for döngü deyiminde kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        for (var i = 0; i < 10; ++i)
            Console.write("%d ", i);

        Console.writeLine();
    }
}
