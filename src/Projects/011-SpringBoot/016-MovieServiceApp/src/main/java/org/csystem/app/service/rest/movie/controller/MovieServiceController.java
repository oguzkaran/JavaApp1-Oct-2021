package org.csystem.app.service.rest.movie.controller;

import org.csystem.app.service.rest.movie.MovieAppService;
import org.csystem.app.service.rest.movie.dto.MoviesDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movie/movies")
public class MovieServiceController {
    private final MovieAppService m_movieAppService;

    public MovieServiceController(MovieAppService movieAppService)
    {
        m_movieAppService = movieAppService;
    }

    @GetMapping("count")
    public long count()
    {
        return m_movieAppService.movieCount();
    }

    @GetMapping("find/sdate/month")
    public MoviesDTO findByMonth(@RequestParam(name = "m") int month)
    {
        return m_movieAppService.findMoviesByMonth(month);
    }

    @GetMapping("find/sdate/year")
    public MoviesDTO findByYear(@RequestParam(name = "y") int year)
    {
        return m_movieAppService.findMoviesByYear(year);
    }

    @GetMapping("find/sdate/my")
    public MoviesDTO findByMonthAndYear(int month, int year)
    {
        return m_movieAppService.findMoviesByMonthAndYear(month, year);
    }

    @GetMapping("find/sdate/year/between")
    public MoviesDTO findByYearBetween(int begin, int end)
    {
        return m_movieAppService.findMoviesByYearBetween(begin, end);
    }

    //...
}
