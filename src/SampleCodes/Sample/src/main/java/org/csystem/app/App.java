/*----------------------------------------------------------------------------------------------------------------------
    Java 11 ile birlikte lambda ifadelerinin parametre bildirimlerinde var kullanılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.function.FunctionalUtil;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        int [] a = {1, 2, 3, 5, 6};
        int [] b = new int[6];

        int count = FunctionalUtil.filter(a, b, val -> val % 2 == 0);

        FunctionalUtil.forEach(b, count, val -> Console.write("%d ", val));
    }
}

