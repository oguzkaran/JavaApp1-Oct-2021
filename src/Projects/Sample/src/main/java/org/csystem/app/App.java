/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Parametresi ile aldığı int türden bir sayının kaç tane bitinin 1(bir) olduğunu döndüren setBitsCount
    isimli metot ile kaç tane sıfır olduğunu döndüren clearBitsCount metotlarını yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.bitwise.BitwiseUtil;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var a = Console.readInt("Bir sayı giriniz:");
        var b = Console.readLong("Bir sayı giriniz:");
        var c = Console.readByte("Bir sayı giriniz:");
        var d = Console.readShort("Bir sayı giriniz:");
        var ch = Console.readChar("Bir karakter giriniz:");

        BitwiseUtil.writeBits(a);
        BitwiseUtil.writeBits(b);
        BitwiseUtil.writeBits(c);
        BitwiseUtil.writeBits(d);
        BitwiseUtil.writeBits(ch);
    }
}

