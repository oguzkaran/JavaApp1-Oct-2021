package org.csystem.application.rest.geonamestreetnamelookup.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_info_id")
    private long m_id;

    @Column(name = "street_name", nullable = false)
    public String m_streetName;

    @Column(name = "admin_code2", nullable = false)
    public String m_adminCode2;

    @Column(name = "admin_code1", nullable = false)
    public String m_adminCode1;

    @Column(name = "longitude", nullable = false)
    public String m_longitude;

    @Column(name = "locality", nullable = false)
    public String m_locality;

    @Column(name = "admin_name2", nullable = false)
    public String m_adminName2;

    @Column(name = "postal_code", nullable = false)
    public String m_postalCode;

    @Column(name = "country_code", nullable = false)
    public String m_countryCode;

    @Column(name = "admin_name1", nullable = false)
    public String m_adminName1;

    @Column(name = "latitute", nullable = false)
    public String m_latitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street", nullable = false)
    private StreetInfo m_streetInfo;

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }


    public String getStreetName()
    {
        return m_streetName;
    }

    public void setStreetName(String streetName)
    {
        m_streetName = streetName;
    }

    public String getAdminCode2()
    {
        return m_adminCode2;
    }

    public void setAdminCode2(String adminCode2)
    {
        m_adminCode2 = adminCode2;
    }

    public String getAdminCode1()
    {
        return m_adminCode1;
    }

    public void setAdminCode1(String adminCode1)
    {
        m_adminCode1 = adminCode1;
    }

    public String getLongitude()
    {
        return m_longitude;
    }

    public void setLongitude(String longitude)
    {
        m_longitude = longitude;
    }

    public String getLocality()
    {
        return m_locality;
    }

    public void setLocality(String locality)
    {
        m_locality = locality;
    }

    public String getAdminName2()
    {
        return m_adminName2;
    }

    public void setAdminName2(String adminName2)
    {
        m_adminName2 = adminName2;
    }

    public String getPostalCode()
    {
        return m_postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        m_postalCode = postalCode;
    }

    public String getCountryCode()
    {
        return m_countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        m_countryCode = countryCode;
    }

    public String getAdminName1()
    {
        return m_adminName1;
    }

    public void setAdminName1(String adminName1)
    {
        m_adminName1 = adminName1;
    }

    public String getLatitude()
    {
        return m_latitude;
    }

    public void setLatitude(String latitude)
    {
        m_latitude = latitude;
    }

    public StreetInfo getStreetInfo()
    {
        return m_streetInfo;
    }

    public void setStreetInfo(StreetInfo streetInfo)
    {
        m_streetInfo = streetInfo;
    }
}
