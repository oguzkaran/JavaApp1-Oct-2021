package org.csystem.application.rest.geonamestreetnamelookup.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address
{
    public String street;
    public String adminCode2;
    public String adminCode3;
    public String adminCode1;
    public String lng;
    public String locality;
    public String adminCode4;
    public String adminName2;
    public String postalcode;
    public String countryCode;
    public String adminName1;
    public String lat;
}
