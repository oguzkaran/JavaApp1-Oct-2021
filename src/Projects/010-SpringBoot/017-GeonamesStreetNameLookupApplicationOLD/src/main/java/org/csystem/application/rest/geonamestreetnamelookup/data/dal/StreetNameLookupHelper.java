package org.csystem.application.rest.geonamestreetnamelookup.data.dal;

import org.csystem.application.rest.geonamestreetnamelookup.data.entity.AddressInfo;
import org.csystem.application.rest.geonamestreetnamelookup.data.entity.StreetInfo;
import org.csystem.application.rest.geonamestreetnamelookup.data.repository.IAddressRepository;
import org.csystem.application.rest.geonamestreetnamelookup.data.repository.IStreetInfoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StreetNameLookupHelper {
    private final IAddressRepository m_addressRepository;
    private final IStreetInfoRepository m_streetInfoRepository;

    public StreetNameLookupHelper(IAddressRepository addressRepository, IStreetInfoRepository streetInfoRepository)
    {
        m_addressRepository = addressRepository;
        m_streetInfoRepository = streetInfoRepository;
    }

    public boolean existStreetById(String street)
    {
        return m_streetInfoRepository.existsById(street);
    }
    public Optional<StreetInfo> findStreetById(String street)
    {
        return m_streetInfoRepository.findById(street);
    }

    public StreetInfo saveStreet(StreetInfo street)
    {
        return m_streetInfoRepository.save(street);
    }
    public AddressInfo saveAddress(AddressInfo address)
    {
        return m_addressRepository.save(address);
    }
}
