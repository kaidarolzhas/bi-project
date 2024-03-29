package kz.olzhas.restaurantservice.service.impl;

import kz.olzhas.restaurantservice.model.Restaurant;
import kz.olzhas.restaurantservice.repository.RestaurantRepository;
import kz.olzhas.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public Restaurant getRestaurant(Long id) throws BadRequestException {
        return restaurantRepository.findById(id)
                .orElseThrow(BadRequestException::new);

    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
