/*----------------------------------------------------------------------------------------------------------------------
    Bir tamsayının belirli bir bitinin elde edilmesi:


    if ((x & 1 << k) != 0)
        k. bit 1
    else
        k.bit sıfır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.bitwise.BitwiseUtil;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        int k = 5;
        int a = 0x00_00_00_61;

        BitwiseUtil.writeBits(a);

        a = BitwiseUtil.toggleBit(a, k);

        BitwiseUtil.writeBits(a);
        Console.writeLine("a = %d", a);
    }
}

