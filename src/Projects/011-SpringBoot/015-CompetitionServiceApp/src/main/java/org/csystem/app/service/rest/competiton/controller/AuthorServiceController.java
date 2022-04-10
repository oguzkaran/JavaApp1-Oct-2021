package org.csystem.app.service.rest.competiton.controller;

import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorSaveDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorsDetailDTO;
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

    @GetMapping("authors/detail/all")
    public Iterable<AuthorDetailDTO> findAllDetail()
    {
        return m_competitionAppService.findAllDetailAuthors();
    }

    @GetMapping("authors/detail/email")
    public ResponseEntity<AuthorDetailDTO> findDetailsByEmail(@RequestParam(name = "e") String email)
    {
        return ResponseEntity.of(m_competitionAppService.findAuthorDetailByEmail(email));
    }

    @GetMapping("authors/detail/name/contains")
    public AuthorsDetailDTO findDetailByNameContains(@RequestParam(name = "t") String text)
    {
        return m_competitionAppService.findAuthorsDetailByNameContains(text);
    }

    @GetMapping("authors/detail/name")
    public Iterable<AuthorDetailDTO> findDetailByName(@RequestParam(name = "n") String name)
    {
        return m_competitionAppService.findAuthorsDetailsByName(name);
    }

    @GetMapping("authors/email")
    public ResponseEntity<AuthorDTO> findByEmail(@RequestParam(name = "e") String email)
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
        return m_competitionAppService.findAuthorsDetailByMonthBetween(min, max);
    }

    @GetMapping("authors/detail/date/year")
    public Iterable<AuthorDetailDTO> findDetailByYearBetween(@RequestParam int min,
                                                             @RequestParam(required = false, defaultValue = "-1") int max)
    {
        if (max == -1) //Örnek amaçlı yazılmıştır
            max = LocalDate.now().getYear();

        return m_competitionAppService.findAuthorsDetailByYearBetween(min, max);
    }

    @GetMapping("authors/detail/date/my")
    public Iterable<AuthorDetailDTO> findDetailByMonthAndYear(@RequestParam int month,
                                                             @RequestParam int year)
    {
        return m_competitionAppService.findAuthorsDetailByMonthAndYear(month, year);
    }

    @PostMapping("authors/save")
    public AuthorSaveDTO saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        return m_competitionAppService.saveAuthor(authorSaveDTO);
    }

    @PostMapping("authors/save/status")
    public boolean saveAuthorStatusResponse(@RequestBody AuthorSaveDTO authorSaveDTO)
    {
        boolean status = false;
        try {
            m_competitionAppService.saveAuthor(authorSaveDTO);
            status = true;
        }
        catch (Throwable ignore) {

        }

        return status;
    }
}

/*
{
    "authors":
    [
        {
            "name": "Kara Heathorn",
            "email": "kheathorn74@va.gov",
            "registerDate": "2021-10-13"
        },
        {
            "name": "Kara Simmgen",
            "email": "ksimmgenao@arizona.edu",
            "registerDate": "2021-10-12"
        }
    ]
}
 */