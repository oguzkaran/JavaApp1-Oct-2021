package org.csystem.application.service.rest.movie.service;

import org.csystem.application.service.rest.movie.converter.DirectorConverter;
import org.csystem.application.service.rest.movie.data.dal.MovieServiceApplicationDAL;
import org.csystem.application.service.rest.movie.dto.DirectorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class DirectorService {
    private final MovieServiceApplicationDAL m_movieServiceApplicationDAL;
    private final DirectorConverter m_directorConverter;

    private DirectorDTO saveDirectorCallback(DirectorDTO directorDTO)
    {
        m_movieServiceApplicationDAL.saveDirector(m_directorConverter.toDirector(directorDTO));

        return directorDTO;
    }

    private List<DirectorDTO> findAllDirectorsCallback()
    {
        return StreamSupport.stream(m_movieServiceApplicationDAL.findAllDirectors().spliterator(), false)
                .map(m_directorConverter::toDirectorDTO)
                .collect(Collectors.toList());
    }

    public DirectorService(MovieServiceApplicationDAL movieServiceApplicationDAL, DirectorConverter directorConverter)
    {
        m_movieServiceApplicationDAL = movieServiceApplicationDAL;
        m_directorConverter = directorConverter;
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        return doWorkForService(() -> saveDirectorCallback(directorDTO), "MovieApplicationService.saveDirector");
    }

    public List<DirectorDTO> findAllDirectors()
    {
        return doWorkForService(this::findAllDirectorsCallback, "MovieApplicationService.findAllDirectors");
    }

    //...
}
