package com.olcaycetin.app.service.rest.place.dto;

import javax.persistence.Column;

public class PlaceInfoDTO {

    public double north;
    public double south;
    public double east;
    public double west;
    public String placeName;

    public PlaceInfoDTO(double north, double south, double east, double west, String placeName) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.placeName = placeName;
    }


    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public double getSouth() {
        return south;
    }

    public void setSouth(double south) {
        this.south = south;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public double getWest() {
        return west;
    }

    public void setWest(double west) {
        this.west = west;
    }


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
