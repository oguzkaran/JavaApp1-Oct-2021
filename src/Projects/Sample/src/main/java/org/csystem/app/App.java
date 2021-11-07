/*----------------------------------------------------------------------------------------------------------------------
    Calendar sınıfının before ve after metotları
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
