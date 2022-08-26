package org.csystem.app.randomuser.collector.mapper;

import org.csystem.app.randomuser.collector.data.entity.UserInfo;
import org.csystem.app.randomuser.collector.dto.UserInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "UserInfoMapperImpl", componentModel = "spring")
public interface IUserInfoMapper {
    UserInfo toUserInfo(UserInfoDTO dto);
}
