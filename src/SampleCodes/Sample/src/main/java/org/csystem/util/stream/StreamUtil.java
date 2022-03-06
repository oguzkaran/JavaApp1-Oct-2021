package org.csystem.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StreamUtil {
    private StreamUtil()
    {}

    public static <T, R> R filter(Stream<T> stream, Predicate<? super T> pred, Collector<? super T, ?, R> collector)
    {
        return stream.filter(pred).collect(collector);
    }

    public static <T, R> R filter(T[] a, Predicate<? super T> pred, Collector<? super T, ?, R> collector)
    {
        return filter(Arrays.stream(a), pred, collector);
    }

    public static <T, R> R filter(List<T> list, Predicate<? super T> pred, Collector<? super T, ?, R> collector)
    {
        return filter(list.stream(), pred, collector);
    }



    //...
}
