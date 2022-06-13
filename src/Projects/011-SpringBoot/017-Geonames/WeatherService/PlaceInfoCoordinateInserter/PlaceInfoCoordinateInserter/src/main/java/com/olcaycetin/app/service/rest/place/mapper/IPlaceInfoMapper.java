package com.olcaycetin.app.service.rest.place.mapper;

import com.olcaycetin.app.service.rest.place.data.entity.PlaceInfo;
import com.olcaycetin.app.service.rest.place.dto.PlaceInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface IPlaceInfoMapper {
    PlaceInfo toPlaceInfo(PlaceInfoDTO placeInfoDTO);
    PlaceInfoDTO toPlaceInfoDto(PlaceInfo placeInfo);
}
