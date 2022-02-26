package org.csystem.app.data.camera;

import org.csystem.util.datetime.DateTimeFormatterUtil;

import java.time.LocalDateTime;
import java.util.Locale;

public class CarCamInfo {
    private String m_plate;
    private double m_speed;
    private LocalDateTime m_passTime;

    public CarCamInfo(String plate, double speed)
    {
        this(plate, speed, LocalDateTime.now());
    }

    public CarCamInfo(String plate, double speed, LocalDateTime passTime)
    {
        //...
        m_plate = plate;
        m_speed = speed;
        m_passTime = passTime;
    }

    public String getPlate()
    {
        return m_plate;
    }

    public void setPlate(String plate)
    {
        //...
        m_plate = plate;
    }

    public double getSpeed()
    {
        return m_speed;
    }

    public void setSpeed(double speed)
    {
        //...
        m_speed = speed;
    }

    public LocalDateTime getPassTime()
    {
        return m_passTime;
    }

    public void setPassTime(LocalDateTime passTime)
    {
        //...
        m_passTime = passTime;
    }

    @Override
    public String toString()
    {
        var formatter = DateTimeFormatterUtil.DATETIME_DOT_SEC_TR;

        return String.format("[%s] %fkm / h %s", m_plate, m_speed, formatter.format(m_passTime));
    }
}
