/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Complex nesnelerine ilişkin referanslar bir kümeye eklenmiştir. TreeSet sınıfına sıralama
    kriteri verilerek norma göre azalan sırada dizilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.math.Complex;

import java.util.Random;
import java.util.TreeSet;

class App {
    public static void main(String[] args)
    {
        var treeSet = new TreeSet<Complex>((z1, z2) -> Double.compare(z2.getNorm(), z1.getNorm()));
        var r = new Random();
        var min = -10;
        var max = 10;

        for (int i = 0; i < 10; ++i) {
            int a = r.nextInt(max - min + 1) + min;
            int b = r.nextInt(max - min + 1) + min;
            var f = new Complex(a, b);
            Console.writeLine("%s -> %b", f, treeSet.add(f));
        }

        Console.writeLine("-----------------------------------------");
        Console.writeLine(treeSet);
        Console.writeLine("Size:%d", treeSet.size());
    }
}