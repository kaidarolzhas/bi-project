package kz.olzhas.restaurantservice.service;

import kz.olzhas.restaurantservice.dto.RestaurantRequest;
import kz.olzhas.restaurantservice.dto.RestaurantResponce;
import kz.olzhas.restaurantservice.model.Restaurant;
import org.apache.coyote.BadRequestException;

public interface RestaurantService {
    RestaurantResponce findById(Long id, String token);

    void save(String token, RestaurantRequest restaurantRequest);

    void update(Long id, RestaurantRequest restaurantRequest);

    void deleteById(Long id);


}
