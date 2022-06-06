package com.olcaycetin.app.service.rest.place.controller;

import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import com.olcaycetin.app.service.rest.place.service.PlaceInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/place")
public class PlaceInfoController {
    public final PlaceInfoService m_placeInfoService;

    public PlaceInfoController(PlaceInfoService placeInfoService) {
        m_placeInfoService = placeInfoService;
    }


    @PostMapping("save")
    public PlaceInfo savePlaceInfo(@RequestParam(name = "n") double north,
                                   @RequestParam(name = "s") double south,
                                   @RequestParam(name = "e") double east,
                                   @RequestParam(name = "w") double west,
                                   @RequestParam(name = "pn") String placeName)
    {
        return m_placeInfoService.savePlaceInfo(new PlaceInfo(north, south, east, west));
    }

    @GetMapping("all")
    public List<PlaceInfo> findAllPlaces()
    {
        return m_placeInfoService.findAllPlaces();
    }
}
