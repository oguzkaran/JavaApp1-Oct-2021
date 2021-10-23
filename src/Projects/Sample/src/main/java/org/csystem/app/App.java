/*----------------------------------------------------------------------------------------------------------------------
    T bir tür olmak üzere T... ve T [] parametreli iki metodun imzası da aynıdır. Aşağıdaki örnekte "bir metot içerisinde
    aynı imzaya sahip 1(bir) den fazla metot yazılamaz" kuralı gereği error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        int [] a = {1, 2, 3, 4};
        int [] b = {5, 6, 7, 8};
        int [] c = {9, 10, 11};

        Util.display(2, a, b, c);
        Console.writeLine("--------------------------------");
        Util.display(2, a, b);
    }
}

class Util {
    public static void display(int n, int [][] a) //error
    {
        for (var array : a)
            display(n, array);
    }

    public static void display(int n, int []... a) //error
    {
        for (var array : a)
            display(n, array);
    }

    public static void display(int n, int...a)
    {
        var fmt = String.format("%%0%dd ", n);

        for (var val : a)
            Console.write(fmt, val);

        Console.writeLine();
    }
}