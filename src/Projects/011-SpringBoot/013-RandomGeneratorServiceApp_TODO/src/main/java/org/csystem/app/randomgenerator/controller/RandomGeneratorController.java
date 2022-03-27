package org.csystem.app.randomgenerator.controller;


import org.csystem.app.randomgenerator.data.NumberInfo;
import org.csystem.app.randomgenerator.data.NumberType;
import org.csystem.app.randomgenerator.data.TextInfo;
import org.csystem.util.string.StringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

import static org.csystem.app.randomgenerator.data.NumberType.DOUBLE;
import static org.csystem.app.randomgenerator.data.NumberType.INT;


@RestController
@RequestMapping("api/random")
@Scope("prototype")
public class RandomGeneratorController {
    private final Random m_random;
    private final LocalDateTime m_dateTime;
    private final ApplicationContext m_context;

    private NumberInfo getNumberInfo(NumberType numberType, double a, double b)
    {
        var ni = new NumberInfo();

        ni.value = numberType == INT ? m_random.nextInt((int)b - (int)a + 1) + (int)a: m_random.nextDouble() * (b - a);
        ni.type = numberType.toString();
        ni.dateTime = m_dateTime;

        return ni;
    }

    public RandomGeneratorController(Random random, LocalDateTime dateTime, ApplicationContext context)
    {
        m_random = random;
        m_dateTime = dateTime;
        m_context = context;
    }

    @GetMapping("number/double")
    public NumberInfo getDoubleInfo(double min, double bound)
    {
        return getNumberInfo(DOUBLE, min, bound);
    }

    @GetMapping("number/int")
    public NumberInfo getIntInfo(@RequestParam(name = "min") int a, @RequestParam(name = "max") int b)
    {
        return getNumberInfo(INT, a, b);
    }

    @GetMapping("string/tr")
    public TextInfo getStringTR(int len)
    {
        var lang = "tr";
        var text = StringUtil.getRandomTextTR(m_random, len);

        return (TextInfo)m_context.getBean("textInfo", text, lang, m_dateTime);
    }

    @GetMapping("string/en")
    public TextInfo getStringEN(int len)
    {
        var lang = "en";
        var text = StringUtil.getRandomTextEN(m_random, len);

        return (TextInfo)m_context.getBean("textInfo", text, lang, m_dateTime);
    }
}
