package com.olcaycetin.app.service.rest.place.data.entity;



import javax.persistence.*;

@Entity
@Table(name = "place_info")
public class PlaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_info_id")
    public int id;

    @Column(name = "place_name", nullable = false)
    public String placeName;

    @Column(nullable = false)
    public double north;

    @Column(nullable = false)
    public double south;

    @Column(nullable = false)
    public double east;

    @Column(nullable = false)
    public double west;


}
