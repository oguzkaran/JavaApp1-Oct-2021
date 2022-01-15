package org.csystem.app.function;

public final class FunctionalUtil {
    private FunctionalUtil()
    {
    }

    public static void forEach(int [] a, int count, IIntConsumer consumer)
    {
        for (int i = 0; i < count; ++i)
            consumer.accept(a[i]);
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
