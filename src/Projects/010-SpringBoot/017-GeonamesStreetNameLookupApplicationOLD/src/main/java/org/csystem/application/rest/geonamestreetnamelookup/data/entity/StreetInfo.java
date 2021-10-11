package org.csystem.application.rest.geonamestreetnamelookup.data.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "streets")
public class StreetInfo {
    @Id
    @Column(name = "street")
    private String m_street;

    @OneToMany(mappedBy = "m_streetInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AddressInfo> m_addressInfos;

    public StreetInfo()
    {
    }

    public StreetInfo(String street)
    {
        m_street = street;
    }

    public String getStreet()
    {
        return m_street;
    }

    public void setStreet(String street)
    {
        m_street = street;
    }

    public Set<AddressInfo> getAddressInfos()
    {
        return m_addressInfos;
    }

    public void setAddressInfos(Set<AddressInfo> addressInfos)
    {
        m_addressInfos = addressInfos;
    }
}
