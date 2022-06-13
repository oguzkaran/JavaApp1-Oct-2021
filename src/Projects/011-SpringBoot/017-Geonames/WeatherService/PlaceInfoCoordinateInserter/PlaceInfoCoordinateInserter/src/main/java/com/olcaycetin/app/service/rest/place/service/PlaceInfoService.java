package com.olcaycetin.app.service.rest.place.service;

import com.olcaycetin.app.service.rest.place.data.dal.PlaceInfoServiceHelper;
import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import com.olcaycetin.app.service.rest.place.dto.PlaceInfoDTO;
import com.olcaycetin.app.service.rest.place.mapper.IPlaceInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlaceInfoService {
    public final PlaceInfoServiceHelper m_placeInfoServiceHelper;
    public final IPlaceInfoMapper m_placeInfoMapper;

    public PlaceInfoService(PlaceInfoServiceHelper placeInfoServiceHelper, IPlaceInfoMapper placeInfoMapper) {
        m_placeInfoServiceHelper = placeInfoServiceHelper;
        m_placeInfoMapper = placeInfoMapper;
    }

    public PlaceInfoDTO savePlaceInfo(PlaceInfoDTO placeInfoDTO)
    {
        var pi = m_placeInfoMapper.toPlaceInfo(placeInfoDTO);
        m_placeInfoServiceHelper.savePlaceInfo(pi);
        return  m_placeInfoMapper.toPlaceInfoDto(pi);
    }

    public List<PlaceInfoDTO> findAllPlaces()
    {
        return StreamSupport.stream(m_placeInfoServiceHelper.findAllPlaceInfos().spliterator(), false)
                .map(m_placeInfoMapper::toPlaceInfoDto).collect(Collectors.toList());
    }

    public void deleteById(int id)
    {
        m_placeInfoServiceHelper.deleteById(id);
    }

}
