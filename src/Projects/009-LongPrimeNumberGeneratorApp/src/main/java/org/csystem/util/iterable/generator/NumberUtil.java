package org.csystem.util.iterable.generator;

final class NumberUtil {
    private NumberUtil()
    {
    }

    static boolean isPrime(long val)
    {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        int sqrtVal = (int)Math.sqrt(val);

        for (int i = 11; i <= sqrtVal; i += 2)
            if (val % i == 0)
                return false;

        return true;
    }
}
