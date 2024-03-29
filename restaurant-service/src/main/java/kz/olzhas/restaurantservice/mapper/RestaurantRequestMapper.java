package kz.olzhas.restaurantservice.mapper;

import kz.olzhas.restaurantservice.dto.RestaurantRequest;
import kz.olzhas.restaurantservice.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantRequestMapper extends Mappable<Restaurant, RestaurantRequest> {
}
