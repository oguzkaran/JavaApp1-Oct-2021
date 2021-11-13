/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden alınan gün ay ve yıl bilgilerine göre kişinin doğum günü geçmişse
    "geçmiş doğum gününüz kutlu olsun", o gün doğum günü ise "doğum gününüz kutlu olsun", doğum henüz gelmemişse
    "doğum gününüzü şimdiden kutlarız" mesajlarından birisini ekrana bastıran programı yazınız. Progamı Calendar ve
    GregorianCalendar sınıfları ile yazabilirsiniz
    (001-BirthDateRemainderConsoleAppCalendar)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        var birthDate = new GregorianCalendar(1976, Calendar.SEPTEMBER, 10);
        var today = new GregorianCalendar();
        var birthDay = new GregorianCalendar(today.get(Calendar.YEAR), birthDate.get(Calendar.MONTH), birthDate.get(Calendar.DAY_OF_MONTH));

        Console.writeLine(today.before(birthDay));
        Console.writeLine(today.after(birthDay));
    }
}
