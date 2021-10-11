package org.csystem.application.rest.geonamestreetnamelookup.controller;


import org.csystem.application.rest.geonamestreetnamelookup.data.service.StreetNameLookupService;
import org.csystem.application.rest.geonamestreetnamelookup.viewmodel.Address;
import org.csystem.application.rest.geonamestreetnamelookup.viewmodel.StreetNameLookupViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.csystem.util.exception.ExceptionUtil.*;

@RestController
@RequestMapping("api/streetNameLookupJSON")
public class StreetNameLookupController {
    private final StreetNameLookupService m_streetNameLookupService;

    public StreetNameLookupController(StreetNameLookupService streetNameLookupService)
    {
        m_streetNameLookupService = streetNameLookupService;
    }

    @GetMapping("/info")
    public StreetNameLookupViewModel getStreetNames(@RequestParam("q") String query)
    {
        return subscribe(() -> m_streetNameLookupService.findStreets(query), ex -> new StreetNameLookupViewModel());
    }

    @GetMapping("/first")
    public Address getFirstStreetName(@RequestParam("q") String query)
    {
        return subscribe(() -> m_streetNameLookupService.findStreets(query).getAddress().get(0), ex -> new Address());
    }
}
