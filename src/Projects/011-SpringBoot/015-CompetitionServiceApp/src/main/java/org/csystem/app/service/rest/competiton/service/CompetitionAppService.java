package org.csystem.app.service.rest.competiton.service;

import org.csystem.app.service.rest.competiton.data.dal.CompetitionServiceAppHelper;
import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.mapper.IAuthorMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompetitionAppService {
    private final CompetitionServiceAppHelper m_competitionServiceAppHelper;
    private final IAuthorMapper m_authorMapper;

    public CompetitionAppService(CompetitionServiceAppHelper competitionServiceAppHelper, IAuthorMapper authorMapper)
    {
        m_competitionServiceAppHelper = competitionServiceAppHelper;
        m_authorMapper = authorMapper;
    }

    public long authorCount()
    {
        return m_competitionServiceAppHelper.authorCount();
    }
    
    public Optional<AuthorDetailDTO> findAuthorDetailByEmail(String email)
    {
        return m_competitionServiceAppHelper.findAuthorByEmail(email).map(m_authorMapper::toAuthorDetailDTO);
    }

    public Iterable<AuthorDetailDTO> findAuthorDetailsByName(String name)
    {
        return StreamSupport.stream(m_competitionServiceAppHelper.findAuthorsByName(name).spliterator(), false)
                .map(m_authorMapper::toAuthorDetailDTO).collect(Collectors.toList());
    }

    public Optional<AuthorDTO> findAuthorByEmail(String email)
    {
        return m_competitionServiceAppHelper.findAuthorByEmail(email).map(m_authorMapper::toAuthorDTO);
    }

    public Iterable<AuthorDTO> findAuthorsByName(String name)
    {
        return StreamSupport.stream(m_competitionServiceAppHelper.findAuthorsByName(name).spliterator(), false)
                .map(m_authorMapper::toAuthorDTO).collect(Collectors.toList());
    }
}
