package org.csystem.application.rest.geonamestreetnamelookup.mapper;

import org.csystem.application.rest.geonamestreetnamelookup.data.entity.AddressInfo;
import org.csystem.application.rest.geonamestreetnamelookup.viewmodel.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "AddressMapperImpl", componentModel = "spring")
public interface IAddressMapper {
    @Mappings({
            @Mapping(source ="addressInfo.longitude", target = "lng"),
            @Mapping(source ="addressInfo.postalCode", target = "postalcode"),
            @Mapping(source ="addressInfo.latitude", target = "lat"),
            @Mapping(source ="addressInfo.streetName", target = "street"),
    })
    Address toAddress(AddressInfo addressInfo);


    @Mappings({
            @Mapping(source ="address.lng", target = "longitude"),
            @Mapping(source ="address.postalcode", target = "postalCode"),
            @Mapping(source ="address.lat", target = "latitude"),
            @Mapping(source ="address.street", target = "streetName"),
    })
    AddressInfo toAddressInfo(Address address);
}
