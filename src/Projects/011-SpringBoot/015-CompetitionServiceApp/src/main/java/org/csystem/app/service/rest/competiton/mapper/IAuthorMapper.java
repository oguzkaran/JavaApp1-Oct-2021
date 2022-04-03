package org.csystem.app.service.rest.competiton.mapper;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;

public interface IAuthorMapper {
    AuthorDetailDTO toAuthorDetailDTO(Author author);
    //...
}
