/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var str = Console.read("Bir yazı giriniz:");

        if (!str.isBlank())
            Console.writeLine(str.toUpperCase());
        else
            Console.Error.writeLine("Hatalı giriş");
    }
}

