package org.csystem.app.data.camera;

import org.csystem.util.string.StringUtil;

import java.util.Random;

public class RandomCarCamFactory {
    private final Random m_random;

    private String generatePlate()
    {
        var num = m_random.nextInt(81) + 1;
        var text = StringUtil.getRandomTextEN(m_random, m_random.nextInt(3) + 1).toUpperCase();
        var value = m_random.nextInt(9999) + 1;

        return String.format("%02d %s %04d", num, text, value);
    }

    public RandomCarCamFactory(Random random)
    {
        m_random = random;
    }

    public CarCamInfo getCarCamInfo()
    {
        return new CarCamInfo(generatePlate(), m_random.nextDouble() * 220 + 5.);
    }
}
