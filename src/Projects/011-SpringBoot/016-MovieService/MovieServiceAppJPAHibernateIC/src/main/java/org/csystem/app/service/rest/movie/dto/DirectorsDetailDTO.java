package org.csystem.app.service.rest.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DirectorsDetailDTO {
    private List<DirectorDetailDTO> m_directorsDetails;

    public static DirectorsDetailDTO of(List<DirectorDetailDTO> directorDetailDTOS)
    {
        return new DirectorsDetailDTO().setDirectorsDetails(directorDetailDTOS);
    }

    public List<DirectorDetailDTO> getDirectorsDetails()
    {
        return m_directorsDetails;
    }

    @JsonProperty("directors")
    public DirectorsDetailDTO setDirectorsDetails(List<DirectorDetailDTO> directorsDetails)
    {
        m_directorsDetails = directorsDetails;

        return this;
    }
}
