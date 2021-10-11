package org.csystem.application.rest.postalcode.geonames.json.dto;

public class PostalCodeInfoGeoNames {
    public String adminName1;
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
