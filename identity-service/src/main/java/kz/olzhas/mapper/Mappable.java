package kz.olzhas.mapper;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D dto);

    D toDto(E e);

    List<E> toEntityList(List<D> dto);

    List<D> toDtoList(List<E> e);
}
