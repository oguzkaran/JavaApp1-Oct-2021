package com.olcaycetin.app.service.rest.place.data.dal;

import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import com.olcaycetin.app.service.rest.place.data.repository.IPlaceInfoRepository;
import org.springframework.stereotype.Component;

@Component
public class PlaceInfoServiceHelper {
    private final IPlaceInfoRepository m_placeInfoRepository;

    public PlaceInfoServiceHelper(IPlaceInfoRepository placeInfoRepository) {
        m_placeInfoRepository = placeInfoRepository;
    }

    public PlaceInfo savePlaceInfo(PlaceInfo placeInfo)
    {
        return m_placeInfoRepository.save(placeInfo);
    }

    public Iterable<PlaceInfo> findAllPlaceInfos()
    {
        return m_placeInfoRepository.findAll();
    }

    public void deleteById(int id)
    {
        m_placeInfoRepository.deleteById(id);
    }
}
