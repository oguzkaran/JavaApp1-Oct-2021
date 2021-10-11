package org.csystem.application.rest.geonamestreetnamelookup.data.service;

import org.csystem.application.rest.geonamestreetnamelookup.data.dal.StreetNameLookupHelper;
import org.csystem.application.rest.geonamestreetnamelookup.data.entity.StreetInfo;
import org.csystem.application.rest.geonamestreetnamelookup.mapper.IAddressMapper;
import org.csystem.application.rest.geonamestreetnamelookup.viewmodel.StreetNameLookupViewModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class StreetNameLookupService {
    @Value("${geonames.url}")
    private String m_url;

    private final IAddressMapper m_addressMapper;
    private final RestTemplate m_restTemplate;
    private final StreetNameLookupHelper m_streetNameLookupHelper;

    private StreetNameLookupViewModel findStreetsFromDB(String query)
    {
        var opt = m_streetNameLookupHelper.findStreetById(query);
        var si = opt.orElseGet(() -> new StreetInfo(query));

        return new StreetNameLookupViewModel(si.getAddressInfos().stream()
                .map(m_addressMapper::toAddress).collect(Collectors.toList()));
    }

    private StreetNameLookupViewModel findStreetsFromGeonames(String query)
    {
        var url = String.format(m_url, query);
        var streetNameViewModel = m_restTemplate.getForObject(url, StreetNameLookupViewModel.class);
        var si = new StreetInfo(query);

        if (streetNameViewModel != null) {
            m_streetNameLookupHelper.saveStreet(si);
            streetNameViewModel.getAddress().stream()
                    .map(m_addressMapper::toAddressInfo)
                    .forEach(ai -> {
                            ai.setStreetInfo(si);
                            m_streetNameLookupHelper.saveAddress(ai);
                    });
        }

        return streetNameViewModel;
    }

    public StreetNameLookupService(IAddressMapper addressMapper, RestTemplate restTemplate, StreetNameLookupHelper streetNameLookupHelper)
    {
        m_addressMapper = addressMapper;
        m_restTemplate = restTemplate;
        m_streetNameLookupHelper = streetNameLookupHelper;
    }

    public StreetNameLookupViewModel findStreets(String query)
    {
        return m_streetNameLookupHelper.existStreetById(query) ? findStreetsFromDB(query) : findStreetsFromGeonames(query);
    }
}
