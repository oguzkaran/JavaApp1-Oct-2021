/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfının fill metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Arrays;

class App {
    public static void main(String[] args)
    {
        var n = Console.readUInt("Bir sayı giriniz:");

        String [] names = new String[n];

        Arrays.fill(names, "indefinite");

        for (var name : names)
            Console.writeLine(name);


    }
}