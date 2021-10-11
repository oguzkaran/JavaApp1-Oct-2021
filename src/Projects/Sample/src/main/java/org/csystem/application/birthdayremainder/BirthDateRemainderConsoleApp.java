package org.csystem.application.birthdayremainder;

import org.csystem.util.Console;
import org.csystem.util.datetime.BirthDateInfo;

public class BirthDateRemainderConsoleApp {
    private static BirthDateInfo getBirthDateInfo()
    {
        Console.writeLine("Doğum günü bilgilerini giriniz:");
        var day = Console.readInt("Gün?");

        if (day <= 0)
            return null;

        var month = Console.readInt("Ay?");
        var year = Console.readInt("Yıl?");

        return new BirthDateInfo(day, month, year);
    }

    private BirthDateRemainderConsoleApp()
    {}

    public static void run()
    {
        String [] messages = {
                "geçmiş doğum gününüz kutlu olsun",
                "doğum gününüzü şimdiden kutlarız",
                "doğum gününüz kutlu olsun"};

        for (;;) {
            var birthDateInfo = getBirthDateInfo();

            if (birthDateInfo == null)
                break;

            var birthDateStatus = birthDateInfo.getBirthDateStatus();

            Console.writeLine(messages[birthDateStatus.ordinal()]);
            Console.writeLine("Yaşınız:%f%n", birthDateInfo.getAge());
        }

        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
