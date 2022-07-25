package com.enesyilmaz.app.service.rest.place.mapper;

import com.enesyilmaz.app.service.rest.place.dto.PlaceInfoSaveDTO;
import org.csystem.app.weather.repository.backup.data.entity.PlaceInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface IPlaceInfoMapper {
    PlaceInfo toPlaceInfo(PlaceInfoSaveDTO placeInfoDTO);
    PlaceInfoSaveDTO toPlaceInfoDto(PlaceInfo placeInfo);
}
