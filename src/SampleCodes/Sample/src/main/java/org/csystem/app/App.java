/*----------------------------------------------------------------------------------------------------------------------
    Class sınıfının getDeclaredXXXs metotları ile türün tüm elemanlarına erişim belirleyiciden bağımsız olarak
    erişilebilir. Taban sınıfın hiçbir bölümüne bu metotlar ile erişilemez. Class sınıfının getXXXs metotları ile
    taban sınıfın da dahil olmak üzere yalnızca public bölüme erişilebilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var cls = Sample.class;

        Console.writeLine("--------------------------------");
        for (var method : cls.getDeclaredMethods())
            Console.writeLine(method.getName());
        Console.writeLine("--------------------------------");

        Console.writeLine("--------------------------------");
        for (var method : cls.getMethods())
            Console.writeLine(method.getName());
        Console.writeLine("--------------------------------");

    }
}


class Sample {
    private void foo(int a)
    {

    }

    public void bar()
    {
    }

    void tar(int a)
    {

    }

    protected void zar(int a)
    {

    }

}


