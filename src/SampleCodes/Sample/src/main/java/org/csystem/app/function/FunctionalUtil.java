package org.csystem.app.function;

import java.util.function.Predicate;

public final class FunctionalUtil {
    private FunctionalUtil()
    {
    }

    public static void forEach(int [] a, int count, IIntConsumer consumer)
    {
        for (int i = 0; i < count; ++i)
            consumer.accept(a[i]);
    }

    public static <T> void forEach(T [] a, int count, IConsumer<T> consumer)
    {
        for (int i = 0; i < count; ++i)
            consumer.accept(a[i]);
    }

    public static <T> int filter(T[] src, T [] dest, IPredicate<T> predicate)
    {
        int index = 0;

        for (var val : src)
            if (predicate.test(val))
                dest[index++] = val;

        return index;
    }


    public static int filter(int [] src, int [] dest, IIntPredicate predicate)
    {
        int index = 0;

        for (var val : src)
            if (predicate.test(val))
                dest[index++] = val;

        return index;
    }

}
