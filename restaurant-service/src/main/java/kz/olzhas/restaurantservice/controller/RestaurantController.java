package kz.olzhas.restaurantservice.controller;

import kz.olzhas.restaurantservice.dto.RestaurantRequest;
import kz.olzhas.restaurantservice.dto.RestaurantResponce;
import kz.olzhas.restaurantservice.mapper.RestaurantRequestMapper;
import kz.olzhas.restaurantservice.mapper.RestaurantResponseMapper;
import kz.olzhas.restaurantservice.model.Restaurant;
import kz.olzhas.restaurantservice.repository.RestaurantRepository;
import kz.olzhas.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantResponseMapper restaurantResponseMapper;
    private final RestaurantRequestMapper restaurantRequestMapper;
    private final RestaurantService restaurantService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponce getRestaurant(@PathVariable Long id) throws BadRequestException {
        return restaurantResponseMapper.toDto(restaurantService.getRestaurant(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurant = restaurantRequestMapper.toEntity(restaurantRequest);
        restaurantService.createRestaurant(restaurant);
    }
}
