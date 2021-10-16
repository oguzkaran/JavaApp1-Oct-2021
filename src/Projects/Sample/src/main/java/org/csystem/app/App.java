package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            int n = Console.readInt("Bir sayı giriniz:", "Hatalı giriş yaptınız!...");

            if (n <= 0)
                break;

            System.out.printf("Text:%s%n", StringUtil.getRandomTextTR(n));
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
