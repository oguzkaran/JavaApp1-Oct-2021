package com.olcaycetin.app.service.rest.place.mapper;

import com.olcaycetin.app.service.rest.place.dto.PlaceInfoSaveDTO;
import org.csystem.app.weather.repository.data.entity.PlaceInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface IPlaceInfoMapper {
    PlaceInfo toPlaceInfo(PlaceInfoSaveDTO placeInfoDTO);
    PlaceInfoSaveDTO toPlaceInfoDto(PlaceInfo placeInfo);
}
