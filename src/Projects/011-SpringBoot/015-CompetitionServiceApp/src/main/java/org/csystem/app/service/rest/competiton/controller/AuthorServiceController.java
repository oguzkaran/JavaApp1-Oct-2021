package org.csystem.app.service.rest.competiton.controller;

import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorSaveDTO;
import org.csystem.app.service.rest.competiton.service.CompetitionAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public ResponseEntity<AuthorDetailDTO> findDetailsByEmail(@RequestParam(name = "e") String email) // Optional dönmeyecek
    {
        return ResponseEntity.of(m_competitionAppService.findAuthorDetailByEmail(email));
    }

    @GetMapping("authors/detail/name")
    public Iterable<AuthorDetailDTO> findDetailByName(@RequestParam(name = "n") String name)
    {
        return m_competitionAppService.findAuthorDetailsByName(name);
    }

    @GetMapping("authors/email")
    public ResponseEntity<AuthorDTO> findByEmail(@RequestParam(name = "e") String email) // Optional dönmeyecek
    {
        var opt = m_competitionAppService.findAuthorByEmail(email);

        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); //of metodunun doğrudan yaptığı işlemler için yazıldı
    }

    @GetMapping("authors/name")
    public Iterable<AuthorDTO> findByName(@RequestParam(name = "n") String name)
    {
        return m_competitionAppService.findAuthorsByName(name);
    }

    @GetMapping("authors/detail/date/month")
    public Iterable<AuthorDetailDTO> findDetailByMonthBetween(int min, int max)
    {
        return m_competitionAppService.findAuthorDetailByMonthBetween(min, max);
    }

    @GetMapping("authors/detail/date/year")
    public Iterable<AuthorDetailDTO> findDetailByYearBetween(@RequestParam int min,
                                                             @RequestParam(required = false, defaultValue = "-1") int max)
    {
        if (max == -1) //Örnek amaçlı yazılmıştır
            max = LocalDate.now().getYear();

        return m_competitionAppService.findAuthorDetailByYearBetween(min, max);
    }

    @PostMapping("authors/save")
    public AuthorSaveDTO saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        return m_competitionAppService.saveAuthor(authorSaveDTO);
    }

    @PostMapping("authors/save/status")
    public boolean saveAuthorStatusResponse(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        try {
            m_competitionAppService.saveAuthor(authorSaveDTO);
            return true;
        }
        catch (Throwable ignore) {
            return false;
        }
    }
}
