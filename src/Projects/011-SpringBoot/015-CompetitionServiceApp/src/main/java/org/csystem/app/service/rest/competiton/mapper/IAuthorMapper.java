package org.csystem.app.service.rest.competiton.mapper;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.dto.AuthorDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorSaveDTO;
import org.csystem.app.service.rest.competiton.dto.AuthorsDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "AuthorMapperImpl", componentModel = "spring")
public interface IAuthorMapper {
    AuthorDetailDTO toAuthorDetailDTO(Author author);
    AuthorDTO toAuthorDTO(Author author);
    Author toAuthor(AuthorSaveDTO authorSaveDTO);
    default AuthorsDetailDTO toAuthorsDetailDTO(List<AuthorDetailDTO> authors)
    {
        var result = new AuthorsDetailDTO();

        result.setAuthors(authors);

        return result;
    }
}
