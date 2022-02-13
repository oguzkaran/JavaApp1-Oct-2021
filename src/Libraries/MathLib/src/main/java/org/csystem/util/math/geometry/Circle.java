/*----------------------------------------------------------------------
	FILE        : Circle.java
	AUTHOR      : JavaApp1-Oct-2021 Group
	LAST UPDATE : 13.02.2022

	Circle class that represents the circle in geometry

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Circle {
    private double m_r;

    public Circle()
    {}

    public Circle(double r)
    {
        setRadius(r);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        m_r = abs(r);
    }

    public double getArea()
    {
        return PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * PI * m_r;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Circle))
            return false;

        return Double.valueOf(m_r).equals(((Circle)other).m_r);
    }

    @Override
    public String toString()
    {
        return String.format("{r: %f, area: %f, circumference:%f}", m_r, getArea(), getCircumference());
    }
}
