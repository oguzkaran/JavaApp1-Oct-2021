package org.csystem.application.rest.todo.configuration;

import org.csystem.application.rest.todo.mapper.ITodoInfoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ITodoInfoMapper getTodoInfoMapper()
    {
        return Mappers.getMapper(ITodoInfoMapper.class);
    }
}
