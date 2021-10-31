/*----------------------------------------------------------------------------------------------------------------------
    Anımsanacağı gibi "bitwise and" ve "bitwise or" operatörleri boolen türü ile kullanıldıklarında kısa devre davranışı
    olmayan "logical and" ve "logical or" operatörleri gibi çalışırlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        boolean result = Sample.foo() | Sample.bar() & Sample.tar();

        Console.writeLine(result);
    }
}

class Sample {
    public static boolean foo()
    {
        Console.writeLine("foo");

        return true;
    }

    public static boolean bar()
    {
        Console.writeLine("bar");

        return false;
    }

    public static boolean tar()
    {
        Console.writeLine("tar");

        return true;
    }
}