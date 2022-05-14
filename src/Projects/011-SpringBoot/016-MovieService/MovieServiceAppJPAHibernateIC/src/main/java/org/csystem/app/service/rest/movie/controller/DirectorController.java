package org.csystem.app.service.rest.movie.controller;

import org.csystem.app.service.rest.movie.service.MovieAppService;
import org.csystem.app.service.rest.movie.dto.DirectorsDetailDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/director/directors")
public class DirectorController {
    private final MovieAppService m_appService;

    public DirectorController(MovieAppService appService)
    {
        m_appService = appService;
    }

    @GetMapping("all")
    public DirectorsDetailDTO findAllDetail()
    {
        return m_appService.findAllDirectorsDetail();
    }

    @GetMapping("find/movie")
    public DirectorsDetailDTO findByMovieId(@RequestParam("id") long movieId)
    {
        return m_appService.findAllDirectorsDetailByMovieId(movieId);
    }
}
