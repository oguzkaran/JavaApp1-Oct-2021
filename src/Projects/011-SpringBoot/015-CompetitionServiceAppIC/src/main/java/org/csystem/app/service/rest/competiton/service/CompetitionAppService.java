package org.csystem.app.service.rest.competiton.service;

import org.csystem.app.service.rest.competiton.data.dal.CompetitionServiceAppHelper;
import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorSaveDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorsDetailDTO;
import org.csystem.app.service.rest.competiton.mapper.IAuthorMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.csystem.util.collection.CollectionUtil.toIterable;
import static org.csystem.util.collection.CollectionUtil.toList;

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

    public Iterable<AuthorDetailDTO> findAllDetailAuthors()
    {
        return toIterable(m_competitionServiceAppHelper.findAllAuthors(), m_authorMapper::toAuthorDetailDTO);
    }
    
    public Optional<AuthorDetailDTO> findAuthorDetailByEmail(String email)
    {
        return m_competitionServiceAppHelper.findAuthorByEmail(email).map(m_authorMapper::toAuthorDetailDTO);
    }

    public Iterable<AuthorDetailDTO> findAuthorsDetailsByName(String name)
    {
        return toIterable(m_competitionServiceAppHelper.findAuthorsByName(name), m_authorMapper::toAuthorDetailDTO);
    }

    public AuthorsDetailDTO findAuthorsDetailByNameContains(String text)
    {
        return m_authorMapper.toAuthorsDetailDTO(toList(m_competitionServiceAppHelper.findAuthorsByNameContains(text), m_authorMapper::toAuthorDetailDTO));
    }

    public Optional<AuthorDTO> findAuthorByEmail(String email)
    {
        return m_competitionServiceAppHelper.findAuthorByEmail(email).map(m_authorMapper::toAuthorDTO);
    }

    public Iterable<AuthorDTO> findAuthorsByName(String name)
    {
        return toIterable(m_competitionServiceAppHelper.findAuthorsByName(name), m_authorMapper::toAuthorDTO);
    }

    public Iterable<AuthorDetailDTO> findAuthorsDetailByMonthBetween(int min, int max)
    {
        return toIterable(m_competitionServiceAppHelper.findAuthorsByMonthBetween(min, max), m_authorMapper::toAuthorDetailDTO);
    }

    public Iterable<AuthorDetailDTO> findAuthorsDetailByYearBetween(int min, int max)
    {
        return toIterable(m_competitionServiceAppHelper.findAuthorsByYearBetween(min, max), m_authorMapper::toAuthorDetailDTO);
    }

    public Iterable<AuthorDetailDTO> findAuthorsDetailByMonthAndYear(int month, int year)
    {
        return toIterable(m_competitionServiceAppHelper.findAuthorsByMonthAndYear(month, year), m_authorMapper::toAuthorDetailDTO);
    }

    public AuthorSaveDTO saveAuthor(AuthorSaveDTO authorSaveDTO)
    {
        m_competitionServiceAppHelper.saveAuthor(m_authorMapper.toAuthor(authorSaveDTO));

        return authorSaveDTO;
    }
}
