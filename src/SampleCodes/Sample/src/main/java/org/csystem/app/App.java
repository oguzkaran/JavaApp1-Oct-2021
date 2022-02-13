/*----------------------------------------------------------------------------------------------------------------------
     Aşağıdaki örneği inceleyiniz. Örneği, org-csystem-util-tuple kütüphanesinin 10.0.0 ve 11.0.0 versiyonları için
     çalıştırıp sonucu gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.tuple.Pair;

import java.util.ArrayList;

class App {
    public static void main(String[] args)
    {
        var list = new ArrayList<Pair<Integer, String>>();

        list.add(Pair.of(67, "zonguldak"));
        list.add(Pair.of(34, "istanbul"));
        list.add(Pair.of(6, "ankara"));
        list.add(Pair.of(34, "istanbul"));
        list.add(Pair.of(35, "izmir"));

        var index = list.indexOf(Pair.of(34, "istanbul"));

        Console.writeLine(index == -1 ? "Not found" : list.get(index) + " found at index:" + index);
    }
}

