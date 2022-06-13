package com.olcaycetin.app.service.rest.place.controller;

import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import com.olcaycetin.app.service.rest.place.dto.PlaceInfoDTO;
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
    public PlaceInfoDTO savePlaceInfo( double north, double south, double east, double west, @RequestParam(name = "pn") String placeName)
    {
        return m_placeInfoService.savePlaceInfo(new PlaceInfoDTO(north, south, east, west, placeName));
    }

    @GetMapping("all")
    public List<PlaceInfoDTO> findAllPlaces()
    {
        return m_placeInfoService.findAllPlaces();
    }

    @GetMapping("delete")
    public void deleteById(@RequestParam(name = "id") int id)
    {
        m_placeInfoService.deleteById(id);
    }
}
