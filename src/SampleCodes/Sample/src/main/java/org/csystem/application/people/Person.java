package org.csystem.application.people;

import org.csystem.util.datetime.DateTimeFormatterUtil;

import java.time.LocalDate;
import java.util.Optional;

public class Person {
    private String m_firstName;
    private Optional<String> m_middleName;
    private String m_familyName;
    private LocalDate m_birthDate;

    public Person(String firstName, String familyName, LocalDate birthDate)
    {
        this(firstName, null, familyName, birthDate);
    }

    public Person(String firstName, String middleName, String familyName, LocalDate birthDate)
    {
        m_firstName = firstName;
        m_middleName = Optional.ofNullable(middleName);
        m_familyName = familyName;
        m_birthDate = birthDate;
    }

    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public String getFamilyName()
    {
        return m_familyName;
    }

    public void setFamilyName(String familyName)
    {
        m_familyName = familyName;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public Optional<String> getMiddleName()
    {
        return m_middleName;
    }

    public void setMiddleName(String middleName)
    {
        m_middleName = Optional.ofNullable(middleName);
    }

    public String getFullName()
    {
        return String.format("%s%s %s", m_firstName, m_middleName.map(n -> " " + n).orElse(""), m_familyName);
    }

    @Override
    public String toString()
    {
        return String.format("%s:%s", getFullName(), DateTimeFormatterUtil.DATE_TR.format(m_birthDate));
    }
}
