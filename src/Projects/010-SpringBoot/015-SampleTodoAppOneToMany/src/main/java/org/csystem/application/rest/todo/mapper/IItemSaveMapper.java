package org.csystem.application.rest.todo.mapper;

import org.csystem.application.rest.todo.data.entity.Item;
import org.csystem.application.rest.todo.dto.ItemSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "ItemSaveMapperImpl", componentModel = "spring")
public interface IItemSaveMapper {
    @Mappings(@Mapping(source = "todoId", target = "todoId")) //Aslında ihtiyaç yok. Sade göstermek için yazıldı
    Item toItem(ItemSaveDTO itemSaveDTO);

    @Mappings(@Mapping(source = "todoId", target = "todoId")) //Aslında ihtiyaç yok. Sade göstermek için yazıldı
    ItemSaveDTO toItemSaveDTO(Item item);
}
