package kz.olzhas.restaurantservice.mapper;

import java.util.List;

public interface Mappable<E,D>{
    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntityList(List<D> dto);
    List<D> toDtoList(List<E> entity);

}
