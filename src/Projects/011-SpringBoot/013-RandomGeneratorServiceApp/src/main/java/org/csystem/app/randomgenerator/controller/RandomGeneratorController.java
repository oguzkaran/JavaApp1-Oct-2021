package org.csystem.app.randomgenerator.controller;

import org.csystem.app.randomgenerator.data.Language;
import org.csystem.app.randomgenerator.data.NumberInfo;
import org.csystem.app.randomgenerator.data.NumberType;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

import static org.csystem.app.randomgenerator.data.NumberType.*;


@RestController
@RequestMapping("api/random")
@Scope("prototype")
public class RandomGeneratorController {
    private final Random m_random;
    private final LocalDateTime m_dateTime;

    private NumberInfo getNumberInfo(NumberType numberType)
    {
        var ni = new NumberInfo();

        ni.value = numberType == INT ? m_random.nextInt(100) : m_random.nextDouble();
        ni.type = numberType.toString();
        ni.dateTime = m_dateTime;

        return ni;
    }

    public RandomGeneratorController(Random random, LocalDateTime dateTime)
    {
        m_random = random;
        m_dateTime = dateTime;
    }

    @GetMapping("number/double")
    public NumberInfo getDoubleInfo()
    {
        return getNumberInfo(DOUBLE);
    }

    @GetMapping("number/int")
    public NumberInfo getIntInfo()
    {
        return getNumberInfo(INT);
    }
}
