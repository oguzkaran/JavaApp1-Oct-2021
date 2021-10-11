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
    {
    }

    public static <T, R> R filter(Stream<T> stream, Predicate<? super T> pred, Collector<? super T, ?, R> coll)
    {
        return stream.filter(pred).collect(coll);
    }

    public static <T, R> R filter(List<T> list, Predicate<? super T> pred, Collector<? super T, ?, R> coll)
    {
        return filter(list.stream(), pred, coll);
    }

    public static <T, R> R filter(T [] a, Predicate<? super T> pred, Collector<? super T, ?, R> coll)
    {
        return filter(Arrays.stream(a), pred, coll);
    }

    /*
    public static <T, R> R map(Stream<T> stream, Function<? super T, ? extends R> func, Collector<? super T, ?, R> coll)
    {
        return stream.map(func).collect(coll);
    }

    public static <T, R> R map(List<T> list, Function<? super T, ? extends R> func, Collector<? super T, ?, R> coll)
    {
        return map(list.stream(), func, coll);
    }

    public static <T, R> R map(T [] a, Function<? super T, ? extends R> func, Collector<? super T, ?, R> coll)
    {
        return map(Arrays.stream(a), func, coll);
    }

     */
    //...
}
