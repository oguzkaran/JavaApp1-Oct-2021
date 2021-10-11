package org.csystem.application.rest.postalcode.mapper;

import org.csystem.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.csystem.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.csystem.application.rest.postalcode.geonames.json.dto.PostalCodeInfoGeoNames;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeInfoMapper", componentModel = "spring")
public interface IPostalCodeMapper {
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfo postalCode);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoDTO postalCodeInfoDTO);
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfoGeoNames postalCodeInfoGeoNames);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoGeoNames postalCodeInfoGeoNames);
}
