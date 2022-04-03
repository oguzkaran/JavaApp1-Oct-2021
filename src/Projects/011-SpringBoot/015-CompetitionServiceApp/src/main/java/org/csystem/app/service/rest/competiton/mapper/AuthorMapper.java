package org.csystem.app.service.rest.competiton.mapper;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.dto.AuthorDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements IAuthorMapper {
    @Override
    public AuthorDetailDTO toAuthorDetailDTO(Author author)
    {
        var dto = new AuthorDetailDTO();

        dto.setName(author.name);
        dto.setEmail(author.email);
        dto.setRegisterTime(author.registerTime);

        return dto;
    }

    //...
}
