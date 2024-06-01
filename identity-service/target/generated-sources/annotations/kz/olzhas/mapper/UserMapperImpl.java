package kz.olzhas.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.olzhas.dto.UserDto;
import kz.olzhas.entity.UserCredential;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T12:56:24+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserCredential toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserCredential userCredential = new UserCredential();

        userCredential.setId( dto.getId() );
        userCredential.setEmail( dto.getEmail() );
        userCredential.setFirstname( dto.getFirstname() );
        userCredential.setLastname( dto.getLastname() );
        userCredential.setDateOfBirth( dto.getDateOfBirth() );

        return userCredential;
    }

    @Override
    public UserDto toDto(UserCredential e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( e.getId() );
        userDto.setFirstname( e.getFirstname() );
        userDto.setLastname( e.getLastname() );
        userDto.setEmail( e.getEmail() );
        userDto.setDateOfBirth( e.getDateOfBirth() );

        return userDto;
    }

    @Override
    public List<UserCredential> toEntityList(List<UserDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<UserCredential> list = new ArrayList<UserCredential>( dto.size() );
        for ( UserDto userDto : dto ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDtoList(List<UserCredential> e) {
        if ( e == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( e.size() );
        for ( UserCredential userCredential : e ) {
            list.add( toDto( userCredential ) );
        }

        return list;
    }
}
