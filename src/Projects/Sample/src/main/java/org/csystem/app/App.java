/*----------------------------------------------------------------------------------------------------------------------
    StringBuilder sınıfının setLength metodu yazının uzunluğu değiştirilebilir. Bu durumda eğer yazının azaltılıyor ise
    yazının bazı karakterleri kaybedilir, artırılıyor ise eklenen karakterker null karaketer ('\0') ile beslenir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        String s = Console.read("Bir yazı giriniz:");
        StringBuilder sb = new StringBuilder(s);

        sb.setLength(5);

        Console.writeLine(sb.toString());
    }
}
