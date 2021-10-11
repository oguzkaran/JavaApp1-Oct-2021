/*--------------------------------------------------------------------------------------------------------------------
    NumericLottoApp sınıfı
---------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.sample;

import org.csystem.util.array.ArrayUtil;

import java.util.Scanner;

public final class NumericLottoApp {
    private NumericLottoApp()
    {
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        NumericLottery lotto = new NumericLottery();

        for (;;) {
            System.out.print("Kaç kupon oynamak istersin?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            ArrayUtil.display(2, lotto.getNumbers(n));
        }
    }
}
