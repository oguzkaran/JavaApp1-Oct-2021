package org.csystem.app.service.rest.movie.mapper;


import org.csystem.app.service.rest.movie.data.entity.DirectorDetail;
import org.csystem.app.service.rest.movie.dto.DirectorDetailDTO;
import org.csystem.app.service.rest.movie.dto.DirectorsDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DirectorMapperImpl", componentModel = "spring")
public interface IDirectorMapper {
    DirectorDetailDTO toDirectorDetailDTO(DirectorDetail directorDetail);
    default DirectorsDetailDTO toDirectorsDetail(List<DirectorDetailDTO> directorDetails)
    {
        return DirectorsDetailDTO.of(directorDetails);
    }
}
