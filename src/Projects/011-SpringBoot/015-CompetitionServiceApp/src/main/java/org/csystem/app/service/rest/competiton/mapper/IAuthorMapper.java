package org.csystem.app.service.rest.competiton.mapper;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AuthorMapperImpl", componentModel = "spring")
public interface IAuthorMapper {
    AuthorDetailDTO toAuthorDetailDTO(Author author);
    AuthorDTO toAuthorDTO(Author author);
}
