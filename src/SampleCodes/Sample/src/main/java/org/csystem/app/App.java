/*----------------------------------------------------------------------------------------------------------------------
    Arrays sınıfınının sort metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

import java.util.Arrays;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        var r = new Random();
        var n = Console.readInt("Bir sayı giriniz:");
        var a = ArrayUtil.getRandomArray(r, n, 1, 99);

        ArrayUtil.display(2, a);
        Arrays.sort(a, 3, 7); //[3, 7)
        ArrayUtil.display(2, a);
    }
}