package org.csystem.application.factory;

import org.csystem.util.math.Complex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomComplexFactory {
    private final Random m_random;

    public RandomComplexFactory(Random random)
    {
        m_random = random;
    }

    public Complex getComplexNumber(double min, double max)
    {
        return new Complex(m_random.nextDouble() * (max - min) + min, m_random.nextDouble() * (max - min) + min);
    }

    public List<Complex> getComplexNumbers(int count, double min, double max)
    {
        var list = new ArrayList<Complex>();

        for (int i = 0; i < count; ++i)
            list.add(getComplexNumber(min, max));

        return list;
    }
}
