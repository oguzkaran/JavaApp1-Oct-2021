package org.csystem.app.service.rest.competiton.controller;

import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.service.CompetitionAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/author")
public class AuthorServiceController {
    private final CompetitionAppService m_competitionAppService;

    public AuthorServiceController(CompetitionAppService competitionAppService)
    {
        m_competitionAppService = competitionAppService;
    }

    @GetMapping("authors/count")
    public long count()
    {
        return m_competitionAppService.authorCount();
    }

    @GetMapping("authors/detail/email")
    public Optional<AuthorDetailDTO> findDetailsByEmail(@RequestParam(name = "e") String email) // Optional dönmeyecek
    {
        return m_competitionAppService.findAuthorDetailByEmail(email);
    }

    @GetMapping("authors/detail/name")
    public Iterable<AuthorDetailDTO> findDetailByName(@RequestParam(name = "n") String name)
    {
        return m_competitionAppService.findAuthorDetailsByName(name);
    }

    @GetMapping("authors/email")
    public Optional<AuthorDTO> findByEmail(@RequestParam(name = "e") String email) // Optional dönmeyecek
    {
        return m_competitionAppService.findAuthorByEmail(email);
    }

    @GetMapping("authors/name")
    public Iterable<AuthorDTO> findByName(@RequestParam(name = "n") String name)
    {
        return m_competitionAppService.findAuthorsByName(name);
    }
}
