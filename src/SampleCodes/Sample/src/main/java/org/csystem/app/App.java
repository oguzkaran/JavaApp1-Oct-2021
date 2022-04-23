/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.ArrayList;

class App {
    public static void main(String[] args)
    {
        Util u = new Util();
        ArrayList<Sample> list = new ArrayList<>();

        u.doWork((Sample s) -> {list.add(s);});
    }
}


class Util {
    public void doWork(IX ix)
    {
        Console.writeLine("doWork(IX)");
    }

    public void doWork(IY<Boolean> iy)
    {
        Console.writeLine("doWork(IY)");
    }
}

class Sample {
    //...
}

@FunctionalInterface
interface IX {
    void foo(Sample s);
}


@FunctionalInterface
interface IY<T> {
    T bar(Sample s);
}
