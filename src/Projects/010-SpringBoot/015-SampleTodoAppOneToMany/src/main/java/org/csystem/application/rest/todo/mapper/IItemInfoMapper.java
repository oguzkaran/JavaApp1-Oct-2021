package org.csystem.application.rest.todo.mapper;

import org.csystem.application.rest.todo.data.entity.Item;
import org.csystem.application.rest.todo.dto.ItemInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemInfoMapperImpl", componentModel = "spring")
public interface IItemInfoMapper {
    Item toItem(ItemInfoDTO itemInfoDTO);

    ItemInfoDTO toItemInfoDTO(Item item);
}
