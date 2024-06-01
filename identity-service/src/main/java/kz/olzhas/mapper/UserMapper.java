package kz.olzhas.mapper;

import kz.olzhas.dto.UserDto;
import kz.olzhas.entity.UserCredential;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<UserCredential, UserDto> {
}
