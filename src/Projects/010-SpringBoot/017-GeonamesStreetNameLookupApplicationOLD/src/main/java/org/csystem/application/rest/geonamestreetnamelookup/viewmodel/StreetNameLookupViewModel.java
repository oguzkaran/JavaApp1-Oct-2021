package org.csystem.application.rest.geonamestreetnamelookup.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreetNameLookupViewModel
{
    private List<Address> m_address;

    public StreetNameLookupViewModel()
    {
    }

    public StreetNameLookupViewModel(List<Address> address)
    {
        m_address = address;
    }

    public List<Address> getAddress()
    {
        return m_address;
    }

    public void setAddress(List<Address> address)
    {
        m_address = address;
    }
}
