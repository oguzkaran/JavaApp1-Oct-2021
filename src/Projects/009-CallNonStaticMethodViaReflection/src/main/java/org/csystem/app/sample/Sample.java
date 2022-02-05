package org.csystem.app.sample;

public class Sample {
    private Sample()
    {
        System.out.println("Sample.Sample()");
    }

    public static void foo(Object val)
    {
        System.out.printf("foo:val=%s%n", val);
    }
}
