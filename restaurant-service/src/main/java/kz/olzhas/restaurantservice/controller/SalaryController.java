package kz.olzhas.restaurantservice.controller;

import kz.olzhas.restaurantservice.dto.RestaurantRequest;
import kz.olzhas.restaurantservice.service.RestaurantService;
import kz.olzhas.restaurantservice.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getRestaurantId(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
//        return ResponseEntity.ok(restaurantService.findById(id, token));
//    }
//
//    @PostMapping
//    public void createSalary(@RequestBody RestaurantRequest restaurantRequest,
//                             @RequestParam("token") String token) {
//        restaurantService.save(token, restaurantRequest);
//    }
//
//    @PutMapping("/{id}")
//    public void updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequest restaurantRequest) {
//        restaurantService.update(id, restaurantRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteRestaurant(@PathVariable Long id) {
//        restaurantService.deleteById(id);
//    }

}
