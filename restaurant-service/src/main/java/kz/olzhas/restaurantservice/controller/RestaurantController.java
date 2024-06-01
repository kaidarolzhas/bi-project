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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurantId(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(restaurantService.findById(id, token));
    }

    @PostMapping
    public void createRestaurant(@RequestBody RestaurantRequest restaurantRequest,
                             @RequestParam("token") String token) {
        restaurantService.save(token, restaurantRequest);
    }

    @PutMapping("/{id}")
    public void updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequest restaurantRequest) {
        restaurantService.update(id, restaurantRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteById(id);
    }

}
