package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.dto.request.UserRegisterRequestDTO;
import kz.g134.onlineShop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRegisterRequestDTO registerRequest);
}
