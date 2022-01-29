package org.csystem.application.factory.password;

import org.csystem.util.string.StringUtil;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class RandomPasswordFactory {
    private final Random m_random;
    private final int m_min;
    private final int m_max;
    private final int m_count;
    private final ArrayList<String> m_passwords;

    private void loadPasswords()
    {
        for (int i = 0; i  < m_count; ++i)
            m_passwords.add(StringUtil.getRandomTextEN(m_random.nextInt(m_max - m_min + 1) + m_min));
    }

    public RandomPasswordFactory(Random random, int min, int max, int count)
    {
        m_random = random;
        m_min = min;
        m_max = max;
        m_count = count;
        m_passwords = new ArrayList<>(m_count);
        loadPasswords();
    }

    public Optional<String> getPassword(int n)
    {
        for (var passwd : m_passwords)
            if (passwd.length() == n)
                return Optional.of(passwd);

        return Optional.empty();
    }
}
