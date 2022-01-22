/*----------------------------------------------------------------------------------------------------------------------
    Metot referans çeşitleri:
    1. static metot referansı (static method reference)
    2. Bir nesneye ilişkin non-static metot referansı (reference to an instance method of particular object)
    3. Bir türe ilişkin non-static metot referansı (reference to an instance method of any object of a particular type)
    4. ctor referansı (reference to constructor)

    Aşağıdaki örnekte referanslara atama şüphesiz metot parametreleri için de geçerlidir. Tamamen örnek amaçlı yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        Random r = new Random();

        IIntBinaryOperator ibo = IntOperation::multiply; //1 -> Lambda karşılığı: (a, b) -> IntOperation.multiply(a, b);

        Console.writeLine(ibo.apply(10, 20));
        Console.writeLine("----------------------------------------------------");

        IIntPredicate pred = NumberUtil::isPrime; //1 -> Lambda karşılığı: a -> NumberUtil.isPrime(a);

        Console.writeLine(pred.test(1_000_003));
        Console.writeLine("----------------------------------------------------");

        IIntSupplier intSupplier = r::nextInt; //2 -> Lambda karşılığı: () -> r.nextInt();
        Console.writeLine(intSupplier.get());
        Console.writeLine("----------------------------------------------------");

        IIntRandomBoundedSupplier ibs = Random::nextInt; //3 -> Lambda karşılığı: (r, b) -> r.nextInt(bound);

        Console.writeLine(ibs.get(r, 100));
        Console.writeLine("----------------------------------------------------");

        IStringToIntConverter  sti = String::length; //3 -> Lambda karşılığı: s -> s.length();

        Console.writeLine(sti.convert("csd"));
        Console.writeLine("----------------------------------------------------");

        IFunction<String, Integer> fsti = String::length; //3 -> Lambda karşılığı: s -> s.length(); //auto boxing

        int val = fsti.apply("csd"); //auto-boxing

        Console.writeLine(val);
        Console.writeLine("----------------------------------------------------");

        IFactory<Integer, IntValue> f = IntValue::new; //4 -> Lambda karşılığı: a -> new IntValue(a);

        IntValue ival = f.create(20);

        Console.writeLine(ival.getVal());
        Console.writeLine("----------------------------------------------------");

        IDefaultFactory<IntValue> fd = IntValue::new;

        ival = fd.create();

        Console.writeLine(ival.getVal());
        Console.writeLine("----------------------------------------------------");
    }
}

class IntOperation {
    //...
    public static int multiply(int a, int b)
    {
        return a * b;
    }
}

class IntValue {
    private int m_val;

    public IntValue()
    {

    }

    public IntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    //...
}

interface IFactory<T, R> {
    R create(T t);
}

interface IDefaultFactory<R> {
    R create();
}

interface IIntRandomBoundedSupplier {
    int get(Random r, int bound);
}

interface IIntRandomSupplier {
    int get(Random r);
}

interface IIntSupplier {
    int get();
}

interface IIntPredicate {
    boolean test(int val);
}

interface IStringToIntConverter {
    int convert(String s);
}

interface IFunction<T, R> {
    R apply(T t);
}

interface IIntBinaryOperator {
    int apply(int a, int b);
}