package com.olcaycetin.app.service.rest.place.service;

import com.olcaycetin.app.service.rest.place.data.dal.PlaceInfoServiceHelper;
import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlaceInfoService {
    public final PlaceInfoServiceHelper m_placeInfoServiceHelper;

    public PlaceInfoService(PlaceInfoServiceHelper placeInfoServiceHelper) {
        m_placeInfoServiceHelper = placeInfoServiceHelper;
    }

    public PlaceInfo savePlaceInfo(PlaceInfo placeInfo)
    {
        return m_placeInfoServiceHelper.savePlaceInfo(placeInfo);
    }

    public List<PlaceInfo> findAllPlaces()
    {
        return StreamSupport.stream(m_placeInfoServiceHelper.findAllPlaceInfos().spliterator(), false).collect(Collectors.toList());
    }

}
