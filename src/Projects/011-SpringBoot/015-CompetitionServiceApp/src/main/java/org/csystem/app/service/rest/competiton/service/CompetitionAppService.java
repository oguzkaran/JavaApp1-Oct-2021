package org.csystem.app.service.rest.competiton.service;

import org.csystem.app.service.rest.competiton.data.dal.CompetitionServiceAppHelper;
import org.csystem.app.service.rest.competiton.mapper.IAuthorMapper;
import org.springframework.stereotype.Service;

@Service
public class CompetitionAppService {
    private final CompetitionServiceAppHelper m_competitionServiceAppHelper;
    private final IAuthorMapper m_authorMapper;

    public CompetitionAppService(CompetitionServiceAppHelper competitionServiceAppHelper, IAuthorMapper authorMapper)
    {
        m_competitionServiceAppHelper = competitionServiceAppHelper;
        m_authorMapper = authorMapper;
    }

    //...
}
