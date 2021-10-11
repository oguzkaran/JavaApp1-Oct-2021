package org.csystem.application.rest.postalcode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PostalCodeInfoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode1;
    public String placeName;
    public double lat;
    public double lng;

    @Override
    public String toString()
    {
        return String.format("%s, %s, %s, %f, %f", adminCode1, adminName1, placeName, lng, lat);
    }
}
