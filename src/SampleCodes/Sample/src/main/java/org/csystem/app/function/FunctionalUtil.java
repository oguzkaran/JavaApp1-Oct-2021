package org.csystem.app.function;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public final class FunctionalUtil {
    private FunctionalUtil()
    {
    }

    public static <T> Optional<T> reduce(T [] a, BinaryOperator<T> bop)
    {
        T result = a.length == 0 ? null : a[0];

        if (result != null)
            for (int i = 1; i < a.length; ++i)
                result = bop.apply(result, a[i]);

        return Optional.ofNullable(result);
    }

    public static OptionalInt reduce(int [] a, IntBinaryOperator bop)
    {
        if (a.length == 0)
            return OptionalInt.empty();

        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = bop.applyAsInt(result, a[i]);

        return OptionalInt.of(result);
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
