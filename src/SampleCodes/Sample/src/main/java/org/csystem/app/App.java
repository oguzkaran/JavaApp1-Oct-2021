/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte çift sayılar başa, tek sayılar sona eklenmiştir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.ArrayDeque;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var random = new Random();
        var count = Console.readInt("Input a number:");
        var deque = new ArrayDeque<Integer>();

        for (int i = 0; i < count; ++i) {
            int val = random.nextInt(100);

            Console.write("%d ", val);
            if (val % 2 == 0)
                deque.addFirst(val);
            else
                deque.addLast(val);
        }
        Console.writeLine();

        deque.forEach(v -> Console.write("%d ", v));
        Console.writeLine();
    }
}
