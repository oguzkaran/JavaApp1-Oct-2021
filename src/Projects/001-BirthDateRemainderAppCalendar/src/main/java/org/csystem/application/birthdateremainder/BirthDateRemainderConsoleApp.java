/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününüz kutlu olsun", o gün doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüzü şimdiden kutlarız" mesajlarından birisini ekrana bastıran programı yazınız. Program Calendar ve
    GregorianCalendar sınıfları kullanılarak yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.birthdateremainder;

import org.csystem.util.console.Console;
import org.csystem.util.datetime.BirthDateInfo;

public final class BirthDateRemainderConsoleApp {
    private static BirthDateInfo getBirthDateInfo()
    {
        Console.writeLine("Doğum günü bilgilerinizi giriniz:");
        var day = Console.readInt("Gün?");

        if (day <= 0)
            return null;

        var month = Console.readInt("Ay?");
        var year = Console.readInt("Yıl?");

        return new BirthDateInfo(day, month, year);
    }

    private BirthDateRemainderConsoleApp()
    {
    }

    public static void run()
    {
        String [] messages = {"Doğum gününüz kutlu olsun", "Geçmiş doğum gününüz kutlu olsun", "Doğum gününüzü şimdiden kutlarız", };

        for (;;) {
            var birthDateIInfo = getBirthDateInfo();

            if (birthDateIInfo == null)
                break;

            var birthDateStatus = birthDateIInfo.getBirtDateStatus();

            Console.writeLine(messages[birthDateStatus.ordinal()]);
            Console.writeLine("Yaşınız:%f", birthDateIInfo.getAge());
        }
    }
}
