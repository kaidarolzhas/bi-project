package kz.olzhas.restaurantservice.service;

import kz.olzhas.restaurantservice.model.Restaurant;
import org.apache.coyote.BadRequestException;

public interface RestaurantService {
    Restaurant getRestaurant(Long id) throws BadRequestException;

    void createRestaurant(Restaurant restaurant);
}
